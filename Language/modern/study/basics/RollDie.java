package study.basics;

import java.security.SecureRandom;

public class RollDie
{

	// Roll a die for 6,000,000 times
	public static void main(String[] args) throws Exception
	{
		final SecureRandom sr = new SecureRandom();
		
		int rollOne = 0;
		int rollTwo = 0;
		int rollThree = 0;
		int rollFour = 0;
		int rollFive = 0;
		int rollSix = 0;
		
		for (int i = 0; i < 6000000; i++)
		{
			switch (sr.nextInt(6) + 1)
			{
			case 1: 
				rollOne++; 
				break;
			case 2: 
				rollTwo++;
				break;
			case 3: 
				rollThree++;
				break;
			case 4: 
				rollFour++;
				break;
			case 5:
				rollFive++;
				break;
			case 6:
				rollSix++;
				break;
			default: 
				System.out.println("Something bad happened!");
				throw new Exception("AAA!");
			}
		}

		System.out.println("Number of ones: " + rollOne);
		System.out.println("Number of twos: " + rollTwo);
		System.out.println("Number of threes: " + rollThree);
		System.out.println("Number of fours: " + rollFour);
		System.out.println("Number of fives: " + rollFive);
		System.out.println("Number of six: " + rollSix);
	}

}
