package study.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class RawHttpClient
{
	private final static int PORT = 80;
	private final static String SERVER = "www.google.com";

	public static void main(String[] args)
	{
		try(var httpSocket = new Socket(SERVER, PORT))
		{
			var os = new OutputStreamWriter(httpSocket.getOutputStream());
			var is = new BufferedReader(new InputStreamReader(httpSocket.getInputStream()));
			
			System.out.println("Sending request");
			os.write("GET / HTTP/1.1");
			os.write("\r\n\r\n");
			os.flush();
			
			System.out.println("Reading response");
			String response;
			while ( (response = is.readLine()) != null)
				System.out.println(response);
		} catch (UnknownHostException e)
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
