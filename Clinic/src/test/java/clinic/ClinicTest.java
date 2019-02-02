package clinic;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class ClinicTest
{

    /**
     * Check that we can add number of Clients equal to 
     * constructor's size parameter.
     * @throws ClinicException
     */
    @Test
    public void testAddClient() throws ClinicException
    {
        Clinic c = new Clinic(10);
        
        // add 10 clients
        for (int i=0; i<10; i++)
            c.addClient(i, new Client(i+"", new Cat(i+"")));
    }
    
    /**
     * Check that we can't add more Clients than 
     * as defined by constructor's size parameter.
     * @throws ClinicException
     */
    @Test(expected = ClinicException.class)
    public void testAddTooManyClients() throws ClinicException
    {
        Clinic c = new Clinic(10);
        
        // add 10 clients
        for (int i=0; i<11; i++)
            c.addClient(i, new Client(i+"", new Cat(i+"")));
    }    

    /**
     * Check that we can remove clients.
     * @throws ClinicException 
     */
    @Test
    public void testRemoveClientInt() throws ClinicException
    {
        Clinic c = new Clinic(10);
        c.addClient(0, new Client("Bob", new Animal("Korova")));
        c.removeClient(0);
    }
    
    /**
     * Check that we can't remove non-existing clients.
     * @throws ClinicException 
     */
    @Test (expected=ClinicException.class)
    public void testRemoveMissingClient() throws ClinicException
    {
        Clinic c = new Clinic(10);
        c.removeClient(5);
    }

    /**
     * Validate removal of client by name.
     * @throws ClinicException
     */
    @Test
    public void testRemoveClientString() throws ClinicException
    {
        Clinic c = new Clinic(10);
        c.addClient(0, new Client("Bob", new Animal("Korova")));
        c.removeClient("Bob");
    }

    /**
     * Validate removal of non-existing client by name.
     * @throws ClinicException
     */
    @Test (expected = ClinicException.class)
    public void testRemoveMissingClientString() throws ClinicException
    {
        Clinic c = new Clinic(10);
        c.addClient(0, new Client("Bob", new Animal("Korova")));
        c.removeClient("George");
    }
    
    @Test
    @Ignore
    public void testRemovePet()
    {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testFindClientsByPetName()
    {
        fail("Not yet implemented");
    }

    @Test
    @Ignore
    public void testFindPetsByClientName()
    {
        fail("Not yet implemented");
    }

}
