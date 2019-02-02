/**
 * This class increments counter
 */
package study.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter 
{
	private AtomicInteger counter = new AtomicInteger();
	
	public int getValue()
	{
		return counter.get();
	}
	
	/**
	 * The effect of increment is similar to int++
	 * @return Previous value
	 */
	public int increment()
	{
		return counter.getAndIncrement();
	}
}
