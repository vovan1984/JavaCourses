package study.util;

import java.util.*;

public class LearnUtil
{

	public static void main(String[] args)
	{
		Comparator<Integer> c = (n1, n2) -> n1 - n2;
		
		System.out.println(c + " : " + Comparator.naturalOrder());

	}

}
