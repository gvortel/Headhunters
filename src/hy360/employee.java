package hy360;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class employee extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JTextField mail;
	private JTextField cardNumber;
	private JButton btnNewButton_1;
	String [] profs = {"biologist", "software_developer", "mathematician", "doctor", "physician", "web developer"};
	public static String eprofession;
	

	/**
	 * Create the frame.
	 */
	public employee() {
		setTitle("Employee Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(147, 11, 277, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(147, 51, 277, 20);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(147, 92, 277, 20);
		contentPane.add(phone);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(147, 133, 277, 20);
		contentPane.add(mail);
		
		cardNumber = new JTextField();
		cardNumber.setColumns(10);
		cardNumber.setBounds(147, 217, 277, 20);
		contentPane.add(cardNumber);
		
		JComboBox profession = new JComboBox(profs);
		profession.setBounds(147, 176, 277, 20);
		contentPane.add(profession);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setText("address");
		txtrAddress.setBounds(10, 53, 127, 18);
		contentPane.add(txtrAddress);
		
		JTextArea txtrPhone = new JTextArea();
		txtrPhone.setText("phone");
		txtrPhone.setBounds(10, 92, 127, 20);
		contentPane.add(txtrPhone);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("e-mail");
		txtrEmail.setBounds(10, 133, 127, 20);
		contentPane.add(txtrEmail);
		
		JTextArea txtrprofession = new JTextArea();
		txtrprofession.setText("profession");
		txtrprofession.setBounds(10, 174, 127, 20);
		contentPane.add(txtrprofession);
		
		JTextArea txtrcardNumber = new JTextArea();
		txtrcardNumber.setText("cardNumber");
		txtrcardNumber.setBounds(10, 215, 127, 20);
		contentPane.add(txtrcardNumber);
		
		JTextArea txtrName = new JTextArea();
		txtrName.setText("name");
		txtrName.setBounds(10, 9, 127, 20);
		contentPane.add(txtrName);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ename = name.getText();
				String eaddress = address.getText();
				String ephone = phone.getText();
				String email = mail.getText();
				//String eaccount = account.getText();
				eprofession = profession.getSelectedItem().toString();
				String ecardNumber = cardNumber.getText();
				
				
				
				
				
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
			            
		
			            
			            
			            System.out.println("AAAAAAAAAAAAAAAAAAAA\n: ");						
			            String sql = "INSERT INTO employee (name,address,phone,email,profession,cardnumber)" +
				                   "VALUES ('"+ ename+"', '"+ eaddress+"', '"+ ephone +"','"+ email +"','" + eprofession +"','"+ ecardNumber+ "')";
				      stt.executeUpdate(sql);
				      
				      String sql17="SELECT account FROM employee "
				      			 + "ORDER BY account DESC "
				      			 + "LIMIT 1";
				      Statement stt17 = con.createStatement();
				      ResultSet rs17 = stt17.executeQuery(sql17);
				      int recentAccount=0;
				      while(rs17.next()){
				    	  recentAccount = Integer.parseInt(rs17.getString("account"));
				    	  System.out.println("recentAccount: \n"+ recentAccount);
				    	  break;}
				      System.out.println("JOBID "+recentAccount);
						
						
						login.employee_Account = recentAccount;
				      
				      
				      stt.executeUpdate("UPDATE headhunters "
				      		+ "SET balance = balance + 10;");
				      
				      query q1 = new query();
				      q1.setVisible(true);
				      
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
				
			}
		});
		btnNewButton.setBounds(10, 272, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("add Skills");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skills e2 = new skills();
				e2.setVisible(true);
			}
		});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btnNewButton_1.setBounds(278, 272, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
