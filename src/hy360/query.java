package hy360;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import java.sql.Connection;

import javax.swing.JButton;

import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class query extends JFrame {
	
	private JPanel contentPane;
	String [] profs = {"biologist", "software_developer", "mathematician", "doctor", "physician", "web developer"};
	

	/**
	 * Create the frame.
	 */
	public query() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JTextArea txtrDate = new JTextArea();
		txtrDate.setText("Date");
		txtrDate.setBounds(0, 11, 94, 22);
		contentPane.add(txtrDate);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(152, 11, 188, 146);
		contentPane.add(calendar);
		
		JButton PostQuery = new JButton("Post Query");
		PostQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//GET DATE
				int day=calendar.getDayChooser().getDay();
				int year=calendar.getYearChooser().getYear();
				int month=calendar.getMonthChooser().getMonth();
				String DeadLine = "";
				DeadLine = day+"/"+(month+1)+"/"+year;  
				
				
				int eaccount = login.employee_Account;
				String edate = DeadLine;
				//String eprofession = profession.getSelectedItem().toString();
				 

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
				            System.out.println("edwwwwwwwwwww:\n");
				            //Statement stt;
				            Statement stt = con.createStatement();
				            stt.execute("USE hy360");
				             // Create and select a database for use. 
				            //stt.execute("USE hy360");
				            //query
				            String sql1 = "INSERT INTO query (account,ddate,profession)"+"  VALUES ("
								+""+ eaccount+",' "
									+ edate+"',' "
									+employee.eprofession +"')";
							System.out.println(sql1);

				            
					      stt.executeUpdate(sql1);
					      
					      String sql2 = "SELECT jobindex FROM job ;";
					      Statement stt2 = con.createStatement();
						  ResultSet rs2 = stt2.executeQuery(sql2);
					      int curJobIndex = 0;
					      while(rs2.next()){
					    	  curJobIndex = Integer.parseInt(rs2.getString("jobindex"));
					    	  
					    	  
					    	  String sql11 = "SELECT profession FROM job "+
				    			  		"WHERE jobindex = "+ curJobIndex+" "+
				    			  		"UNION "+
				    			  		"SELECT profession FROM employee "+
				    			  		"WHERE account = "+ login.employee_Account+" "+
				    			  		"ORDER BY profession; ";
					    	  
					    	  System.out.println("\n"+sql11+"\n");
					    	  Statement stt11 = con.createStatement();
						      ResultSet rs11 = stt11.executeQuery(sql11);
						      int profCounter=0;
						      while(rs11.next()){
						    	  profCounter++;
						      }
						      if(profCounter !=1)
						    	  continue;
					      
						      String sql3 = "SELECT deadline FROM job "+
						    		  		"WHERE jobindex = "+curJobIndex+" ;";
						      
						      String deadline = null;
						      Statement stt3 = con.createStatement();
								ResultSet rs3 = stt3.executeQuery(sql3);
								if(rs3.next()){
									deadline = rs3.getString("deadline");
								}
						    
						      System.out.println("\nDATE: "+deadline+"\n");
						      
						      String[] parts = deadline.split("/");
						      int ddyear = Integer.parseInt(parts[2]);
						      int ddmon = Integer.parseInt(parts[1]);
						      int ddday = Integer.parseInt(parts[0]);
						    
						      
						      
								
							String sql4 = "SELECT ddate FROM query "+
											"WHERE account = "+login.employee_Account+" ;";
							Statement stt4 = con.createStatement();
							ResultSet rs4 = stt4.executeQuery(sql4);
							String date = null;
							  int dyear = Integer.parseInt(parts[2]);
						      int dmon = Integer.parseInt(parts[1]);
						      int dday = Integer.parseInt(parts[0]);
						      
							if(rs4.next()){
								date = rs4.getString("ddate");
								String[] dparts = deadline.split("/");
							      dyear = Integer.parseInt(parts[2]);
							      dmon = Integer.parseInt(parts[1]);
							      dday = Integer.parseInt(parts[0]);
							}     
							System.out.println( "date: "+ date);  
							
							
							      if(ddyear < dyear)
									{
							    	  System.out.println("\nginame\n");
										continue;
										
									}
									else if (ddyear == dyear){
										if( ddmon  < dmon){	
											System.out.println("\nYOLO\n");
											continue;
										}
										else if (ddmon == dmon){
											if (ddmon < dmon){
												System.out.println("\nLIPOU\n");
												continue;
											}
										
										}
										else{}
									}
										
									else{}
							      
							      String sql5 = "SELECT skillname FROM skill "+
							    		  		"WHERE jobindex = "+curJobIndex+ " ;";
							      Statement stt5 = con.createStatement();
								  ResultSet rs5 = stt5.executeQuery(sql5);
							      int skillCounter = 0;
							      while(rs5.next()){
							    	  skillCounter++;
							      }
							     
							      
							      
							      String sql6 = "SELECT skillname FROM skill "+
							    		  		"WHERE jobindex = "+curJobIndex+ " "+
							    		  		"UNION "+
							    		  		"SELECT skillname FROM skill "+
							    		  		"WHERE account = "+login.employee_Account+" "+
							    		  		"ORDER BY skillname";
							      Statement stt6 = con.createStatement();
								  ResultSet rs6 = stt6.executeQuery(sql6);
							      int Counter = 0;
							      while(rs6.next()){
							    	  Counter++;
							      }
							      System.out.println(sql6);
							      if(skillCounter > Counter)
							    	  continue;
							      System.out.println("skillCounter: "+skillCounter);
							      System.out.println("Counter: "+Counter);
							      
							      
							      String sql7 = " SELECT langname FROM language "+
							    		  		"WHERE jobindex = "+curJobIndex+ ";";
							      Statement stt7 = con.createStatement();
								  ResultSet rs7 = stt7.executeQuery(sql7);
							      int langCounter = 0;
							      while(rs7.next()){
							    	  langCounter++;
							      }
							      
							      
							      
							      String sql8 = "SELECT langname FROM language "+
							    		  		"WHERE jobindex = "+curJobIndex+ " "+
							    		  		"UNION "+
							    		  		"SELECT langname FROM language "+
							    		  		"WHERE account = "+login.employee_Account+" "+
							    		  		"ORDER BY langname ;";
							      Statement stt8 = con.createStatement();
								  ResultSet rs8 = stt8.executeQuery(sql8);
							      int lCounter = 0;
							      while(rs8.next()){
							    	  lCounter++;
							      }
							      
							      if(langCounter >lCounter){
							    	  continue;
							      }
							      
							      //else we have a match
							      String sql9 = "SELECT queryindex FROM query "+
							    		  		"WHERE account ="+login.employee_Account+";";
							      Statement stt9 = con.createStatement();
								  ResultSet rs9 = stt9.executeQuery(sql9);
							      int qindex = 0;
							      if (rs9.next()){
							    	  qindex = Integer.parseInt(rs9.getString("queryindex"));
							      }
							      
							      
							      String sql10 = "INSERT INTO matchttable (queryindex,jobindex) "+
							    		  		" VALUES ("+qindex+", " +curJobIndex+" )";
							      Statement stt10 = con.createStatement();
							      stt10.execute(sql10);
							      
							      
					      }
					      
			        }
			        catch (Exception e2)
			        {
			            e2.printStackTrace();
			        }
			        employee_actions ea= new employee_actions();
				      ea.setVisible(true);
				      setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
				    
			}
		});
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		PostQuery.setBounds(10, 229, 188, 23);
		contentPane.add(PostQuery);
	
	
	}
}
