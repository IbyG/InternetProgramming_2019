import javax.swing.*;
import java.awt.*;
public class ShowGraphics extends JFrame {
    public void paint(Graphics g) {
        // must use getContentPane(), not "this"
        getContentPane().setBackground(new Color(0.0f, 0.0f, 1.0f));
        super.paint(g); // paint components
        // do some paintings
        g.setColor(Color.cyan);
        g.setFont(new Font("SansSerif",
            Font.BOLD + Font.ITALIC, 16));
        g.drawString("Graphics Demo", 20, 40);
        g.setColor(new Color(255, 0, 0));
        g.fillRoundRect(20, 50, 100, 50, 50, 25);
        // it's "this" container!
        this.setBackground(Color.yellow);
        g.clearRect(45, 63, 50, 25);
    }
    public static void main(String[] args) {
        JFrame f = new ShowGraphics(); //used JFrame for variety
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200, 150);
        // back/foreground colors both active
        JButton b = new JButton("button");
        b.setBackground(Color.cyan);
        b.setForeground(Color.red);
        //label's background color taken over by its container
        JLabel l = new JLabel("label");
        l.setBackground(Color.cyan); // taken over later
        l.setForeground(Color.red); // active
        Container p = new JPanel(); // used as a container
        p.setBackground(Color.green);
        p.setForeground(Color.white); // taken over later
        p.setLayout(new FlowLayout()); // default too
        p.add(b);
        p.add(l);

        f.getContentPane().add(BorderLayout.SOUTH, p);
        f.setVisible(true);
        f.repaint(); // needed for some platforms
    }
}