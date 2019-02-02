package study.lambdas;

public class FunctionsSet
{
	int localNum;
	
	public FunctionsSet()
	{
		this(0);
	}
	
	public FunctionsSet(int n)
	{
		localNum = n;
	}
	
	boolean isSquare(int a, int b)
	{
		if (a*a == b)
			return true;
		else 
			return false;
	}
	
	boolean isSquareL(int b)
	{
		if (localNum == b*b)
			return true;
		else 
			return false;
	}
	
	boolean isDivisible(int k)
	{
		if (k == 0) return false;
		
		if (localNum%k == 0)
			return true;
		
		return false;
	}

}
