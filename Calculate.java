public class Calculate
{  
    public static void main(String[] args)
    {
        System.out.println("Calculate...");
        long first = Long.valueOf(args[0]);
        long second = Long.valueOf(args[1]);
        
        System.out.println(first + " + " + second + " = " + sum(first, second));
        System.out.println(first + " - " + second + " = " + minus(first, second));
        System.out.println(first + " * " + second + " = " + multiply(first, second));
        System.out.println(first + "/" + second + " = " + divide(first, second));
        System.out.println(first + "^" + second + " = " + power(first, second));
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
