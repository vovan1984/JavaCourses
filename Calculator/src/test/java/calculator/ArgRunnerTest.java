package calculator;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ArgRunnerTest
{
    /**
     * Test for sum of two numbers.
     *  We simulate expected output by printing into to stream to
     *  avoid mismatches of end of line character between platforms.
     */

    @Test
    public void testMain()
    {
        // simulate expected output
        ByteArrayOutputStream expContent = new ByteArrayOutputStream();
        var expPs = new PrintStream(expContent);
        expPs.println("Sum: 7");

        // get real output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream origOut = System.out;
        System.setOut(new PrintStream(outContent));
        String[] args = {"3", "4"};
        ArgRunner.main(args);

        assertEquals(expContent.toString(), outContent.toString());

        // reset System.out to original value
        System.setOut(origOut);
    }

    /**
     * Test for scenario when input is incomplete.
     * We simulate expected output by printing into to stream to
     * avoid mismatches of end of line character between platforms.
     */
    @Test
    public void testBadInputMain()
    {
        // simulate expected output
        ByteArrayOutputStream expContent = new ByteArrayOutputStream();
        var expPs = new PrintStream(expContent);
        expPs.println("Enter two parameters!");

        // get real output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream origOut = System.out;
        System.setOut(new PrintStream(outContent));
        String[] args = {};
        ArgRunner.main(args);

        assertEquals(expContent.toString(), outContent.toString());

        // reset System.out to original value
        System.setOut(origOut);
    }
}