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
                buildOutput(
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

    /**
     * Build expected output
     * @param args Lines expected to be printed by the tested method.
     * @return Byte output stream buffering expected output.
     */
    private String buildOutput(String ... args)
    {
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        var outPs = new PrintStream(outBytes);
        for (String line : args)
        {
            outPs.println(line);
        }

        return outBytes.toString();
    }
}