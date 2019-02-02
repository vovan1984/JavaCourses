package study.unicode;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.*;
import java.text.Normalizer;

public class UnicodeExample
{

	public static void main(String[] args)
	{
		// Unicode sequences are used as identifiers
		char c1 = 0x20AC, 東 = 0x6771, \uCC00 = 0xCC00;
		String c4 = "\uD835\uDD0A";
		
		if(Normalizer.isNormalized(c4,	Normalizer.Form.NFC))
		{
			System.out.println("c1 = '" + c1 + "', 東 = '" + 東 + "', \uCC00 = '" + \uCC00 + "', c4 = '" + c4 +"'");
		}
		               
		System.out.println("Code point " + c4.codePointAt(0) + " represents symbol '" + c4 + "' and contains " 
		                    + Character.charCount(c4.codePointAt(0)) + " chars");
		
		try
		{
			PrintStream ps = new PrintStream(System.out, true, "UTF-8");
			ps.println("c1 = '" + c1 + "', 東 = '" + 東 + "', \uCC00 = '" + \uCC00 + "', c4 = '" + c4 +"'");
			
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	    int x1 = 0x1D50A;
		Character.UnicodeBlock cub = Character.UnicodeBlock.of(x1);
	    System.out.println("0x1D5"
	    		+ "0A codepoint is used for character '" + String.valueOf(Character.toChars(x1))
	                     + "' from " + cub + " Unicode block");
	    
	    Charset charset = Charset.defaultCharset();
	    
	    System.out.println("Default encoding is " + charset + "(Aliases: " + charset.aliases() + ")");
	}

}
