package study.collections;

import java.util.LinkedList;
import java.util.List;

public class FirstAttempt
{
	private static enum Status {FIRST, SECOND, THIRD};
	
	public static void main(String[] args)
	{
		Status gameStatus = Status.FIRST;

		System.out.println(gameStatus);
		
		if (gameStatus.ordinal() == 0)
			System.out.println("Cool!");
		
		List<Integer> ali = List.of(5, 8, 10);
		
		Integer[] ia = new Integer[1];
		
		ia = ali.toArray(ia);
		
		System.out.println(ali);
		
		LinkedList<Integer> lli = new LinkedList<>(ali);
		
		lli.set(0, 100);
		
		System.out.println(lli);
		System.out.println(ali); // first 
	} // main
}
