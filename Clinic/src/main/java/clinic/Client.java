package clinic;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for keeping client's info.
 * @since 1.0
 */
public class Client
{
    private String name;
    private List<Pet> pets; // client's pets
    
    /**
     * Constructor of client with no pet yet.
     * @param name Name of the client.
     */
    Client(String name)
    {
        this.name = name;
        this.pets = new LinkedList<>();
    }
    
    /**
     * Construct of client with given pet.
     * @param name Name of client.
     * @param pet Instance of client's pet.
     */
    Client(String name, Pet pet)
    {
        this(name);
        this.pets.add(pet);
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
     * Add pet to a client.
     */
    public void addPet(Pet newPet)
    {
        this.pets.add(newPet);
    }
 
    /**
     * Retrieve client's pets
     */
    public List<Pet> getPets()
    {
        return this.pets;
    }  
    
    /**
     * Represent client in form of String.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
