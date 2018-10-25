import java.util.Scanner;

/**
 * A class that imports Product Class as an array, has the attributes of totalCost and saleCode which are generated in the Sale Class.
 * 
 * @author Prabhav Swaminathan
 * @version 2018.09.08
 */
public class SaleTransaction
{
    //Generates Sale Code for products purchased at the time of Checkout
    private int saleCode;
    //Calculates the Total Cost of Products added to Cart 
    private double totalCost;
    //Creates an an array named items of class Product
    private Product[] items;
    int j=0;  //Index for the array of Items

    /**
     * Default Constructor for objects of class SaleTransaction
     */
    public SaleTransaction()
    {
        items = new Product[3];
        for(int i = 0;i < 3;i++)
        {
            items[i] = new Product();
        }
        saleCode = 0;
        totalCost = 0;
    }
    
    /**
     * Parameterized constructor for objects of Class SaleTransaction
     * @param salesCode sets SalesCode.
     * @param totalCost sets the TotalCost.
     */
    public SaleTransaction(int salesCode, double totalCost)
    {
        this.saleCode = saleCode;        
        this.totalCost = totalCost;
    }
    
    /**
     * Returns the integer value of saleCode.
     * @return the integer value of saleCode.
     */
    public int getSaleCode()
    {
        return saleCode;        
    }
    
    /**
     * Returns the double value of Total Cost.
     * @return the double value of Total Cost.
     */
    public double getTotalCost()
    {
        return totalCost;        
    }
    
    /**
     * Sets the value of Sales Code.
     * @param salesCode Value of Sales Code is set.
     */
    public void setSalesCode(int salesCode)
    {
        this.saleCode = saleCode;
    }
    
    /**
     * Sets the value of Total Cost.
     * @param totalCost Value of Total Cost is set.
     */
    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }
        
    /**
     * Adds products to the Cart, value in parameter obj is set in the items array.
     * @param obj contains the value of the Product returned and is added to the items array.
     */
    public void addToCart(Product obj)
    {
        if(j==3)
        {
            System.out.println("No more products can be purchased, a maximum of 3 products can be registered");
        }
        else
        {
            items[j]=obj;
            j++;
        }
    }
     
    /**
     * Calculates the total cost of products in the cart.
     */
    public void calcTotalCost()
    {
        double totalCostOfPurchase=0;
        for(int i = 0; i < j; i++ )
        {
            totalCostOfPurchase = totalCostOfPurchase + items[i].getPrice();
            setTotalCost(totalCostOfPurchase);
        }
        System.out.println("Total Cost  of Order : "+getTotalCost());
    }
    
    /**
     * Displays Values of all the items in the cart.
     */   
    public void displayProduct()
    {
         for(int num=0;num<items.length;num++)
        {
            System.out.println("Select Product "+(num+1));
            getProduct(num);
        }
    }
    
    /**
     * Displays Values of Total Cost and Sales Code.
     */ 
    public void displayTransaction()
    {
        System.out.println("The Sales Code is "+getSaleCode());
        System.out.println("The total cost is"+getTotalCost());
    }
    
    /**
     * Displays Values of Total Cost and Sales Code.
     * @param i uses index to display a specific product in the cart.
     */ 
    public void getProduct(int i)
    {
        items[i].productDisplay();
    }
    
    /**
     * Displays Values of Total Cost and Sales Code.
     * @param i uses index to display a specific product in the cart.
     */
    public void removeItem(int element)
    {
        j=j-1;
        Product[] temp = new Product[j];
        for(int  i=0,k=0; i<items.length;i++)
        {
            if(i==element) 
                continue;
            else
                temp[k++] = items[i];
        }
        items = temp;
    }
      
    /**
     * Returns the length of the array items.
     */
    public int returnItemLength()
    {
        return j;
    }
    
    /**
     * Updates the value of Quantity During the time of Checkout
     * @param i uses index to check whether minimum order quantity and quantity on hand
     */
    public void updateQty(int index)
    {
        if(items[index].getQtyOnHand() < items[index].getMinOrderQty())
            System.out.println("Sorry Product can not be purchased as Available Quantity is less than Minimum Order Quantity");
        else
        {
            System.out.println("Purchase Successsful");
            items[index].setQtyOnHand(items[index].getQtyOnHand()-items[index].getMinOrderQty());
        }
    }
  
}