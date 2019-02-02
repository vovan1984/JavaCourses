package study.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This is the main server class for the capitalization application.
 * It listens for messages for clients, capitalizes those strings, and
 * sends the modified sequence back.
 * <br>
 * Clients display received message.
 * Every client request is processed by pool of threads from ExecutorService.
 * 
 * @author Vladimir.Igumnov
 * @since 1.11
 * @see study.net.CapitalizerCall
 * @see study.net.MyFirstTextClient
 */
public class PooledCapitalizerServer
{
	private final static Logger logger = Logger.getLogger(PooledCapitalizerServer.class.getName());

	/**
	 * @param args None at this time
	 */
	public static void main(String[] args)
	{
		// Create pool with 2 threads
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		// Display IP address of the Server app
		try (var server = new ServerSocket(2501))
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
					logger.info("["+ client.getRemoteSocketAddress() + "] Got new connection. Starting new thread.");
					
					var capitalizer = new CapitalizerCall(client);
					
					pool.submit(capitalizer);
				}
				catch (IOException ex) 
				{
					logger.log(Level.WARNING, "Error while getting connection from client!", ex);
				}		
			}
		} catch (UnknownHostException e)
		{
			logger.log(Level.SEVERE, "Could not get server address!", e);
		} catch (IOException e)
		{
			logger.log(Level.SEVERE, "Could not start server!", e);
		}

	}

}
