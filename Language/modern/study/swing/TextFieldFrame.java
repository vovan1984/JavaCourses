package study.swing;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextFieldFrame extends JFrame
{
	/**
	 *   Version of the class
	 */
	private static final long serialVersionUID = 1L;
	
	private final JTextField textField1; // text field with set size
	private final JTextField textField2; // text field with text
	private final JTextField textField3; // text field with text and size
	private final JPasswordField passwordField;
	
	public TextFieldFrame()
	{
		super("Testing JTextField and JPasswordField");
		setLayout(new FlowLayout());
		
		textField1 = new JTextField(5);
		textField2 = new JTextField(5);;
		textField3 = new JTextField(5);;
		passwordField = new JPasswordField(5);
		
		add(textField1);
		add(textField2);
		add(textField3);
		add(passwordField);
	}
}
