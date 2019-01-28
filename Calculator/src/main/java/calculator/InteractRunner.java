package calculator;

import java.util.Scanner;

/**
 * Class for running Calculator. It supports input from user.
 */
public class InteractRunner
{
    private int first;       // first argument for calculation.
    private int second;      // second argument for calculation.
    private String operator; // arithmetic operation
    private final Scanner reader;  // reader for getting interaction arguments.
    private final Calculator calc; // processor for performing arithmetic operations.
    
    /**
     * Constructor for a user interaction. 
     * Initialize instance variables.
     */
    private InteractRunner(Scanner reader)
    {
        first = 0;
        second = 0;
        operator = null;
        this.reader = reader;
        calc = new Calculator();
    }
    
    public static void main(String[] args)
    {        
        // read input from console
        try (Scanner reader = new Scanner(System.in))
        {
            // create interaction with a user.
            var interaction = new InteractRunner(reader);
            
            String exit = "no";
            while (!exit.equals("yes"))
            {
                // Set operation to perform
                String op = interaction.setOperator();
                
                // Set arguments only if user asked for an arithmetic operation
                if (!op.equals("clean"))
                    interaction.setOperands();
                    
                // perform the calculation.
                int res = interaction.calculate();
                System.out.println("Result: " + res);
                
                System.out.println("Exit: yes/no");
                exit = reader.next();
            }
        }
    }
    
    /**
     * Set arithmetic operation to perform.
     */
    private String setOperator()
    {
        System.out.print("Enter operation (clean, *, /, +, - or ^): ");
        operator = reader.next();
        return operator;
    }
    
    /**
     * Set operands for operation execution.
     * Operands are taken from user via console.
     */
    private void setOperands()
    {
        // set first and second arguments.
        first = setOperand("Enter first arg (or 'reuse' to reuse previous result): ");
        second = setOperand("Enter second arg (or 'reuse' to reuse previous result): ");
    }


    /**
     * Set calculation argument from a user.
     * @param msg Message for retrieving the argument.
     */
    private int setOperand(String msg)
    {
        int arg = 0;
        String tmp = null;

        System.out.print(msg);

        tmp = reader.next();

        // If user enters 'reuse' then take the latest calculation result
        if (tmp.equals("reuse") || tmp.equals("'reuse'"))
            arg = calc.getResult();
        else
            arg = Integer.valueOf(tmp);

        return arg;
    } // end of setOperand


    /**
     * Peform input operation on interaction arguments.
     * @return Result of the calculation.
     */ 
     private int calculate()
     {
        // check possible options for an operation.
        switch (operator)
        {
            case "+": 
                calc.add(first, second);
                break;
                            
            case "-": 
                calc.subtract(first, second);
                break;    

            case "*": 
                calc.multiply(first, second);
                break;  

            case "/": 
                calc.divide(first, second);
                break;  

            case "^": 
                calc.power(first, second);
                break;                          
                            
            case "clean":
                calc.cleanResult();
                break;
                        
            default: 
                System.out.println("Unknown operation: " + operator);
                calc.cleanResult();
                break;
        }
        
        // return calculation result.
        return calc.getResult();
     } // end of calculate
}