package calculator;

public class Calculate
{  
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Please enter 2 arguments!");
            System.exit(1);
        }
        System.out.println("Calculate...");
        long first = Long.valueOf(args[0]);
        long second = Long.valueOf(args[1]);
        
        System.out.println(first + " + " + second + " = " + sum(first, second));
        System.out.println(first + " - " + second + " = " + minus(first, second));
        System.out.println(first + " * " + second + " = " + multiply(first, second));
        System.out.println(first + "/" + second + " = " + divide(first, second));
        System.out.println(first + "^" + second + " = " + power(first, second));
        
        double firstD = first;
        double secondD = second;
        
        System.out.println(firstD + " + " + secondD + " = " + sum(firstD, secondD));
        System.out.println(firstD + " - " + secondD + " = " + minus(firstD, secondD));
        System.out.println(firstD + " * " + secondD + " = " + multiply(firstD, secondD));
        System.out.println(firstD + "/" + secondD + " = " + divide(firstD, secondD));
        System.out.println(firstD + "^" + secondD + " = " + power(firstD, secondD));
    }
    
    private static long sum(long first, long second)
    {
        return first + second;
    }    
    
    private static double sum(double first, double second)
    {
        return first + second;
    }
    
    private static long minus(long first, long second)
    {
        return first - second;
    }    
    
    private static double minus(double first, double second)
    {
        return first - second;
    }  

    private static long multiply(long first, long second)
    {
        return first * second;
    }    
    
    private static double multiply(double first, double second)
    {
        return first * second;
    }   

    private static long divide(long first, long second)
    {
        return first / second;
    }    
    
    private static double divide(double first, double second)
    {
        return first / second;
    }    
    
    private static long power(long first, long second)
    {
        return (long)Math.pow(first, second);
    }    
    
    private static double power(double first, double second)
    {
        return Math.pow(first, second);
    }
}
