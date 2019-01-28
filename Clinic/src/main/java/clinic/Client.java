package clinic;

/**
 * Class for keeping client's info.
 * @since 1.0
 */
public class Client
{
    private String name;
    private final Pet pet;
    
    Client(String name, Pet pet)
    {
        this.name = name;
        this.pet = pet;
    }
    
    /**
     * Retrieve client's name
     */
    public String getName()
    {
        return this.name;
    }
 
    /**
     * Change client's name
     */
    public void setName(String newName)
    {
        this.name = newName;
    }
 
    /**
     * Retrieve client's pet
     */
    public Pet getPet()
    {
        return this.pet;
    }    
}