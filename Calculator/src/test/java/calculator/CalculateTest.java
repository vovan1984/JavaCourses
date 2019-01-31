package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest
{

    /**
     * Test addition of long numbers.
     */
    @Test
    public void testSumLong()
    {
        assertEquals(Calculate.sum(5, 10), 15L);
    }

    /**
     * Test addition of double numbers.
     */
    @Test
    public void testSumDouble()
    {
        assertEquals(Calculate.sum(8.07, 1.04), 9.11, 0);
    }
    
    /**
     * Test subtraction of long numbers.
     */
    @Test
    public void testMinusLong()
    {
        assertEquals(Calculate.minus(5, 3L), 2L);
    }

    /**
     * Test subtraction of double numbers.
     */
    @Test
    public void testMinusDouble()
    {
        assertEquals(Calculate.minus(5.0, 3.1), 1.9, 0);
    }
    
    /**
     * Test division of integer numbers.
     */
    @Test
    public void testDivLong()
    {
        assertEquals(Calculate.divide(15, 10), 1L);
    }
    
    /**
     * Test division of double numbers.
     */
    @Test
    public void testDivDouble()
    {
        assertEquals(Calculate.divide(15.0, 11), 15.0/11, 0);
    }
    
}
