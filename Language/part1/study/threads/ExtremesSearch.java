package study.threads;

/**
 * This class is used to find min, median and max
 * values  in the auto-generated double array.
 * 
 * Search is done by sorting array in the separate thread,
 * and then taking the required values from the beginning,
 * middle and end of the array.
 * 
 * @author Vladimir.Igumnov
 *
 */
public class ExtremesSearch
{

	public static void main(String[] args)
	{
		double[] array = new double[10000];                         // 1
		for (int i = 0; i < array.length; i++)                      // 2
		{                    
		  array[i] = Math.random();                                 // 3
		}                                                           // 4
		
		SortingThread t = new SortingThread(array);                 // 5
		t.start();                                                  // 6
		
		try {                                                       // 7
		  t.join();                                                 // 8
		  System.out.println("Minimum: " + array[0]);               // 9
		  System.out.println("Median: " + array[array.length/2]);   // 10
		  System.out.println("Maximum: " + array[array.length-1]);  // 11
		} catch (InterruptedException ex) {                         // 12
		}    
	}

}
