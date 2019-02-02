package study.enumerations;

public class EnumTest
{
	static enum Apple
	{
		Jonahtan, GoldenDel, RedDel, WinseSap, Cortland
	}
	public static void main(String[] args)
	{
		Apple ap1 = Apple.Cortland, ap2 = Apple.Cortland;
		
		System.out.println(ap1 == ap2);
		
		for (Apple a : Apple.values())
		{
			System.out.print(a + " ");
		}
		
		System.out.println();
	} // end of main

}
