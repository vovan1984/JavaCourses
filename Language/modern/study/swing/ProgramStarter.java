/* This program pops up a dialog box repeatedly asking for 
 * process name to start. After name is obtained, corresponding
 * routine is invoked, and placed to the Map of running
 * programs. 
 * If user enters "quit", then all started programs are 
 * terminated, and info about their execution is displayed. */
package study.swing;

import java.io.IOException;

public class ProgramStarter
{

	public static void main(String[] args)
	{
		Runtime runtime = Runtime.getRuntime();
		
		try
		{
			Process p = runtime.exec("java -cp C:\\Users\\vladimir.igumnov\\eclipse-workspace\\Java\\bin study.swing.Addition");
			ProcessHandle ph = p.toHandle();
			System.out.println(ph.info());
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(runtime);
	}

}
