package study.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * This program uses channels to write 26 bytes starting from position 15 
 * from the beginning of the text file created by {@link study.io.PrintStreamTest}.
 * 
 * @author Vladimir Igumnov
 * @since 1.10
 *
 */
public class FileModification
{

	/**
	 * @param args Not in use
	 */
	public static void main(String[] args)
	{
		Path t = Paths.get("resources/PrintStreamTestDuplicate.my");
		System.out.println(t.toAbsolutePath());
		
		try (var channel = Files.newByteChannel(t, StandardOpenOption.WRITE))
		{
			ByteBuffer buf = ByteBuffer.allocate(26);
			for (int i = 0; i < 26; i++)
				buf.put((byte)('A' + i));
			buf.rewind();
			
			channel.position(15);
			channel.write(buf);
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
