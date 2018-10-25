import java.util.Scanner;
import java.util.Random;

/**
 * A class that imports the RandonNumberGenerator class, the SaleTransaction class and the ProductList Class.
 * It has the menu method from which the program runs.
 * 
 * @author Prabhav Swaminathan
 * @version 2018.09.08
 */
public class Sale
{
    //Variable to store Quantity generated Randomly
    private RandomNumberGenerator randomNoQtyOnHand;
    //Variable to store Minimum OrderQuantity generated Randomly
    private RandomNumberGenerator randomNoMinOrderQty;
    //An object of SaleTranscation is created
    private SaleTransaction transaction;
    //An object of ProductList is created
    private ProductList prodList;
    //Used as index during registeration of product
    static int index=0; 
    
    /**
     * Default Constructor for objects of class Sale
     */
    public Sale()
    {
        prodList = new ProductList();
        randomNoQtyOnHand = new RandomNumberGenerator();
        randomNoMinOrderQty =  new RandomNumberGenerator();
        transaction = new SaleTransaction();    
    }
    
    /**
     * Displays the items in the cart.
     */
    public void getSaleTransaction()
    {
        transaction.displayTransaction();
    }
    
    /**
     * Displays the the products registered by the user.
     */
    public void getProductList()
    {
        prodList.displayProduct();
    }
    
    /**
     * To buy product from the registered products and add it to the Cart.
     */
    public void buyProduct()
    {
        Scanner console = new Scanner(System.in);
        int choice;
        getProductList();  
        System.out.println("Please Enter the Product you want to buy: ");
        choice = console.nextInt();
        while(choice<6)
        {
            System.out.println("\nPlease Select from the following products which are available");
            System.out.println("Enter Product Number, 6 to Exit");
            getProductList();  
            if(prodList.returnProduct(choice-1).getMinOrderQty() > prodList.returnProduct(choice-1).getQtyOnHand())
                System.out.println("Sorry not enough Quantity Available, Quantity available is less than Minimum order Quantity, product cannot be purchased, please select another product"); 
            else
            {
                returnProductToItems(choice-1);
            }
            System.out.println("Please Enter the Product you want to buy: ");
            choice = console.nextInt();
        }
    }
    
    /**
     * To finalize the sale by checking out the products added to the Cart.
     */
    public void checkOut()
    {
        Scanner console = new Scanner(System.in);
        int choice = 0;
        transaction.displayProduct();
        transaction.calcTotalCost();
        do
        {        
            System.out.println("1. Press 1 to proceed with check out");
            System.out.println("2. Press 2 to make changes to Cart or Exit\n");
            System.out.println("Enter your choice");
            choice = console.nextInt();
            switch(choice)
            {
                case 1: System.out.println("Sale Code for this order is : ");
                        generateSaleCode();
                        for(int k=0;k<transaction.returnItemLength();k++)
                        {   
                            transaction.updateQty(k);
                        }
                        break;
                
                case 2: System.out.println("Exiting Cart");
                        break;
                
                default: System.out.println("You have not entered a valid choice, please enter a valid choice");
            }
        }while(choice!=2);
    }
    
    /**
     * Return the randomly generated minimum order quantity.
     * @return the randomly generated minimum order quantity.
     */
    public int generateMinOrderQty()
    {
        Random rand = new Random();
        randomNoMinOrderQty.setMinimumValue(2);
        randomNoMinOrderQty.setMaximumValue(4);
        int  number = rand.nextInt(randomNoMinOrderQty.getMaximumValue()) + randomNoMinOrderQty.getMinimumValue(); 
        return number;
    }
    
    /**
     * Return the randomly generated quantity on hand.
     * @return the randomly generated quantity on hand.
     */
    public int generateQtyOnHand()
    {
        Random rand = new Random();
        randomNoQtyOnHand.setMinimumValue(1);
        randomNoQtyOnHand.setMaximumValue(9);
        int  number = rand.nextInt(randomNoQtyOnHand.getMaximumValue()) + randomNoQtyOnHand.getMinimumValue();
        return number;
    }
    
