package study.javadoc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * The {@code ScannerTest} is a class which shows how to use {@code java.util.Scanner} 
 * objects. Examples are provided for reading from input {@code String} object, as 
 * well as from the {@code InputStreamReader}.
 * For more information check {@link study.collections.EnumSetTest EnumSetTest}
 * @see study.datetime.DateTime
 * @author Vladimir Igumnov
 * @version 1.0
 */
public class ScannerTest
{
	/**
	 * This constant field contains file name to be ready by {@code ScannerTest}
	 */
	private final static String fileName = 
			"C:/Users/vladimir.igumnov/eclipse-workspace/Java/part2/study/util/MyResources_ru_BY.properties";
	
	/**
	 * This is main method of the {@code ScannerTest} class. 
	 * It creates required objects and organizes the flow.
	 * 
	 * @param args Input to the program (usually not provided)
	 */
	public static void main(String[] args)
	{
		String testStr = "Hts,32 sdsfa,32 ds ds325 3, dsfkdsaj 325 calendar test, ! 8 -73 dsfsdl ...";

		try (Scanner scan = new Scanner(testStr))
		{
			scan.useDelimiter(", *");
			while (scan.hasNext())
			{
				String token = scan.next();
				System.out.println(token);
				
			}
		}
	
		
		try (	FileInputStream fis = new FileInputStream(fileName);
				Scanner scan = new Scanner(new InputStreamReader(fis));
				)
		{
			System.out.println("Available bytes to read without blocking: " + fis.available());
			
			while (scan.hasNext())
			{
				String str = scan.nextLine();
				System.out.println(str);
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try (
				FileInputStream fis = new FileInputStream(fileName);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF8")))
		{
			String str;
			while ((str = br.readLine()) != null)
			{
				System.out.println("Length = " + str.length() + "; " + str);
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
