package study.gui;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseEventDemo extends Frame 
implements MouseListener, MouseMotionListener
{

	/**
	 * Default value
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	private int mouseX, mouseY; // coordinates of the mouse

	public MouseEventDemo()
	{
		msg = "";
		mouseX = 0;
		mouseY = 0;
		
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(new MyWindowAdapter());
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		msg = "*" + " mouse at " + mouseX + ", " + mouseY;
		repaint();	
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		msg = "Moving mouse at " + e.getX() + ", " + e.getY();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		msg = msg + " -- click received";
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		msg = "Button down";
		repaint();	
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		msg = "Button released";
		repaint();		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		mouseX = 100;
		mouseY = 100;
		msg = "Mouse entered";
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		mouseX = 100;
		mouseY = 100;
		msg = "Mouse exited";
		repaint();
	}

	// Display message in the window in the last recorded mouse location
	public void paint(Graphics g)
	{
		g.drawString(msg, mouseX, mouseY);
	}
	
	class MyWindowAdapter extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		MouseEventDemo winapp = new MouseEventDemo();
		
		winapp.setSize(300, 300);
		winapp.setTitle("First mouse app");
		winapp.setVisible(true);
	}
}
