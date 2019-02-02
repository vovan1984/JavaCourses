package clinic;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Ignore;
import org.junit.Test;

public class CatTest
{

    /**
     * Check makeSound() method. 
     */
    @Test
    public void testMakeSound()
    {
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        var outPs = new PrintStream(actualOutput);   
        final PrintStream saveOut = System.out; // save System.out for restoring later.
        System.setOut(new PrintStream(outPs));  // setup output to a byte array.

        Cat a = new Cat("UnitTest");
        a.makeSound();
        
        // reset System.out to an original value
        System.setOut(saveOut);
        outPs.close();
        
        // setup expected output
        String expectedOutput = String.format("%s%n", a.getName() + " says: Miauuu!");
        
        assertEquals(expectedOutput.toString(), actualOutput.toString());
    }

    @Test
    @Ignore("Method doesn't do anything in Cat class yet")
    public void testCatchMouse()
    {
        fail("Not yet implemented");
    }

}
