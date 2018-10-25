import java.util.Scanner;

/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    //For storing product name
    private String name;
    //For storing product description
    private String desc;
    //For storing price of product
    private double price;
    //For storing quantity on hand
    private int qtyOnHand;
    //For storing minimum order quantity
    private int minOrderQty;
    
    /**
     * Default Constructor for objects of class Product
     */
    public Product()
    {      
        this.name = "";
        this.desc = "";
        this.price = 0;
        this.qtyOnHand = 0;
        this.minOrderQty = 0;
    }
    
    /**
     * Parameterized Constructor for objects of class Product
     * @param name to set name
     * @param desc to set description
     * @param price to set price
     * @param qtyOnHand to set Quantity
     * @param minOrderQty to set the minimum order Quantity
     */
    public Product(String name, String desc, double price, int qtyOnHand, int minOrderQty)
    {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
        this.minOrderQty = minOrderQty;
    }

    /**
     * To get the name of product
     * @return name gets name of product
     */
    public String getName()
    {
        return name;        
    }
    
    /**
     * To get the Description of product
     * @return desc gets description of product
     */
    public String getDesc()
    {
        return desc;        
    }
    
    /**
     * To get the price of product
     * @return price gets price of product
     */
    public double getPrice()
    {
        return price;        
    }
    
    /**
     * To get the quantity of product
     * @return qtyOnHand gets quantity of product
     */
    public int getQtyOnHand()
    {
        return qtyOnHand;        
    }
    
    /**
     * To get the Minimum Order Quantity of product
     * @return minOrderQty gets Minimum Order Quantity of product
     */
    public int getMinOrderQty()
    {
        return minOrderQty;        
    }
       
    /**
     * Sets the value of Name.
     * @param name Value of name is set.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Sets the value of Description.
     * @param desc Value of Description is set.
     */
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    
    /**
     * Sets the value of Price.
     * @param price Value of Price is set.
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    /**
     * Sets the value of Quantity.
     * @param qtyOnHand Value of Quantity is set.
     */
    public void setQtyOnHand(int qtyOnHand)
    {
        this.qtyOnHand = qtyOnHand;
    }
    
    /**
     * Sets the value of Minimum Order Quantity.
     * @param minOrderQty Value of Minimum Order Quantity is set.
     */
    public void setMinOrderQty(int minOrderQty)
    {
        this.minOrderQty = minOrderQty;
    }
    
    /**
     * Displays all the values stored in the attributes.
     */
    public void productDisplay()
    {      
       System.out.println("\nName of Product is "+getName());
       System.out.println("Description of Product is "+getDesc());
       System.out.println("Price of Product is "+getPrice());
       System.out.println("Quantity Available is "+getQtyOnHand());
       System.out.println("Minimum Order Quantity is "+getMinOrderQty());
    }
}