package clinic;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class AnimalTest
{

    /**
     * Check getName() method.
     */
    @Test
    public void testGetName()
    {
        Animal a = new Animal("UnitTest");
        assertEquals(a.getName(), "UnitTest");
    }

    /**
     * Check changeName() method.
     */
    @Test
    public void testChangeNameMethod()
    {
        Animal a = new Animal("UnitTest");
        a.changeName("Korova");
        assertEquals(a.getName(), "Korova");
    }
    
    /**
     * Check makeSound() method. Since we don't know the animal, 
     * the sound should be "beep" :)
     */
    @Test
    public void testMakeSound()
    {
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        var outPs = new PrintStream(actualOutput);   
        final PrintStream saveOut = System.out; // save System.out for restoring later.
        System.setOut(new PrintStream(outPs));  // setup output to a byte array.

        Animal a = new Animal("UnitTest");
        a.makeSound();
        
        // reset System.out to an original value
        System.setOut(saveOut);
        outPs.close();
        
        // setup expected output
        String expectedOutput = String.format("%s%n", a.getName() + " says: beep");
        
        assertEquals(expectedOutput.toString(), actualOutput.toString());
    }

}
