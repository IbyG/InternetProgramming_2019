import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;

public class SimpleGraph2 extends JFrame {
   public void paint(Graphics g) {
      super.paint(g);
      g.setColor(Color.red);
      g.fillOval(40,40,50,30);
      g.drawString("Hello, world!",100,60); }

   public static void main(String[] args) {
        SimpleGraph2  f=new SimpleGraph2();
        //this is the JFrame setting size
        f.setSize(200,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().
        add(BorderLayout.SOUTH, new JButton("button"));
        f.setVisible(true);
    }
}
