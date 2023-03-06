import java.awt.Color;


import javax.swing.JFrame;

public class LogIn extends mainFrame {

	public static void new_Frame() {
		JFrame newFrame = new JFrame();
		newFrame.getContentPane().setBackground(Color.WHITE);
		newFrame.setBounds(400,400,1138,670);
		newFrame.getContentPane().setLayout(null);
		newFrame.setLocationRelativeTo(null);
		newFrame.setTitle("Log In");
		newFrame.setVisible(true);
		
	}
}
