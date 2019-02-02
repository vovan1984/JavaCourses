/**
 * First client-server program. Server listens for messages from clients,
 * capitalizes those messages, and sends them back.
 * Clients display received message.
 */
package study.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.Normalizer;


/**
 * This is the main server class for the capitalization application.
 * It listens for messages for clients, capitalizes those strings, and
 * sends the modified sequence back.
 * 
 * @author Vladimir.Igumnov
 * @since 1.10
 * @see study.net.MyFirstTextClient
 */
public class MyFirstServer
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
				try (var s = server.accept())
				{			
					// process the connection
					System.out.println("\nGot new connection from " + s.getRemoteSocketAddress());
					
					var is = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
					var os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));

					String str; 
					while ( (str = is.readLine()) != null)
					{
						System.out.println("Received: " + str);

						if (!Normalizer.isNormalized(str, Normalizer.Form.NFC))
							str = Normalizer.normalize(str, Normalizer.Form.NFC);

						os.write(str.toUpperCase() + '\n'); 
						os.flush();
					}
					
					System.out.println("Client disconnected!\n");
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
