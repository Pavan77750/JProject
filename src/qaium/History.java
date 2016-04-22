package qaium;

import java.awt.EventQueue;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class History {

	JFrame frame;
	private JTextField dateFrom;
	private JTextField dateTo;
	private JButton button;
	private JLabel lblFrom;
	private JLabel lblTo;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History window = new History();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public History() {
		initialize();			
	}

	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Expenses History");
		
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				{
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
						String Id=Home.IDpasstost ;
						
						String qurey="Select Date,Expenses,RemainBalance,ExpensesReasonTable from expenseshistory where user_id = '"+userName+"' and Date between '"+dateFrom.getText()+" 00:00:00' and '"+dateTo.getText()+" 23:59:59'";
						//String qurey="Select Date,Expenses,RemainBalance,ExpensesReasonTable from expenseshistory where user_id = '"+userName+"'";

						//String qurey="Select * from expenseshistory where user_id = '"+userName+"'";
						System.out.println(qurey);
						ResultSet rs = stat.executeQuery(qurey);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						
						}
						catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
					
				}
				
			}
		});
		
		btnNewButton.setBounds(372, 155, 58, 23);
		frame.getContentPane().add(btnNewButton);
		
		dateFrom = new JTextField();
		dateFrom.setText("yy-mm-dd");
		dateFrom.setBounds(118, 156, 86, 20);
		frame.getContentPane().add(dateFrom);
		dateFrom.setColumns(10);
		
		dateTo = new JTextField();
		dateTo.setText("yy-mm-dd");
		dateTo.setBounds(261, 156, 86, 20);
		frame.getContentPane().add(dateTo);
		dateTo.setColumns(10);
		
		table = new JTable();
		table.setBounds(72, 212, 365, 213);
		frame.getContentPane().add(table);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setVisible(false);
		
		button = new JButton("< Back <");
		button.setBackground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MamberFrom window = new MamberFrom();
				window.frame.setVisible(true);
				frame.setVisible(false);
				
			}
		});
		
		button.setBounds(128, 533, 209, 23);
		frame.getContentPane().add(button);
		
		lblFrom = new JLabel("From :");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFrom.setBounds(72, 162, 46, 14);
		frame.getContentPane().add(lblFrom);
		
		lblTo = new JLabel("To :");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTo.setBounds(231, 158, 46, 14);
		frame.getContentPane().add(lblTo);
		
		
		Image img =new ImageIcon (this.getClass().getResource("/Background.jpg")).getImage();
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(72, 187, 56, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblRemainbalance = new JLabel("RemainBalance");
		lblRemainbalance.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRemainbalance.setBounds(231, 187, 99, 14);
		frame.getContentPane().add(lblRemainbalance);
		
		JLabel lblExpensesreason = new JLabel("ExpensesReason");
		lblExpensesreason.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExpensesreason.setBounds(329, 187, 116, 14);
		frame.getContentPane().add(lblExpensesreason);
		
		JLabel lblExpenses = new JLabel("Expenses");
		lblExpenses.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExpenses.setBounds(138, 187, 66, 14);
		frame.getContentPane().add(lblExpenses);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, -6, 499, 596);
		frame.getContentPane().add(lblNewLabel);
	}
}
