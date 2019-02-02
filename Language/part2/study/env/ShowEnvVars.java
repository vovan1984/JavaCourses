package study.env;

import java.util.Map;
import java.util.Properties;

public class ShowEnvVars
{

	public static void main(String[] args)
	{
		System.out.println("\n\nDisplaying env variables:");
		
		// show environment variables
		Map<String, String> m = System.getenv();

		for (String key : m.keySet())
			System.out.println(key + " = " + m.get(key));
		
		System.out.println("\n\nDisplaying properties:");
		
		// show properties
		Properties p = System.getProperties();
		
		for (Object key : p.keySet())
			System.out.println(key + " = " + p.getProperty((String)key));
	}

}
