package study.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.zip.GZIPInputStream;


public class URLDemo
{
	private static final String fileName = "outputdir/URLDemoOutput.txt";
	public static void main(String[] args)
	{
		try (PrintWriter pw = new PrintWriter(fileName))
		{
			//URL hp = new URL("https://www.internic.net/");
			URL hp = new URL("https://meduza.io/");
			
			System.out.println("Protocol    : " + hp.getProtocol());
			System.out.println("Port        : " + hp.getPort());
			System.out.println("Default port: " + hp.getDefaultPort());
			System.out.println("Host        : " + hp.getHost());
			System.out.println("File        : " + hp.getFile());
			System.out.println("Path        : " + hp.getPath());
			System.out.println("Ext         : " + hp.toExternalForm());
			
			var con = (HttpURLConnection)hp.openConnection();
			
			// Inspect request header
			System.out.println("\nSending the following request: ");
			var requestHeader = con.getRequestProperties();
			
			requestHeader.forEach((key, value) -> System.out.println(key + ": " + value));
			
			// Inspect response header 
			System.out.println("\nGetting the following response header:");
			var headerFields = con.getHeaderFields();
			headerFields.keySet().forEach(s -> System.out.println(s + ": " + headerFields.get(s)));
			
			System.out.println("\nAnalyzing the response header:");
			System.out.println("Last modifiied: " + new Date(con.getLastModified()));
			System.out.println("Response msg  : " + con.getResponseMessage());
			System.out.println("Content type  : " + con.getContentType());
			System.out.println("Content length: " + con.getContentLength());
			
			// Get encoding from the content type
			String encoding = Charset.defaultCharset().displayName();
			var contentType = con.getContentType().split("charset *= *");
			if (contentType.length == 2)
				encoding = contentType[1];
			System.out.println("Encoding of the response: " + encoding);
			
			// Store the content of the response
			System.out.println("\nStoring the content of response body to the " + fileName);
			// check if content is encoded (e.g. zipped)
			var contentEncoding = con.getContentEncoding();
			InputStream is;
			if (contentEncoding != null && contentEncoding.contains("gzip"))
				is = new GZIPInputStream(con.getInputStream());
			else
				is = con.getInputStream(); 

			var br = new BufferedReader(new InputStreamReader(is, encoding));			
			String str;
			
			while ((str = br.readLine()) != null)
			{
				//System.out.println(str); 
				pw.println(str);
			}
			
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
