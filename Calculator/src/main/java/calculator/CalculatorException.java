package calculator;

/**
 * This class describes user-defined exception
 * which is used in the Calculator project.
 * 
 * @author Vladimir Igumnov
 * @version 1.0
 * @since 1.0
 */
public class CalculatorException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor for the exception.
     * @param message
     */
    public CalculatorException(String message)
    {
        super(message);
    }

}
