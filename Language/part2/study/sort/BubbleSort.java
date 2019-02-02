package study.sort;

public class BubbleSort
{
	static String[] sort(String[] arr)
	{
		for (int j = 0; j < arr.length; j++)
		{
			// scan for minimum element to put it to position j
			for (int i = j +1; i < arr.length; i++) 
				if (arr[i].compareTo(arr[j]) < 0)
				{
					String tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
		}		
		
		return arr;
	}
}
