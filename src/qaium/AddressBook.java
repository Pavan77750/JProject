package qaium;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class AddressBook {

	JFrame frame;
	JButton Bdone = new JButton("Done");
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblName;
	private JTextField fname;
	private JLabel lblAddress;
	private JTextField faddress;
	private JLabel lblMobileNo;
	private JTextField fmobile;
	private JTextField search;
	private JTable table;
	private JButton btnNewButton;
	private JTextField searchBox;
	private JButton Back;
	private JLabel lblNewLabel;
	private JLabel lblName_1;
	private JLabel lblAddress_1;
	private JLabel lblMobile;


	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBook window= new AddressBook();
					window.frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddressBook()
	{
		initialize();
	}

	
	private void initialize() {
		
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
			
			String qurey="Select friend_name,friend_address,friend_mobile from registration where user_name = '" +userName +"'and password='"+Id+"'";
			ResultSet rs = stat.executeQuery(qurey);
			stat.close () ;
		}
		catch (Exception e1) {
		
			e1.printStackTrace();
			}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Address Book");
		
		
		JButton btnAddAddress = new JButton("Add Address");
		btnAddAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setVisible(true);
				fname.setVisible(true);
				faddress.setVisible(true);
				lblAddress.setVisible(true);
				lblMobileNo.setVisible(true);
				fmobile.setVisible(true);
				Bdone.setVisible(true);
				
			}
		});
		
		btnAddAddress.setBounds(197, 378, 118, 23);
		frame.getContentPane().add(btnAddAddress);
		Image img =new ImageIcon (this.getClass().getResource("/Background.jpg")).getImage();
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(77, 407, 46, 14);
		frame.getContentPane().add(lblName);
		lblName.setVisible(false);
		
		fname = new JTextField();
		fname.setBounds(143, 405, 229, 20);
		frame.getContentPane().add(fname);
		fname.setColumns(10);
		fname.setVisible(false);
		
		faddress = new JTextField();
		faddress.setColumns(10);
		faddress.setBounds(143, 436, 229, 20);
		frame.getContentPane().add(faddress);
		faddress.setVisible(false);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(77, 443, 67, 14);
		frame.getContentPane().add(lblAddress);
		lblAddress.setVisible(false);
		
		lblMobileNo = new JLabel("Mobile:");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobileNo.setBounds(77, 472, 67, 14);
		frame.getContentPane().add(lblMobileNo);
		lblMobileNo.setVisible(false);
		
		fmobile = new JTextField();
		fmobile.setColumns(10);
		fmobile.setBounds(143, 470, 152, 20);
		frame.getContentPane().add(fmobile);
		fmobile.setVisible(false);
		Bdone.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		Bdone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url="jdbc:mysql://localhost/qaium";
				String DBuser="root";
				String DBpass="";
				String JDBCdriver= "com.mysql.jdbc.Driver" ;
			
				try {
					
					Class.forName(JDBCdriver);
					Connection conn = DriverManager.getConnection(url, DBuser, DBpass);
					Statement stat= conn.createStatement();
					String userName=Home.userNamepasstost ;
				    String qurey="INSERT INTO friend_address (friend_name,friend_address,friend_mobile,username) VALUES ('"+fname.getText()+"','"+faddress.getText()+"','"+fmobile.getText()+"','"+userName+"')";
			        stat.executeUpdate(qurey);
			        AddressBook ab=new AddressBook();
			        ab.frame.setVisible(true);
				
			        stat.close () ;
				}
				
				catch (Exception a) {
						a.printStackTrace();	
							}
				
			}
		});
		
		
		Bdone.setBounds(305, 469, 67, 23);
	    frame.getContentPane().add(Bdone);
		Bdone.setVisible(false);
		
		JButton friendAddress = new JButton("Friends Address");
		friendAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblName_1.setVisible(true);
				lblAddress_1.setVisible(true);
				lblMobile.setVisible(true);
				table.setVisible(true);
				
				String url="jdbc:mysql://localhost/qaium";
				String DBuser="root";
				String DBpass="";
				String JDBCdriver= "com.mysql.jdbc.Driver" ;
				try {
					Class.forName(JDBCdriver);
					Connection conn = DriverManager.getConnection(url, DBuser, DBpass);
					Statement stat= conn.createStatement();
				
					String userName=Home.userNamepasstost ;
					
					
					String qurey="Select friend_name,friend_address,friend_mobile from friend_address where username = '"+userName+"'";
					System.out.println(qurey);
					ResultSet rs = stat.executeQuery(qurey);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					}
					catch (Exception e1) {
					
					e1.printStackTrace();
					}
			}
		});
		
		
		friendAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		friendAddress.setBounds(77, 104, 148, 23);
		frame.getContentPane().add(friendAddress);
		
		searchBox = new JTextField();
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				table.setVisible(true);
				String url="jdbc:mysql://localhost/qaium";
				String DBuser="root";
				String DBpass="";
				String JDBCdriver= "com.mysql.jdbc.Driver" ;
				try {
					Class.forName(JDBCdriver);
					Connection conn = DriverManager.getConnection(url, DBuser, DBpass);
					Statement stat= conn.createStatement();
				
					String userName=Home.userNamepasstost ;
					

						String searchNameMatch = ""+searchBox.getText()+"%";
						String qurey="Select friend_name,friend_address,friend_mobile from friend_address where username = '"+userName+"' and friend_name like '"+searchNameMatch+"'";
						System.out.println(qurey);
						ResultSet rs = stat.executeQuery(qurey);
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
					}
					catch (Exception e1) {
					
					e1.printStackTrace();
					}
			}
		});
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearch.setBounds(258, 107, 46, 14);
		frame.getContentPane().add(lblSearch);
		
		lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName_1.setBounds(90, 163, 46, 14);
		frame.getContentPane().add(lblName_1);
		lblName_1.setVisible(false);
		
		lblAddress_1 = new JLabel("Address");
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress_1.setBounds(208, 164, 67, 14);
		frame.getContentPane().add(lblAddress_1);
		lblAddress_1.setVisible(false);
		
		
		lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobile.setBounds(356, 164, 46, 14);
		frame.getContentPane().add(lblMobile);
		lblMobile.setVisible(false);
		
		searchBox.setBounds(305, 105, 125, 20);
		frame.getContentPane().add(searchBox);
		searchBox.setColumns(10);
		
		table = new JTable();
		table.setBounds(77, 181, 349, 186);
		frame.getContentPane().add(table);
		table.setVisible(false);
		
		Back = new JButton("< Back <");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MamberFrom window = new MamberFrom();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
				
		Back.setBounds(139, 533, 206, 23);
		frame.getContentPane().add(Back);
		
		
		JLabel filter = new JLabel("New label");
		filter.setIcon(new ImageIcon(img));
		filter.setBounds(0, 0, 499, 598);
		frame.getContentPane().add(filter);
		
		btnNewButton = new JButton("< Back <");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MamberFrom window = new MamberFrom();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		btnNewButton.setBounds(143, 533, 191, 23);
		frame.getContentPane().add(btnNewButton);
		
	}
}
