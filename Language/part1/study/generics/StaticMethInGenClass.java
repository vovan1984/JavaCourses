package study.generics;

class MyClass<T>
{
	static <E> void displayMsg(E k)
	{
		System.out.println("Input value = " + k);
	}
	
	T ob;
	
	MyClass(T ob)
	{
		this.ob = ob;
	}
	
	T getOb()
	{
		return ob;
	}
	
	@Override
	public String toString()
	{
		return "MyClass: " + ob;
	}
}

public class StaticMethInGenClass
{

	public static void main(String[] args)
	{
		MyClass<Double> d = new MyClass<>(1.02);
		
		MyClass<Object> o = new MyClass<>(5);

		MyClass.displayMsg(d);
		
		MyClass.displayMsg(15);
		
		MyClass.displayMsg(o);
		
		// can't cast MyClass<Object> to MyClass<Double>
		//d = (MyClass<Double>)o;
	}

}
