import java.util.Scanner;

/**
 * Class for running Calculator. It supports input from user.
 */
public class InteractRunner
{
    public static void main(String[] args)
    {
        try (Scanner reader = new Scanner(System.in))
        {
            Calculator calc = new Calculator();
            String exit = "no";
            while (!exit.equals("yes"))
            {
                System.out.print("Enter first arg: ");
                int first = reader.nextInt();
                System.out.print("Enter second arg: ");
                int second = reader.nextInt();
                calc.add(first, second);
                System.out.println("Result: " + calc.getResult());
                calc.cleanResult();
                System.out.println("Exit: yes/no");
                exit = reader.next();
            }
        }
    }
}