/**
 * This class implements calculator.
 */
public class Calculator
{
    // result of calculation
    private int result;
    
    /**
     * Sum arguments
     * @param params Arguments for addition
     */
    public void add(int ... params)
    {
        for (Integer param : params)
        {
            this.result += param;
        }
    }
    
    /**
     * Get result of the calculation
     */
    public int getResult()
    {
        return this.result;
    }
    
    /**
     * Cleanup result of the calculation.   
     */
     public void cleanResult()
     {
         this.result = 0;
     }
}