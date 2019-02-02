package study.util;

import java.util.Calendar;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Locale;

public class LocalizationTryOuts
{
	private static void handle(Formatter fmt)
	{
		fmt.format("[%tc] Floating number in %s: %f = %<e", Calendar.getInstance(), fmt.locale().getDisplayName(), 
				    Math.E);
		System.out.println(fmt);
		fmt.close();
	}
	
	public static void main(String[] args)
	{
		var lArr = Locale.getAvailableLocales();
		var fmtList = new LinkedList<Formatter>();
		
		for (Locale l : lArr)
		 fmtList.addFirst(new Formatter(l));
		
		fmtList.forEach(LocalizationTryOuts::handle);
	}

}
