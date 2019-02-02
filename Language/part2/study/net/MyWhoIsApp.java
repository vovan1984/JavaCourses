package study.net;

public class MyWhoIsApp
{
	private final static String WHOIS_IANA = "whois.iana.org";

	public static void main(String[] args)
	{		
		// Check that domains to check are provided in input
		if (args.length < 1)
		{
			System.out.println("Invalid input arguments\n" +
					"Usage: MyWhoIs <domain> [more domains via space]");
			return;
		}
		
		var whoisIana = new MyWhoIs(WHOIS_IANA);
		
		for (String domain :  args)
		{
			// find top-level domain whois server
			String tld = whoisIana.getTld(domain);
			
			if (tld != null)
			{
				System.out.println("Found top level domain whois server: " + tld);

				// find registrar whois server
				var whoisTld = new MyWhoIs(tld);
				String registrar = whoisTld.getRegistrar(domain);

				if (registrar != null)
				{
					System.out.println("Found registrar whois server: " + registrar);
					var whoisRegistrar = new MyWhoIs(registrar);
					whoisRegistrar.displayInfo(domain);
				}
				else
					whoisTld.displayInfo(domain);
			}
			else
				whoisIana.displayInfo(domain); // display whatever we have
		}
	}

}
