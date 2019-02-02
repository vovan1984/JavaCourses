package study.other;

public class Printing 
{
	private final static double sqrt2 = Math.sqrt(2.74e13);
	private final static byte[] bytes = {6, 94, 54};

	public static void main(String[] args) 
	{
		System.out.printf("%f: %<+020.10f%n", sqrt2);
		System.out.format("%f: %<,+020.10f%n", sqrt2);

		for (var b : bytes)
			System.out.format("%02X", b);
		System.out.println();
		
		bytes[2] = 10;
		for (var b : bytes)
			System.out.format("%02X", b);
		System.out.println();
	}

}
