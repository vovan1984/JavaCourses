import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest
{
    Calculator calc = new Calculator();
    
    @Test
    public void testAdd()
    {
        calc.add(1,2,3,8);
        assertEquals(14, calc.getResult());
    }
}