package study.net;

/**
 * 
 * This program implements UDP time server.
 * The server listens on UDP port #13 and responds 
 * with current date.
 * 
 * @author Vladimir.Igumnov
 * @since 1.11
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatagramTimeServer
{

	private final static int PORT = 1013;
	private final static Logger logger = Logger.getLogger(DatagramTimeServer.class.getCanonicalName());

	public static void main(String[] args)
	{
		/* 
		 * Create socket to send and receive datagrams from
		 * random port assigned by OS. 
		 */

		try (DatagramSocket socket = new DatagramSocket(PORT))
		{
			var localHost = InetAddress.getLocalHost();
			System.out.println("Server's address : " + localHost.getHostAddress());
			System.out.println("Server's name    : " + localHost.getHostName());
			System.out.println("Listening to port: " + socket.getLocalPort());
			System.out.println("Default encoding : " + Charset.defaultCharset());

			while (true)
			{
				try
				{
					// get request from the client
					DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
					socket.receive(request);
					logger.info("Request was received from " + request.getSocketAddress());

					// send response to the client
					String currDate = new Date().toString();
					logger.info("Currend date is: " + currDate);

					byte[] currDateBytes = currDate.getBytes("UTF-8"); 		
					DatagramPacket response = new DatagramPacket(currDateBytes, currDateBytes.length, request.getSocketAddress());

					logger.info("Sending response to " + response.getSocketAddress());
					socket.send(response);
					logger.info("Request was sent successfully!");
				}
				catch (IOException e)
				{
					logger.log(Level.WARNING, "I/O error!", e);
				}
			}

		} 
		catch (SocketException e)
		{
			logger.log(Level.SEVERE, "Socket can't be opened", e);
		} catch (UnknownHostException e1)
		{
			logger.log(Level.SEVERE, "This shouldn't happen - localhost was not found!", e1);
		} 


	}
}
