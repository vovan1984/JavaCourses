package calculator;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class InteractRunnerTest {

    /**
     * Test validates typical console interaction.
     * Simulate expected input for multiplication of 12 and 9,
     * following by calculation of 2 in power of 10.
     */
    @Test
    public void testMain()
    {
        //    Create input stream of input.
        ByteArrayInputStream expInput =
                buildInput("*", "12", "9", "no", "^", "2", "10", "yes");

        // simulate expected output
        String expOutput =
                String.format("%s%n%s%n%s%n%s%n",
                        "Enter operation (clean, *, /, +, - or ^): " +
                        "Enter first arg (or 'reuse' to reuse previous result): " +
                        "Enter second arg (or 'reuse' to reuse previous result): " +
                        "Result: 108",
                        "Exit: yes/no",
                        "Enter operation (clean, *, /, +, - or ^): " +
                        "Enter first arg (or 'reuse' to reuse previous result): " +
                        "Enter second arg (or 'reuse' to reuse previous result): " +
                        "Result: 1024",
                        "Exit: yes/no"
                           );
        // get real output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream saveOut = System.out; // save System.out for restoring later.
        final InputStream saveIn = System.in;   // save System.in for restoring later.

        System.setIn(expInput);
        System.setOut(new PrintStream(outContent));

        InteractRunner.main(new String[]{});

        assertEquals(expOutput, outContent.toString());

        // reset System.out/System.in to original values
        System.setOut(saveOut);
        System.setIn(saveIn);
    }

    private ByteArrayInputStream buildInput(String ... args)
    {
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        var outPs = new PrintStream(outBytes);
        for (String line : args)
        {
            outPs.println(line);
        }

        ByteArrayInputStream b = new ByteArrayInputStream(outBytes.toByteArray());
        return b;
    }
}