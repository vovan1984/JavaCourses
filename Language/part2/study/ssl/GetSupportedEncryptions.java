package study.ssl;

import javax.net.ssl.SSLSocketFactory;

/**
 * This program displays list of supported encryptions by current 
 * version of Java
 * 
 * @author Vladimir.Igumnov
 * @since 1.11
 */
public class GetSupportedEncryptions
{

	public static void main(String[] args)
	{
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

		System.out.println("List of encryptions supported by Java version " + System.getProperty("java.version") + ":");
		
		for (var encryption : factory.getDefaultCipherSuites())
			System.out.println(encryption);
	}

}
