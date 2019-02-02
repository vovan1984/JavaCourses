package study.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * The {@code DateTime} is a class which shows how to use {@code java.time} 
 * classes. 
 * @author Vladimir Igumnov
 * @version 1.0
 */
public class DateTime
{

	public static void main(String[] args)
	{
		// Date/Time API has only private constructors
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate tomorrow = today.plusDays(2);
		System.out.println(tomorrow);
		
		today = today.minusDays(10); // bad variable name!!!
		System.out.println(today);
		
		String hello = "Hello";
		System.out.println(hello);
		String h2 = hello.concat(" world");
		System.out.println(h2);
		
		Period p = Period.of(1, 25, 100);
		System.out.println(p);
		p = p.normalized();
		System.out.println(p);
		
		LocalDate future = today.plus(p);
		System.out.println(future);
		
		LocalTime nineThirteen = LocalTime.of(9, 13);
		System.out.println(nineThirteen);
		
		// FAILS, times cannot represent days etc!!!
//		LocalTime muchLater = nineThirteen.plus(p);
//		System.out.println(muchLater);
		
		LocalDate tod = LocalDate.now();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d M yy");
		System.out.println(fmt.format(tod));
	}

}
