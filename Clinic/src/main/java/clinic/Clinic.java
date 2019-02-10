package clinic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Base class to contain clients.
 * @since 1.0
 */
public class Clinic
{
    // list of clients
    private final List<Client> clients;

    /**
     * Create clinic with unknown number of clients.
     */
    public Clinic()
    {
        this.clients = new ArrayList<>();
    }

    /**
     * Create clinic with expected number of clients.
     * @param size Expected number of clients.
     */
    public Clinic(int size)
    {
        this.clients = new ArrayList<>(size);
    }

    /**
     * Add new client to a clinic.
     * @param Index in array to add client to.
     * @throws ClinicException 
     */
    public void addClient(Client client) throws ClinicException
    {
        clients.add(client);
    }

    /**
     * Remove client by client's name.
     * @param name Name of the client to remove
     * @throws ClinicException 
     */
    public void removeClient(String name) throws ClinicException
    {
        boolean found = false;

        Iterator<Client> it = clients.iterator();

        while (it.hasNext())
        {
            Client c = it.next();
            if (c.getName().equals(name))
            {
                it.remove();
                found = true;
            }
        }

        if (!found)
            throw new ClinicException("Client " + name + " doesn't exist!");
    }

    /**
     * Remove pets with given name.
     * @param name Name of the pet to remove
     * @throws ClinicException 
     */
    public Pet removePet(String petName) throws ClinicException
    {
        boolean found = false;
        Pet removedPet = null;

        Iterator<Client> it = clients.iterator();

        while (it.hasNext())
        {
            Client c = it.next();

            Iterator<Pet> petIt = c.getPets().iterator();

            while (petIt.hasNext())
            {
                Pet curPet = petIt.next();
                if (curPet.getName().equals(petName))
                {
                    petIt.remove();
                    removedPet = curPet;
                    found = true;
                }
            }
        }

        // if pet doesn't exist, then throw an exception.
        if (!found)
            throw new ClinicException("Pet " + petName + " doesn't exist!");

        return removedPet;
    }

    /**
     * Find all clients with a given pet name.
     * @param petName Name of a pet.
     * @return Array of clients having a pet with that name.
     */
    public Client[] getClientsByPetName(String petName)
    {
        LinkedList<Client> c = new LinkedList<>();

        for (Client client : clients)
        {
            List<Pet> petsOfClient = client.getPets();

            for (Pet pet : petsOfClient)
            {
                if (pet.getName().equals(petName))
                    c.add(client);
            }
        }

        return c.toArray(new Client[0]);
    }

    /**
     * Get all clients of the Pet Clinic in an array.
     */
    public Client[] getClients()
    {
        return clients.toArray(new Client[] {});
    }

    /**
     * Find all clients with a given name.
     * @param clientName Name of the client.
     * @return Array of clients.
     */
    public Client[] getClientsByClientName(String clientName)
    {
        LinkedList<Client> c = new LinkedList<>();

        for (Client client : clients)
            if (client.getName().equals(clientName))
                c.add(client);

        return c.toArray(new Client[0]);
    }
}
