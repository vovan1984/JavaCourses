package study.lambdas;

// interface for checks on integer values
interface IntChks<T>
{
	boolean func(T a, T b);
}

interface MoreIntChks
{
	boolean func(FunctionsSet x, int a);
}

public class MethRefs
{
	static <T> int count(T[] arr, IntChks<T> condition, T val)
	{
		int k = 0;
		
		for (T elem : arr)
		{
			if (condition.func(elem, val)) 
				k++;
		}
		
		return k;
	}
	
	static int count(Integer[] arr, MoreIntChks condition, FunctionsSet val)
	{
		int k = 0;
		
		for (Integer elem : arr)
		{
			if (condition.func(val, elem)) 
				k++;
		}
		
		return k;		
	}

	public static void main(String[] args)
	{
		Integer[] arr = {2, 3, 9, 2, 3, 4, 23, 435, 2, 5, 6, 980};		
		
		FunctionsSet obj = new FunctionsSet(9);
		
		System.out.println("Count of squares: " + count(arr, obj::isSquare, 4));
		
		// other way
		System.out.println("Count of squares: " + count(arr, FunctionsSet::isSquareL, obj));
	}

}
