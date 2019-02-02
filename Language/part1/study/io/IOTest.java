package study.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOTest
{

	private static String fileName = "part1/study/io/IOTest.java";
	public static void main(String[] args) 
	{
		boolean skip = false;
		
		try (var br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));)
		{
			int c;
			while ((c=br.read()) != -1 )
			{
				if (c == '東')
				{
					br.mark(50);
				}
				
				if (c == '찀' && !skip)
				{
					br.reset();
					skip = true;
				}
					
				System.out.print((char)c);
			}
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Leaving the program");
	}

}
