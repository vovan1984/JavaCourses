package study.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Program uses User Datagram Protocol to get current time from server
 * @author Vladimir.Igumnov
 * @since 1.11
 */
public class DatagramTimeClient
{
	private final static Logger logger = Logger.getLogger(DatagramTimeClient.class.getCanonicalName());

	public static void main(String[] args)
	{
		int port;
		String server;
		
		// get server host and address from the input
		if (args.length != 2)
		{
			logger.severe("Usage: DatagramTimeClient <server> <port>");
			return;
		}
		else try
		{
			server = args[0];
			port = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException e)
		{
			logger.info("Invalid port: " + args[1] + ". It must be of integer type!");
			return;
		}
		
		/* 
		 * Create socket to send and receive datagrams from
		 * random port assigned by OS. 
		 */
		
		try (DatagramSocket socket = new DatagramSocket())
		{
			// stop waiting for response after 10 sec
			socket.setSoTimeout(10000);
			
			// send request to time server
			InetAddress ia = InetAddress.getByName(server);
			DatagramPacket request = new DatagramPacket(new byte[1], 1, ia, port);
			socket.send(request);
			logger.info("Request was sent successfully!");
			
			// get response from time server
			DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
			socket.receive(response);
			logger.info("Response was received!");
			System.out.println(new String(response.getData(), response.getOffset(), response.getLength(), "UTF-8"));
			
		} catch (SocketException e)
		{
			logger.log(Level.SEVERE, "Socket can't be opened", e);
		} catch (UnknownHostException e)
		{
			logger.log(Level.SEVERE, "No IP address for the host " + server + " can be found!", e);
		} catch (IOException e)
		{
			logger.log(Level.SEVERE, "I/O error!", e);
		}

	}

}
