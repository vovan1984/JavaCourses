package study.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;


/**
 * This is the main server class for the capitalization application.
 * It listens for messages for clients, capitalizes those strings, and
 * sends the modified sequence back.
 * 
 * Clients display received message.
 * Every client is processed by separate Thread.
 * 
 * @author Vladimir.Igumnov
 * @since 1.11
 * @see study.net.MyFirstTextClient
 * @see study.net.CapitalizerThread
 */
public class ThreadedCapitalizerServer
{

	/**
	 * @param args None at this time
	 */
	public static void main(String[] args)
	{
		// Display IP address of the Server app
		try (var server = new ServerSocket(2500))
		{
			var localHost = InetAddress.getLocalHost();
			System.out.println("Server's address : " + localHost.getHostAddress());
			System.out.println("Server's name    : " + localHost.getHostName());
			System.out.println("Listening to port: " + server.getLocalPort());
			System.out.println("Default encoding : " + Charset.defaultCharset());
			
			// wait for client to connect
			while (true)
			{
				try 
				{		
					var client = server.accept();
					
					Thread capitalizer = new CapitalizerThread(client);
					
					capitalizer.start();
				}
				catch (IOException ex) 
				{
					System.out.println(ex.getMessage());
				}		
			}
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
