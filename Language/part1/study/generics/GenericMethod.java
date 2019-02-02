package study.generics;

public class GenericMethod
{

	private static <T> void genTest(T k, T l)
	{
		System.out.println(k);
		System.out.println(l);
	}
	
	public static void main(String[] args)
	{
		//Compiler will not allow below, because types are different
		//GenericMethod.<Integer>genTest(5, "Hello");
		
		// Here both String and Integer are promoted to
		genTest("Test", 5);
		
		Class<?> list[] = new Class<?>[3];
		
		System.out.println(list.toString());
	}
}
