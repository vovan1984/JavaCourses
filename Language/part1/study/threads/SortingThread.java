/**
 * 
 */
package study.threads;

import java.util.Arrays;

/**
 * This thread is used to sort input array of double elements.
 * 
 * @author Vladimir.Igumnov
 * @since 1.10.2
 * @see study.threads.ExtremesSearch
 */
public class SortingThread extends Thread
{
	private double[] arr;

	SortingThread(double[] arr)
	{
		this.arr = arr;
	}
	
	@Override
	public void run()
	{
		Arrays.sort(arr);
	}
}
