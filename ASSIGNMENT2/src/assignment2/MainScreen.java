package assignment2;

import java.awt.EventQueue;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;


public class MainScreen extends JFrame {

	//jfram
	private JFrame frame;

	
	
	//amount of items in the list
	public int ListAmount = 1;
	
	//all the labels
	private JLabel lblTheGreatAuction;
	
	//the auction headers
	String Titles[]= {"ID","Name","Description", "Vendor", "Closing Time","Latest bidder","Highest Bid Price", "Status"};
	
	
	//all the auction lists
	private JTable table;
	
	//stores if the user is logged in or not
	public static boolean loggedIn = false;
	
	 Login objL = new Login();
	
	//a class of objects that store the items of the auction items
	public class Items{
		
		public int id;
		public String name;
		public String Description;
		public String Vendor;
		public String Time;
		public String Bidder;
		public Double Price;
		public String Status;
		
		public Items(int i, String n, String D,String V, String T, String B, Double P, String s) {
			this.id = i;
			this.name = n;
			this.Description = D;
			this.Vendor = V;
			this.Time = T;
			this.Bidder = B;
			this.Price = P;
			this.Status = s;
		}
		
	}
	
	//the array list which stores objects about the auction
	public static ArrayList<Items> list = new ArrayList<Items>();
	/*
	public ArrayList ListData() {
		
		Items a = new Items(1234,"chair","its a chair", "st mary's", java.time.LocalTime.now().toString(),"ibrahim",26.50, "open");
		
		list.add(a);
		
		return list;
	}
	*/
	
	//this will add custom data that is based off user input
	public void AddCustomData(int i, String n, String D,String V, String T, String B, Double P, String s) {
			Items a = new Items(i,n,D, V, T, B,P, s);
			
			list.add(a);
			
			System.out.println(a);
			
			System.out.println("added");
			
	}
	

	//tableModel that stores the data inside to be used inside of jtable
	DefaultTableModel tableModel = new DefaultTableModel(Titles, 0);
	//adding the data to a table model 
	public void addRowToJTable() {
		//DefaultTableModel model = (DefaultTableModel) table.getModel();
		//ArrayList<Items> list = ListData();
		//the amount of columns
		Object rowData[] = new Object[8];
		for(int i = 0; i < list.size(); i ++)
		{
			rowData[0] = list.get(i).id;
			rowData[1] = list.get(i).name;
			rowData[2] = list.get(i).Description;
			rowData[3] = list.get(i).Vendor;
			rowData[4] = list.get(i).Time;
			rowData[5] = list.get(i).Bidder;
			rowData[6] = list.get(i).Price;
			rowData[7] = list.get(i).Status;
			
			
			tableModel.addRow(rowData);
			
		}
		
	}
	

	//updating the values inside the table 
	public void updateTable() {
		tableModel.setRowCount(0);
		addRowToJTable();
		table = new JTable(tableModel);
		
	}
	
	
	//check the current time against the bidding close time
	// and changes the status accord to that change
	public void CheckIfStillOpen() {
		for(int i = 0; i < list.size(); i ++) {
			LocalTime SavedTime = LocalTime.parse(list.get(i).Time);
			LocalTime CurrentTime = java.time.LocalTime.now();
			
			int value = SavedTime.compareTo(CurrentTime);
			
			if(value > 0) {
				//means that the savedtime is ahead of current time
				//keep the order open
				System.out.println("Still Fine" + list.get(i).id);
			}
			if(value < 0) {
				//this means currentTime is ahead and so we close the order
				list.get(i).Status = "Closed";
				System.out.println("Closed: " + list.get(i).id);
			}
			
		}
	}
	
	
	/*
	 * how to use these
	 * 
	 * 
	 * MainScreen obj = new MainScreen();
		String UserID = obj.chechStatus(the user id);
	 * 	double price = obj.checkprice(the user id);
	 * 
	 */
	
	//return the status of an item based on the id
	public String checkStatus(int id) {	
		for(int i = 0; i < list.size(); i ++) {
			if(list.get(i).id == id) {
				return(list.get(i).Status);
			}
		}
		
		return null;
		
	}
	
	//return the price of an item based on the id
		public Double checkprice(int id) {	
			for(int i = 0; i < list.size(); i ++) {
				if(list.get(i).id == id) {
					return(list.get(i).Price);
				}
			}
			
			return null;
			
		}
		
		//setting price and name
		public void SetPrice(int id, Double Price, String UserName) {	
			for(int i = 0; i < list.size(); i ++) {
				if(list.get(i).id == id) {
					list.get(i).Price = Price;
					list.get(i).Bidder = UserName;
				}
			}
			
			
		}


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//custom data
		//AddCustomData(12, "Books", "its a book","bunnings", java.time.LocalTime.now().toString(), "ibrahim", 34.5, "open");
		

		frame = new JFrame();
		frame.getContentPane().setLayout(null);

		frame.addWindowFocusListener(new WindowAdapter() {
		      public void windowGainedFocus(WindowEvent e) {
		    	//updating the view of the table  
		        updateTable();
		        
		        //checking the time agains the orders 
		        CheckIfStillOpen();
		        
		        Login objL = new Login();
		        
		        loggedIn = objL.returnlogged();
		      }
		}
		);
		
	
		
		//title
		lblTheGreatAuction = new JLabel("The Great Auction");
		lblTheGreatAuction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTheGreatAuction.setBounds(375, 11, 113, 14);
		
		
		
		frame.getContentPane().add(lblTheGreatAuction);
		
		
		//############################################################################################################################
		
		
		
		//updating the array list in which will hold the data to be displayed in the jtable
		addRowToJTable();
		
		//the auction table
		//adding the structure to the table 
		table = new JTable(tableModel);
		table.setBounds(10, 46, 642, 195);
		
		
		//putting the table inside a scrollpane because the headers werent showing 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 817, 195);
		scrollPane.setViewportView(table);
		
		//displaying it 
		frame.getContentPane().add(scrollPane);
		//frame.getContentPane().add(table);
		
		
		//############################################################################################################################
		
		
		
		JButton btnLoginregister = new JButton("Login/Register");
		btnLoginregister.setBounds(10, 299, 157, 23);
		btnLoginregister.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					objL.setVisible(true);
						
					}
				});
		frame.getContentPane().add(btnLoginregister);
		
		JButton btnCreateAuctionItem = new JButton("Create Auction Item");
		btnCreateAuctionItem.setBounds(325, 299, 269, 23);
		
		//going to Creating auction view
		btnCreateAuctionItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(loggedIn) {
							CreatingAuctionItems obj = new CreatingAuctionItems();
							
							obj.setVisible(true);
						}else {
							objL.LogError();
						}
						
						
						//new CreatingAuctionItems().setVisible(true);
						
					}
				});
		
		
		frame.getContentPane().add(btnCreateAuctionItem);
		
		JButton btnPlaceBid = new JButton("Place Bid");
		btnPlaceBid.setBounds(738, 299, 89, 23);
		btnPlaceBid.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(loggedIn) {
						Bid obj = new Bid();
						
						obj.setVisible(true);
						}else {
							objL.LogError();
						}
						
						//new CreatingAuctionItems().setVisible(true);
						
					}
				});
		frame.getContentPane().add(btnPlaceBid);
		
		

		
		
		//############################################################################################################################
		
		
		frame.setBounds(100, 100, 869, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}
}
