package clinic;

/**
 * Implementation of the dog.
 * @since 1.0
 */
public class Dog implements Pet
{
    // basic Pet implementation
    private Pet pet;
    
    /**
     * Constructor.
     * @param pet Basic pet object provided in input.
     */
    public Dog(Pet pet)
    {
        this.pet = pet;
    }
    
    /**
     * (@inheritDoc)
     */
    @Override
    public void makeSound()
    {
        this.pet.makeSound();
        System.out.println("Gav, Gav");
    }
    
    /**
     * (@inheritDoc)
     */
    @Override
    public String getName()
    {
        return this.pet.getName();
    }
    
    /**
     * (@inheritDoc)
     */
    @Override
    public void setName(String newName)
    {
        this.pet.setName(newName);
    }    
}