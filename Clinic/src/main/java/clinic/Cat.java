/**
 * Implementation of the cat. It can say "Miauuu!" and catch mice.
 * @since 1.0
 */
public class Cat extends Animal
{
    /**
     * Constructor
     * @param name Name of the cat.
     */
    public Cat(String name)
    {
        super(name);
    }
    
    /**
     * Catch mouse.
     */
    public void catchMouse()
    {
    }
    
    /**
     * (@inheritDoc)
     */ 
    @Override
    public void makeSound()
    {
        System.out.println
            (String.format("%s says: %s", this.getName(), "Miauuu!"));
    }
}