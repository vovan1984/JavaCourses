/**
 * This class represent WhoIs object, which is able to retrieve information
 * from the whois server for which it was constructed 
 */
package study.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;

public class MyWhoIs
{
	private final static int DEFAULT_PORT = 43; // default whois port
	
	private String lastQueriedDomain;
	private LinkedList<String> lastQueryResult;
	
	private String server;
	private int port;
	
	public String getServer()
	{
		return server;
	}

	public void setServer(String server)
	{
		this.server = server;
	}

	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	MyWhoIs(String server, int port)
	{
		this.server = server;
		this.port = port;
		lastQueriedDomain = null;
		lastQueryResult = null;
	}
	
	MyWhoIs(String server)
	{
		this(server, DEFAULT_PORT);
	}
	
	// return list of lines containing output of whois server
	public LinkedList<String> queryDomain(String domain)
	{
		// if domain was already queried
		if (lastQueriedDomain != null && lastQueriedDomain.equals(domain))
			return lastQueryResult;
		
		LinkedList<String> sb = new LinkedList<>();
		
		try (var socket = new Socket(server, port))
		{
			// Show from where we connect
			System.out.println("\nConnecting from: " + socket.getLocalSocketAddress());
			System.out.println("Connecting to  : " + socket.getRemoteSocketAddress());

			var is = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			var os = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");

			// Write to whois server
			os.write(domain + "\r\n");
			os.flush();

			// Get response from whois server
			String line;
			while ( (line = is.readLine()) != null)
			{
				sb.add(line);   
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
	
		lastQueriedDomain = domain;
		lastQueryResult = sb;
		
		return sb;
	}
	
	public void displayInfo(String domain)
	{
		var queryOutput = queryDomain(domain);
		System.out.println();
		for (String line : queryOutput)
			System.out.println(line);
	}
	
	// Get TLD server name (if applicable) from whois output
	public String getTld(String domain)
	{
		String tld = null;
		var queryOutput = queryDomain(domain);
		for (String line : queryOutput)
		{
			if (line.startsWith("whois:"))
				tld = line.split(":")[1].trim();
		}
		
		return tld;
	}
	
	// Get registrar name (if applicable) from whois output
	public String getRegistrar(String domain)
	{
		String regristrar = null;
		var queryOutput = queryDomain(domain);
		for (String line : queryOutput)
		{
			if (line.contains("Registrar WHOIS Server:"))
				regristrar = line.split(":")[1].trim();
		}
		
		return regristrar;		
	}
}
