package clinic;

/**
 * This class describes user-defined exception
 * which is used in the Pet Clinic project.
 * 
 * @author Vladimir Igumnov
 * @version 1.0
 * @since 1.0
 */
public class ClinicException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor for the exception.
     * @param message
     */
    public ClinicException(String message)
    {
        super(message);
    }
}
