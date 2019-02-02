/* Casting to a wrong interface. This should be allowed, but will cause ClassCastException. 
 * Let's see.
 */
package study.exception;

import java.util.Comparator;

public class ExceptionPlayground
{
	public static void main(String[] args)
	{
		ExceptionPlayground ep = new ExceptionPlayground();
		
		// there is a warning only, but ClassCastException at runtime
		@SuppressWarnings("unchecked")
		Comparator<String> s = (Comparator<String>)ep;
		
		System.out.println(s);
		
	}
}
