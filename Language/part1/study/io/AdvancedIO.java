package study.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

public class AdvancedIO
{
	private final static String fileName = 
			"C:\\Users\\vladimir.igumnov\\eclipse-workspace\\Java\\part2\\index.html";
	private final static String dirName =
			"C:/Users/vladimir.igumnov/eclipse-workspace/Java/part2/study/util/";
	
	public static void main(String[] args)
	{
		File f = new File(fileName);
		
		System.out.println("Free space: " + f.getFreeSpace());
		System.out.println("Used space: " + f.getTotalSpace());
		
		System.out.println(new Date(f.lastModified()));
		
		File d = new File(dirName);
		System.out.println(new Date(d.lastModified()));
		LinkedList<String> files = new LinkedList<>(Arrays.asList(d.list()));
		files.forEach(System.out::println);
		
		try (FileInputStream  fis = new FileInputStream(f);)
		{
			System.out.println("Contents of " + fileName + ":");
			fis.transferTo(System.out);
			
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("\nNow perform some buffered processing:");
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f)))
		{
			int availBytes = bis.available();
			System.out.println("Available bytes: " + availBytes);
			
			bis.skip(availBytes/2);
			bis.mark(availBytes/2);
			
			for (int i = 0; i<availBytes/16; i++)
				System.out.print((char)bis.read());
			
			System.out.println("\nResetting");
			bis.reset();
			
			for (int i = 0; i<availBytes/17; i++)
				System.out.print((char)bis.read());			
				
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
