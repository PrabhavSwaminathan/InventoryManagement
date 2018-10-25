/**
 * A class that has the maximum and minimum value attributes.
 * 
 * @author Prabhav Swaminathan
 * @version 2018.09.08
 */

public class RandomNumberGenerator
{
    private int minimumValue;
    private int maximumValue;
   
    /**
     * Default Constructor for objects of class RandomNumberGenerator
     */
    public RandomNumberGenerator()
    {
        minimumValue = 0;
        maximumValue = 0;
    }
    
    /**
     * Parameterized Constructor for objects of class RandomNumberGenerator
     * @param minimumValue sets the minimum value.
     * @param maximumValue sets the maximum value.
     */
    public RandomNumberGenerator(int minimumValue, int maximumValue)
    {
        this.minimumValue = minimumValue;        
        this.maximumValue = maximumValue;
    }
    
    /**
     * Returns the integer value of Minimum Value.
     * @return the integer value of Minimum Value.
     */
    public int getMinimumValue()
    {
        return minimumValue;        
    }
    
    /**
     * Returns the integer value of Maximum Value.
     * @return the integer value of Maximum Value.
     */
    public int getMaximumValue()
    {
        return maximumValue;        
    }
    
    /**
     * Sets the value of Minimum Value.
     * @param salesCode Value of Minimum Value is set.
     */
    public void setMinimumValue(int minimumValue)
    {
        this.minimumValue = minimumValue;
    }
    
    /**
     * Sets the value of Maximum Value.
     * @param salesCode Value of Maximum Value is set.
     */
    public void setMaximumValue(int maximumValue)
    {
        this.maximumValue = maximumValue;
    }
}
