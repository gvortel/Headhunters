package hy360;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class skills extends JFrame {

	private JPanel contentPane;
	private String [] skills_table = {"-","Skill_1", "Skill_2", "Skill_3","Skill_4","Skill_5","Skill_6","Skill_7","Skill_8"};
	private String [] lang_table = {"-","Greek", "English","chinese","spanish","french","russian"};
	private String [] studies_table = {"-","pc_studies", "biology","chemistry","math","applied maths","engineer","medic"};
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public skills() {
		setTitle("Employee Skills");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox(skills_table);
		comboBox.setBounds(128, 11, 334, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(skills_table);
		comboBox_1.setBounds(128, 42, 334, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(skills_table);
		comboBox_2.setBounds(128, 73, 334, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox(skills_table);
		comboBox_3.setBounds(128, 103, 334, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox(skills_table);
		comboBox_4.setBounds(128, 129, 334, 20);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox(skills_table);
		comboBox_5.setBounds(128, 160, 334, 20);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox(skills_table);
		comboBox_6.setBounds(128, 191, 334, 20);
		contentPane.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox(skills_table);
		comboBox_7.setBounds(128, 222, 334, 20);
		contentPane.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox(skills_table);
		comboBox_8.setBounds(128, 253, 334, 20);
		contentPane.add(comboBox_8);
		
		JTextArea txtrSkill = new JTextArea();
		txtrSkill.setBounds(10, 11, 96, 20);
		txtrSkill.setText("skill 1");
		contentPane.add(txtrSkill);
		
		JTextArea txtrSkill_1 = new JTextArea();
		txtrSkill_1.setBounds(10, 42, 96, 20);
		txtrSkill_1.setText("skill 2");
		contentPane.add(txtrSkill_1);
		
		JTextArea txtrSkill_2 = new JTextArea();
		txtrSkill_2.setBounds(10, 73, 96, 20);
		txtrSkill_2.setText("skill 3");
		contentPane.add(txtrSkill_2);
		
		JTextArea txtrSkill_3 = new JTextArea();
		txtrSkill_3.setBounds(10, 103, 96, 20);
		txtrSkill_3.setText("skill 4");
		contentPane.add(txtrSkill_3);
		
		JTextArea txtrSkill_4 = new JTextArea();
		txtrSkill_4.setBounds(10, 132, 96, 20);
		txtrSkill_4.setText("skill 5");
		contentPane.add(txtrSkill_4);
		
		JTextArea txtrSkill_5 = new JTextArea();
		txtrSkill_5.setBounds(10, 160, 96, 20);
		txtrSkill_5.setText("skill 6");
		contentPane.add(txtrSkill_5);
		
		JTextArea txtrSkill_6 = new JTextArea();
		txtrSkill_6.setBounds(10, 191, 96, 20);
		txtrSkill_6.setText("skill 7");
		contentPane.add(txtrSkill_6);
		
		JTextArea txtrSkill_7 = new JTextArea();
		txtrSkill_7.setBounds(10, 222, 96, 20);
		txtrSkill_7.setText("skill 8");
		contentPane.add(txtrSkill_7);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(10, 258, 96, -184);
		textArea_7.setText("skill 1");
		contentPane.add(textArea_7);
		
		JComboBox comboBox_9 = new JComboBox(skills_table);
		comboBox_9.setBounds(128, 284, 334, 20);
		contentPane.add(comboBox_9);
		
		JTextArea txtrSkill_8 = new JTextArea();
		txtrSkill_8.setBounds(10, 253, 96, 20);
		txtrSkill_8.setText("skill 9");
		contentPane.add(txtrSkill_8);
		
		JTextArea txtrSkill_9 = new JTextArea();
		txtrSkill_9.setBounds(10, 284, 96, 20);
		txtrSkill_9.setText("skill 10");
		contentPane.add(txtrSkill_9);
		
		JTextArea txtrLanguage = new JTextArea();
		txtrLanguage.setBounds(10, 333, 96, 20);
		txtrLanguage.setText("language 1");
		contentPane.add(txtrLanguage);
		
		JTextArea txtrLanguage_1 = new JTextArea();
		txtrLanguage_1.setBounds(10, 364, 96, 20);
		txtrLanguage_1.setText("language 2");
		contentPane.add(txtrLanguage_1);
		
		JTextArea txtrLanguage_2 = new JTextArea();
		txtrLanguage_2.setBounds(10, 391, 96, 20);
		txtrLanguage_2.setText("language 3");
		contentPane.add(txtrLanguage_2);
		
		JTextArea txtrLanguage_3 = new JTextArea();
		txtrLanguage_3.setBounds(10, 422, 96, 20);
		txtrLanguage_3.setText("language 4");
		contentPane.add(txtrLanguage_3);
		
		JComboBox lang_1 = new JComboBox(lang_table);
		lang_1.setBounds(128, 333, 334, 20);
		contentPane.add(lang_1);
		
		JComboBox lang_2 = new JComboBox(lang_table);
		lang_2.setBounds(128, 364, 334, 20);
		contentPane.add(lang_2);
		
		JComboBox lang_3 = new JComboBox(lang_table);
		lang_3.setBounds(128, 391, 334, 20);
		contentPane.add(lang_3);
		
		JComboBox lang_4 = new JComboBox(lang_table);
		lang_4.setBounds(128, 422, 334, 20);
		contentPane.add(lang_4);
		
		JTextArea txtrStudies = new JTextArea();
		txtrStudies.setBounds(10, 477, 96, 20);
		txtrStudies.setText("Studies 1");
		contentPane.add(txtrStudies);
		
		JTextArea txtrStudies_1 = new JTextArea();
		txtrStudies_1.setBounds(10, 508, 96, 20);
		txtrStudies_1.setText("Studies 2");
		contentPane.add(txtrStudies_1);
		
		JTextArea txtrStudies_2 = new JTextArea();
		txtrStudies_2.setBounds(10, 539, 96, 20);
		txtrStudies_2.setText("Studies 3");
		contentPane.add(txtrStudies_2);
		
		JTextArea txtrStudies_3 = new JTextArea();
		txtrStudies_3.setBounds(10, 570, 96, 20);
		txtrStudies_3.setText("Studies 4");
		contentPane.add(txtrStudies_3);
		
		JComboBox study_1 = new JComboBox(studies_table);
		study_1.setBounds(128, 477, 334, 20);
		contentPane.add(study_1);
		
		JComboBox study_2 = new JComboBox(studies_table);
		study_2.setBounds(128, 508, 334, 20);
		contentPane.add(study_2);
		
		JComboBox study_3 = new JComboBox(studies_table);
		study_3.setBounds(128, 539, 334, 20);
		contentPane.add(study_3);
		
		JComboBox study_4 = new JComboBox(studies_table);
		study_4.setBounds(128, 570, 334, 20);
		contentPane.add(study_4);
		
		
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(10, 624, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String skill_0= comboBox.getSelectedItem().toString();
				String skill_1 = comboBox_1.getSelectedItem().toString();
				String skill_2 = comboBox_2.getSelectedItem().toString();
				String skill_3 = comboBox_3.getSelectedItem().toString();
				String skill_4 = comboBox_4.getSelectedItem().toString();
				String skill_5 = comboBox_5.getSelectedItem().toString();
				String skill_6 = comboBox_6.getSelectedItem().toString();
				String skill_7 = comboBox_7.getSelectedItem().toString();
				String skill_8 = comboBox_8.getSelectedItem().toString();
				String skill_9 = comboBox_9.getSelectedItem().toString();
				String std_1 = study_1.getSelectedItem().toString();
				String std_2 = study_2.getSelectedItem().toString();
				String std_3 = study_3.getSelectedItem().toString();
				String std_4 = study_4.getSelectedItem().toString();
				String lng_1 = lang_1.getSelectedItem().toString();
				String lng_2 = lang_2.getSelectedItem().toString();
				String lng_3 = lang_3.getSelectedItem().toString();
				String lng_4 = lang_4.getSelectedItem().toString();
				System.out.println("skill_0:\n"+skill_0);
				System.out.println("skill_1:\n"+skill_1);

				
				 String url = "jdbc:mysql://localhost:3306/";
			   
		        String user = "root";
		        
		       
		        String password = "";
				if (login.flag == 0) //employee
				{
					try{
				        Class.forName("com.mysql.jdbc.Driver").newInstance();
			            Connection con = DriverManager.getConnection(url, user, password);
			            
			            Statement stt = con.createStatement();
			            stt.execute("USE hy360");
			            if(skill_0 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_0+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(skill_1 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_1+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(skill_2 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_2+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(skill_3 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_3+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(skill_4 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_4+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(skill_5 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_5+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(skill_6 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_6+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(skill_7 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_7+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(skill_8 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_8+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(skill_9 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, account)"
									+"VALUES("+"'"+skill_9+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            
			            if(lng_1 != "-")
			            {
			            	String sql = "INSERT INTO language(langname, account)"
									+"VALUES("+"'"+lng_1+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(lng_2 != "-")
			            {
			            	String sql = "INSERT INTO language(langname, account)"
									+"VALUES("+"'"+lng_2+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(lng_3 != "-")
			            {
			            	String sql = "INSERT INTO language(langname, account)"
									+"VALUES("+"'"+lng_3+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(lng_4 != "-")
			            {
			            	String sql = "INSERT INTO language(langname, account)"
									+"VALUES("+"'"+lng_4+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(std_1 != "-")
			            {
			            	String sql = "INSERT INTO studies(titlename, account)"
									+"VALUES("+"'"+std_1+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(std_2 != "-")
			            {
			            	String sql = "INSERT INTO studies(titlename, account)"
									+"VALUES("+"'"+std_2+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            if(std_3 != "-")
			            {
			            	String sql = "INSERT INTO studies(titlename, account)"
									+"VALUES("+"'"+std_3+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            
			            if(std_4 != "-")
			            {
			            	String sql = "INSERT INTO studies(titlename, account)"
									+"VALUES("+"'"+std_4+ "', "+login.employee_Account +")";
									stt.executeUpdate(sql);
			            }
			            
			            
			            
			            
			           
					}
					catch (Exception e)
			        {
			            e.printStackTrace();
			        }
					
					
				}
				else if(login.flag == 1) // emlpoyer
				{
					try{
				        Class.forName("com.mysql.jdbc.Driver").newInstance();
			            Connection con = DriverManager.getConnection(url, user, password);
			            
			            Statement stt = con.createStatement();
			            stt.execute("USE hy360");
			            
			            
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
					      recentjobid++;
					      
			            if(skill_0 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname, jobindex)"
									+"VALUES("+"'"+skill_0+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(skill_1 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname,jobindex)"
									+"VALUES("+"'"+skill_1+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(skill_2 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname,jobindex)"
									+"VALUES("+"'"+skill_2+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(skill_3 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname,jobindex)"
									+"VALUES("+"'"+skill_3+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(skill_4 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname,jobindex)"
									+"VALUES("+"'"+skill_4+ "', "+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(skill_5 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname,jobindex)"
									+"VALUES("+"'"+skill_5+ "', "+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(skill_6 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname ,jobindex)"
									+"VALUES("+"'"+skill_6+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(skill_7 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname,jobindex)"
									+"VALUES("+"'"+skill_7+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(skill_8 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname,jobindex)"
									+"VALUES("+"'"+skill_8+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(skill_9 != "-")
			            {
			            	String sql = "INSERT INTO skill(skillname,jobindex)"
									+"VALUES("+"'"+skill_9+ "',"+recentjobid+")";
									stt.executeUpdate(sql+ "\n");
			            }
			            
			            if(lng_1 != "-")
			            {
			            	String sql = "INSERT INTO language(langname,jobindex) "
			            			+"VALUES("+"'"+lng_1+ "',"+recentjobid+")";
			            	
									stt.executeUpdate(sql);
			            }
			            if(lng_2 != "-")
			            {
			            	String sql = "INSERT INTO language(langname,jobindex) "
									+"VALUES("+"'"+lng_2+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(lng_3 != "-")
			            {
			            	String sql = "INSERT INTO language(langname,jobindex)"
									+"VALUES("+"'"+lng_3+ "', "+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(lng_4 != "-")
			            {
			            	String sql = "INSERT INTO language(langname,jobindex)"
									+"VALUES("+"'"+lng_4+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(std_1 != "-")
			            {
			            	String sql = "INSERT INTO studies(titlename,jobindex)"
									+"VALUES("+"'"+std_1+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(std_2 != "-")
			            {
			            	String sql = "INSERT INTO studies(titlename,jobindex)"
									+"VALUES("+"'"+std_2+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            if(std_3 != "-")
			            {
			            	String sql = "INSERT INTO studies(titlename,jobindex)"
									+"VALUES("+"'"+std_3+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            
			            if(std_4 != "-")
			            {
			            	String sql = "INSERT INTO studies(titlename,jobindex)"
									+"VALUES("+"'"+std_4+ "',"+recentjobid+")";
									stt.executeUpdate(sql);
			            }
			            
			            
			            
			            
			           
					}
					catch (Exception e)
			        {
			            e.printStackTrace();
			        }
					
					
				
					
				}
				else {} // admin

				
			}
		});
		contentPane.add(btnNewButton);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}
}
