/**
  * First client-server program. Server listens for messages from clients,
 * capitalizes those messages, and sends them back.
 * Clients display received message.
 */
package study.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;



/**
 * This is the text client class for the capitalization application.
 * It asks user to enter console messages, sends them to server,
 * and displays the returned string.
 * 
 * The program also uses non-ASCII Unicode characters for identifiers. 
 * For more examples of Unicode use please refer to the implementation 
 * of {@link study.unicode.UnicodeExample}
 *           
 * 
 * @author Vladimir.Igumnov
 * @since 1.10
 * @see study.net.PooledCapitalizerServer
 */
public class MyFirstTextClient
{
	private static String server;
	private static int port;
	

	/**
	 * @param args None at this time
	 */
	public static void main(String[] args)
	{
		// Check that server and port info are provided in input
		if (args.length != 2)
		{
			System.out.println("Invalid input arguments\n" +
					"Usage: MyFirstTextClient <server> <port>");
			return;
		}
		else try
		{
			server = args[0];
			port = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException e)
		{
			System.out.printf("Invalid argument: %s%nIt must be of integer type!%n", args[1]);
			return;
		}
	
		// Connect to the server
		System.out.println("Connecting to " + server + ":" + port);
		
		try (var сокет = new Socket(server, port);
		     var br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));)
		{
			var is = new BufferedReader(new InputStreamReader(сокет.getInputStream(), "UTF-8"));
			var os = new OutputStreamWriter(сокет.getOutputStream(), "UTF-8");
			
			String msg;
			do
			{
				System.out.print("Please enter the message (enter \"done\" to exit): ");
				msg = br.readLine();
				if (msg != null && !msg.equals("done"))
				{
					// send the request
					System.out.println("Sending: " + msg);
					os.write(msg + '\n');
					os.flush();
					
					// process the response
					System.out.print("Response from server: ");
					
					String response = is.readLine();
					if (response != null)
						System.out.println(response);
					else
						System.out.println();

				}
			}
			while (msg != null && !msg.equals("done"));
			
			System.out.println("Goodbye!");
			
		} catch (UnknownHostException e)
		{
			System.out.println("Can't connect to requested server!");
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
