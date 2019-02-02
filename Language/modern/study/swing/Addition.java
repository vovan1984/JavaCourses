// addition program which uses JOptionPane for input and output
package study.swing;

import javax.swing.JOptionPane;

public class Addition
{
	public static void main(String[] args)
	{
		// Obtain user input from JOptionPane input dialogs
		String firstNumber  = JOptionPane.showInputDialog("Enter first integer");
		String secondNumber = JOptionPane.showInputDialog("Enter second integer");
		
		// convert String inputs to int values for use in a calculation
		int number1 = Integer.parseInt(firstNumber),
			number2 = Integer.parseInt(secondNumber);
		
		int sum = number1 + number2;
		
		// display result in JOpationPane message dialog
		JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of integers", JOptionPane.PLAIN_MESSAGE);
	}
}

