package study.other;

public class PassArrayToVarArgs
{
	private static void printInts(int ... args)
	{
		for (int k : args)
			System.out.print(k + " ");
		System.out.println();
	}

	public static void main(String[] args)
	{
		int[] intArr = {3, -345, 23, 24, -23, 3245};

		printInts(intArr);
	}

}
