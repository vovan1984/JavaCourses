package study.swing;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 * This class shows how different top-level containers
 * look like in Swing.
 *
 */
public class ContainerAppearance 
{
  public static void main(String[] args) 
  {
    JFrame f = new JFrame("The Frame");
    f.setSize(300, 300);
    f.setLocation(100, 100);

    JWindow w = new JWindow();
    w.setSize(300, 300);
    w.setLocation(500, 100);
    
    JDialog d = new JDialog();
    d.setSize(300, 300);
    d.setLocation(900, 100);
    
    f.setVisible(true);
    w.setVisible(true);
    d.setVisible(true);
    

  }
}