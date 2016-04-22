package qaium;


/**
 * @author 	Qaium and Ahmad
 * @version 1.0
 */


import messages.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Color;



public class Home {

public JFrame frame;
	public JTextField userName;
	static String userNamepasstost , IDpasstost ;
	public static Object userPasspasstost;
	private JPasswordField userPass;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Home() {
		initialize();
		
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login");
		
		JLabel lblUserName = new JLabel("User name :");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserName.setBounds(122, 249, 95, 23);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(122, 283, 95, 23);
		frame.getContentPane().add(lblPassword);
		
		userName = new JTextField();
		userName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		Label label = new Label("Personal Assistant ");
		label.setBackground(new Color(255, 255, 255));
		label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		label.setBounds(108, 110, 281, 49);
		frame.getContentPane().add(label);
		userName.setBounds(205, 252, 114, 20);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		frame.setVisible(true);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IDpasstost=userPass.getText();
				userNamepasstost=userName.getText() ;
				
				String url="jdbc:mysql://localhost/qaium";
				String DBuser="root";
				String DBpass="";
				String JDBCdriver="com.mysql.jdbc.Driver";
				try {
					Class.forName(JDBCdriver);
					Connection conn = DriverManager.getConnection(url, DBuser, DBpass);
					Statement stat= conn.createStatement();
					String qurey="Select * from registration where user_name = '" +userName.getText() +"' and password='"+userPass.getText()+"'";
					ResultSet rs = stat.executeQuery(qurey);
					if (rs.next()==false)
					{
						NewWindowMessage n1 = new NewWindowMessage("Wrong Username/Password combination");
						frame.setVisible(false);
					}
					else
						
						{
							MamberFrom window = new MamberFrom();
							window.frame.setVisible(true);
							frame.setVisible(false);
							
						}
						
					
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				
				
			}
		});
		
		userPass = new JPasswordField();
		userPass.setBounds(205, 285, 114, 20);
		frame.getContentPane().add(userPass);
		btnLogin.setBounds(230, 335, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(0, 102, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		Image img =new ImageIcon (this.getClass().getResource("/Background.jpg")).getImage();
		
		JButton btnRegistration_1 = new JButton("Registration");
		btnRegistration_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistration_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Registration window1 = new Registration();
				window1.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		btnRegistration_1.setBounds(87, 335, 114, 23);
		frame.getContentPane().add(btnRegistration_1);
		
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, -3, 485, 590);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
