package qaium;


import java.awt.EventQueue;
import java.awt.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.xml.ws.handler.MessageContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils ;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextArea;

public class ShowProfile {

	JFrame frame;
	private JButton btnNewButton;
	private JTextField firstname;
	private JTextField email;
	private JLabel lblTotalBalance;
	private JTextField tb;

	
	 
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ShowProfile window = new ShowProfile();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	public ShowProfile() {
		
		initialize();
		
		String url="jdbc:mysql://localhost/qaium";
		String DBuser="root";
		String DBpass="";
		String JDBCdriver= "com.mysql.jdbc.Driver" ;
		try {
				Class.forName(JDBCdriver);
				Connection conn = DriverManager.getConnection(url, DBuser, DBpass);
				Statement stat= conn.createStatement();
			
				String userName=Home.userNamepasstost ;
				String Id=Home.IDpasstost ;
			
				
				//String qurey="Select first_name,last_name from registration where user_name = '"+userName+"'and password='"+Id+"'";
				String qurey="Select first_name,last_name from registration where user_name = '"+userName+"'";
				System.out.println(qurey);
	
				ResultSet rs1 = stat.executeQuery(qurey) ;
				System.out.println(rs1);
				if (rs1.next()){
					String a = rs1.getString("first_name") ;
					String b = rs1.getString("last_name");
					String d= " " ;
					String c=a+d+b ;
					firstname.setText(c);
						
				}
				
				qurey="Select email from registration where user_name = '"+userName+"'and password='"+Id+"'";
				ResultSet rs2 = stat.executeQuery(qurey);
				if (rs2.next()){
					
					email.setText(rs2.getString("email"));
				}
				qurey="Select TotalBalance from registration where user_name = '"+userName+"'and password='"+Id+"'";
				ResultSet rs3 = stat.executeQuery(qurey);
				if (rs3.next()){
					
					tb.setText(rs3.getString("TotalBalance"));
				}
			
			
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
	}
	
	

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Current User Profile");
		
		JLabel lblNewLabel = new JLabel("Your Profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(180, 13, 90, 25);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
		
		JLabel lblNewLabel1 = new JLabel("New label");
		Image img =new ImageIcon (this.getClass().getResource("/Background.jpg")).getImage();
		
		btnNewButton = new JButton("< Back <");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MamberFrom window = new MamberFrom();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		JLabel lblUserName = new JLabel("Full name :");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserName.setBounds(72, 187, 82, 14);
		frame.getContentPane().add(lblUserName);
		
		lblTotalBalance = new JLabel("Total balance :");
		lblTotalBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalBalance.setBounds(72, 277, 101, 14);
		frame.getContentPane().add(lblTotalBalance);
		
		firstname = new JTextField();
		firstname.setBounds(183, 185, 159, 20);
		frame.getContentPane().add(firstname);
		firstname.setColumns(10);
		
		email = new JTextField();
		email.setBounds(183, 232, 162, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		tb = new JTextField();
		tb.setBounds(183, 275, 159, 20);
		frame.getContentPane().add(tb);
		tb.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(72, 234, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		btnNewButton.setBounds(136, 533, 206, 25);
		frame.getContentPane().add(btnNewButton);
		lblNewLabel1.setIcon(new ImageIcon(img));
		lblNewLabel1.setBounds(0, 0, 499, 590);
		frame.getContentPane().add(lblNewLabel1);

	}
}
