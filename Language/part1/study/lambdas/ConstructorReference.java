package study.lambdas;

import java.util.function.*;

interface MyFunc
{
	FunctionsSet func();
}

public class ConstructorReference
{

	public static void main(String[] args)
	{
		// constructor without parameters
		MyFunc mf = FunctionsSet::new;

		System.out.println(mf + " is divisible by 3: " + mf.func().isDivisible(3));
		
		Function<Integer, FunctionsSet> op = FunctionsSet::new;
		
		System.out.println(op + " is square of 4: " + op.apply(16).isSquareL(4));
	}

}
	