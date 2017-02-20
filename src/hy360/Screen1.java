package hy360;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;

import java.awt.SystemColor;

import javax.swing.UIManager;


public class Screen1 extends JFrame {

	private JPanel contentPane;
	String [] profs = {"biologist", "software_developer", "mathematician", "doctor", "physician", "web developer"};

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen1 frame = new Screen1();
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
	public Screen1() {
		setTitle("Insert Job");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 468);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JTextArea txtrAddress = new JTextArea();
		txtrAddress.setEditable(false);
		txtrAddress.setText("Location");
		txtrAddress.setBounds(10, 33, 84, 29);
		contentPane.add(txtrAddress);
		
		JTextArea txtrSalary = new JTextArea();
		txtrSalary.setEditable(false);
		txtrSalary.setText("Salary");
		txtrSalary.setBounds(10, 73, 84, 29);
		contentPane.add(txtrSalary);
		
		JTextArea txtrHours = new JTextArea();
		txtrHours.setEditable(false);
		txtrHours.setText("Hours");
		txtrHours.setBounds(10, 113, 84, 29);
		contentPane.add(txtrHours);
		
		JTextArea txtrDeadline = new JTextArea();
		txtrDeadline.setEditable(false);
		txtrDeadline.setText("DeadLine");
		txtrDeadline.setBounds(10, 165, 84, 29);
		contentPane.add(txtrDeadline);
		
		JTextArea txtrProfession = new JTextArea();
		txtrProfession.setText("Profession");
		txtrProfession.setEditable(false);
		txtrProfession.setBounds(10, 315, 84, 29);
		contentPane.add(txtrProfession);
		
		JTextArea location = new JTextArea();
		location.setBounds(104, 33, 339, 29);
		contentPane.add(location);
		
		JTextArea salary = new JTextArea();
		salary.setBounds(104, 73, 339, 29);
		contentPane.add(salary);
		
		JTextArea hours = new JTextArea();
		hours.setBounds(104, 113, 339, 29);
		contentPane.add(hours);
		
		JComboBox comboBox = new JComboBox(profs);
		comboBox.setFont(new Font("Monospaced", Font.PLAIN, 13));
		comboBox.setBounds(104, 315, 339, 29);
		contentPane.add(comboBox);
		
		//CALENDAR
		JCalendar calendar = new JCalendar();
		calendar.setBounds(104, 158, 188, 146);
		contentPane.add(calendar);
		
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Profession = comboBox.getSelectedItem().toString();
				
				//GET DATE
				int day=calendar.getDayChooser().getDay();
				int year=calendar.getYearChooser().getYear();
				int month=calendar.getMonthChooser().getMonth();
				String DeadLine = "";
				
				String Hours = hours.getText();
				String Salary = salary.getText();
				String Location = location.getText();
				System.out.println("Profession: " + Profession);	
				
				
				
				/*INSERT TO JOB ARRAY################################################################*/
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
			            stt.execute("USE hy360");
			            //
			            //  TO BE DONE!!!
			            //
			            //  ACCOUNT = TO ID TOU EMPLOYER POU XEI KANEI LOGIN
			            //
			            //	UPDATE TA FIELDS TOU HEADHUNTER AVAILABLE FAILED PERCENTAGE
			            //	ME VASH TO STATE
			            //
			           int  employerAccount=login.employer_Account;
			           String State="available";
			           int Discount = 0;
			           
			           DeadLine = day+"/"+(month+1)+"/"+year;
			           
						String sql = "INSERT INTO job (location,account,salary,hours"
								+",deadline,profession,state)  VALUES ("
								+"'"+ Location+"', "
								+ employerAccount+", "
								+ Salary+", "
								+ Hours +",'"
								+ DeadLine +"', '"
								+ Profession+"','"
								+ State+"')";	
				      stt.executeUpdate(sql);						
				      System.out.println("DONE :  JOB INSERTED ");
				      System.out.println("deadline : "+DeadLine);
				      
				      
				      
				      String sql1=	"UPDATE employer "
									+"SET jobcounter = jobcounter + 1 "
									+"WHERE account = "+employerAccount +"; ";
				      Statement stt1 = con.createStatement();
				      stt1.executeUpdate(sql1);
				      
				      
					  String sql2=  "UPDATE employer "
									+"SET discount = 0 "
									+"WHERE jobcounter < 3; " ;
					  Statement stt2 = con.createStatement();
				      stt2.executeUpdate(sql2);
									
				      
					  String sql3=  "UPDATE employer "
									+"SET discount = 0.10 "
									+"WHERE jobcounter >= 3 AND jobcounter <= 4; ";
					  Statement stt3 = con.createStatement();
				      stt3.executeUpdate(sql3);
				      
				      
					  String sql4=  "UPDATE employer "
									+"SET discount = 0.20 "
									+"WHERE jobcounter >= 5; ";
					  Statement stt4 = con.createStatement();
				      stt4.executeUpdate(sql4);
				      
				      
					  String sql5=  "UPDATE headhunters "
									+"SET jobcounter = jobcounter + 1; ";
					  Statement stt5 = con.createStatement();
				      stt5.executeUpdate(sql5);
								
				      
					  String sql6=  "UPDATE headhunters "
									+"SET available = 0 , failed = 0, succeeded = 0; ";
					  Statement stt6 = con.createStatement();
				      stt6.executeUpdate(sql6);
						
				      
				      
