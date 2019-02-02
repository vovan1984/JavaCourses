package study.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * This class shows usage of {@code PrintStream} for writing to a new file,
 * or adding data to an existing file.
 * 
 * First it writes to PrintStreamTestDuplicate.my (by overriding if it exists);
 * then closes that new file, reopens it and writes the same data again. As a 
 * result the output file has duplicate content.
 * 
 * This class also demonstrates some usage of {@code Formatter} class.
 * 
 * @author Vladimir Igumnov
 * @version 1.0
 * @since 1.10
 * @see study.io.AdvancedIO
 */
public class PrintStreamTest
{
	static private final String outFileName =
			"C:\\Users\\vladimir.igumnov\\eclipse-workspace\\Java\\resources\\PrintStreamTestDuplicate.my";
	
	static private final String text = "Карты выполнены в двух вариантах: на одних изображен проект участка " + 
			"Варшавского шоссе, а на других — инопланетные разумные машины-трансформеры";

	public static void main(String[] args)
	{
		// Write text first time
		try (OutputStream fos = new FileOutputStream(outFileName);
			 PrintStream ps = new PrintStream(fos))
		{
			ps.println(text);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Add text second time
		try (OutputStream fos = new FileOutputStream(outFileName, true);
				 PrintStream ps = new PrintStream(fos))
			{
				ps.println(text);
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

}
