package study.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest
{

	public static void main(String[] args)
	{
		Locale ruBel = new Locale("ru", "BY"),
			   ruRu  = new Locale("ru", "RU"),
			   deRu  = new Locale("de", "DE");
		
		ResourceBundle rb = ResourceBundle.getBundle("study.util.MyResources", ruBel);		
		System.out.println(rb.getString("hello"));
		
		rb = ResourceBundle.getBundle("study.util.MyResources", ruRu);
		System.out.println(rb.getString("hello"));
		
		rb = ResourceBundle.getBundle("study.util.MyResources", deRu);
		System.out.println(rb.getString("hello"));
	}

}
