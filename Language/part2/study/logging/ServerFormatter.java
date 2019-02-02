package study.logging;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class ServerFormatter extends SimpleFormatter
{
	@Override
	public String format(LogRecord record)
	{
		return record.getMessage()+"\n";
	}

}
