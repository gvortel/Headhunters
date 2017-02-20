package hy360;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class PopUp extends JFrame {
	String sql;
	private JPanel contentPane;

	/**
	 * Launch the application.
	*/ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUp frame = new PopUp("YOLO Yolo", "skata");
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
	/*public PopUp() {
		setTitle("Results");
		//setTitle("Results:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 374, 459);
		setBounds(100, 100, 425, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}*/
	public PopUp(String yolo,String blaze) {
		System.out.println("\n"+blaze+"\n");
		
		sql=yolo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setBounds(100, 100, 425, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	    // create the middle panel components
	    JTextArea display = new JTextArea ( 26, 38 );
	    display.setEditable ( false ); // set textArea non-editable
	    display.setText(yolo);
	    JScrollPane scroll = new JScrollPane ( display );
	    scroll.setBounds(100, 100, 691, 468);
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    
	    //Add Textarea in to middle panel
	    contentPane.add ( scroll );

	    // My code
	    JFrame frame = new JFrame ();
	    frame.setTitle(blaze);
	    frame.getContentPane().add ( contentPane );
	    frame.pack ();
	    frame.setLocationRelativeTo ( null );
	    frame.setVisible ( true );
	}

}
