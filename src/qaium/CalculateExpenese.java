package qaium;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.TextField;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class CalculateExpenese {

	JFrame frame;
	JButton btnAddBalOk = new JButton("OK");
	private JTextField ExpensesTk;
	JLabel lvldate = new JLabel("00/00/0000");
	private JTextField tbaddbalance;
	double myBalance=0 ;
	private JLabel ReBalance;
	private JTextField expenseReason;
	

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateExpenese window = new CalculateExpenese();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	public CalculateExpenese() {
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
	
	
	public void updateTableField(String tableName ,String tableField , double amount){
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/qaium", "root", "");
			Statement stat= conn.createStatement();
			
			String userName=Home.userNamepasstost ;
			String Id=Home.IDpasstost ;
			
			String qurey="UPDATE " +tableName+ " SET " +tableField+ " = " +amount+"WHERE user_name = '"+userName+"'";
			stat.executeUpdate(qurey);
			
			conn.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public String getTableField(String tableName,String tableField){
        try { 
        String url="jdbc:mysql://localhost/qaium"; 
        String DBuser="root"; 
        String DBpass=""; 
        String JDBCdriver= "com.mysql.jdbc.Driver" ; 
        Class.forName(JDBCdriver); 
        Connection conn = DriverManager.getConnection(url, DBuser, DBpass); 
        Statement stat= conn.createStatement(); 
         
        String userName=Home.userNamepasstost ; 
        String Id=Home.IDpasstost ; 
         
        String qurey="Select "+ tableField +" from "+tableName+" where user_name = '" +userName +"'and password ='"+Id+"'"; 
        ResultSet rs = stat.executeQuery(qurey); 
        String ret = null;
        while (rs.next()) 
        { 
            ret =  rs.getString(tableField);
             
        } 
        conn.close();
        return ret;
        } 
        catch (Exception e1) { 
            e1.printStackTrace(); 
            return "Error. Contact Admin";
        } 
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Expenses Management");
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(41, 41, -553, -9);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expense :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(126, 276, 87, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Remain Balance :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(84, 340, 108, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(84, 365, 87, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total Balance :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(94, 241, 87, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		ExpensesTk = new JTextField();
		ExpensesTk.setBounds(210, 267, 134, 23);
		frame.getContentPane().add(ExpensesTk);
		ExpensesTk.setColumns(10);
		
		
		JLabel lvlTotalBalance = new JLabel("");
		lvlTotalBalance.setBounds(210, 232, 102, 23);
		frame.getContentPane().add(lvlTotalBalance);
	
            try { 
            String url="jdbc:mysql://localhost/qaium"; 
            String DBuser="root"; 
            String DBpass=""; 
            String JDBCdriver= "com.mysql.jdbc.Driver" ; 
            Class.forName(JDBCdriver); 
            Connection conn = DriverManager.getConnection(url, DBuser, DBpass); 
            Statement stat= conn.createStatement(); 
             
            String userName=Home.userNamepasstost ; 
            String Id=Home.IDpasstost ; 
             
            String qurey="Select TotalBalance from registration where user_name = '" +userName+"'and password ='"+Id+"'"; 
            ResultSet rs = stat.executeQuery(qurey); 
            while (rs.next()) 
            { 
                lvlTotalBalance.setText(rs.getString("TotalBalance")); 
                 
            } 
            conn.close();
            } 
            catch (Exception e1) { 
                e1.printStackTrace(); 
            } 
		
		
		ReBalance = new JLabel("0");
		ReBalance.setBounds(210, 336, 134, 23);
		frame.getContentPane().add(ReBalance);
		
		
		lvldate.setBounds(139, 365, 111, 14);
		frame.getContentPane().add(lvldate);
		
		
		
		JButton btnAdd = new JButton("add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tbaddbalance.setVisible(true);
				btnAddBalOk.setVisible(true);
			}
		});
		
		
		btnAddBalOk.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddBalOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double originalBalance = Double.parseDouble(lvlTotalBalance.getText());
				double newBalance = Double.parseDouble(tbaddbalance.getText());
				double totalBalance = originalBalance + newBalance;
				updateTableField("registration" ,"TotalBalance" , totalBalance);
				String newBal = ""+totalBalance;
				lvlTotalBalance.setText(newBal);
				ReBalance.setText(lvlTotalBalance.getText());
				tbaddbalance.setVisible(false);
				btnAddBalOk.setVisible(false);
			}
		} );
		
		btnAdd.setBounds(107, 198, 64, 23);
		frame.getContentPane().add(btnAdd);
		
		tbaddbalance = new JTextField();
		tbaddbalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		tbaddbalance.setBounds(210, 198, 134, 23);
		frame.getContentPane().add(tbaddbalance);
		tbaddbalance.setColumns(10);
		tbaddbalance.setVisible(false);
		
		
		btnAddBalOk.setBounds(358, 198, 59, 23);
		frame.getContentPane().add(btnAddBalOk);
		
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				double tmp = Double.parseDouble(ExpensesTk.getText());
				ReBalance.setText(getTableField("registration","TotalBalance"));
				myBalance = Double.parseDouble(ReBalance.getText());
				if(myBalance-tmp>0){
					myBalance-=tmp;
					updateTableField("registration" ,"TotalBalance" , myBalance);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Not effecient Balance.");
					CalculateExpenese ce =new CalculateExpenese();
					ce.frame.setVisible(true);
				} 
				ReBalance.setText(myBalance+"");
				
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
					
					String genereted ="Expense :"+tmp+"\tNew Balance :"+myBalance;
					
					String qurey="Select TotalBalance from registration where user_name = '"+userName+"'";
					ResultSet rs = stat.executeQuery(qurey);
					if(rs.next()){
					
					lvlTotalBalance.setText(rs.getString("TotalBalance"));
					ReBalance.setText(lvlTotalBalance.getText());
					
					//qurey="INSERT INTO `expenseshistory` (`Expenses`,`RemainBalance`,`Date`,`ExpensesReasonTable`,`user_id`) VALUES ("+tmp+","+myBalance+",'"+lvldate.getText()+"','"+expenseReason.getText()+"','"+userName+"')";     
					qurey="INSERT INTO `expenseshistory` (`Expenses`,`RemainBalance`,`ExpensesReasonTable`,`user_id`) VALUES ('"+tmp+"','"+myBalance+"','"+expenseReason.getText()+"','"+userName+"')";     

					stat.executeUpdate(qurey);
					}
					conn.close();
					
					
				}
				catch (Exception e1) {
					e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
				
			}
			
		});
		
		btnDone.setBounds(333, 361, 89, 23);
		frame.getContentPane().add(btnDone);
		
		JButton button = new JButton("< Back <");
		button.setBackground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MamberFrom window = new MamberFrom();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		
		button.setBounds(138, 539, 206, 23);
		frame.getContentPane().add(button);
		JLabel lblReason = new JLabel("Reason :");
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReason.setBounds(131, 308, 67, 14);
		frame.getContentPane().add(lblReason);
		
		expenseReason = new JTextField();
		expenseReason.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		
		
		expenseReason.setBounds(210, 301, 135, 24);
		frame.getContentPane().add(expenseReason);
		expenseReason.setColumns(10);
		btnAddBalOk.setVisible(false);
		
		JLabel lblNewLabel1 = new JLabel("New label");
		Image img =new ImageIcon (this.getClass().getResource("/Background.jpg")).getImage();
		lblNewLabel1.setIcon(new ImageIcon(img));
		lblNewLabel1.setBounds(0, 0, 499, 598);
		frame.getContentPane().add(lblNewLabel1);
		
	}
}
