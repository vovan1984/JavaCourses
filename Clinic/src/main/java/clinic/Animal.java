package clinic;

/**
 * Base class representing an animal.
 * @since 1.0
 */
public class Animal implements Pet
{
    // name of the pet
    private String name;
    
    /**
     * Constructor.
     * @param name Name of an animal.
     */
    public Animal(final String name)
    {
        this.name = name;
    }
    
    /**
     * Make sound.
     */ 
    @Override
    public void makeSound()
    {
        System.out.println
            (String.format("%s says: %s", this.name, "beep"));
    }
    
    /**
     * Return name of the pet.
     */
    @Override
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Update name of the pet.
     */
    @Override
    public void setName(String newName)
    {
        this.name = newName;
    }
}