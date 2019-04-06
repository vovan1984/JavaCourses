package study.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateDemo 
{

	public static void main(String[] args) 
	{
		// define format of the day
	    SimpleDateFormat sdf = new SimpleDateFormat("dd YYY MMMM G, hh:mm z");
	    
	    // current date
	    Date curDate = new Date();

	    System.out.println(sdf.format(curDate));
	}

}