    /**
     * Randomly generates sales code for the order at Checkout.
     */
    public void generateSaleCode()
    {
        Random rand = new Random();
        int  number = rand.nextInt(10000) + 1001;
        System.out.println(number);
    }
    
    /**
     * To view the information of each option in the menu.
     */
    public void getHelp()
    {
        System.out.println("\n\n1. Register a Product");
        System.out.println("(A) A Total of 5 Products can be resgistered");
        System.out.println("(B) Product Name must be between 3 and 25 Characters only");
        System.out.println("(C) Product Description must be between 1 and 50 Characters only");
        System.out.println("(D) Product Price must be Greater than $0");
        System.out.println("(E) Product Quantity and Minimum Order are assigned during registeration of Product\n");
        System.out.println("2. Buy a Product");
        System.out.println("(A) A Maximum of 3 Products can be purchased, when a product is selected it is added to Cart,");
        System.out.println("    Product Number must be entered to select a product\n");
        System.out.println("3. A product can be removed from the cart\n");
        System.out.println("4. To view all available products\n");
        System.out.println("5. All the products that have been added to the cart can be purchased\n");
        System.out.println("7. To exit the program\n\n");
        System.out.flush();
    }
    
    /**
     * To display all the options available to the user.
     */ 
    public void menu()
    {
        Scanner console = new Scanner(System.in);
        int choice=0;
        do
        {
            System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println("Welcome to the Simple Inventory Management System");
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+\n");
            System.out.println("Please Select from the following options:");
            System.out.println("Press 1 to Register a Product for Sale");
            System.out.println("Press 2 to Buy a Product to the Cart");
            System.out.println("Press 3 to Remove a Product from the Cart");
            System.out.println("Press 4 to View all Available Products");
            System.out.println("Press 5 to Check out");
            System.out.println("Press 6 to Get Help");
            System.out.println("Press 7 to Exit\n");
            System.out.println("Please Enter your Choice:");
            choice = console.nextInt();
            switch(choice)
            {
                case 1: if(index == 5)
                        {
                            System.out.println("No more products can be registered, only a maximum of 5 products can be registered");
                        }
                        else
                        {
                            prodList.returnProduct(index).setMinOrderQty(generateMinOrderQty());
                            prodList.returnProduct(index).setQtyOnHand(generateQtyOnHand());
                            prodList.inputProductName();
                            prodList.inputProductDesc();
                            prodList.inputProductPrice();
                            index++;
                        }
                        break; 
                case 2: if(index==0)
                            System.out.println("No products have been registered");
                        else
                            buyProduct();
                        break;
                        
                case 3:if(index==0)
                            System.out.println("No products have been registered");
                        else 
                            removeProduct();
                        break;
                        
                case 4: prodList.displayProduct();
                        break;
                        
                case 5: checkOut();
                        break;
                       
                case 6: getHelp();
                        break;
                        
                case 7: System.out.println("Exiting..............");
                        System.exit(0);
                        break;
                
                default: System.out.println("Wrong input");
                         break;
            }
        }while(choice != 7);
    }
    
    /**
     * To remove product from the products added to the Cart.
     */
    public void removeProduct()
    {
        Scanner console = new Scanner(System.in);
        int ch;
        transaction.displayProduct();
        System.out.println("Select the product you want to remove");
        ch=console.nextInt();
        if(ch==1)
        {
            transaction.removeItem(0);
        }
        else if(ch==2)
        {
            transaction.removeItem(1);
        }
        else if(ch==3)
        {
            transaction.removeItem(2);
        }
    }
    
    /**
     * Access a specific product from array of listOfProducts in ProductList and adding it to the items array in SaleTransaction Class.
     * @param i The Product to be returned.
     */
    public void returnProductToItems(int i)
    {
        transaction.addToCart(prodList.returnProduct(i));
    }

    public static void main(String[] args) {
        Sale sale = new Sale();
        sale.menu();
    }
}