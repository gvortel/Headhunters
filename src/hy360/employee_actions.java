package hy360;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.Statement;

public class employee_actions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee_actions frame = new employee_actions();
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
	public employee_actions() {
		setTitle("Employee Actions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnMatchJobs = new JButton("Add Skills, Languages, Studies ");
		btnMatchJobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skills sk = new skills();
				sk.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnMatchJobs.setBounds(5, 150, 424, 23);
		contentPane.add(btnMatchJobs);
		
		
		
		
		
		
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
			            stt = con.createStatement();
			            stt.execute("USE hy360");
			            
			            
			            String sql1 = "SELECT jobindex FROM job ;";
			            Statement stt1 = con.createStatement();
						int curjobindex = 0;
						ResultSet rs1 = stt1.executeQuery(sql1);	
						while(rs1.next()){
							
							curjobindex= Integer.parseInt(rs1.getString("jobindex"));
							String sql2 = "SELECT deadline FROM job "+
											"WHERE jobindex = "+curjobindex+"; ";
							Statement stt2 = con.createStatement();
							ResultSet rs2 = stt2.executeQuery(sql2);
							String date = null;
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
											"SET state = 'failed' "+
											"WHERE jobindex = "+curjobindex+ " ;";
							Statement stt3 = con.createStatement();
							
							System.out.println("YOLO: "+curjobindex);
							if(year > yearNow)
							{
								stt3.executeUpdate(sql3);
								System.out.println("\nginame\n");
							}
							else if (year == yearNow){
								if(mon > monNow){
									stt3.executeUpdate(sql3);
									System.out.println("\nYOLO\n");
								}
								else if (mon == monNow){
									if (day>dayNow){
										stt3.executeUpdate(sql3);
										System.out.println("\nLIPOU\n");
									}
								
								}
								else{}
							}
								
							else{}
		
								
						}
							
			           
						
			            	String sql4 = "SELECT jobindex,account,state,hours,salary,deadline,location FROM job "+
			            					"WHERE jobindex IN( "+
			            						"SELECT jobindex FROM matchttable "+
			            							"WHERE queryindex IN( "+
			            								"SELECT queryindex FROM query "+
			            									"WHERE account = "+login.employee_Account+")); ";
			            	
			            	
			            	String toPopup1 = "jobindex \t account \t state \t hours \t salary  \t deadline \t location \n";
			            	
			            	Statement stt4 = con.createStatement();
				            ResultSet rs4 = stt4.executeQuery(sql4);	
				            while(rs4.next()){
				            	toPopup1 = toPopup1 + rs4.getString("jobindex")+"\t" +rs4.getString("account")+ "\t" +rs4.getString("state")+ "\t"+ rs4.getString("hours")+"\t" +rs4.getString("salary")+ "\t"+ rs4.getString("deadline")+"\t"+ rs4.getString("location")+"\n";
								//System.out.println("exei to rs3");
								//String temmp=rs3.getString("jobindex");
								System.out.println(toPopup1);
								
							}
				            PopUp po1 = new PopUp(toPopup1," JOB");
			             
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
			            
			}
		});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Question.setBounds(5, 74, 200, 23);
		contentPane.add(Question);
		
		
		
	}
}

