/**
 * Kotopes implementation.
 * @since 1.0
 */
public class CatDog implements Pet
{
    private final Pet cat;
    private final Pet dog;
    
    public CatDog(Pet cat, Pet dog)
    {
        this.cat = cat;
        this.dog = dog;
    }
    
    /**
     * (@inheritDoc)
     */
    public void makeSound()
    {
        this.cat.makeSound();
        this.dog.makeSound();
    }
    
    /**
     * (@inheritDoc)
     */
    public String getName()
    {
        return String.format("%s%s", this.cat.getName(), this.dog.getName());
    }

    /**
     * (@inheritDoc)
     */
    public void setName(String newName)
    {
        System.out.println("Can't change name to " + newName + ". Operation not supported!");
    }
}