package qaium;


import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class MamberFrom {

	JFrame frame;
	public JTextField userName;
	public  JTextField userPass;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MamberFrom window = new MamberFrom();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MamberFrom() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Personal Assisstant");
		
		
		frame.setVisible(true);
		JButton btnProfile = new JButton("Profile");
		btnProfile.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowProfile window= new ShowProfile() ;
			    window.frame.setVisible(true);
			    frame.setVisible(false);
			}
		});
		
			
		btnProfile.setBounds(208, 91, 94, 28);
		frame.getContentPane().add(btnProfile);
		
		JButton btnExpencess = new JButton("Expenses");
		btnExpencess.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExpencess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculateExpenese window= new CalculateExpenese() ;
			    window.frame.setVisible(true);
			    frame.setVisible(false);
				
			}
		});
		btnExpencess.setBounds(45, 52, 109, 28);
		frame.getContentPane().add(btnExpencess);
		
		JButton btnNewButton = new JButton("History ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				History window= new History() ;
			    window.frame.setVisible(true);
			    frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(152, 52, 103, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Addresses");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddressBook window = new AddressBook();
				window.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		
		btnLogout.setBounds(136, 534, 205, 28);
		frame.getContentPane().add(btnLogout);
		btnNewButton_1.setBounds(339, 52, 103, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Diary ");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DiaryWriting window = new DiaryWriting();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		btnNewButton_2.setBounds(254, 52, 87, 28);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img =new ImageIcon (this.getClass().getResource("/Background.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, -6, 499, 609);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}

