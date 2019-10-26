import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*; // for JList

class Combolist extends JFrame {
    Container c=getContentPane();
    String names[]={"one","two","three","four","five"};
    JComboBox b=new JComboBox(names);
    JList l=new JList(names);

    String picked(Object o) { // message for the choices
	if(o instanceof ItemEvent)
	    return b.getSelectedIndex()+": "+b.getSelectedItem();
	else if(o instanceof ListSelectionEvent)
	    return l.getSelectedIndex()+"# "+l.getSelectedValue();
	else return "null";
    }

    public Combolist() {
	c.setLayout(new FlowLayout());
	c.add(b);
	b.setMaximumRowCount(3); // maximum rows
	setTitle(picked(new ItemEvent(b,0,null,0)));
	b.addItemListener(
	    new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
			setTitle(picked(e));
		    }
		}
	    );

	// below for JList
	c.add(new JScrollPane(l));
	l.setVisibleRowCount(4); //effetive when using JScrollPane
	l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	l.addListSelectionListener(
	    new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
			setTitle(picked(e));
		    }
		}
	    );
	

    }

    public static void main(String[] args) {
	Combolist a=new Combolist();
	a.setDefaultCloseOperation(EXIT_ON_CLOSE);
	a.setSize(250,150); a.show();
    }
}