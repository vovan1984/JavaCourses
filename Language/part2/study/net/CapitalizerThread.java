package study.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.text.Normalizer;

public class CapitalizerThread extends Thread
{
	private Socket client;
	private SocketAddress clientAddress;
	private String logPrefix;
	
	CapitalizerThread(Socket client)
	{
		this.client = client;
		clientAddress = client.getRemoteSocketAddress();
		logPrefix = "[" + clientAddress + "] ";
	}
	
	@Override
	public void run()
	{
		// process the connection
		System.out.println("\n" + logPrefix + "Got new connection. Starting new thread.");

		try
		{
			var is = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
			var os = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"));

			String str; 
			while ( (str = is.readLine()) != null)
			{
				System.out.println(logPrefix + "Received: " + str);

				if (!Normalizer.isNormalized(str, Normalizer.Form.NFC))
					str = Normalizer.normalize(str, Normalizer.Form.NFC);

				os.write(str.toUpperCase() + '\n'); 
				os.flush();
			}
		} 
		catch (IOException e)
		{
			// Just print error message
			System.out.println(logPrefix + "IO error!");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				client.close();
			}
			catch (IOException e)
			{
				// Just print error message
				System.out.println(logPrefix + "Failed to close connection");
				e.printStackTrace();
			}
			
		}
		
		System.out.println(logPrefix + "Client disconnected!\n");
	}
}
