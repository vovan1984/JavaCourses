package study.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.text.Normalizer;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CapitalizerCall implements Callable<Void>
{
	private Socket client;
	private SocketAddress clientAddress;
	private String logPrefix;
	
	private final static Logger logger = Logger.getLogger(PooledCapitalizerServer.class.getName());
	
	public CapitalizerCall(Socket client)
	{
		this.client = client;
		clientAddress = client.getRemoteSocketAddress();
		logPrefix = "[" + clientAddress + "] ";
	}

	@Override
	public Void call()
	{
		// process the connection
		try
		{
			var is = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
			var os = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"));

			String str; 
			while ( (str = is.readLine()) != null)
			{
				logger.info(logPrefix + "Received: " + str);

				if (!Normalizer.isNormalized(str, Normalizer.Form.NFC))
					str = Normalizer.normalize(str, Normalizer.Form.NFC);

				os.write(str.toUpperCase() + '\n'); 
				os.flush();
			}
		} 
		catch (IOException e)
		{
			// Just print error message
			logger.log(Level.WARNING, logPrefix + "IO error!", e);
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
				logger.log(Level.WARNING, logPrefix + "Failed to close connection", e);
				e.printStackTrace();
			}	
		}
		
		logger.info(logPrefix + "Client disconnected!");
		
		return null;
	}

}
