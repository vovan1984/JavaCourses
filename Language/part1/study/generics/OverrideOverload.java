package study.generics;

class A<T>
{
	T ob1;
	
	A(T ob1)
	{
		this.ob1 = ob1;
	}
	
	T getOb()
	{
		System.out.println("In class A");
		return ob1;
	}
	
	static void display()
	{
		System.out.println("In A");
	}
}

class B<T, V> extends A<T>
{
	V ob2;
	
	B(T ob1, V ob2)
	{
		super(ob1);
		this.ob2 = ob2;
	}
	
	// overridden version
	T getOb()
	{
		System.out.println("In class B");
		return ob1;
	}
}

public class OverrideOverload
{
	/* The below won't compile because result of erasure is the same
	
	public static void genericOverloading(A<Integer> a)
	{
		System.out.println(a);
	}
	
	public static void genericOverloading(A<String> a)
	{
		System.out.println(a);
	}	

	*/
	
	public static void main(String[] args)
	{
		A<Integer> a = new A<Integer>(7);
		A<Integer> b = new B<Integer, String>(5, "Object B");

		int aVal = a.getOb();
		int bVal = b.getOb();
		
		System.out.println("aVal = " + aVal + ", bVal = " + bVal);
		
		A.display();
	}

}
