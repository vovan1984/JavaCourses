package study.other;

public class PkgTest
{

	public static void main(String[] args)
	{
		Package[] pkgs = Package.getPackages();
		
		for (Package p : pkgs)
		{
			System.out.println("Package info: " + p.getName() + ", " 
					+ p.getImplementationTitle() + ", "
					+ p.getImplementationVersion());
		}

	}

}
