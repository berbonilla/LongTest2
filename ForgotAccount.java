package longExam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JCheckBox;


public class CreateAccount extends finalExam{
	private static JTextField newUserNameTextField;
	private static JPasswordField newPasswordField;
	private static JPasswordField newPasswordField1;
	
	
	public CreateAccount() {
		create_Account();
	}
	
	public static void create_Account() {

		JFrame newAccFrame = new JFrame();
		newAccFrame.getContentPane().setBackground(Color.WHITE);
		newAccFrame.setBounds(400,400,438,419);
		newAccFrame.getContentPane().setLayout(null);
		newAccFrame.setLocationRelativeTo(null);
		newAccFrame.setTitle("Sign In");
		newAccFrame.setResizable(false);
		
		JPanel logInPanel = new JPanel();
		logInPanel.setBounds(10, 11, 402, 358);
		newAccFrame.getContentPane().add(logInPanel);
		logInPanel.setLayout(null);
		
		newUserNameTextField = new JTextField(10);
		newUserNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newUserNameTextField.setText("Email or Phone Number");
		newUserNameTextField.setForeground(Color.GRAY);
		newUserNameTextField.setBounds(10, 104, 382, 43);
		
		newUserNameTextField.addFocusListener((FocusListener) new FocusListener() {
		 public void focusGained(FocusEvent e) {
			 if (newUserNameTextField.getText().equals("Input New Password")) {
				 	newUserNameTextField.setText("");
				 	newUserNameTextField.setForeground(Color.BLACK);
	 	        }
	    }
		 public void focusLost(FocusEvent e) {
	        
	    
		 }
	        
	    });
		
		
	    logInPanel.add(newUserNameTextField);
			
	    newPasswordField = new JPasswordField(10);
	    newPasswordField.setBounds(10, 158, 297, 43);
	    newPasswordField.setEchoChar((char)0);
	    newPasswordField.setText("Input New Password");
	    newPasswordField.setForeground(Color.GRAY);
	    newPasswordField.setForeground(Color.BLACK);
	    newPasswordField.addFocusListener((FocusListener) new FocusListener() {
	    	 public void focusGained(FocusEvent e) {
	 	        if (new String(newPasswordField.getPassword()).equals("Input New Password")) {
	 	        	newPasswordField.setEchoChar('*');
	 	        	newPasswordField.setText("");
	 	        	newPasswordField.setForeground(Color.BLACK);
	 	        }
	 	    }
	 		 public void focusLost(FocusEvent e) {
	 	        if (new String(newPasswordField.getPassword()).equals("Input New Password")) {
	 	        	newPasswordField.setForeground(Color.GRAY);
	 	        	newPasswordField.setText("Input New Password");
	 	        }
	 		 }
		    });
	    
	    newPasswordField1 = new JPasswordField(10);
		newPasswordField1.setEchoChar((char)0);
		newPasswordField1.setText("Repeat Password");
		newPasswordField1.setForeground(Color.GRAY);
		newPasswordField1.setBounds(10, 213, 297, 43);
		newPasswordField1.addFocusListener((FocusListener) new FocusListener() {
			public void focusGained(FocusEvent e) {
	 	        if (new String(newPasswordField1.getPassword()).equals("Repeat Password")) {
	 	        	newPasswordField1.setEchoChar('*');
	 	        	newPasswordField1.setText("");
	 	        	newPasswordField1.setForeground(Color.BLACK);
	 	        }
	 	    }
	 		 public void focusLost(FocusEvent e) {
	 	        if (new String(newPasswordField1.getPassword()).equals("Repeat Password")) {
	 	        	newPasswordField1.setForeground(Color.GRAY);
	 	        	newPasswordField1.setText("Repeat Password");
	 	        }
	 		 }
		    });
		
		logInPanel.add(newPasswordField1);
	    logInPanel.add(newPasswordField);
	    
		JButton newAccButt = new JButton("Sign Up");
		newAccButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (newUserNameTextField.getText().equals("") || new String(newPasswordField.getPassword()).equals("") || new String(newPasswordField1.getPassword()).equals(""))
					JOptionPane.showMessageDialog(null, "Invalid Username/Password!");
				else {
					if (new String(newPasswordField.getPassword()).equals(new String(newPasswordField1.getPassword()))) {
						passList.add(new String(newPasswordField.getPassword()));
						userList.add(newUserNameTextField.getText());
						newPasswordField.setText("");
						newUserNameTextField.setText("");
						JOptionPane.showMessageDialog(null, "New Account Succesfully Added!");
						newAccFrame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Username/Password!");
					}
				}
			}
		});
		
		newAccButt.setFont(new Font("Tahoma", Font.BOLD, 19));
		newAccButt.setForeground(new Color(255, 255, 255));
		newAccButt.setBackground(new Color(0, 164, 0));
		newAccButt.setBounds(138, 283, 153, 37);
		newAccButt.setBorderPainted(false);
		logInPanel.add(newAccButt);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 11, 177, 40);
		logInPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Its quick and easy.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 56, 134, 14);
		logInPanel.add(lblNewLabel_1);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.addActionListener(ae -> {
	         JCheckBox c = (JCheckBox) ae.getSource();
	         newPasswordField.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
		});
		chckbxNewCheckBox.setBounds(321, 168, 97, 23);
		logInPanel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Show");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_1.addActionListener(ae -> {
	         JCheckBox c = (JCheckBox) ae.getSource();
	         newPasswordField1.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
		});
		chckbxNewCheckBox_1.setBounds(321, 223, 97, 23);
		logInPanel.add(chckbxNewCheckBox_1);
		newAccFrame.setVisible(true);
		
	}

}
