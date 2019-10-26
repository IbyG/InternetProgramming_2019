//this is prac 3 for internet programming 
//done by Ibrahim George

//f11 to automaticaly run


//use drawline to draw the border around the image and circle
//you need 8 drawlines top bottom left right topright topleft bottomright bottomleft

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class DrawGraphics extends JFrame{
	public void paint(Graphics g) {
		//setting background color
		getContentPane().setBackground(new Color(70,80,70));
		
		//painting
		super.paint(g);
		
		//this is for the title
		g.setColor(Color.GREEN);
		g.setFont(new Font("MonoSpaced", Font.BOLD + Font.ITALIC,18));
		g.drawString("Workshop 3: Graphics", 50, 50);
		
		//this line only partially sets the line, doesnt fully work
		int width = g.getFontMetrics().stringWidth("Workshop 3: Graphics");
		
		//270 is the width of the text
		g.drawLine(55,55 ,270,55 );
		
		Image image=new ImageIcon("educ1.gif").getImage();
		g.drawImage(image,170,75,90,100, this);
		
		
		//this is for the oval
		g.setColor(new Color(255,0,0));
		g.fillOval(40, 80, 50, 100);
		
		//drawing the rectangle top left of the red oval 
		g.setColor(Color.yellow);
		g.fillRect(40, 80, 10, 10);
		
		
		//the line above the label and button
		g.setColor(Color.GREEN);
		g.drawLine(20, 200, 270, 200);
		
		//drawing the border around the picture and red circle
		 Graphics2D g2 = (Graphics2D) g;
		 g2.setPaint(Color.GREEN);
		 g2.setStroke(new BasicStroke(2.0f));
		 g2.draw(new RoundRectangle2D.Double(20, 60, 260, 130, 50, 50));
		
	}
	


	public static void main(String[] args) {
		JFrame f = new DrawGraphics(); //displaying the draw graphics 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setting form size
		f.setSize(300,250);
		
		
		
		
		//the button
		JButton b = new JButton("Button");
		b.setToolTipText("This is a button");
		b.setBackground(new Color(70,80,70));
		b.setForeground(Color.white);
		
		
		//image for the label
		Icon smile = new ImageIcon("Smiley.gif");
		
		
		//the label
		JLabel l = new JLabel("Label",smile,JLabel.RIGHT);
		//declaring the layout distance
		FlowLayout space = new FlowLayout();
		//setting the distance
		space.setHgap(50);
		
		l.setToolTipText("This is a Label");
		l.setBackground(Color.yellow);
		l.setForeground(Color.white);
		
		Container p = new JPanel();
		p.setBackground(new Color(70,80,70));
		p.setLayout(new FlowLayout());
		
		//adding label and button to jlabel
		p.add(l);
		//setting 50px between the button and label 
		p.setLayout(space);
		p.add(b);
		
		
		//putting the button and label at the south of the form
		f.getContentPane().add(BorderLayout.SOUTH, p);
		//allowing the user to see it
		f.setVisible(true);
		f.getIgnoreRepaint(); 
		
		
		
	
	}
}
