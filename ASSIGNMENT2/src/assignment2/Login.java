package assignment2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	public static String userName = "";
	public static boolean loggedIn = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}
	
	//returning if the user is logged in or not
	public boolean returnlogged() {
		return loggedIn;
	}
	
	public String returnName() {
		return userName;
	}
	
	//error message if not logged in
	public void LogError() {
		JOptionPane.showMessageDialog(null, "You need To log In before being able to use this");
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(42, 60, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(296, 40, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(296, 86, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(60, 39, 98, 14);
		getContentPane().add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(296, 117, 86, 20);
		getContentPane().add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(296, 165, 86, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(296, 196, 86, 20);
		getContentPane().add(textField_5);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setBounds(286, 11, 103, 14);
		getContentPane().add(lblRegistration);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//checking if the user input is the same as the stored input
						if(textField.getText().equalsIgnoreCase(userName) ) {
							JOptionPane.showMessageDialog(frame, "Succesfully logged in");
							loggedIn = true;
							
						}
						else 
						{
							System.out.println(textField.getText());
							System.out.println(userName);
							JOptionPane.showMessageDialog(frame, "incorrect username");
							loggedIn = true;
						}
						
					}
				});
		
		btnNewButton.setBounds(42, 125, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Succesfully registered");
				userName = textField_2.getText();
				
			}
		});
		btnRegister.setBounds(269, 227, 89, 23);
		getContentPane().add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(186, 51, 73, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(186, 97, 73, 14);
		getContentPane().add(lblName);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(186, 128, 73, 14);
		getContentPane().add(lblTelephone);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setBounds(186, 176, 86, 14);
		getContentPane().add(lblEmailAddress);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(186, 207, 73, 14);
		getContentPane().add(lblPassword);
	}
}