					  String sql7=  "SELECT jobindex "
									+"FROM job "
									+"WHERE state = 'available' ";
					  Statement stt7 = con.createStatement();
				      //stt7.execute(sql7);
				      ResultSet rs7 = stt7.executeQuery(sql7);
				      int tmp_available=0;
				      while(rs7.next())
				    	  tmp_available++;
				      System.out.println("AVAILABLE : "+tmp_available);
				      
					  String sql8=  "UPDATE headhunters "
									+"SET available = "+tmp_available+"; ";
					  Statement stt8 = con.createStatement();
				      stt8.executeUpdate(sql8);

				      
				      
				      
					  String sql9=  "SELECT jobindex "
									+"FROM job "
									+"WHERE state = 'failed'; ";
					  Statement stt9 = con.createStatement();
					  ResultSet rs9 = stt9.executeQuery(sql9);
				      int tmp_failed=0;
				      while(rs9.next())
				    	  tmp_failed++;
				      System.out.println("FAILED : "+tmp_failed);
				      
					  String sql10=  "UPDATE headhunters "
									+"SET failed = "+tmp_failed+"; ";
					  Statement stt10 = con.createStatement();
				      stt10.executeUpdate(sql10);
				      
				      
				      
					  String sql11=  "SELECT jobindex "
									+"FROM job "
									+"WHERE state = 'succeeded'; ";
					  Statement stt11 = con.createStatement();
					  ResultSet rs11 = stt11.executeQuery(sql11);
				      int tmp_succeeded=0;
				      while(rs11.next())
				    	  tmp_succeeded++;
				      System.out.println("SUCCEEDED : "+tmp_succeeded);
				      
					  String sql12=  "UPDATE headhunters "
									+"SET succeeded = "+tmp_succeeded+"; ";
					  Statement stt12 = con.createStatement();
				      stt12.executeUpdate(sql12);				
									
				      
				      
					  String sql13=  "UPDATE headhunters "
									+"SET failurepercentage =  failed/jobcounter *100, succeededpercentage = succeeded/jobcounter *100; ";
					  Statement stt13 = con.createStatement();
				      stt13.executeUpdate(sql13);
				      
				      /*
				       ********* JOB PAYMENT
				       * */
				      String sql14="SELECT discount " 
				    		  		+"FROM employer "
				    		  		+"WHERE account = "+employerAccount+";";
				      Statement stt14 = con.createStatement();
				      ResultSet rs14 = stt14.executeQuery(sql14);
				      float tmp_discount=0;
				      while(rs14.next()){
				    	  tmp_discount = Float.parseFloat(rs14.getString("discount"));
				    	  break;}
				      System.out.println("DISCOUNT : "+tmp_discount);
				      
				      String sql15="UPDATE headhunters SET balance = balance - 5*"+tmp_discount+";";
				      System.out.println("DONE  :  BALANCE UPDATED");
				      Statement stt15 = con.createStatement();
				      stt15.executeUpdate(sql15);
				      
				      
				      
				      /*
				       * 		JOB MATCHING 
				       * 
				       * */
				      String sql16="SELECT account "
				      		+ "FROM query";
				      Statement stt16 = con.createStatement();
				      ResultSet rs16 = stt16.executeQuery(sql16);
				      
				      //get last inserted job's id 
				      String sql17="SELECT jobindex FROM job "
				      			 + "ORDER BY jobindex DESC "
				      			 + "LIMIT 1";
				      Statement stt17 = con.createStatement();
				      ResultSet rs17 = stt17.executeQuery(sql17);
				      int recentjobid=0;
				      while(rs17.next()){
				    	  recentjobid = Integer.parseInt(rs17.getString("jobindex"));
				    	  break;}
				      System.out.println("JOBID "+recentjobid);
				      
