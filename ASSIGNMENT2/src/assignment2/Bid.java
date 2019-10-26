package assignment2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Bid extends JFrame {

	private JFrame frame;
	private JTextField tfId;
	private JTextField tfPrice;

	JButton btnPlaceBid;
	
	//status from the auction
	String itemStatus  ="";
	//the price from the auction
	double itemPrice = 0.0;
	
	//what the user has entered as price 
	double ip = 0.0;
	
	//item id from the auction 
	int itemId = 0;
	
	boolean priceValid = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bid window = new Bid();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bid() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 343, 236);
		getContentPane().setLayout(null);
		
		
		JLabel lblPlaceBid = new JLabel("Place Bid");
		lblPlaceBid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaceBid.setBounds(188, 11, 94, 14);
		getContentPane().add(lblPlaceBid);
		
		JLabel lblItemId = new JLabel("Item ID:");
		lblItemId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblItemId.setBounds(10, 58, 94, 14);
		getContentPane().add(lblItemId);
		
		tfId = new JTextField();
		tfId.setBounds(75, 56, 86, 20);
		tfId.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				updateValue();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				updateValue();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				updateValue();
			}
			
			public void updateValue() {
				itemId = Integer.parseInt(tfId.getText());
			}
		});
		getContentPane().add(tfId);
		tfId.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(172, 55, 89, 23);
		btnSearch.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainScreen obj = new MainScreen();
						itemStatus = obj.checkStatus(itemId);
						
						if(itemStatus == "Closed") {
							JOptionPane.showMessageDialog(null, "Sorry Item is Closed");
							btnPlaceBid.setEnabled(false);
						}else if(itemStatus == null) {
							JOptionPane.showMessageDialog(null, "Sorry Item could not be found");
							btnPlaceBid.setEnabled(false);
						}else {
							itemPrice = obj.checkprice(itemId);
							tfPrice.setText(Double.toString(itemPrice));
							btnPlaceBid.setEnabled(true);
						}
						
					}
				});
		getContentPane().add(btnSearch);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrice.setBounds(10, 120, 46, 14);
		getContentPane().add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(75, 118, 86, 20);
		
		tfPrice.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				updateValue();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				updateValue();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				updateValue();
			}
			
			public void updateValue() {
				
				try {
				ip = Double.parseDouble(tfPrice.getText());
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "not a price");
					priceValid = false;
				}
				}
		});
		
		getContentPane().add(tfPrice);
		tfPrice.setColumns(10);
		
		btnPlaceBid = new JButton("Place Bid");
		btnPlaceBid.setEnabled(false);
		btnPlaceBid.setBounds(46, 149, 89, 23);
		btnPlaceBid.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainScreen obj = new MainScreen();
						
						if(ip > itemPrice) {
							priceValid = true;
							
						}else {
							JOptionPane.showMessageDialog(null, "That is less than the current price");
							priceValid = false;
						}
						
						
						
						if(priceValid) {
							Login objL = new Login();
						obj.SetPrice(itemId, ip, objL.returnName());
						JOptionPane.showMessageDialog(null, "Bid Placed");
						btnPlaceBid.setEnabled(false);
						
						setVisible(false);
						
						}
						
						
						
								
						
					}
				});
		getContentPane().add(btnPlaceBid);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
