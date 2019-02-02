package study.collections;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class CompLastFirst implements Comparator<String>
{

	@Override
	public int compare(String o1, String o2)
	{
		int lstNm1 = o1.trim().lastIndexOf(' ');
		int lstNm2 = o2.trim().lastIndexOf(' ');
		
		// compare last names
		int res = o1.trim().substring(lstNm1).compareToIgnoreCase(o2.trim().substring(lstNm2));
		
		if (res == 0)
			return o1.trim().compareToIgnoreCase(o2.trim());
		else
			return res;
	}
	
}

class CompByLast implements Comparator<String>
{
	@Override
	public int compare(String o1, String o2)
	{
		int lstNm1 = o1.trim().lastIndexOf(' ');
		int lstNm2 = o2.trim().lastIndexOf(' ');
		
		// compare last names
		return o1.trim().substring(lstNm1).compareToIgnoreCase(o2.trim().substring(lstNm2));
	}	
}

public class SortByLastName
{

	public static void main(String[] args)
	{
		// compare using reversed natural order
		TreeMap<String, Double> tm1 = new TreeMap<>((a,b) -> b.compareTo(a));
		populateAndDisplay(tm1);
		
		// compare in reversed order using last name and then first name
		tm1 = new TreeMap<>(new CompLastFirst().reversed());
		populateAndDisplay(tm1);
	
		/* Compare by last name then by first name.
		 * Note: interface Comparator is used without type specification because  
		 * naturalOrder is a static function of Comparator interface. It returns
		 * Comparator of type which implements Comparable, so in the below case
		 * it is inferred to be Comparator<String>.
		 * 
		 *  Inside naturalOrder we cast to Comparator<String> because every type
		 *  can be casted to an interface without compilation error.
		 */
		tm1 = new TreeMap<>(new CompByLast().thenComparing(Comparator.naturalOrder()));
		populateAndDisplay(tm1);
		
		/* remove leading and trailing spaces, and replace repeating spaces
		   with single space */
		System.out.println("   Alex    Donovan ".trim().replaceAll(" +", " "));
	} // end of main

	private static void populateAndDisplay(TreeMap<String, Double> tm1)
	{
		Set<Map.Entry<String, Double>> set;
		tm1.put("Alex Johnson  ", 91.91);
		tm1.put("Frank Sinatra   ", 78.5);
		tm1.put("Oscar Hevert	", 5.13);
		tm1.put("Ralph Smith", -19.45);
		tm1.put("Ralph Mendonca", 5.65);
		tm1.put("Peter Hevert", 8.88);
		tm1.put("John  Smith", (double)16);
		
		set = tm1.entrySet();
		
		for (Map.Entry<String, Double> me : set)
			System.out.println(me.getKey().trim() + ": " + me.getValue());
		System.out.println();
	}

}
