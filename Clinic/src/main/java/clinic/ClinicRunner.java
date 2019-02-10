package clinic;

/**
 * Implementation of Clinic's work.
 * @since 1.0
 */ 
public class ClinicRunner
{
    public static void showClients(Clinic clinic)
    {
        System.out.println("Clinic has the following clients:");
        for (Client client : clinic.getClients())
            System.out.println(client);
        
    }
    public static void main(String[] args)
    {
        final Clinic clinic = new Clinic(10);

        try
        {
            clinic.addClient(new Client("Brown", new Cat("Murka")));
            clinic.addClient(new Client("Nick", new Dog(new Animal("Sparky"))));
            clinic.addClient(new Client("Ann",
                    new CatDog(new Cat("Tom"), new Dog(new Animal("Barsik")))
                    ));
            
            showClients(clinic);
        } catch (ClinicException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}