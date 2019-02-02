package study.string;

public class StringOps
{

	public static void main(String[] args)
	{
		String str = "Hello world!";
		CharSequence cs = str.subSequence(2, 4);
		
		System.out.println(cs);
		String str2 = new String(str);
		
		if (str == str2)
			System.out.println("Equal references");
		else
			System.out.println("Different references");
		
		if (str.equals(str2))
			System.out.println("Equal");
		else 
			System.out.println("Different");
		
		System.out.println(str.replace("world",	"Vova"));
	}

}
