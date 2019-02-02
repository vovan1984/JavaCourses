package calculator;
/**
 * This class implements calculator.
 */
public class Calculator
{
    // result of calculation
    private int result;
    
    /**
     * Sum arguments.
     * @param params Arguments for addition.
     */
    public void add(int ... params)
    {
        int res = 0;
        for (Integer param : params)
        {
            res += param;
        }
        this.result = res;
    }
    
    /**
     * Multiply arguments.
     * @param params Arguments for multiplication.
     */
    public void multiply(int ... params)
    {
        if (params.length > 0)
        {
            this.result = 1;
            for (Integer param : params)
            {
                this.result *= param;
            }
        }
    }    

    /**
     * Subtract arguments.
     * @param minuend The number from which subtrahend is subtracted.
     * @param subtrahend The number being subtracted
     */
    public void subtract(int minuend, int subtrahend)
    {
        this.result = minuend - subtrahend;

    }
    
    /**
     * Divide arguments.
     * @param dividend The number being divided.
     * @param divisor The number to be divided by.
     * @throws CalculatorException 
     */
    public void divide(int ... div) throws CalculatorException
    {
        if (div.length > 0)
        {
            this.result = div[0];
            for (int i=1; i<div.length; i++)
            {
                if (div[i] == 0)
                    throw new IllegalArgumentException("Attempt to divide by zero!");
                this.result /= div[i];
            }
        }
        else
            throw new CalculatorException("Please provide arguments for division!");
    }   

    /**
     * Place first argument in the power of second.
     * @param base The base number to enter into power.
     * @param power The power.
     */
    public void power(int base, int power)
    {
        this.result = (int)Math.pow(base, power);

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