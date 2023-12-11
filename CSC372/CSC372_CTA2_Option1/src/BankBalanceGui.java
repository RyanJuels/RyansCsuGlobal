import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;


public class BankBalanceGui {
	
	
	private void GUIComponents()
	{
		JButton mybutton = new JButton("Please Click me!");
		ActionListener mylistener = new ClickListener();
		mybutton.addActionListener(mylistener);
		JLabel mylabel = new JLabel("Hello!");
		JPanel mypanel = new JPanel();
		mypanel.add(mybutton);
		mypanel.add(mylabel);
		add(mypanel);
	}
	public static void main(String[] args)
	{
		JFrame myframe = new JFrame();
		final int F_WIDTH = 250;
		final int F_HEIGHT = 250;
		myframe.setSize(F_WIDTH, F_HEIGHT);
		myframe.setTitle("My Frame");
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setVisible(true);
	}
}
