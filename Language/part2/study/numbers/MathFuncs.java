package study.numbers;

public class MathFuncs
{

	public static void main(String[] args)
	{
		double sqrt2 = Math.sqrt(2.0);
		
		System.out.println("sqrt(2)                = " + sqrt2);
		System.out.println("Next value after pi    = " + Math.nextAfter(sqrt2, 4.0));
		System.out.println("ulp(sqrt)              = " + Math.ulp(sqrt2));
		System.out.println("exponent of ulp(sqrt2) = " + Math.getExponent(Math.ulp(sqrt2)));
		System.out.println("hypot(3,4) of triangle = " + Math.hypot(3, 4));
		System.out.println("180 degrees            = " + Math.toRadians(180) + " radians");
	}

}
		