				      //get number of skills
				      String sql18="SELECT skillname "
				      		+ "FROM skill "
				      		+ "WHERE jobindex= "+recentjobid+";";	  
				      Statement stt18 = con.createStatement();
				      ResultSet rs18 = stt18.executeQuery(sql18);
				      int skillcounter=0;
				      while(rs18.next()){
				    	  skillcounter++;
				      }
				      System.out.println("SKILLS :  "+skillcounter);
				      
				      
				      //get number of languages
				      String sql19="SELECT langname "
				      		+ "FROM language "
				      		+ "WHERE jobindex= "+recentjobid+";";	  
				      Statement stt19 = con.createStatement();
				      ResultSet rs19 = stt19.executeQuery(sql19);
				      int languagecounter=0;
				      while(rs19.next()){
				    	  languagecounter++;
				      }
				      System.out.println("LANGUAGES :  "+languagecounter);
				      
				      
				      //loop start
				      while(rs16.next()){
				    	  
				    	  
				    	  String sql25 = "SELECT profession FROM job "+
				    			  		"WHERE jobindex = "+ recentjobid+" "+
				    			  		"UNION "+
				    			  		"SELECT profession FROM employee "+
				    			  		"WHERE account = "+ Integer.parseInt(rs16.getString("account"))+" "+
				    			  		"ORDER BY profession ;";
				    	  System.out.println("\n"+sql25+"\n");
				    	  Statement stt25 = con.createStatement();
					      ResultSet rs25 = stt25.executeQuery(sql25);
					      int profCounter=0;
					      while(rs25.next()){
					    	  profCounter++;
					      }
					      if(profCounter !=1)
					    	  continue;
				    	  
				    	  
				    	  
				    	  
				    	  
				    	  String sql23 = " SELECT deadline FROM job "+
				    			  		"WHERE jobindex = "+recentjobid+" ;";
				    	  String ddate;
				    	  String[] dparts ;
				    	  int dyear = 0 ,dmon = 0 ,dday = 0;
				    	  Statement stt23 = con.createStatement();
					      ResultSet rs23= stt23.executeQuery(sql23);
					      if (rs23.next()){
					    	  ddate = rs23.getString("deadline");
					    	  dparts = ddate.split("/");
					    	  dyear = Integer.parseInt(dparts[2]);
					    	  dmon = Integer.parseInt(dparts[1]);
					    	  dday = Integer.parseInt(dparts[0]);
					      }
				    	  
				    	  
					      String sql24 = " SELECT deadline FROM job "+
				    			  		"WHERE account = "+Integer.parseInt(rs16.getString("account"));
					      
					      String date_2;
				    	  String[] parts_2 ;
				    	  int year_2 = 0 ,mon_2 = 0 ,day_2 = 0;
				    	  Statement stt24 = con.createStatement();
					      ResultSet rs24= stt24.executeQuery(sql24);
					      if (rs24.next()){
					    	  date_2 = rs24.getString("deadline");
					    	  parts_2 = date_2.split("/");
					    	  year_2 = Integer.parseInt(parts_2[2]);
					    	  mon_2 = Integer.parseInt(parts_2[1]);
					    	  day_2 = Integer.parseInt(parts_2[0]);
					      }
					      
					      
					      if(dyear < year_2)
							{
					    	  System.out.println("\nginame\n");
								continue;
								
							}
							else if (dyear == year_2){
								if( dmon  < mon_2){	
									System.out.println("\nYOLO\n");
									continue;
								}
								else if (dmon == mon_2){
									if (dday < day_2){
										System.out.println("\nLIPOU\n");
										continue;
									}
								
								}
								else{}
							}
								
							else{}
					      
					      
					      
					      
					      
					      
					      
					      
					      
					      
					      
					      
				    	  String sql20="SELECT skillname "
				    	  		+ "FROM skill "
				    	  		+ "WHERE jobindex="+recentjobid+" "
				    	  		+ "UNION "
				    	  		+ "SELECT skillname "
				    	  		+ "FROM skill "
				    	  		+ "WHERE account="+Integer.parseInt(rs16.getString("account"))+" "
				    	  		+ "ORDER BY skillname;";
				    	  Statement stt20 = con.createStatement();
					      ResultSet rs20= stt20.executeQuery(sql20);
					      int resultcounter=0;
					      while(rs20.next()){
					    	  resultcounter++;
					      }
					      
					      //if job skill counter > this counter then no match . continue loop
					      if(skillcounter > resultcounter)
					    	  continue;
					      
					      //else we have a match
					      String sql21="SELECT queryindex "
					      		+ "FROM query "
					      		+ "WHERE account="+employerAccount+";";
					      Statement stt21 = con.createStatement();
					      ResultSet rs21= stt21.executeQuery(sql21);
					      int selectedqueryindex=0;
					      while(rs21.next()){
					    	  selectedqueryindex=Integer.parseInt(rs21.getString("queryindex"));
					    	  break;
					      }
					      System.out.println("QUERYINDEX  : "+selectedqueryindex);
					      
					      
					      String sql22="INSERT INTO matchttable(queryindex,jobindex) "
					      				+"VALUES("+selectedqueryindex+","+recentjobid+")";
					      Statement stt22 = con.createStatement();
					      stt22.executeUpdate(sql22);
					  //end of loop
				      }
				      
				      System.out.println("===>"+calendar.getDayChooser());
				      
				      
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 385, 94, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Skills & Languages");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					skills sk = new skills();
					sk.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(326, 388, 339, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnClose = new JButton("close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnClose.setBounds(576, 11, 89, 23);
		contentPane.add(btnClose);
		
		
		
		
		
	}
}
