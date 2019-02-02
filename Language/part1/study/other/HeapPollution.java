package study.other;

import java.util.Arrays;
import java.util.List;

public class HeapPollution
{
	 @SafeVarargs // Not actually safe!
	 static <T> void m(T ... stringLists) 
	 {
	   Object[] array = stringLists;
	   List<Integer> tmpList = Arrays.asList(42);
	   array[0] = tmpList; // Semantically invalid, but compiles without warnings
	   T s = stringLists[0]; // Oh no, ClassCastException at runtime!
	   System.out.println(s);
	 }
	 
	 public static void main(String[] args)
	 {
		 Number[] n = new Integer[10];
		 n[0] = 0b1_1;
		 System.out.println(n[0]);
		 
		 HeapPollution.m(1, 2, 3, 4, 5);
	 }
}	
