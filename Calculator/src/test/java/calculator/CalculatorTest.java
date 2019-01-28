package calculator;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest
{
    Calculator calc = new Calculator();

    @Test
    public void add()
    {
        calc.add(1,3,2,8);
        assertEquals(14, calc.getResult());
    }

    @Test
    public void multiply()
    {
        calc.multiply(8, 5, 2);
        assertEquals(80, calc.getResult());
    }

    @Test
    public void subtract()
    {
        calc.subtract(10, 2);
        assertEquals(8, calc.getResult());
    }

    @Test
    public void divide()
    {
        calc.divide(9, 1);
        assertEquals(9, calc.getResult());
    }

    @Test
    public void power()
    {
        calc.power(2, 10);
        assertEquals(1024, calc.getResult());
    }

    @Test
    public void getResult()
    {
        Calculator tmp = new Calculator();
        //initial value should be zero
        assertEquals(0, tmp.getResult());
    }

    @Test
    public void cleanResult()
    {
        calc.add(3,3);
        calc.cleanResult();
        assertEquals(0, calc.getResult());
    }
}