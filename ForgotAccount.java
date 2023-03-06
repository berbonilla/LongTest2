package longExam;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotAccount extends finalExam {
	private static JTextField txtEmailOrPhone;
	private static JLabel lblNewLabel;
	private static JPanel panel_1;
	private static JLabel lblNewLabel_1;
	private static JButton btnNewButton;
	private static JButton btnNewButton_1;
	public static int userIndex;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void forgotAcc() {
		JFrame newFrame = new JFrame();
		newFrame.getContentPane().setBackground(Color.WHITE);
		newFrame.setBounds(400,400,591,216);
		newFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 575, 137);
		newFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtEmailOrPhone = new JTextField();
		txtEmailOrPhone.setForeground(new Color(192, 192, 192));
		txtEmailOrPhone.setText("Email or Phone Number");
		txtEmailOrPhone.setBounds(89, 73, 416, 42);
		txtEmailOrPhone.setColumns(10);
		txtEmailOrPhone.addFocusListener((FocusListener) new FocusListener() {
		 public void focusGained(FocusEvent e) {
		        if (txtEmailOrPhone.getText().equals("Email or Phone Number")) {
		        	txtEmailOrPhone.setText("");
		        	txtEmailOrPhone.setForeground(Color.BLACK);
		        }
		    }
			 public void focusLost(FocusEvent e) {
		        if (txtEmailOrPhone.getText().isEmpty()) {
		        	txtEmailOrPhone.setForeground(Color.GRAY);
		        	txtEmailOrPhone.setText("Email or Phone Number");
		        }
			 }
			
		    });
		panel.add(txtEmailOrPhone);
		
		lblNewLabel = new JLabel("Find Your Account");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 199, 28);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Please enter your email or phone number to search for your accoount");
		lblNewLabel_1.setBounds(89, 50, 416, 14);
		panel.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(242, 242, 242));
		panel_1.setBounds(0, 137, 575, 40);
		newFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userList.contains(txtEmailOrPhone.getText())) {
					userIndex = userList.indexOf(txtEmailOrPhone.getText());
					JOptionPane.showMessageDialog(null,"Account Found");
					new changePass(userIndex);
					newFrame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Username Does not Exist");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(65, 102, 179));
		btnNewButton.setBounds(377, 11, 89, 23);
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalExam.main_Frame();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(476, 11, 89, 23);
		panel_1.add(btnNewButton_1);
		newFrame.setLocationRelativeTo(null);
		newFrame.setTitle("Account recovery");
		newFrame.setVisible(true);
		newFrame.setResizable(false);
		
	}
}
