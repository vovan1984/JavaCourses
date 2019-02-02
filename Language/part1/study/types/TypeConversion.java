package study.types;

public class TypeConversion
{

	public static void main(String[] args)
	{
		int k;
		char x = 88;
		
		System.out.println("x = <" + x + ">");
		
		k  = x;
		
		System.out.println("k = <"  +  k + ">");

		k++;
		
		//x = k;  - does not compile
		
	}

}
