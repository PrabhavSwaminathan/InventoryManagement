import java.util.Scanner;

/**
 * A class that imports Product Class as an array.
 * 
 * @author Prabhav Swaminathan
 * @version 2018.09.08
 */
public class ProductList
{
    //Creates an array of objects of class Product
    private Product[] listOfProducts;
    //This is used as an index for the array of list of products
    static int i = 0;  
    
    /**
    * Default Constructor for objects of class ProductList
    */
    public ProductList()
    {
        listOfProducts = new Product[5];
        for(int i = 0;i < 5;i++)
        {
            listOfProducts[i] = new Product();
        }
    }
    
    /**
    * Displays registered products at index i.
    * @param i used to display products at index i.
    */
    public void getProduct(int i)
    {
        listOfProducts[i].productDisplay();
    }
    
    /**
    * Displays all the registered products.
    */
    public void displayProduct()
    {
        for(int num = 0;num < i;num++)
        {
            System.out.println("Details of Products ");
            getProduct(num);
        }
    }
   
    /**
    * Inputs product description and checks validation.
    */
    public void inputProductDesc()
    {
        Scanner console = new Scanner(System.in);
        String desc; //Declaring a temporary variable desc to take input of description
        boolean error = true;
        while(error)
        {
            System.out.println("Enter Description of Product : ");
            desc = console.nextLine();
            if(desc.length() <= 1 || desc.length() >= 50)
            {   
                System.out.println("Your product description must be between 2 and 50 characters, Sorry for the Inconvienience");
            }
            else
            {
                listOfProducts[i].setDesc(desc);
                break;
            }
        }
    }
    
    /**
    * Inputs product name and checks validation.
    */
    public void inputProductName()
    {
        String name=""; //Declaring a temporary variable name to take input of name
        boolean error = true;
        Scanner console = new Scanner(System.in);
        while(error)
        {
            System.out.println("Enter Name : ");
            name = console.nextLine();
            if(name.length() <= 3 || name.length() >= 25)
            {   
                System.out.println("Your input name must be between 3 and 25 characters, Sorry for the Inconvienience");
            }    
            else            
            {
                error = false;
                for(int j = 0;j < listOfProducts.length;j++)
                {
                    if(listOfProducts[j].getName().equalsIgnoreCase(name))
                    {
                        System.out.println("Name Already Exists");  
                        error = true;
                        break;
                    }    
                } 
            }
        }
        listOfProducts[i].setName(name);     
    }  
    
    /**
    * Inputs product price and checks validation.
    */ 
    public void inputProductPrice()
    {
        Scanner console = new Scanner(System.in);
        double price; //Declaring a temporary variable price to take input of product price
        boolean error=true;
        while(error)
        {
            System.out.println("Enter Price of Product : ");
            price = console.nextDouble();
            if(price <= 0)
            {   
                System.out.println("Your Product Price must be greater than 0, Sorry for the Inconvienience");
            }
            else
            {
                listOfProducts[i].setPrice(price);
                break;
            }
        }
        i++; //To increment the index the index of array listOfProducts
    }
    
    /**
    * Returns the value of Product at index i.
    * @param i used for finding product values at i.
    * @return the value of product at index i.
    */  
    public Product returnProduct(int i)
    {
        return listOfProducts[i];
    }
}
