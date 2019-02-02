package study.lambdas;

interface A
{
	void ShowMsg(String str);
}

interface NumericFunc
{
	int func(int n);
}

public class FirstSteps
{
	// recursive lambda
	static NumericFunc factorial = n -> n <= 1? 1 : n * FirstSteps.factorial.func(--n);
	
	public static void main(String[] args)
	{
		String msg = "Square of ";
		final A a = s -> System.out.println(s);
		
		a.ShowMsg("Hello world!");
		
		System.out.println("5! = " + factorial.func(5));
		
		System.out.println("0! = " + factorial.func(0));
		
		NumericFunc square = (n) -> 
		{
			a.ShowMsg("In NumericFunc closure for calculation of square");
			a.ShowMsg(n + "! = " + factorial.func(n));
			a.ShowMsg(msg + n + " = " + n*n);
			return n;
		};	
		
		square.func(10);
		
		square = factorial;
		
		System.out.println("5! = " + square.func(5));
	}

}
