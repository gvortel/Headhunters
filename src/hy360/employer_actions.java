package hy360;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class employer_actions extends JFrame {

	private JPanel contentPane;
	private JTextField Matchindex;
	private JTextField Accept;
	private JTextField txtMatchindex;
	private JTextField txtAccept;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employer_actions frame = new employer_actions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public employer_actions() {
		setTitle("Employer Actions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Question = new JButton("Question");
		Question.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String url = "jdbc:mysql://localhost:3306/";
		        String user = "root";
		        String password = "";
				
		        try{
		        	Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection con = DriverManager.getConnection(url, user, password); 
		            Statement stt = con.createStatement();
		            stt.execute("USE hy360");
		            int employeraccount=login.employer_Account;
		            
					String sql1="SELECT name,address,email,account,phone,profession,cardnumber "
							+ "FROM employee "
							+ "WHERE account IN( "
								+ "SELECT account "
								+ "FROM query "
								+ "WHERE queryindex IN( "
									+ "SELECT queryindex "
									+ "FROM matchttable "
									+ "WHERE jobindex IN( "
										+ "SELECT jobindex "
										+ "FROM job "
										+ "WHERE account= "+employeraccount+" "
									+ ") "
								+ ") "
							+ ");";
					Statement stt1 = con.createStatement();
				    ResultSet rs1= stt1.executeQuery(sql1);
			        String result="name \taddress \temail \taccount \tphone \tprofession \tcardnumber\n";
			        while(rs1.next()){
			        	result=result+rs1.getString("name")+"\t";
			        	result=result+rs1.getString("address")+"\t";
			        	result=result+rs1.getString("email")+"\t";
			        	result=result+rs1.getString("account")+"\t";
			        	result=result+rs1.getString("phone")+"\t";
			        	result=result+rs1.getString("profession")+"\t";
			        	result=result+rs1.getString("cardnumber")+"\n";
			        }
			        
			        
			        if(result.equals("")) result="No results";
			        //print in a pop up window
			        PopUp popup=new PopUp(result," Employee");
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
				
				
				
			}
		});
		Question.setBounds(10, 11, 103, 23);
		contentPane.add(Question);
		
		JButton btnNewButton_1 = new JButton("Post job");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Screen1 jobs = new Screen1();
	            jobs.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 101, 103, 23);
		
		contentPane.add(btnNewButton_1);
		Matchindex = new JTextField();
		Matchindex.setBounds(229, 152, 129, 20);
		contentPane.add(Matchindex);
		Matchindex.setColumns(10);
		
		Accept = new JTextField();
		Accept.setColumns(10);
		Accept.setBounds(229, 183, 129, 20);
		contentPane.add(Accept);
		
		JButton Respond = new JButton("Respond");
		Respond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String eAccept = Accept.getText();
				String eMatchindex = Matchindex.getText();
				String url = "jdbc:mysql://localhost:3306/";
		        String user = "root";
		        String password = "";
				
		        try{
				        Class.forName("com.mysql.jdbc.Driver").newInstance();
			            Connection con = DriverManager.getConnection(url, user, password);
			            
			            Statement stt = con.createStatement();
			            stt.execute("USE hy360");
			            
			            System.out.println("\nAccept: "+eAccept);
			            System.out.println("\nMatchindex: "+eMatchindex+"\n");
			            System.out.println("\nINSERT INTO response\n");
			            String sql1 = "INSERT INTO response (matchindex,accept)"+
			            			"VALUES("+eMatchindex+","+eAccept+");";
			            
			            Statement stt1 = con.createStatement();
					      stt1.executeUpdate(sql1);
					      

			            String sql2 = 	"UPDATE job "+
			            				"SET state = 'succeeded'  "+
			            				"WHERE jobindex IN( "+
				    		  			"SELECT jobindex "+
				    		  			"FROM matchttable "+
				    		  			"WHERE matchindex IN( "+
				    		  				"SELECT matchindex "+ 
				    		  				"FROM response "+
				    		  				"WHERE accept = "+1+" "+
				    		  				" ) "+
				    		  			" ); ";
			            System.out.println(sql1+"\n"+"\n");
			            System.out.println();
					    System.out.println(sql2+"\n");
			            Statement stt2 = con.createStatement();
			           
					      stt2.executeUpdate(sql2);
					      

				
			}
		    catch (Exception e2)
		    {
		        e2.printStackTrace();
		    }
			}
	});
		Respond.setBounds(10, 151, 103, 23);
		contentPane.add(Respond);
		
		JButton contact = new JButton("contact");
		contact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String url = "jdbc:mysql://localhost:3306/";
		        String user = "root";
		        String password = "";
				
		        try{
				        Class.forName("com.mysql.jdbc.Driver").newInstance();
			            Connection con = DriverManager.getConnection(url, user, password);
			            
			            Statement stt = con.createStatement();
			            stt.execute("USE hy360");
			            
			            String sql1 = "SELECT * FROM matchttable "+
			            		"WHERE jobindex IN( "+
			            			"SELECT jobindex FROM job "+
			            			"WHERE account = "+login.employer_Account +");";
			            System.out.println("\n"+sql1+"\n");
			            Statement stt1 = con.createStatement();
			            //stt1.executeQuery(sql1);
			            String toPopUp1 = "jobindex \t queryindex \tmatchindex\n";
                   
			            ResultSet rs1 = stt1.executeQuery(sql1);
			            while(rs1.next()){
			            	toPopUp1 = toPopUp1 + rs1.getString("jobindex")+"\t" + rs1.getString("queryindex")+"\t"+rs1.getString("queryindex")+"\n";
					    	  }
			            PopUp  pu1= new PopUp(toPopUp1, " Matchtable");
			            
			            
			            
			            
			            
			            String sql2 = "SELECT * FROM query "+
			            		"WHERE queryindex IN( "+
			            			"SELECT queryindex FROM matchttable "+
			            			"WHERE jobindex IN( "+
			            				"SELECT jobindex FROM job "+
			            				"WHERE account= "+login.employer_Account +"));";
			            				
			            
			            Statement stt2 = con.createStatement();
			            //stt1.executeQuery(sql1);
			            String toPopUp2 = "account \t ddate \t queryindex \t profession\n";
			            ResultSet rs2 = stt2.executeQuery(sql2);
			            while(rs2.next()){
			            	toPopUp2 = toPopUp2 + rs2.getString("account")+"\t" + rs2.getString("ddate")+"\t"+rs2.getString("queryindex")+"\t"+rs2.getString("profession")+"\n";
			            }
			            System.out.println("\nyolo: 430\n");
			            PopUp po2 = new PopUp(toPopUp2, " Queries");
			            
			            
			            String sql3 = "SELECT * FROM employee "+
			            		"WHERE account IN( "+
			            			"SELECT account FROM query "+
			            			"WHERE queryindex IN( "+
			            				"SELECT queryindex FROM matchttable "+
			            				"WHERE jobindex IN( "+
			            					"SELECT jobindex FROM job "+
			            					"WHERE account = "+login.employer_Account +")));"; 
			            					
			            				
			            
			            Statement stt3 = con.createStatement();
			            String toPopUp3 = "name \t email \t account \t profession\n";
			            ResultSet rs3 = stt3.executeQuery(sql3);
			            while(rs3.next()){
			            	toPopUp3 = toPopUp3 + rs3.getString("name")+"\t"+ rs3.getString("email")+"\t"+ rs3.getString("account")+"\t"+ rs3.getString("profession")+"\n";
					    	  
					    	  }
			            System.out.println("\nyolo: 440\n");
			            PopUp po3 = new PopUp(toPopUp3," Employee");
			            
			            
			            
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
			            
         
				
			}
		});
		contact.setBounds(10, 57, 103, 23);
		contentPane.add(contact);
		
		
		
		txtMatchindex = new JTextField();
		txtMatchindex.setEditable(false);
		txtMatchindex.setText("MatchIndex");
		txtMatchindex.setBounds(123, 152, 86, 20);
		contentPane.add(txtMatchindex);
		txtMatchindex.setColumns(10);
		
		txtAccept = new JTextField();
		txtAccept.setEditable(false);
		txtAccept.setText("accept");
		txtAccept.setColumns(10);
		txtAccept.setBounds(123, 183, 86, 20);
		contentPane.add(txtAccept);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
