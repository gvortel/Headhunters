package hy360;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class employer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JTextField mail;
	private JTextField cardnumber;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public employer() {
		setTitle("Employer Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setText("name");
		txtrName.setBounds(0, 10, 145, 23);
		contentPane.add(txtrName);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setText("address");
		txtrAddress.setBounds(0, 48, 145, 23);
		contentPane.add(txtrAddress);
		
		JTextArea txtrPhone = new JTextArea();
		txtrPhone.setText("phone");
		txtrPhone.setBounds(0, 87, 145, 23);
		contentPane.add(txtrPhone);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("email");
		txtrEmail.setBounds(0, 127, 145, 23);
		contentPane.add(txtrEmail);
		
		JTextArea txtrCardnumber = new JTextArea();
		txtrCardnumber.setText("cardnumber");
		txtrCardnumber.setBounds(0, 169, 145, 23);
		contentPane.add(txtrCardnumber);
		
		name = new JTextField();
		name.setBounds(184, 11, 290, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(184, 49, 290, 22);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(184, 87, 290, 22);
		contentPane.add(phone);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(184, 127, 290, 22);
		contentPane.add(mail);
		
		cardnumber = new JTextField();
		cardnumber.setColumns(10);
		cardnumber.setBounds(184, 170, 290, 22);
		contentPane.add(cardnumber);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ename = name.getText();
				String eaddress = address.getText();
				String ephone = phone.getText();
				String email = mail.getText();
				//String eaccount = account.getText();
				String ediscount = "0";
				String ecardNumber = cardnumber.getText();
				

			
				/*INSERT TO EMPLOYEE ARRAY################################################################*/
				// 3306 is the default port for MySQL in XAMPP.
		        String url = "jdbc:mysql://localhost:3306/";
		        
		         // The MySQL user.
		        String user = "root";
		        
		         // If no password has been set 
		         // an empty string can be used.
		        String password = "";
				
		        try{
				        Class.forName("com.mysql.jdbc.Driver").newInstance();
			            Connection con = DriverManager.getConnection(url, user, password);
			            
			            Statement stt = con.createStatement();
			            
			             // Create and select a database for use. 
			            stt.execute("USE hy360");
			            
			            String sql = "INSERT INTO employer (name,address,phone,jobcounter,email,discount,cardnumber)" +
				                   "VALUES ('"+ ename+"', '"+ eaddress+"', '"+ ephone +"',"+ 0 +",'"+ email +"','" + ediscount +"','"+ ecardNumber+ "')";
				      stt.executeUpdate(sql);
				      
				      String sql17="SELECT account FROM employer "
				      			 + "ORDER BY account DESC "
				      			 + "LIMIT 1";
				      Statement stt17 = con.createStatement();
				      ResultSet rs17 = stt17.executeQuery(sql17);
				      int recentAccount=0;
				      while(rs17.next()){
				    	  recentAccount = Integer.parseInt(rs17.getString("account"));
				    	  break;}
				      System.out.println("JOBID "+recentAccount);
				      login.employer_Account = recentAccount;
				      
				      
				      
				      employer_actions e2 = new employer_actions();
				      e2.setVisible(true);
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
				
			}
		});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btnNewButton.setBounds(10, 250, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
	}
}
