package study.sort;

public class SortTest
{
	private static void displayArr(String desc, String[] arr)
	{
		System.out.println(desc);	
		System.out.println(String.join(" ", arr));
	}

	public static void main(String[] args)
	{
		String[] arr = 
			{"Now", "it", "is", "the", "time", "for", "all", "good", "men", "to", "come", "to", "the", "aid", "of", "their", "country"};

		displayArr("Before bubble sort:", arr);
		
		// ToDo: pass method reference for comparing the objects
		BubbleSort.sort(arr);
		
		displayArr("After bubble sort: ", arr);
	}
}
