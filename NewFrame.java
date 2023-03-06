import java.awt.Color;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;


public class NewFrame extends mainFrame{
		public static JFrame newFrame = new JFrame();
		public static JFrame discountFrame = new JFrame();
		
		private static String[] courses = {"Tourism", "Computer Science", "Engineering", "Nursing", "Architecture"};
		private static String[] discountType = {"Discounted(Gold)", "Discounted(Blue)", "Discounted(White)", "Walk-In", "Continuing"};
		private static JTextField IDNumber;
		private static JTextField firstName;
		private static JTextField lastName;
		private static JTextField yearLevel;
		
		
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void newFrame(String username) {
		newFrame.getContentPane().setBackground(new Color(255, 255, 255));
		newFrame.getContentPane().setForeground(Color.LIGHT_GRAY);
		newFrame.setBounds(400,400,325,419);
		newFrame.setLocationRelativeTo(null);
		newFrame.setTitle("Log In Sucess");
		newFrame.setVisible(true);
		newFrame.getContentPane().setLayout(null);
		newFrame.setResizable(true);
		
		JLabel lblSuccess = new JLabel("Welcome " + username + "!");
		lblSuccess.setBounds(67, 58, 148, 14);
		lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		newFrame.getContentPane().add(lblSuccess);
		
		JLabel lblNewLabel = new JLabel("ENROLLMENT PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(60, 11, 177, 36);
		newFrame.getContentPane().add(lblNewLabel);
		
		JComboBox<String> coursesArr = new JComboBox<String>();
		coursesArr.setBounds(23, 161, 111, 20);
		for (int i = 0; i < courses.length; i++) {
			coursesArr.addItem(courses[i]);
		}
		newFrame.getContentPane().add(coursesArr);
		
		JLabel lblNewLabel_1 = new JLabel("Courses");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(23, 139, 116, 14);
		newFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdNumber.setBounds(22, 192, 72, 14);
		newFrame.getContentPane().add(lblIdNumber);
		
		IDNumber = new JTextField();
		IDNumber.setText("ex.(2022-103266)");
		IDNumber.setBounds(23, 217, 111, 20);
		newFrame.getContentPane().add(IDNumber);
		IDNumber.setColumns(10);
		
		IDNumber.addFocusListener((FocusListener) new FocusListener() {
			 public void focusGained(FocusEvent e) {
		        	IDNumber.setText("");
		        	IDNumber.setForeground(Color.BLACK);
		        
		    }
			 public void focusLost(FocusEvent e) {
				  
			 	
			 }
	    });
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(23, 108, 113, 20);
		newFrame.getContentPane().add(firstName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(23, 83, 72, 14);
		newFrame.getContentPane().add(lblFirstName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(166, 108, 123, 20);
		newFrame.getContentPane().add(lastName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setBounds(165, 83, 72, 14);
		newFrame.getContentPane().add(lblLastName);
		
		JLabel lblIdNumber_4_1 = new JLabel("Student Type");
		lblIdNumber_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdNumber_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdNumber_4_1.setBounds(165, 139, 93, 14);
		newFrame.getContentPane().add(lblIdNumber_4_1);
		
		JComboBox<String> studentTypeArr = new JComboBox<String>();
		studentTypeArr.setBounds(166, 160, 123, 22);
		for (int i = 0; i < discountType.length; i++) {
			studentTypeArr.addItem(discountType[i]);
		}
		newFrame.getContentPane().add(studentTypeArr);
		
		yearLevel = new JTextField();
		yearLevel.setText("ex.(1st Year... etc)");
		yearLevel.addFocusListener((FocusListener) new FocusListener() {
			 public void focusGained(FocusEvent e) {
				 yearLevel.setText("");
				 yearLevel.setForeground(Color.BLACK);
		    }
			 public void focusLost(FocusEvent e) {
		        
		    
			 }
		        
		    });
		yearLevel.setColumns(10);
		yearLevel.setBounds(167, 217, 111, 20);
		newFrame.getContentPane().add(yearLevel);
		
		JLabel lblIdNumber_4_3 = new JLabel("Year Level");
		lblIdNumber_4_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblIdNumber_4_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdNumber_4_3.setBounds(165, 192, 72, 14);
		newFrame.getContentPane().add(lblIdNumber_4_3);
		
		JButton btnNewButton = new JButton("Enroll");
		btnNewButton.setBackground(new Color(34, 123, 239));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewFrame myFrame = new NewFrame();
				NewFrame.Student myStudent = myFrame.new Student(IDNumber.getText(), firstName.getText(), lastName.getText(), 
						studentTypeArr.getSelectedItem().toString(), coursesArr.getSelectedItem().toString(), yearLevel.getText());
			}
		});
		btnNewButton.setBounds(57, 282, 201, 49);
		newFrame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Out");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainFrame.main_Frame();
				newFrame.dispose();
			}
		});
		btnNewButton_1.setBounds(57, 342, 201, 23);
		newFrame.getContentPane().add(btnNewButton_1);
		
		
		
	}
	
	public static void discountFrame (String IDNumber, String firstName, String lastName, String studentType, String courseName, String yearLevel, double total) {
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);
		
		discountFrame.getContentPane().setBackground(new Color(255,255,255,125));
		discountFrame.setBounds(400,400,300,400);
		discountFrame.setLocationRelativeTo(null);
		discountFrame.setTitle("Discounts");
		discountFrame.setVisible(true);
		discountFrame.getContentPane().setLayout(null);
		discountFrame.setResizable(true);
		
		JLabel Receipt = new JLabel("Receipt");
		Receipt.setBounds(85, 23, 200, 14);
		discountFrame.getContentPane().add(Receipt);
		
		
		JLabel lblNewLabel = new JLabel("ID Number: " + IDNumber);
		lblNewLabel.setBounds(10, 53, 200, 14);
		discountFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name: " + firstName);
		lblFirstName.setBounds(10, 78, 200, 14);
		discountFrame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name: " + lastName);
		lblLastName.setBounds(10, 103, 200, 14);
		discountFrame.getContentPane().add(lblLastName);
		
		JLabel lblCourse = new JLabel("Course: " + courseName);
		lblCourse.setBounds(10, 128, 200, 14);
		discountFrame.getContentPane().add(lblCourse);
		
		JLabel lblStudentType = new JLabel("Student Type: " + studentType);
		lblStudentType.setBounds(10, 153, 200, 14);
		discountFrame.getContentPane().add(lblStudentType);
		
		JLabel lblYearLevel = new JLabel("Year Level: " + yearLevel);
		lblYearLevel.setBounds(10, 178, 200, 14);
		discountFrame.getContentPane().add(lblYearLevel);
		
		JLabel lblTotalFee = new JLabel("Tution Fee (Computation): Php " + myFormat.format(total));
		lblTotalFee.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalFee.setBounds(10, 190, 500, 38);
		discountFrame.getContentPane().add(lblTotalFee);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBounds(85, 227, 89, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "You have Successfully Enrolled!");
				discountFrame.dispose();
				newFrame.dispose();
			}
		});
		discountFrame.getContentPane().add(btnNewButton);
	}
	
	public class Student {
		String IDNumber, firstName, lastName, studentType, courseName, yearLevel;
		int tuition, miscellaneous;
		String[][] courseTuitions = {{"Tourism", "10000", "22500"}, {"Computer Science", "20000", "11000"}, 
				 					 {"Engineering", "30000", "25000"}, {"Nursing", "15000", "15000"},
				 					 {"Architecture", "25000", "23000"}};
		String[][] discounts = {{"Discounted(Gold)", ".5"}, {"Discounted(Blue)", ".7"}, {"Discounted(White)", ".9"}, 
								{"Continuing", null}, {"Walk-In", ".9"}};
		double total;
		
		public Student (String IDNumber, String firstName, String lastName, String studentType, String courseName, String yearLevel) {
			this.IDNumber = IDNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.studentType = studentType;
			this.courseName = courseName;
			this.yearLevel = yearLevel;
			
			for (String[] string : courseTuitions) {
				if (this.courseName == string[0]) {
					tuition = Integer.parseInt(string[1]);
					miscellaneous = Integer.parseInt(string[2]);
				}
			}
			
			for (String[] string : discounts) {
				if (string[0] == "Continuing") total = tuition + miscellaneous;
				else if (string[0] == "Walk-In") total = (tuition * Double.parseDouble(string[1])) + miscellaneous;
				else {
					if (this.studentType == string[0]) total = (tuition + miscellaneous) * Double.parseDouble(string[1]); break;
				}
			}
			
			discountFrame(this.IDNumber, this.firstName, this.lastName, this.studentType, this.courseName, this.yearLevel, this.total);
		}
		
	}
}