package study.string;

public class SplitTest
{

	public static void main(String[] args)
	{
		String phrase = "Now it is the   time for all good men to come to the aid of their country";

		String arr[] = phrase.split(" +");
		
		for (String s : arr)
			System.out.printf("<%s>%n", s);
	}

}
