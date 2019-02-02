package study.unicode;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This program identifies last name using BreakIterator
 *  
 * @author Vladimir.Igumnov
 * @see UnicodeExample
 */
public class BreakIteratorTest
{
	private static String lastName(String str)
	{
		BreakIterator bi = BreakIterator.getWordInstance();
		bi.setText(str);
		int end = bi.last();
		int start = bi.previous();
		return str.substring(start, end);
	}

	public static void main(String[] args)
	{
		ArrayList<String> al = new ArrayList<>(Arrays.asList("Антон Павлович Чехов", "John Peterson", "Li Yang", "John P. Johnson", "马云A ééक्तु𝔊"));

		al.forEach(s -> System.out.printf("Last name of %-20s: %s%n", s, lastName(s)));
	}

	
}
