package study.other;

public class AssertChecks
{

	public static void main(String[] args)
	{
		int a = 3, b =4;
		
		// to get AssertionError we need to pass -ea argument to JVM
		assert a == b : "Values of a and b are not equal!";
	}

}
