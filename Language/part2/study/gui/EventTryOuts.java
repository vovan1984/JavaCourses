package study.gui;

import java.awt.event.ActionEvent;
import java.util.EventObject;

public class EventTryOuts
{

	public static void main(String[] args)
	{
		// button is pressed
		EventObject eo = new ActionEvent(EventTryOuts.class, ActionEvent.ACTION_PERFORMED, "ABC");
		System.out.println("Created supercalss event: " + eo.toString());

	}

}
