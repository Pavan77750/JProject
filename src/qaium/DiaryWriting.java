package qaium;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.JTable;

public class DiaryWriting {

	JFrame frame;
	private JTextField topic;
	private JButton btnSave;
	private JLabel lblDate;
	JLabel lvldate = new JLabel("00/00/0000");
	private JButton Back;
	private JTextArea writings;
	private JTable topic_table;
	public JButton btnFindWritings = new JButton("Find writings");
	public JButton btnWriteSomething = new JButton("Write something ");
	public JButton btnOldWritings = new JButton("Old writings ");
	private JLabel lblTopics;
	private JLabel lblDateTime;
	private JLabel lblWritings;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiaryWriting window = new DiaryWriting();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DiaryWriting() {
		initialize();
		cal();
	}
	private void cal () 
	{
		Calendar cal = new GregorianCalendar();
		
		int day = cal.get(Calendar.DAY_OF_MONTH);   
		int month = cal.get(Calendar.MONTH); 
		int year = cal.get(Calendar.YEAR);
		lvldate.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.lvldate.setText(day+"/"+month+"/"+year);
	}

	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Diary");
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		Image img =new ImageIcon (this.getClass().getResource("/Background.jpg")).getImage();
		frame.getContentPane().setLayout(null);
		
	
		btnWriteSomething.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writings.setVisible(true);
				topic.setVisible(true);
				btnSave.setVisible(true);
				lvldate.setVisible(true);
				lblDate.setVisible(true);
				btnFindWritings.setVisible(false);
				
			}
		});
		
		
		btnWriteSomething.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnWriteSomething.setBounds(71, 97, 153, 23);
		frame.getContentPane().add(btnWriteSomething);

		btnFindWritings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topic_table.setVisible(true);
				lblTopics.setVisible(true);
				lblDateTime.setVisible(true);
				lblWritings.setVisible(true);	
				btnWriteSomething.setVisible(false);
				String url="jdbc:mysql://localhost/qaium";
				String DBuser="root";
				String DBpass="";
				String JDBCdriver= "com.mysql.jdbc.Driver" ;
				try {
					Class.forName(JDBCdriver);
					Connection conn = DriverManager.getConnection(url, DBuser, DBpass);
					Statement stat= conn.createStatement();
				
					String userName=Home.userNamepasstost ;
					
					
					String qurey="Select topic,writings,date from diary where writer_name = '"+userName+"'";
				
					ResultSet rs = stat.executeQuery(qurey);
					topic_table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					}
					catch (Exception e1) {
					
					e1.printStackTrace();
					}
				
				
			}
		});
		
		btnFindWritings.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnFindWritings.setBounds(271, 97, 145, 23);
		frame.getContentPane().add(btnFindWritings);

		
		
		topic_table = new JTable();
		topic_table.setBounds(71, 235, 345, 248);
		frame.getContentPane().add(topic_table);
		topic_table.setVisible(false);
		
		topic = new JTextField();
		topic.setBounds(71, 158, 348, 28);
		frame.getContentPane().add(topic);
		topic.setVisible(false);
		
		topic.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url="jdbc:mysql://localhost/qaium";
				String DBuser="root";
				String DBpass="";
				String JDBCdriver= "com.mysql.jdbc.Driver" ;
				boolean flag ; 
				try {
					
					Class.forName(JDBCdriver);
					Connection conn = DriverManager.getConnection(url, DBuser, DBpass);
					Statement stat= conn.createStatement();
					String userName=Home.userNamepasstost ;
					String qurey="INSERT INTO diary (topic,writings,writer_name) VALUES ('"+topic.getText()+"', '"+writings.getText()+"','"+userName+"')";
					
					stat.executeUpdate(qurey);
					
				}
				 catch (Exception a) {
						a.printStackTrace();
						
					}
				
			}
		});
		
		lblTopics = new JLabel("Topics");
		lblTopics.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblTopics.setBounds(94, 210, 46, 14);
		frame.getContentPane().add(lblTopics);
		lblTopics.setVisible(false);
		
		lblDateTime = new JLabel("Date & Time");
		lblDateTime.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblDateTime.setBounds(338, 210, 81, 14);
		frame.getContentPane().add(lblDateTime);
		lblDateTime.setVisible(false);
		
		lblWritings = new JLabel("Writings");
		lblWritings.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblWritings.setBounds(207, 210, 69, 14);
		frame.getContentPane().add(lblWritings);
		lblWritings.setVisible(false);
		
		btnSave.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnSave.setBounds(250, 465, 89, 23);
		frame.getContentPane().add(btnSave);
		btnSave.setVisible(false);
		
		lvldate = new JLabel("");
		lvldate.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lvldate.setBounds(143, 467, 81, 18);
		frame.getContentPane().add(lvldate);
		lvldate.setVisible(false);
		
		lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		lblDate.setBounds(94, 469, 46, 14);
		frame.getContentPane().add(lblDate);
		lblDate.setVisible(false);
		
		Back = new JButton("< Back <");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MamberFrom window = new MamberFrom();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		writings = new JTextArea();
		writings.setBounds(71, 197, 348, 257);
		frame.getContentPane().add(writings);
		Back.setBounds(141, 539, 193, 23);
		writings.setVisible(false);
		frame.getContentPane().add(Back);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 475, 592);
		frame.getContentPane().add(lblNewLabel);

		
	}
}
