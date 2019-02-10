package clinic;

import static org.junit.Assert.*;

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
            c.addClient(new Client(i+"", new Cat(i+"")));
    }


    /**
     * Check removal of client from an empty clinic.
     * @throws ClinicException 
     */
    @Test (expected=ClinicException.class)
    public void testRemoveClientFromEmptyClinic() throws ClinicException
    {
        Clinic c = new Clinic(10);
        c.removeClient("Kate");
    }

    /**
     * Remove client which doesn't exist.
     * @throws ClinicException
     */
    @Test (expected = ClinicException.class)
    public void testRemoveMissingClient() throws ClinicException
    {
        Clinic c = new Clinic(10);
        c.addClient(new Client("Bob", new Animal("Korova")));
        c.removeClient("George");
    }

    /**
     * Remove clients by pet name.
     * @throws ClinicException
     */
    @Test(expected = ClinicException.class)
    public void testRemovePet() throws ClinicException
    {
        Clinic c = new Clinic(10);
        Pet petToRemove = new Dog(new Animal("Muhtar"));

        c.addClient(new Client("Bob", new Animal("Korova")));
        c.addClient(new Client("Mr. Robinson", petToRemove));
        c.addClient(new Client("John", new Cat("Murka")));

        assertEquals("Wrong animal was removed!", c.removePet("Muhtar"), petToRemove);
        c.removePet("Muhtar");
    }

    /**
     * Check that retrieval of clients works well.
     * @throws ClinicException 
     */
    @Test
    public void testGetClients() throws ClinicException
    {
        Client[] inputClients = new Client[] 
                {
                        new Client("Bob", new Animal("Korova")),
                        new Client("Nick", new Cat("Murka")),
                        new Client("Vladimir", new Dog(new Animal("Barsik")))
                };
        Clinic c = new Clinic(10);

        for (int i=0; i < inputClients.length; i++)
            c.addClient(inputClients[i]);


        Client[] clinicClients = c.getClients();

        assertEquals("Number of clients is incorrect!", inputClients.length,
                clinicClients.length);

        /* 
         * Check that arrays match. They generally can't be sorted,
         * so we check every element of input array with every 
         * element of the array returned by Clinic.
         */
        for (int i = 0; i<inputClients.length; i++)
        {
            boolean found = false;

            for (int j=0; j<clinicClients.length; j++)
                if (inputClients[i].equals(clinicClients[j]))
                {
                    found = true;
                    break;
                }

            assertTrue("Clinic didn't store some clients!", found);
        }
    }


    /**
     * Check retrieval of clients by pet name.
     * @throws ClinicException 
     */
    @Test
    public void testFindClientsByPetName() throws ClinicException
    {
        Client[] inputClients = new Client[] 
                {
                        new Client("Bob", new Animal("Murka")),
                        new Client("Nick", new Cat("Murka")),
                        new Client("John", new Dog(new Animal("Barsik")))
                };

        // create clinic and put clients there
        Clinic c = new Clinic(10);

        for (int i=0; i < inputClients.length; i++)
            c.addClient(inputClients[i]);

        Client[]searchOutput = c.getClientsByPetName("Murka");

        //check that two client records were found
        assertEquals("Search by pet name found wrong number of clients!", 
                2, searchOutput.length);

        if(searchOutput[0].equals(inputClients[0]))
            assertEquals("Wrong clients were retrieved by pet name!", 
                    inputClients[1], searchOutput[1]);
        else
        {
            assertEquals("Wrong clients were retrieved by pet name!", 
                    inputClients[0], searchOutput[1]);
            assertEquals("Wrong clients were retrieved! by pet name!", 
                    inputClients[1], searchOutput[0]);
        }
    }

    /**
     * Check that retrieval of clients by name works well.
     * @throws ClinicException 
     */
    @Test
    public void testGetClientsByClientName() throws ClinicException
    {
        Client[] inputClients = new Client[] 
                {
                        new Client("Bob", new Animal("Korova")),
                        new Client("Nick", new Cat("Murka")),
                        new Client("Bob", new Dog(new Animal("Barsik")))
                };

        // create clinic and put clients there
        Clinic c = new Clinic(10);

        for (int i=0; i < inputClients.length; i++)
            c.addClient(inputClients[i]);

        Client[]searchOutput = c.getClientsByClientName("Bob");

        //check that two client records were found
        assertEquals("Search by client name found wrong number of clients!", 
                2, searchOutput.length);

        if(searchOutput[0].equals(inputClients[0]))
            assertEquals("Wrong clients were retrieved!", inputClients[2], searchOutput[1]);
        else
        {
            assertEquals("Wrong clients were retrieved!", inputClients[0], searchOutput[1]);
            assertEquals("Wrong clients were retrieved!", inputClients[2], searchOutput[0]);
        }
    } // end of testGetClientsByClientName

}
