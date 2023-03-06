import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


public class mainFrame {
	
	protected static final LinkedList<String> userList = new LinkedList<String>();
	protected static final LinkedList<String> passList = new LinkedList<String>();
	public static int attemptCount;		
	private static JTextField userNameTextField;
	private static JPasswordField passwordField;

	public static void main_Frame()  {
		userList.add("Admin");
		
		passList.add("password1");
		
		JFrame main_Frame = new JFrame();
		main_Frame.getContentPane().setBackground(Color.WHITE);
		main_Frame.setBounds(400,400,1166,424);
		main_Frame.getContentPane().setLayout(null);
		main_Frame.setLocationRelativeTo(null);
		main_Frame.setTitle("Log In");
		main_Frame.setResizable(false);
		
		attemptCount = 3;
		
		JPanel logInPanel = new JPanel();
		logInPanel.setBounds(626, 45, 490, 315);
		main_Frame.getContentPane().add(logInPanel);
		logInPanel.setLayout(null);
		
		userNameTextField = new JTextField(10);
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userNameTextField.setText("Email or Phone Number");
		userNameTextField.setForeground(Color.GRAY);
		userNameTextField.setBounds(10, 11, 470, 43);
		
		userNameTextField.addFocusListener((FocusListener) new FocusListener() {
		 public void focusGained(FocusEvent e) {
	        if (userNameTextField.getText().equals("Email or Phone Number")) {
	        	userNameTextField.setText("");
	        	userNameTextField.setForeground(Color.BLACK);
	        }
	    }
		 public void focusLost(FocusEvent e) {
	        if (userNameTextField.getText().isEmpty()) {
	        	userNameTextField.setForeground(Color.GRAY);
	        	userNameTextField.setText("Email or Phone Number");
	        }
		 }
		
	    });
		
	    logInPanel.add(userNameTextField);
			
		passwordField = new JPasswordField(10);
		passwordField.setBounds(10, 65, 391, 43);
		passwordField.setForeground(Color.BLACK);
		logInPanel.add(passwordField);
		

		JLabel lblNewLabel_3 = new JLabel("Incorrect password or username!!!");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_3.setForeground(Color.RED);
				lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 13));
				lblNewLabel_3.setBounds(737, 11, 261, 37);
				lblNewLabel_3.setVisible(false);
				main_Frame.getContentPane().add(lblNewLabel_3);
		
		JButton logInButt = new JButton("Log In");
		
		logInButt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean correct = false;
				for (int i = 0; i < passList.size(); i++) {
					if (new String(passwordField.getPassword()).equals(passList.get(i)) && userNameTextField.getText().equals(userList.get(i))) {
						correct = true; break;
					}
				}
				if (correct) {
					JOptionPane.showMessageDialog(null, "Log In Succesful!");
					NewFrame.newFrame(userNameTextField.getText());
					main_Frame.dispose();
				} 
				else {
					lblNewLabel_3.setVisible(true);
				}
			}
		});
		logInButt.setForeground(new Color(255, 255, 255));
		logInButt.setBackground(new Color(34, 123, 239));
		logInButt.setBorderPainted(false);
		logInButt.setFont(new Font("Tahoma", Font.BOLD, 16));
		
	
		logInButt.setBounds(10, 154, 470, 37);
		logInPanel.add(logInButt);
	
		
		JButton newAccButt = new JButton("Create New Account");
		newAccButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount.create_Account();
			}
		});
		newAccButt.setFont(new Font("Tahoma", Font.BOLD, 11));
		newAccButt.setForeground(new Color(255, 255, 255));
		newAccButt.setBackground(new Color(66, 183, 42));
		newAccButt.setBounds(128, 267, 229, 37);
		newAccButt.setBorderPainted(false);
		logInPanel.add(newAccButt);
		
		JButton forgotAccButt = new JButton("Forgot Account? ");
		forgotAccButt.setFont(new Font("Tahoma", Font.BOLD, 11));
		forgotAccButt.setForeground(new Color(34, 123, 239));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		forgotAccButt.setBackground(new Color(0,0,0,125));
		forgotAccButt.setOpaque(false);
		forgotAccButt.setContentAreaFilled(false);
		forgotAccButt.setBorderPainted(false);
		forgotAccButt.setBorder(emptyBorder);
		forgotAccButt.setBorderPainted(false);
		forgotAccButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgotAccount.forgotAcc();
				main_Frame.dispose();
			}
		});
		forgotAccButt.setBounds(158, 202, 175, 23);
		logInPanel.add(forgotAccButt);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember me");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setBounds(10, 115, 137, 23);
		logInPanel.add(chckbxNewCheckBox);
		
		JCheckBox ShowPass = new JCheckBox("Show");
		ShowPass.setFont(new Font("Tahoma", Font.BOLD, 11));
			ShowPass.addActionListener(ae -> {
		         JCheckBox c = (JCheckBox) ae.getSource();
		         passwordField.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
		  });
			
		ShowPass.setBounds(407, 75, 57, 23);
		logInPanel.add(ShowPass);
		
		JLabel lblNewLabel = new JLabel("facebook");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 77));
		lblNewLabel.setForeground(new Color(34, 123, 239));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 45, 420, 149);
		main_Frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Connect with friends and the world ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(90, 195, 526, 27);
		main_Frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("around you on Facebook");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(90, 225, 526, 37);
		main_Frame.getContentPane().add(lblNewLabel_2);
	
		main_Frame.setVisible(true);
		
	}
		
	
	public static void main(String[] args) {
		
		main_Frame();
	
	}	
}
