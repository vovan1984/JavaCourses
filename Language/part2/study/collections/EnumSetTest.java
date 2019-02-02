package study.collections;

import java.lang.annotation.RetentionPolicy;
import java.util.EnumSet;

public class EnumSetTest
{

	private enum Apple {ONE, TWO, THREE};
	
	public static void main(String[] args)
	{
		Apple ap = Apple.ONE;
		
		System.out.println("ap = " + ap);
		
		EnumSet<Apple> es = EnumSet.allOf(Apple.class);
		
		System.out.println(es);
		
		EnumSet<RetentionPolicy> rp = EnumSet.allOf(RetentionPolicy.class);

		System.out.println(rp);
	}

}
