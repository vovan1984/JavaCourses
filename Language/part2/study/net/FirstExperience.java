/**
 * The file for FirstExperience.java
 */
package study.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Vladimir.Igumnov
 * @since 1.10
 */
public class FirstExperience
{
	/**
	 * @param args Not in use
	 */
	public static void main(String[] args)
	{
		try
		{
			var localHost = InetAddress.getLocalHost();
			System.out.println("Local: " + localHost);
			var yandexHosts = InetAddress.getAllByName("yandex.ru");
			int num = 0;
			for (var yandexHost : yandexHosts)
			{
				boolean multiCast = yandexHost.isMulticastAddress();
				System.out.println("Yandex host #" + ++num + " " + yandexHost +
						"\t Multicast? " + multiCast);
			}
			
			System.out.println("Local host address: " + localHost.getHostName());
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
