package hy360;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField Sname;
	private JTextField Spass;
	private JTextField mail;
	public static int employee_Account;
	public static int employer_Account;
	String [] div = {"employee", "employer"};
	public static int flag;
	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
		
		/*################################################################## 	create base*/		
		
		// 3306 is the default port for MySQL in XAMPP.
        String url = "jdbc:mysql://localhost:3306/";
        
         // The MySQL user.
        String user = "root";
        
         // If no password has been set 
         // an empty string can be used.
        String password = "";
        
        


        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            
            Statement stt = con.createStatement();
            
            
             // Create and select a database for use. 
            stt.execute("CREATE DATABASE IF NOT EXISTS hy360");
            stt.execute("USE hy360");
            
          //DELETE TABLES
            /*stt.execute("DROP TABLE IF EXISTS employee");
            stt.execute("DROP TABLE IF EXISTS employer");
            stt.execute("DROP TABLE IF EXISTS headhunters");
            stt.execute("DROP TABLE IF EXISTS job");
            stt.execute("DROP TABLE IF EXISTS card");
            stt.execute("DROP TABLE IF EXISTS response");
            stt.execute("DROP TABLE IF EXISTS language");
            stt.execute("DROP TABLE IF EXISTS skill");
            stt.execute("DROP TABLE IF EXISTS studies");
            stt.execute("DROP TABLE IF EXISTS 	matchttable");
            stt.execute("DROP TABLE IF EXISTS query");
            
            
            
             // Create tables
            stt.execute("CREATE TABLE IF NOT EXISTS employee (" 
                    + "name VARCHAR(50),"
                    + "address VARCHAR(50),"
                    + "phone INT,"
                    + "email VARCHAR(50),"
                    + "account INT NOT NULL AUTO_INCREMENT,"
                    + "profession VARCHAR(50),"
                    + "cardnumber INT NOT NULL,"
                    + "primary key (account,email)"
                    + ")");
            
            
            
            stt.execute("CREATE TABLE IF NOT EXISTS employer (" 
                    + "name VARCHAR(50),"
                    + "address VARCHAR(50),"
                    + "phone INT,"
                    + "jobcounter INT,"
                    + "email VARCHAR(50),"
                    + "account INT NOT NULL AUTO_INCREMENT,"
                    + "discount FLOAT,"
                    + "cardnumber INT NOT NULL,"
                    + "primary key (account,email)"
                    + ")");
            
            
            
            stt.execute("CREATE TABLE IF NOT EXISTS headhunters (" 
                    + "name VARCHAR(50),"
                    + "address VARCHAR(50),"
                    + "account INT NOT NULL,"
                    + "succeeded INT,"
                    + "jobcounter INT,"
                    + "available INT,"//
                    + "succeededpercentage FLOAT,"//
                    + "balance FLOAT,"//
                    + "failed INT,"//
                    + "failurepercentage FLOAT,"//
                    + "primary key (name,account)"
                    + ")");
            
            //INSERT ADMIN
		    /*
  		    String insertadmin = "INSERT INTO headhunters (name,address,account,succeeded,jobcounter"
  						+",available,succeededpercentage,failed,failurepercentage,balance)  "
  						+ "VALUES ('admin','adminadress', 1 , 0 , 0 , 0 , 0 , 0 , 0,0) ";	
  		    System.out.println("2BDONE  :   "+insertadmin);
  		    stt.executeUpdate(insertadmin);*/
            
            
            stt.execute("CREATE TABLE IF NOT EXISTS job (" 
                    + "location VARCHAR(50),"
                    + "account INT NOT NULL,"
                    + "jobindex INT NOT NULL AUTO_INCREMENT,"
                    + "salary FLOAT,"
                    + "hours INT,"
                    + "deadline VARCHAR(50),"
                    + "profession VARCHAR(50),"
                    + "state VARCHAR(50),"
                    + "primary key (jobindex)"
                    + ")");
            
            
            
            stt.execute("CREATE TABLE IF NOT EXISTS card (" 
                    + "name VARCHAR(50),"
                    + "expiration VARCHAR(50),"
                    + "cardnumber INT NOT NULL,"
                    + "primary key (cardnumber)"
                    + ")");
            
            
            stt.execute("CREATE TABLE IF NOT EXISTS query (" 
                    + "account INT NOT NULL,"
                    + "ddate VARCHAR(50),"
                    + "queryindex INT NOT NULL AUTO_INCREMENT,"
                    + "profession VARCHAR(50) NOT NULL,"
                    + "primary key (queryindex,account)"
                    + ")");
            
            
            stt.execute("CREATE TABLE IF NOT EXISTS matchttable (" 
            		+ "jobindex INT NOT NULL,"
                    + "queryindex INT NOT NULL,"
                    + "matchindex INT NOT NULL AUTO_INCREMENT,"
                    + "primary key (matchindex)"
                    + ")");
            
            
            
            stt.execute("CREATE TABLE IF NOT EXISTS studies (" 
            		+ "titlename VARCHAR(50),"
            		+ "titleindex INT NOT NULL AUTO_INCREMENT,"
                    + "jobindex INT ,"
                    + "account INT ,"
                    + "primary key (titleindex)"
                    + ")");            
            
            
            stt.execute("CREATE TABLE IF NOT EXISTS skill (" 
            		+ "skillname VARCHAR(50) NOT NULL,"
            		+ "skillindex INT NOT NULL AUTO_INCREMENT,"
            		+ "account INT,"
                    + "jobindex INT,"
                    + "primary key (skillindex)"
                    + ")");   
            
           
            stt.execute("CREATE TABLE IF NOT EXISTS language (" 
            		+ "langname VARCHAR(50) NOT NULL,"
            		+ "langindex INT NOT NULL AUTO_INCREMENT,"
            		+ "account INT,"
                    + "jobindex INT,"
                    + "primary key (langindex)"
                    + ")");     
           
		
            
            stt.execute("CREATE TABLE IF NOT EXISTS response (" 
            		+ "matchindex INT NOT NULL,"
            		+ "accept INT NOT NULL,"//BOOLEAN
                    + "primary key (matchindex)"
                    + ")");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		
		/*###############################################################################*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("Start");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrSignUp = new JTextArea();
		txtrSignUp.setEditable(false);
		txtrSignUp.setText("Sign Up");
		txtrSignUp.setBounds(10, 11, 74, 22);
		contentPane.add(txtrSignUp);
		
		
		JTextArea txtrName = new JTextArea();
		txtrName.setEditable(false);
		txtrName.setText("mail");
		txtrName.setBounds(10, 40, 54, 20);
		contentPane.add(txtrName);
		
		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setEditable(false);
		txtrLogin.setText("Login");
		txtrLogin.setBounds(10, 137, 74, 22);
		contentPane.add(txtrLogin);
		
		JTextArea txtrMail = new JTextArea();
		txtrMail.setEditable(false);
		txtrMail.setText("mail");
		txtrMail.setBounds(10, 170, 54, 20);
		contentPane.add(txtrMail);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(114, 172, 151, 20);
		contentPane.add(mail);
		
		
		
		
		JButton lEnter = new JButton("Enter");
		lEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lmail = mail.getText();
				//String lpass = pass.getText();
				
				//System.out.println(lpass);
				/*Search databse if is employee or employeer*/
				String sql = "select * from people";
				// 3306 is the default port for MySQL in XAMPP.
		        String url = "jdbc:mysql://localhost:3306/";
		        
		         // The MySQL user.
		        String user = "root";
		        
		         // If no password has been set 
		         // an empty string can be used.
		        String password = "";
		        try
		        {
				 Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection con = DriverManager.getConnection(url, user, password);
		            
		            Statement stt = con.createStatement();
		            Statement stt2 = con.createStatement();
		            stt.execute("USE hy360");
		            
				String sql1 = "Select * From employee Where email = '"+lmail+"'";
				ResultSet rs = stt.executeQuery(sql1);
				////////////////////////////////////////////////
				if(rs.next() ) {
		            String Name = rs.getString("name");
		            flag = 0;
		            System.out.println(Name + "\t") ;
		            employee_Account = Integer.parseInt(rs.getString("account"));
		            System.out.println("employee_Account:"+ employee_Account);
		            employee_actions e_a = new employee_actions();
		            e_a.setVisible(true);
		            
		            
		        }
				
				
				else {
					String sql2 = "Select * From employer Where email = '"+lmail+"'";
					ResultSet rs2 = stt2.executeQuery(sql2);
					////////////////////////////////////////////////
					if(rs2.next() ) {
						flag = 1;
			            //String acc = rs2.getString("account");
			            employer_Account = Integer.parseInt(rs2.getString("account"));
			            System.out.println("employee_Account:"+ employer_Account);
			            
			            employer_actions e_a = new employer_actions();
			            e_a.setVisible(true);
			            
					}
					
					
					
				}

				
				////////////////////////////////////////////////
		        }
		        catch (Exception e1)
		        {
		            e1.printStackTrace();
		        }
									
				
		        if(lmail.equals("admin")){

					admin_actions aa =  new admin_actions();
					aa.setVisible(true);
		        	
		        	}

				
			}
		});
		lEnter.setBounds(10, 213, 89, 23);
		contentPane.add(lEnter);
		
		JComboBox comboBox = new JComboBox(div);
		comboBox.setBounds(114, 41, 152, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedItem().toString() == "employee")
				{
					flag = 0;
					
					employee e1 = new employee();
					e1.setVisible(true);
				}
				else
				{
					flag = 1;

					employer e2 = new employer();
					e2.setVisible(true);
				}		
				
		}
		});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btnNewButton.setBounds(10, 77, 89, 23);
		contentPane.add(btnNewButton);
	}
}
