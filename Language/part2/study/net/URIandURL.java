package study.net;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URIandURL
{

	public static void main(String[] args)
	{
		try
		{
			String spec = "http://www.xml.com/pub/東/пр/2003/stax.html#id=_h\uCC00%40";
			var myURI = new URI(spec);
			System.out.println(myURI);
			System.out.println(myURI.toASCIIString());
			
			var myURL = new URL(spec);
			System.out.println(myURL);
			System.out.println(myURL.toExternalForm());
		} catch (URISyntaxException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
