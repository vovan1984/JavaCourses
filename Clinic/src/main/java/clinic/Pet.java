/**
 * This interface describes actions of pet.
 * @since 1.0
 */
public interface Pet
{
    // make noise.
    public void makeSound();
    
    // get name of the pet.
    public String getName();
    
    /**
     * Set name of the pet.
     */
    public void setName(String newName);
}