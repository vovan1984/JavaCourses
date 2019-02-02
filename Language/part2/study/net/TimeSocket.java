/**
 * This program reads current time from time.nist.gov
 */
package study.net;

import java.io.IOException;
import java.net.Socket;

public class TimeSocket
{

	public static void main(String[] args)
	{
		try (Socket socket = new Socket("time.nist.gov", 13)) 
		{
			socket.setSoTimeout(15000);
			// Show from where we connect
			System.out.println("We connect from: " + socket.getLocalSocketAddress());
			System.out.println("We connect to  : " + socket.getRemoteSocketAddress());
			var is = socket.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char)c);
			System.out.println();
			is.close();
		} catch (IOException ex) 
		{
			System.err.println("Could not connect to time.nist.gov");
		}
	}

}
