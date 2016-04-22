package messages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import qaium.Home;

public class NewWindowMessage extends ShowMessage{
	public NewWindowMessage(String msg){
		showMessage(msg);
	}
	public void showMessage(String Message){
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 490, 634);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Message);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(118, 183, 297, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("< Back <");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home window = new Home();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		button.setBounds(143, 358, 198, 23);
		frame.getContentPane().add(button);
		

		frame.getContentPane().add(newLabel());
		frame.setVisible(true);
	}
	
	public JLabel newLabel(){
		JLabel lblNewLabel1 = new JLabel("New label");
		Image img =new ImageIcon (this.getClass().getResource("/Background.jpg")).getImage();
		lblNewLabel1.setIcon(new ImageIcon(img));
		lblNewLabel1.setBounds(0, -6, 499, 598);
		return lblNewLabel1;
	}
	
}