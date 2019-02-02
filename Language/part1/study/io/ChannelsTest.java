package study.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class ChannelsTest
{

	public static void main(String[] args)
	{
		Path t = Paths.get("resources/PrintStreamTestDuplicate.my");
		System.out.println(t.toAbsolutePath());
		
		try (var channel = Files.newByteChannel(t, StandardOpenOption.READ, StandardOpenOption.WRITE))
		{
			BasicFileAttributes bfa = Files.readAttributes(t, BasicFileAttributes.class);
			System.out.println("Creation time: " + bfa.creationTime());
			
			ByteBuffer buf = ByteBuffer.allocate(10);
			
			System.out.println("\nSize of channel: " + channel.size());
			int count;
			do
			{
				// Read into buffer
				count = channel.read(buf);

				if (count != -1)
				{
					System.out.println("\nChannel's position after reading into the buffer: " + channel.position());
					buf.flip();
					
					for (int i = buf.position(); i < buf.limit(); i++)
						System.out.print((char)buf.get());
					
					buf.compact();
				}
			}
			while (count != -1);
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
