import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleEvent extends JFrame implements ActionListener {
//	public SimpleEvent() {
//	super("Simple Event Example");
//	}
	JTextArea t = new JTextArea("Display here!");

	public void actionPerformed(ActionEvent a){
		t.setText( Double.toString(Math.random()) );
		t.repaint();
	}

	public static void main(String[] args) {
		SimpleEvent f = new SimpleEvent();
		Container c = f.getContentPane();
		JButton b = new JButton("Generate a Random Number");
		b.addActionListener(f);
		c.add(f.t);
		c.add(BorderLayout.SOUTH, b);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,100);
		f.setVisible(true);
	}
}