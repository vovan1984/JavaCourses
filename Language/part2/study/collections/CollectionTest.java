package study.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;

public class CollectionTest
{

	public static void main(String[] args)
	{
		ArrayList<Integer> ali = new ArrayList<>();
		ali.add(5);
		ali.add(8);
		ali.add(10);
		ali.add(1);
		ali.add(56);

		Spliterator<Integer> s = ali.spliterator();
		
		while (s.tryAdvance(x->System.out.print(x + " ")));
		System.out.println();
		
		Iterator<Integer> i = ali.iterator();
		i.forEachRemaining(x->System.out.print(x*x + " "));
		System.out.println();
		
		try
		{
			Thread.sleep(100);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// runtime exception
		Integer[] ia = (Integer[]) ali.toArray();
		System.out.println(ia);
	}

}
