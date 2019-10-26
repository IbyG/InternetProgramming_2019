package assignment2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreatingAuctionItems extends JFrame {

	private JFrame frame;
	private JTextField tfPName;
	private JTextField tfDescription;
	private JTextField tfVendor;
	private JTextField tfTime;
	private JTextField tfPrice;
	
	//storing the product name
	String pname = "";
	//storing the product description
	String pDes = "";
	//Storing the product vendor
	String pVen = "";
	//storing  auction closing time
	String pCloseTime = "";
	//Storing the price 
	double price = 0.0;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatingAuctionItems window = new CreatingAuctionItems();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreatingAuctionItems() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		
		getContentPane().setLayout(null);
		
		JLabel lblCreatingAuctionItem = new JLabel("                 Creating Auction Item");
		lblCreatingAuctionItem.setBounds(113, 11, 224, 14);
		getContentPane().add(lblCreatingAuctionItem);
		
		JLabel lblPName = new JLabel("Product Name:");
		lblPName.setBounds(10, 56, 89, 14);
		getContentPane().add(lblPName);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(10, 81, 76, 14);
		getContentPane().add(lblDescription);
		
		JLabel lblVender = new JLabel("Vender:");
		lblVender.setBounds(10, 106, 76, 14);
		getContentPane().add(lblVender);
		
		JLabel lblTime = new JLabel("Auction Closing Time:");
		lblTime.setBounds(10, 131, 146, 14);
		getContentPane().add(lblTime);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 156, 76, 14);
		getContentPane().add(lblPrice);
		
		tfPName = new JTextField();
		tfPName.setBounds(179, 47, 158, 20);
		//####################################################################
				//listener for name textfield
				tfPName.getDocument().addDocumentListener(new DocumentListener() {

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
						
						//updating price based on the value inside of count textfield 
						if(!tfPName.getText().isEmpty()) {
							// error handling if input is not int
							
							pname = tfPName.getText();

							}else {
								pname = "";
							}
						}
				});
		//####################################################################
		getContentPane().add(tfPName);
		tfPName.setColumns(10);
		
		tfDescription = new JTextField();
		tfDescription.setBounds(179, 72, 158, 20);
		//####################################################################
		//listener for name description text field
		tfDescription.getDocument().addDocumentListener(new DocumentListener() {

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
				
				//updating price based on the value inside of count textfield 
				if(!tfDescription.getText().isEmpty()) {
					// error handling if input is not int
					
					pDes = tfDescription.getText();

					}else {
						pDes = "";
					}
				}
		});
		//####################################################################
		getContentPane().add(tfDescription);
		tfDescription.setColumns(10);
		
		tfVendor = new JTextField();
		tfVendor.setBounds(179, 97, 158, 20);
		//####################################################################
		//listener for name vendor text field
		tfVendor.getDocument().addDocumentListener(new DocumentListener() {

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
				
				//updating price based on the value inside of count textfield 
				if(!tfVendor.getText().isEmpty()) {
					// error handling if input is not int
					
					pVen = tfVendor.getText();

					}else {
						pVen = "";
					}
				}
		});
		//####################################################################
		getContentPane().add(tfVendor);
		tfVendor.setColumns(10);
		
		tfTime = new JTextField();
		tfTime.setBounds(179, 122, 158, 20);
		tfTime.setText(java.time.LocalTime.now().toString());
		//####################################################################
		//listener for name auction closing time text field
		tfTime.getDocument().addDocumentListener(new DocumentListener() {

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
				
				//updating price based on the value inside of count textfield 
				if(!tfTime.getText().isEmpty()) {
					// error handling if input is not int
					
					pCloseTime = tfTime.getText();

					}
				}
		});
		//####################################################################
		getContentPane().add(tfTime);
		tfTime.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(179, 150, 158, 20);
		//####################################################################
		//listener for name auction closing time text field
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
				
				//updating price based on the value inside of count textfield 
				if(!tfPrice.getText().isEmpty()) {
					// error handling if input is not int
					try {
					price = Integer.parseInt(tfPrice.getText());	
					}catch(NumberFormatException | NullPointerException nfe) {
						
						try {
							price = Double.parseDouble(tfPrice.getText());
							}
							catch(NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "not a price");
								price = 0.0;
								
							}
						}
				}
			}
			
		});
		//####################################################################
		getContentPane().add(tfPrice);
		tfPrice.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(127, 209, 89, 23);
		getContentPane().add(btnSubmit);
		
		
		
		
				btnSubmit.addActionListener(
						new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								//here should open a new window and display all the items bought
								//and the price
								System.out.println(price);
								System.out.println(pname);
								System.out.println(pDes);
								System.out.println(pVen);
								
								//storing the time of the closing auction item 
								pCloseTime = tfTime.getText();
								System.out.println(pCloseTime);
								
							
								
								//a 4 digit number
								int id = (int) ((Math.random() * (9999 - 999)) + 999);
								
								
								if(price != 0.0 && pname != "" && pDes != "" && pVen != "") {
									MainScreen obj = new MainScreen();
									
									//for user name
									Login objL = new Login();
									
									//adding the data to array list of objects
									obj.AddCustomData(id, pname, pDes, pVen, pCloseTime, objL.returnName(), price, "Open");
									
									
									setVisible(false);
								}else {
									if(price == 0.0) {
										JOptionPane.showMessageDialog(null, "Please Check Price");
									}else {
										JOptionPane.showMessageDialog(null, "Something is missing");
									}
									
								}
								
								
							}
						});
		
		
		
		
		setBounds(100, 100, 402, 323);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	

	




	
}
