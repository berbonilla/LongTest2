import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;


public class changePass extends mainFrame{
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;
	static int userInd;
	
	public changePass(int userIndex) {
		userInd = userIndex;
		change_Pass();
	}
	
	public static void change_Pass() {
		
		JFrame changePassFrame = new JFrame();
		changePassFrame.getContentPane().setBackground(Color.WHITE);
		changePassFrame.setBounds(400,400,591,216);
		changePassFrame.getContentPane().setLayout(null);
		changePassFrame.getContentPane().requestFocusInWindow();
		
		JLabel lblChangeYourPassword = new JLabel("Change your password");
		lblChangeYourPassword.setForeground(Color.BLACK);
		lblChangeYourPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChangeYourPassword.setBackground(Color.BLACK);
		lblChangeYourPassword.setBounds(10, 0, 199, 28);
		changePassFrame.getContentPane().add(lblChangeYourPassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(242, 242, 242));
		panel_1.setBounds(0, 135, 575, 42);
		changePassFrame.getContentPane().add(panel_1);
		
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.main_Frame();
				changePassFrame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(476, 11, 89, 23);
		panel_1.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(94, 39, 382, 35);
		passwordField.setEchoChar((char)0);
		passwordField.setText("Input Password");
		passwordField.addFocusListener((FocusListener) new FocusListener() {
			 public void focusGained(FocusEvent e) {
				 passwordField.setForeground(Color.BLACK);
				 passwordField.setEchoChar('*');
				 passwordField.setText("");
				
			 	}
			 public void focusLost(FocusEvent e) {
				 	
			 }
			
		    });
		
		changePassFrame.getContentPane().add(passwordField);
		
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(94, 85, 382, 35);
		passwordField_1.setEchoChar((char)0);
    	passwordField_1.setText("Repeat Password");
		passwordField_1.addFocusListener((FocusListener) new FocusListener() {
			
			 public void focusGained(FocusEvent e) {
				 passwordField_1.setForeground(Color.BLACK);
				 passwordField_1.setEchoChar('*');
				 passwordField_1.setText("");
		        
		    }
			 public void focusLost(FocusEvent e) {

	
			 }
			
		    });
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String pass1 = String.copyValueOf(passwordField.getPassword());
				String pass2 = String.copyValueOf(passwordField_1.getPassword());
				if (pass1.length() > 8 && pass2.length() > 8) {
					if (pass1.equals(pass2)) {
							JOptionPane.showMessageDialog(null,"Password Changed");
							passList.remove(userInd);
							char [] nPass = passwordField_1.getPassword();
							String newPass = String.copyValueOf(nPass);
							passList.add(userInd,newPass);
							mainFrame.main_Frame();
							
						}
					else if (passwordField.getPassword().length == 0 || passwordField_1.getPassword().length ==0){
							JOptionPane.showMessageDialog(null,"Field Cannot be Empty");
						}
					else {
							JOptionPane.showMessageDialog(null,"Passwords does not match");
						}
					}
				else {
					JOptionPane.showMessageDialog(null,"Passwords must contain atleast 8 characters!");
				}
			}
				
		});
		
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBackground(new Color(65, 102, 179));
		btnSave.setBounds(377, 11, 89, 23);
		btnSave.requestFocusInWindow();
		panel_1.add(btnSave);
		
		changePassFrame.getContentPane().add(passwordField_1);
		
		JCheckBox show1stPass = new JCheckBox("Show");
		show1stPass.setBounds(482, 45, 97, 23);
		changePassFrame.getContentPane().add(show1stPass);
		show1stPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		show1stPass.addActionListener(ae -> {
		         JCheckBox c = (JCheckBox) ae.getSource();
		         passwordField.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
		  });
		
		JCheckBox show2ndPass = new JCheckBox("Show");
		show2ndPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		show2ndPass.setBounds(482, 91, 97, 23);
		changePassFrame.getContentPane().add(show2ndPass);
		show2ndPass.addActionListener(ae -> {
	         JCheckBox c = (JCheckBox) ae.getSource();
	         passwordField_1.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
		});
	
		changePassFrame.setLocationRelativeTo(null);
		changePassFrame.setTitle("Account recovery");
		changePassFrame.setVisible(true);
		changePassFrame.setResizable(false);
	}

}
