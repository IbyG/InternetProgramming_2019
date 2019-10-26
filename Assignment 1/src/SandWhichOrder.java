import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class SandWhichOrder extends JFrame implements ActionListener {
	
			//the sandwich options
			String SandWiches[]= {"Ultimate Club Sandwich $9.50","Seafood $9.00",
					"Chicken $8.50", "Meatball $8.50", "Veggie $9.00","Tuna $7.50"};
			//the prices of the sandwiches
			double SWprice[] = {9.5,9.0,8.5,8.5,9.0,7.5};
			
			//the Bread options
			String BreadOptions[]= {"White $0", "Honey Oats $1.00","Wheat $0"};
			
			//the Ingrediants Options
			String Ingrediants[]= {"Avacode $1.50","Mushroom $1.50", "Olives $1.50",
					"Cheese $1.50","Beef $1.50", "Ham $1.50", "Bacon $1.50", "Salami $1.50",
					"Chicken $1.50"};
			//the sauces options 
			String sauces[]= {"Tomato $0", "Barbeque $0"};
			
			//keeps the value of the choice sandwiches, bread options,ingrediants
			double ArrayOfPricesChosen[] = {0.0,0.0,0.0,0.0};
			
			//stores the items name selected by user
			String ArrayOfProductsChosen[]= {"", "","",""};
			
			//the textboxes in the form
			private JFrame frmSandwichOrder;
			private JTextField PriceTextFiels;
			private JTextField CountTextField;
			
			//the Labels in the form 
			private JLabel lblNewLabel;
			private JLabel lblSandWiches;
			private JLabel lblBreads;
			private JLabel lblIngrediants;
			private JLabel lblSauce;
			private JLabel lblCount;
			private JLabel lblDelivery;
			private JLabel lblErrorCount; 
			private JLabel lblimage;//the image
			
			//the checkboxes 
			private JCheckBox DeliveryCheckBox;
			
			
			
			//the lists 
			private JList Lsw; //sandwiches
			private JList Lbo; 	//bread list
			private JList Lig;//ingrediants list
			private JList Lsa; //sauces list
			
			//the scrollpanes
			private JScrollPane scrollPaneSW; //the sandwich scrollpane
			private JScrollPane scrollPaneB; //the breads scrollpane
			private JScrollPane scrollPaneI; //the Ingrediants scrollpane
			private JScrollPane scrollPaneS; //the sauces scroolpane
			
			//the buttons
			private JButton btnClearOrder; //the clear order button
			private JButton btnOrder; //opens a dialog box that shows what is ordered.
			
			
			
			//the price that the user will pay based on the ArrayOfChoice
			double totalprice; 
			
			//the amount that the user wants
			int count = 1;
			
			//user choosing for it to bet delivered 
			boolean delivery = false;
			
	
			
		
	
			//from array of choice it gets the total 
			public double TotalPrice() {
				//resetting total price
				totalprice = 0;
				
				//adding all the values in ArrayOfPricesChosen to totalprice
				for(int i = 0; i < 3; i ++) {
					totalprice +=ArrayOfPricesChosen[i];
				}
				//multiplying by how many the user wants
				totalprice *= count;
				
				//adding delivery fee if its under $27
				if(totalprice < 27.00 && delivery) {
					//per order that is under $27
					totalprice += 5.0;
				}
				
					return totalprice;
			}
		
			//showing the value that the user will pay
			public void PriceFieldUpdate() {
				
				if(TotalPrice() != 0.0) {
					PriceTextFiels.setText("$"+Double.toString(TotalPrice()));
				}
				
			}
			
			//displaying error if text in count is not int
			public void CountError() {
				lblErrorCount.setVisible(true);
			}
			//making error message invisible
			public void CountGood() {
				lblErrorCount.setVisible(false);
			}
			
			//resetting all values
			public void reseteverything() {
				CountTextField.setText("");
				PriceTextFiels.setText("");
				count = 1;
				totalprice = 0.0;
				delivery = false;
				
				for(int i = 0; i <ArrayOfPricesChosen.length; i++ ) {
					ArrayOfPricesChosen[i] = 0.0;
				}
				
				for(int i = 0; i <ArrayOfProductsChosen.length;i++) {
					ArrayOfProductsChosen[i] = "";
				}
				
			}
			
			//the order dialog box
			public void OrderDialog() {
				String DorP = "PickUp";
				if(delivery) 
					DorP = "Delivery";
				
				
				JOptionPane.showMessageDialog(frmSandwichOrder,
						ArrayOfProductsChosen[0] + "\n" +
						ArrayOfProductsChosen[1] + "\n" +
						ArrayOfProductsChosen[2] + "\n" +
						ArrayOfProductsChosen[3] + "\n" +
						"Total Count: " + count  + "\n" +
						"Total Price: " + totalprice + "\n"+
						"Retreival Option: "+ DorP);
			}
			
			

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SandWhichOrder window = new SandWhichOrder();
					window.frmSandwichOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the application.
	 */
	public SandWhichOrder() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSandwichOrder = new JFrame();
		frmSandwichOrder.setTitle("SandWich Order");
		frmSandwichOrder.setResizable(false);
		frmSandwichOrder.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("SANDWICH ORDER");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 209, 33);
		frmSandwichOrder.getContentPane().add(lblNewLabel);
		
		lblSandWiches = new JLabel("SandWiches");
		lblSandWiches.setBounds(20, 55, 76, 24);
		frmSandwichOrder.getContentPane().add(lblSandWiches);
		
		lblBreads = new JLabel("Bread's");
		lblBreads.setBounds(216, 55, 53, 24);
		frmSandwichOrder.getContentPane().add(lblBreads);
		
		lblIngrediants = new JLabel("Ingrediants");
		lblIngrediants.setBounds(387, 55, 87, 24);
		frmSandwichOrder.getContentPane().add(lblIngrediants);
		
		lblSauce = new JLabel("Sauce");
		lblSauce.setBounds(216, 169, 53, 24);
		frmSandwichOrder.getContentPane().add(lblSauce);
		
		//the price text box
		PriceTextFiels = new JTextField();
		PriceTextFiels.setBounds(58, 276, 86, 20);
		//stops user from inputting price 
		PriceTextFiels.setEditable(false);
		frmSandwichOrder.getContentPane().add(PriceTextFiels);
		PriceTextFiels.setColumns(10);
		
		lblCount = new JLabel("Count:");
		lblCount.setBounds(10, 304, 46, 14);
		frmSandwichOrder.getContentPane().add(lblCount);
		
		lblErrorCount = new JLabel("This is not a number");
		lblErrorCount.setVisible(false);
		lblErrorCount.setForeground(Color.RED);
		lblErrorCount.setBackground(Color.WHITE);
		lblErrorCount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblErrorCount.setBounds(154, 298, 115, 24);
		frmSandwichOrder.getContentPane().add(lblErrorCount);
		
		CountTextField = new JTextField();
		CountTextField.setBounds(58, 304, 86, 20);
		
		//waits for user input to for count and then updates the price
		CountTextField.getDocument().addDocumentListener(new DocumentListener() {

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
				if(!CountTextField.getText().isEmpty()) {
					// error handling if input is not int
					try {
					count = Integer.parseInt(CountTextField.getText());	
					}catch(NumberFormatException | NullPointerException nfe) {
						System.out.println("This is not a number");
						CountError();
					}
				}else {
					CountGood();
					count = 1;
				}
				//updating the price
				PriceFieldUpdate();
				
				
			}
			
		});
		
		frmSandwichOrder.getContentPane().add(CountTextField);
		CountTextField.setColumns(1);
		
		lblDelivery = new JLabel("Delivery:");
		lblDelivery.setBounds(10, 329, 52, 25);
		frmSandwichOrder.getContentPane().add(lblDelivery);
		
		DeliveryCheckBox = new JCheckBox("");
		DeliveryCheckBox.setBounds(58, 331, 97, 23);
		
		DeliveryCheckBox.addItemListener(new ItemListener() {

			//setting delivery mode
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {
					delivery = true;
				}else {
					delivery = false;
				}
				PriceFieldUpdate();
				
			}
			
		});
		
		frmSandwichOrder.getContentPane().add(DeliveryCheckBox);
		
		btnOrder = new JButton("Order");
		btnOrder.setBounds(7, 354, 89, 23);
		btnOrder.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//here should open a new window and display all the items bought
					//and the price
					OrderDialog();
					
				}
			});
		frmSandwichOrder.getContentPane().add(btnOrder);
		
		btnClearOrder = new JButton("Clear Order");
		btnClearOrder.setBounds(103, 355, 116, 22);
		btnClearOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//resetting all the values
				reseteverything();
			}
		});
		frmSandwichOrder.getContentPane().add(btnClearOrder);
		
		
		
		
		
		//sandwich list
		Lsw = new JList(SandWiches);
		
		
		scrollPaneSW = new JScrollPane(Lsw);
		
		Lsw.setVisibleRowCount(SandWiches.length);
		Lsw.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//deals with what happen when an option is selected
		Lsw.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						//getting the value of the sandwich from swprice array
						System.out.println(SWprice[Lsw.getSelectedIndex()]);
						//storing the choice value in the array
						ArrayOfPricesChosen[0] = SWprice[Lsw.getSelectedIndex()];
						//storing the option
						ArrayOfProductsChosen[0]= Lsw.getSelectedValue().toString();
						//displaying the array position 0 which stored the sandwich price
						System.out.println("This is array of choice" +ArrayOfPricesChosen[0]);
						//updating the price
						PriceFieldUpdate();
					}
				});
		
		
		scrollPaneSW.setBounds(10, 90, 182, 114);
		frmSandwichOrder.getContentPane().add(scrollPaneSW);
		
		//bread list
		Lbo = new JList(BreadOptions);
		
		scrollPaneB = new JScrollPane(Lbo);
		Lbo.setVisibleRowCount(BreadOptions.length);
		Lbo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		Lbo.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						
						//only add $1 to the price if honey oats is selected
						if(Lbo.getSelectedValue() == "Honey Oats $1.00") {
							//storing the choice value in the array
							ArrayOfPricesChosen[1] = 1.0 ;
							System.out.println("This is array of choice" +ArrayOfPricesChosen[1]);
							//updating the price
							PriceFieldUpdate();
						}
						else {
							ArrayOfPricesChosen[1] = 0.0 ;
							System.out.println("This is array of choice" +ArrayOfPricesChosen[1]);
							//updating the price
							PriceFieldUpdate();
						}
						//storing the option
						ArrayOfProductsChosen[1]= Lbo.getSelectedValue().toString();
					}
				});
		
		scrollPaneB.setBounds(207, 90, 114, 68);
		frmSandwichOrder.getContentPane().add(scrollPaneB);
		
		//ingrediants
		Lig = new JList(Ingrediants);
		
		scrollPaneI = new JScrollPane(Lig);
		Lig.setVisibleRowCount(Ingrediants.length);
		Lig.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		Lig.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {		
						//only add $1.5 to the price if any is selected
							//storing the choice value in the array
							
							ArrayOfPricesChosen[2] = 1.5 ;
							ArrayOfProductsChosen[2]= Lig.getSelectedValue().toString();
							//storing the option
							System.out.println("This is array of choice" +ArrayOfPricesChosen[2]);
							//updating the price
							PriceFieldUpdate();
						
					}
				});
		
		scrollPaneI.setBounds(351, 90, 123, 168);
		frmSandwichOrder.getContentPane().add(scrollPaneI);
		
		
		//sauces list
		Lsa = new JList(sauces);
		
		scrollPaneS = new JScrollPane(Lsa);
		Lsa.setVisibleRowCount(sauces.length);
		Lsa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		Lsa.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {		
						//only add $1.5 to the price if any is selected
							//storing the choice value in the array
							ArrayOfPricesChosen[3] = 0.0 ;
							System.out.println("This is array of choice" +ArrayOfPricesChosen[2]);
							//storing the option
							ArrayOfProductsChosen[3]= Lsa.getSelectedValue().toString();
							//updating the price
							PriceFieldUpdate();
						
					}
				});
		
		
		scrollPaneS.setBounds(216, 204, 105, 43);
		frmSandwichOrder.getContentPane().add(scrollPaneS);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 279, 46, 14);
		frmSandwichOrder.getContentPane().add(lblPrice);
		
		
		
		//the sandwich image
		lblimage = new JLabel("");
		Image img = new ImageIcon("sand.gif").getImage();
		lblimage.setIcon(new ImageIcon(new ImageIcon("sand.gif").getImage().getScaledInstance(200, 290, Image.SCALE_DEFAULT)));
		lblimage.setBounds(265, 329, 209, 175);
		frmSandwichOrder.getContentPane().add(lblimage);
		
		
		
		
		
		frmSandwichOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSandwichOrder.setSize(500,554);
		frmSandwichOrder.setResizable(false);
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
