package qaium;



import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Registration {

	JFrame frame;
	JLabel lbldate = new JLabel("00-00-0000");
	private JTextField firsrName;
	private JTextField lastName;
	private JTextField PassWord;
	private JTextField email;
	private JTextField user_name;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window1 = new Registration();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Registration() {
		initialize();
	}

	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 490, 634);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("Firstname : ");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setBounds(98, 107, 148, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblSecondName = new JLabel("Last Name :");
		lblSecondName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSecondName.setBounds(95, 132, 87, 14);
		frame.getContentPane().add(lblSecondName);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(98, 187, 72, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(121, 218, 72, 14);
		frame.getContentPane().add(lblEmail);
		
		firsrName = new JTextField();
		firsrName.setForeground(SystemColor.desktop);
		firsrName.setBackground(Color.WHITE);
		firsrName.setBounds(192, 104, 181, 20);
		frame.getContentPane().add(firsrName);
		firsrName.setColumns(10);
		
		JLabel lblUserName = new JLabel("User name :");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserName.setBounds(92, 162, 78, 14);
		frame.getContentPane().add(lblUserName);
		
		user_name = new JTextField();
		user_name.setBounds(192, 159, 181, 20);
		frame.getContentPane().add(user_name);
		user_name.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(192, 132, 181, 20);
		frame.getContentPane().add(lastName);
		lastName.setColumns(10);
		
		PassWord = new JTextField();
		PassWord.setBounds(192, 188, 181, 20);
		frame.getContentPane().add(PassWord);
		PassWord.setColumns(10);
		
		email = new JTextField();
		email.setBounds(192, 215, 181, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		frame.setVisible(true);
		
		
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(SystemColor.textHighlight);
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 11));		
		btnConfirm.addActionListener(new ActionListener() {
			
			
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
				    String qurey="INSERT INTO registration (password,first_name,last_name,user_name,email) VALUES ('"+PassWord.getText()+"', '"+firsrName.getText()+"', '"+lastName.getText()+"','"+user_name.getText()+"','"+email.getText()+"')";
					stat.executeUpdate(qurey);
					flag=true ;
					
					
				}
				
				
				 catch (Exception a) {
						a.printStackTrace();
						JOptionPane.showMessageDialog(frame, "Empty Field OR duplicate user name. Please correct it ");	
						flag=false ;
						
					}
				if (flag==true)
				{
				Home window = new Home();
				window.frame.setVisible(true);
				frame.setVisible(false);
				}
				
			
			}
		});
		
		
		btnConfirm.setBounds(284, 265, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
	
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img =new ImageIcon (this.getClass().getResource("/Background.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, -6, 499, 609);
		frame.getContentPane().add(lblNewLabel);
	}
}
