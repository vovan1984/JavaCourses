package study.threads;

public class Messeger
{
	private int iteration = 0;
	
	public synchronized int getIteration()
	{
		return iteration;
	}

	public synchronized void showMessage(boolean runAtEven)
	{
		if(runAtEven && iteration%2 == 0 || !runAtEven && iteration%2 == 1)
		{
			System.out.println("Thread: " + Thread.currentThread().getName() + "; iteration #" + iteration);
			iteration++;
			this.notifyAll();
		}
		else
			try
			{
				this.wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
