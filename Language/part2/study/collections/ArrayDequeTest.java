package study.collections;

import java.util.ArrayDeque;

public class ArrayDequeTest
{
	public static void main(String[] args)
	{
		ArrayDeque<Integer> ali = new ArrayDeque<>();
		ali.push(5);
		ali.push(8);
		ali.push(10);
		ali.push(1);
		ali.push(56);
		
		System.out.println(ali);
		
		Integer k;
		
		while ( (k = ali.pollFirst()) != null)
		{
			System.out.print(k + " ");
		}

	}
}
