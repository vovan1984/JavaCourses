package study.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TraceTest
{
	static String[] sites = {
			"http://www.cafeaulait.org",
			"https://meduza.io",
			"https://yandex.ru"
			         };

	public static void main(String[] args)
	{		
		try
		{
			URL u;
			u = new URL(sites[0]);
			HttpURLConnection con = (HttpURLConnection) u.openConnection();
			con.setRequestMethod("TRACE");
			
			if (con.usingProxy())
				System.out.println("Note: this connection is using proxy!");
			
			var br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			while ((line = br.readLine()) != null)
				System.out.println(line);
			
			br.close();
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
