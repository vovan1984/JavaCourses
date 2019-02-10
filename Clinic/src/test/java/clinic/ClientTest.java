package clinic;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ClientTest
{

    /**
     * Check retrieval of client's name.
     */
    @Test
    public void testGetName()
    {
        Client c = new Client("Bob", new Cat("Murka"));
        assertEquals("Client didn't store name properly!", "Bob", c.getName());
    }

    /**
     * Validate changing of client's name.
     */
    @Test
    public void testSetName()
    {
        Client c = new Client("Bob", new Cat("Murka"));
        c.setName("Barcelona");
        assertEquals("Client didn't change name properly!", "Barcelona", c.getName());
    }

    /**
     * Test addition of pet.
     */
    public void testAddPet()
    {
        Client c = new Client("John");
        c.addPet(new Animal("Korova"));
        c.addPet(new Cat("Murka"));
    }
    
    /**
     * Retrieve pets of a client.
     */
    @Test
    public void testGetPets()
    {
        List<Pet> petsToTest = new LinkedList<>();
        petsToTest.add(new Cat("Murka"));
        petsToTest.add(new Dog(new Animal("Barsik")));
        
        Client c = new Client("Bob");
        
        for (Pet p : petsToTest)
            c.addPet(p);
        
        assertTrue(c.getPets().containsAll(petsToTest));
        assertFalse(c.getPets().contains(new Cat("Marusia")));
    }

    /**
     * Test client's description.
     */
    @Test
    public void testToString()
    {
        Client c1 = new Client("John");
        assertEquals("John", c1.getName());
        
        Client c2 = new Client("Bill", new Cat("Shamaladada"));
        assertEquals("Bill", c2.getName());
    }

}
