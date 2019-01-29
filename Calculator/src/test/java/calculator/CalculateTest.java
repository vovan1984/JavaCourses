package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest
{

    /**
     * Test addition.
     */
    @Test
    public void testSum()
    {
        assertEquals(Calculate.sum(5, 10), 15L);
        assertEquals(Calculate.sum(8.07, 1.04), 9.11, 0);
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
