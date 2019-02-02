package study.collections;

import java.util.Map;
import java.util.TreeMap;

public class MapTest
{
	private static class Student
	{
		private String firstName;
		private String lastName;
		
		Student(String firstName, String lastName)
		{
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName()
		{
			return firstName;
		}

		public String getLastName()
		{
			return lastName;
		}

		@Override
		public String toString()
		{
			return "Student [firstName=" + getFirstName() + ", LastName=" + getLastName() + "]";
		}
		
		
	}

	public static void main(String[] args)
	{
		Map<Double, Student> myMap = new TreeMap<>();
		
		myMap.put(3.5, new Student("Alex", "Donovan"));
		myMap.put(4.5, new Student("John", "Hlll"));
		myMap.put(3.1, new Student("Bradley", "Johnson"));
		myMap.put(3.0, new Student("Margarita", "Hill"));
		
		
		myMap.forEach((k, v) -> System.out.println(v + ": " + k));
		
		System.out.println("-----------------------------");
		
		myMap.values().forEach(x -> System.out.println(x));
		
		System.out.println("---------------------------");
	}

}
