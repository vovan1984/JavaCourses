package study.classes;

public class CompoundInterest
{
	private final static int NUM_OF_YEARS = 30;
	private final static double TAX_RATE = 0.15;

	public static void main(String[] args)
	{
		double amount = 0.0; //amount on deposit at the end of each year
		double principal = 35759; // initial amount before interest
		double growthRate = 0.07; // interest rate
		
		// display headers
		System.out.printf("%s%20s%n", "Year", "Amount on deposit");
		
		// calculate amount on deposit for each year
		for (int i=1; i<=NUM_OF_YEARS; i++)
		{
			// calculate new amount for specified year
			amount = principal * Math.pow(1.0 + growthRate, i);
			System.out.printf("%4d%20.2f%n", i, amount);
		}
		
		// calculate amount to be paid at retirement
		System.out.printf("Monthly after-tax amount to be paid at the retirement: $%.2f CAD%n", amount*growthRate * (1-TAX_RATE)/12);
	}
}
