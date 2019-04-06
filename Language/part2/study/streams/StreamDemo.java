package study.streams;

import java.util.*;

/**
 * Class containing name, phone and email
 *
 */
class NamePhoneEmail
{
	String name, phone, email;

    NamePhoneEmail(String n, String p, String e)
    {
    	name = n;
    	phone = p;
    	email = e;
    }
    
    @Override
    public String toString()
    {
    	return name + " " + phone + " " + email;
    }
}

/**
 * Class containing name, and phone
 *
 */
class NamePhone
{
	String name, phone;

    NamePhone(String n, String p)
    {
    	name = n;
    	phone = p;
    }
    
    @Override
    public String toString()
    {
    	return name + " " + phone;
    }

}

public class StreamDemo 
{
    public static void main(String[] args)
    {
    	// A list of names, phones and email addresses
    	ArrayList<NamePhoneEmail> myList = new ArrayList<>();
    	
    	myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchieldt.com"));
    	myList.add(new NamePhoneEmail("Garry", "222-2222", "Garry@HerbSchieldt.com"));
    	myList.add(new NamePhoneEmail("Anton", "777-7777", "Anton@HerbSchieldt.com"));
    	
    	System.out.println("Initial list: ");
    	for (NamePhoneEmail item : myList)
    		System.out.println(item);
    	System.out.println();
    	
    	// map to NamePhone and collect to HashSet
    	HashSet<NamePhone> npSet = myList.stream().
    			                          map((npe) -> new NamePhone(npe.name, npe.phone)).
    			                          collect(HashSet<NamePhone>::new, HashSet::add, HashSet<NamePhone>::addAll);

    	System.out.println("Collected set: ");
    	for (NamePhone item : npSet)
    		System.out.println(item);
    }
}
