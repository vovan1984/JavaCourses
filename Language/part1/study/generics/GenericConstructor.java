package study.generics;

interface MyFunc<T>
{
	int func(T f);
}

class GenConstructorClass
{
	private double test, xz;
	
	<V extends Number> GenConstructorClass(V d1, V d2, MyFunc<V> d3)
	{
		test = d1.doubleValue();
		xz = d2.doubleValue();
		
		d3.func(d1);
	}
	
	@Override
	public String toString()
	{
		return String.format("Object of GenConstructorClass: value1 = %.2f, value2 = %.2f", test, xz);
	}
}


public class GenericConstructor
{
	private static int myTest(Double f)
	{
		System.out.println("In myTest: " + f);
		return 0;
	}

	public static void main(String[] args)
	{
		GenConstructorClass a = new GenConstructorClass(2.01, 3.06, GenericConstructor::myTest);

		System.out.println(a);
		
		// Below will not compile because myTest expects Double, while value 5 is of Integer type
		//a = new GenConstructorClass(3.0, 5, GenericConstructor::myTest);
		
		System.out.println(a);
	}
}
