package clinic;

import java.util.LinkedList;

/**
 * Base class to contain clients.
 * @since 1.0
 */
public class Clinic
{
    // list of clients
    private final Client[] clients;
    
    public Clinic(int size)
    {
        this.clients = new Client[size];
    }
    
    /**
     * Add client to given position.
     * @param Index in array to add client to.
     * @throws ClinicException 
     */
    public void addClient(int position, Client client) throws ClinicException
    {
        if (position < 0 || position >= clients.length)
            throw new ClinicException("Can't add client to position " + position);
        else if (clients[position] != null)
            throw new ClinicException("Client already exists at postition " + position + 
                    "! Please provide different index, or delete existing client first!"); 
        else
           this.clients[position] = client;
    }
    
    /**
     * Remove client at given position.
     * @throws ClinicException 
     */
    public void removeClient(int position) throws ClinicException
    {
        if (position < 0 || position >= clients.length)
            throw new ClinicException("Can't remove client from position " + position);
        else if (clients[position] == null)
            throw new ClinicException("Client doesn't exists at postition " + position); 
        else 
           this.clients[position] = null;
    }
    
    /**
     * Remove given client.
     * @param name Name of the client to remove
     * @throws ClinicException 
     */
    public void removeClient(String name) throws ClinicException
    {
        boolean found = false;
        
        // search for all occurrences of name, and remove corresponding clients.
        for (int i = 0; i < clients.length; i++)
        {
            if (clients[i] != null && clients[i].getName().equals(name))
            {
                clients[i] = null;
                found = true;
            }
        }
        
        if (!found)
            throw new ClinicException("Client " + name + " doesn't exist!");
    }

    /**
     * Remove given pet.
     * @param name Name of the pet to remove
     * @throws ClinicException 
     */
    public void removePet(String petName) throws ClinicException
    {
        boolean found = false;
        
        // search for all occurrences of name, and remove corresponding pets.
        for (int i = 0; i < clients.length; i++)
        {
            if (clients[i] != null && clients[i].getPet() != null
                && clients[i].getPet().getName().equals(petName))
            {
                clients[i] = null;
                found = true;
            }
        }
        
        // if pet doesn't exist, then throw an exception.
        if (!found)
            throw new ClinicException("Pet " + petName + " doesn't exist!");
    }
     
    /**
     * Find all clients with a given pet name.
     * @param petName Name of a pet.
     * @return Array of clients having a pet with that name.
     */
    public Client[] findClientsByPetName(String petName)
    {
        LinkedList<Client> c = new LinkedList<>();
        
        for (int i = 0; i < clients.length; i++)
        {
            if (clients[i] != null && clients[i].getPet() != null 
                   && clients[i].getPet().getName().equals(petName))
                c.add(clients[i]);
        }
        
        return c.toArray(new Client[0]);
    }
     
    /**
     * Find all pets of a given client.
     * @param clientName Name of the client.
     * @return Array of pets belonging to a client.
     */
    public Pet[] findPetsByClientName(String clientName)
    {
        LinkedList<Pet> p = new LinkedList<>();

        for (int i = 0; i < clients.length; i++)
        {
            if (clients[i] != null && clients[i].getName().equals(clientName))
                p.add(clients[i].getPet());
        }
        
        return new Pet[]{};
    }
}
