/**
 * This program checks if read() for a byte array
 * blocks in case not entire array is filled
 * 
 * As per Elliotte Rusty Harold, it should not block!
 * Indeed, this program confirms that.
 */
package study.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ByteReaderTestServer 
{
    private final static Logger logger = Logger.getLogger(ByteReaderTestServer.class.getCanonicalName());
    
	public static void main(String[] args) 
	{
		try (ServerSocket ss = new ServerSocket(2500))
		{
			var localHost = InetAddress.getLocalHost();
			System.out.println("Server's address : " + localHost.getHostAddress());
			System.out.println("Server's name    : " + localHost.getHostName());
			System.out.println("Listening to port: " + ss.getLocalPort());
			System.out.println("Default encoding : " + Charset.defaultCharset());
			
			byte[] inputBuf = new byte[1024]; 
			
			while (true)
			{
				try(var socket = ss.accept())
				{
					System.out.println("\nGot connection from " + socket.getRemoteSocketAddress());
					var is = socket.getInputStream();
					int bytesRead = is.read(inputBuf);

					if (bytesRead > 0)
						System.out.println(bytesRead + " bytes out of 1024 was read!");
				}
				catch (IOException e)
				{
					logger.log(Level.WARNING, "IO error!");
					e.printStackTrace();					
				}
			}
		} catch (IOException e) 
		{
			logger.log(Level.SEVERE, "Failed to start server!");
			e.printStackTrace();
			return;
		}

	}

}
