package study.hierrarchy;

import study.types.TwoD;


public class DimensionsTest
{

	public static void main(String[] args)
	{
		TwoD<Integer> td = new TwoD<Integer>(3, 4);

		System.out.println(td);
		td = new ThreeD(3, 4, 5);
		
		System.out.println(td.toString());
	}

}
