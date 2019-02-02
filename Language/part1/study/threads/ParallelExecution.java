package study.threads;

class MyParallel implements Runnable
{
	Messeger m;
	
	MyParallel(Messeger m)
	{
		this.m = m;
	}
	
        @Override
	public void run()
	{
		while (m.getIteration() < 100)
			m.showMessage(false);
	}
}

public class ParallelExecution
{
	public static void main(String[] args)
	{
		Messeger m = new Messeger();
		
		Thread mainThread = Thread.currentThread();
		mainThread.setName("mainThread");
		
		Thread childThread = new Thread(new MyParallel(m), "childThread");
		childThread.start();
		
		while (m.getIteration() < 99)
			m.showMessage(true);
	}

}
