package study.types;

public class FloatingTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
        System.out.println(Float.MAX_EXPONENT);
        System.out.println(Float.MIN_EXPONENT);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_NORMAL);
        System.out.println(Float.MIN_VALUE);
        
        // precision imperfection
        double first  = 10.8887776665554443;
        double second =  0.0000000000000001; 
        System.out.println("first = <" + first + ">");
        System.out.println("first = <" + second + ">");
        System.out.println("first - second = <" + (first - second) + ">");  
        
        //binary numbers
        byte bin = 0b1111111; // 127
        byte dec = 127;
        byte oct = 0177;      // 127
        byte hex = 0x7F;      // 127
        
        if (bin==dec)
        {
        	if (oct == dec)
        	{
        		if (hex == dec)
        		{
        			System.out.println("0b1111111 == 127 == 0177 == 0x7F");
        		}
        		else System.out.println("0x7F is not equal to 127!");
        	}
        	else System.out.println("0177 is not equal to 127!");
        }
        else System.out.println("0b1111111 is not equal to 127!");
        
        System.out.println("Some Unicode characters:");
        System.out.println("\u01F0 = <" + '\ua432' + ">");
	}
}
