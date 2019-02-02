package study.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ClientTest
{

	public static void main(String[] args) 
	{
		Counter counter = new Counter();
		
		// Result should be: 0, 0, 1
		System.out.println("Before: " + counter.getValue());
		System.out.println("During: " + counter.increment());
		System.out.println("After: " + counter.getValue());

		var es = Executors.newFixedThreadPool(2);
		
		Runnable task1 = () -> 
		{
			for (int i = 0; i<20_000; i++) counter.increment();
		};
			
		Runnable task2 = () -> 
		{
			for (int i = 0; i<80_000; i++) counter.increment();
		};
		
		var res1 = es.submit(task1);
		var res2 = es.submit(task2);
		
		try
		{
			res1.get();
			res2.get();
			System.out.println("After two threads: " + counter.getValue());
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (es != null)
				es.shutdownNow();
		}
			
	}

}
