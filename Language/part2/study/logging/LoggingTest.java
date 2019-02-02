package study.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingTest
{

	public static void main(String[] args)
	{
		ServerFormatter sf = new ServerFormatter();
		
		Logger logger      = Logger.getLogger("");
		Logger logger1     = Logger.getLogger("1");
		Logger logger1_2   = Logger.getLogger("1.2");
		
		/* 
		 * add handlers to logger1 and logger1_2, because
		 * they don't have default loggers
		 */
		ConsoleHandler ch = new ConsoleHandler();
		ch.setFormatter(sf);
		
		logger1.addHandler(ch);
		logger1_2.addHandler(ch);
		


		logger1 .setLevel(Level.WARNING);
		logger1_2.setLevel(Level.INFO);

		logger     .info("msg:");
		logger1    .info("msg: 1");
		logger1_2  .info("msg: 1.2");
	}

}
