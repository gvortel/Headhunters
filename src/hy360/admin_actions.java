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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class admin_actions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_actions frame = new admin_actions();
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
	public admin_actions() {
		setTitle("Admin Actions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton history = new JButton("History");
		history.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String url = "jdbc:mysql://localhost:3306/";
		        String user = "root";
		        String password = "";
				
		        try
		        {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection con = DriverManager.getConnection(url, user, password);
		            
		            Statement stt2 = con.createStatement();
		            Statement stt10 = con.createStatement();
		             // Create and select a database for use. 
		            stt10.execute("CREATE DATABASE IF NOT EXISTS hy360");
		            stt10.execute("USE hy360");
		            
		            //String sql1 = "UPDATE job";
						            
		            String sql1 = "SELECT jobindex FROM job ";
		            Statement stt1 = con.createStatement();
		            ResultSet rs1 = stt1.executeQuery(sql1);
		            int jobindex;
		            while(rs1.next()){
						System.out.println("\nEFTASE\n");
						jobindex=Integer.parseInt(rs1.getString("jobindex"));
						
						
				    
						String sql2 = "SELECT deadline FROM job "+
										"WHERE jobindex = "+jobindex+";";
						System.out.println(sql2);
						String date = null;
						ResultSet rs2 = stt2.executeQuery(sql2);
						if(rs2.next()){
							date = rs2.getString("deadline");
						}
						String datenow = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
						
						System.out.println("\nDATE: "+date+"\n");
						System.out.println("\ndatenow: "+datenow+"\n");
						
						String[] partsNow = datenow.split("-");
						int yearNow = Integer.parseInt(partsNow[2]);
						int monNow = Integer.parseInt(partsNow[1]);
						int dayNow = Integer.parseInt(partsNow[0]);
						
						String[] parts = date.split("/");
						int year = Integer.parseInt(parts[2]);
						int mon = Integer.parseInt(parts[1]);
						int day = Integer.parseInt(parts[0]);
						
						
						
						
						String sql3 = "UPDATE job "+
						 		"SET state= 'failed' "+
						 		"WHERE jobindex = "+jobindex+";";
						Statement stt3 = con.createStatement();
						
						if(year < yearNow)
						{
							stt3.executeUpdate(sql3);
							System.out.println("\nginame\n");
						}
						else if (year == yearNow){
							if(mon < monNow){
								stt3.executeUpdate(sql3);
								System.out.println("\nYOLO\n");
							}
							else if (mon == monNow){
								if (day < dayNow){
									stt3.executeUpdate(sql3);
									System.out.println("\nLIPOU\n");
								}
							
							}
							else{}
						}
							
						else{}
	
					
					}
		            
		            String sql4 = "SELECT * FROM job WHERE state = 'succeeded' OR state = 'failed';";
		            String toPopup1 = "location \t account \t jobindex \t profession \t state\n";
                    
		            Statement stt4 = con.createStatement();
		            ResultSet rs4 = stt4.executeQuery(sql4);	
		            while(rs4.next()){
		            	toPopup1 = toPopup1 + rs4.getString("location")+"\t" +rs4.getString("account")+ "\t" +rs4.getString("jobindex")+ "\t"+ rs4.getString("profession")+ "\t"+ rs4.getString("state")+"\n";
						//System.out.println("exei to rs3");
						//String temmp=rs3.getString("jobindex");
						System.out.println(toPopup1);
						
					}
		            PopUp po1 = new PopUp(toPopup1,"JOB");
		            
		            
		            String sql6 = "UPDATE headhunters "+
		            				"SET available = 0 , failed = 0, succeeded = 0 ;";
		            Statement stt6 = con.createStatement();
		            stt6.executeUpdate(sql6);
		            
		            String sql7 = "SELECT jobindex FROM job "+
		            				"WHERE state = 'available' ;";
		            Statement stt7 = con.createStatement();
		            ResultSet rs7 = stt7.executeQuery(sql7);
		            int jobCounter = 0;
		            while(rs7.next()){
		            	jobCounter = jobCounter+1;
		            }
		            
		            
		            String spl8 = "UPDATE headhunters "+
		            			"SET available = "+jobCounter+ " ;";
		            Statement stt8 = con.createStatement();
		            stt8.executeUpdate(spl8);
		            
		            
		            
		            String sql9 = "SELECT jobindex FROM job "+
		            				"WHERE state = 'failed' ;";
		            
		            Statement stt9 = con.createStatement();
		            ResultSet rs9 = stt9.executeQuery(sql9);
		            int jobFailedCounter = 0;
		            while(rs9.next()){
		            	jobFailedCounter++; 
		            }
		            
		            
		            String sql11 =  "UPDATE headhunters "+
	            			"SET failed = "+jobFailedCounter+ " ;";
		            Statement stt11 = con.createStatement();
		            stt11.executeUpdate(sql11);
		            
		            String sql12 = "SELECT jobindex FROM job "+
            				"WHERE state = 'succeeded' ;";
            
		            Statement stt12 = con.createStatement();
		            ResultSet rs12 = stt12.executeQuery(sql12);
		            int jobSucCounter = 0;
		            while(rs12.next()){
		            	jobSucCounter++;
		            }
		            
		            
		            String sql13 =  "UPDATE headhunters "+
	            			"SET succeeded = "+jobSucCounter+ " ;";
		            Statement stt13 = con.createStatement();
		            stt13.executeUpdate(sql13);
		            
		            System.out.println("\njobCounter: "+jobCounter);
		            System.out.println("\njobFailedCounter: "+jobFailedCounter);
		            System.out.println("\njobSucCounter: "+jobSucCounter);
		            
		            String sql14 =  "UPDATE headhunters "+
	            			"SET failurepercentage = "+jobFailedCounter+"  / jobcounter * "+100+" , succeededpercentage = "+jobSucCounter+" / jobcounter * "+100+" ;";
		            Statement stt14 = con.createStatement();
		            System.out.println("\n"+sql14+"\n");
		            stt14.executeUpdate(sql14);
		            
		            
		            String sql5 = "SELECT available,failed, succeeded, failurepercentage, succeededpercentage "+
							 "FROM headhunters ;" ;
		            String toPopup2 = "available \tfailed \t succeeded\t failurepercentage\t succeededpercentage\n";
		            Statement stt5 = con.createStatement();
		            ResultSet rs5 = stt5.executeQuery(sql5);	
		            while(rs5.next()){
						toPopup2 = toPopup2 + rs5.getString("available")+"\t" +rs5.getString("failed")+   "     \t"+ rs5.getString("succeeded")+ "         \t"+ rs5.getString("failurepercentage")+ "       \t\t"+ rs5.getString("succeededpercentage")+"\n";
						int temp= Integer.parseInt(rs5.getString("failed"));
						System.out.println(temp+"__---------succeeded\n");
						
					}
		            PopUp po2 = new PopUp(toPopup2, "headhunters");
		            
		           
		            		
		            		
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		history.setBounds(10, 25, 89, 23);
		contentPane.add(history);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
