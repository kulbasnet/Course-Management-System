package coursework;
import backend.DbUtil;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class UserRegistration {

JFrame frame;
private JTextField fullNameTextField;
private JTextField passwordTextField;
private JTextField userNameTextField;
private JRadioButton maleRadioBtn;
private JRadioButton femaleRadioBtn;
private JComboBox selectUserTypeComboBox;
private JComboBox selectCourseComboBox;
private JButton addBtn;
private final ButtonGroup buttonGroup = new ButtonGroup();
private String fullName = "";
private String gender = "";
private String userName = "";
private String password = "";
private String selectedCourseFromComboBox = "";
private String SelectedUserTypeFromComboBox = "";
private JLabel lblNewLabel;


/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
UserRegistration window = new UserRegistration();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public UserRegistration() {
initialize();
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(new Color(0, 64, 0));
frame.setTitle("User Registration");
frame.setBounds(100, 100, 587, 538);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel NameLabrl = new JLabel("Full Name");
NameLabrl.setForeground(new Color(255, 255, 255));
NameLabrl.setFont(new Font("Times New Roman", Font.PLAIN, 14));

JLabel genderLabel = new JLabel("Gender");
genderLabel.setForeground(new Color(255, 255, 255));
genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel selectCourseLabel = new JLabel("Select Course");
selectCourseLabel.setForeground(new Color(255, 255, 255));
selectCourseLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

fullNameTextField = new JTextField();
fullNameTextField.setBackground(new Color(255, 255, 255));
fullNameTextField.setColumns(10);

maleRadioBtn = new JRadioButton("Male");
maleRadioBtn.setBackground(new Color(192, 192, 192));
buttonGroup.add(maleRadioBtn);

femaleRadioBtn = new JRadioButton("Female");
femaleRadioBtn.setBackground(new Color(192, 192, 192));
buttonGroup.add(femaleRadioBtn);

selectCourseComboBox = new JComboBox();
selectCourseComboBox.setBackground(new Color(192, 192, 192));
selectCourseComboBox.addItemListener(new ItemListener() {
public void itemStateChanged(ItemEvent e) {
if (e.getStateChange() == 1) {
selectedCourseFromComboBox = (String) e.getItem();
System.out.println(e.getItem());
}
}
});
selectCourseComboBox.setModel(new DefaultComboBoxModel(new String[] {"BIBM", "BIT"}));

JLabel userNameLabel = new JLabel("User Name");
userNameLabel.setForeground(new Color(255, 255, 255));
userNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel passwordLabel = new JLabel("Password");
passwordLabel.setForeground(new Color(255, 255, 255));
passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

passwordTextField = new JTextField();
passwordTextField.setBackground(new Color(255, 255, 255));
passwordTextField.setColumns(10);

userNameTextField = new JTextField();
userNameTextField.setBackground(new Color(255, 255, 255));
userNameTextField.setColumns(10);

JLabel selectUserTypeLabel = new JLabel("User Type");
selectUserTypeLabel.setForeground(new Color(255, 255, 255));
selectUserTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

selectUserTypeComboBox = new JComboBox();
selectUserTypeComboBox.setBackground(new Color(192, 192, 192));
selectUserTypeComboBox.addItemListener(new ItemListener() {
public void itemStateChanged(ItemEvent e) {
if (e.getStateChange() == 1) {
SelectedUserTypeFromComboBox = (String) e.getItem();
System.out.println(e.getItem());
}
}
});
selectUserTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Teacher", "Admin"}));

addBtn = new JButton("Add");
addBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
addBtn.setBackground(new Color(192, 192, 192));
addBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
fullName = fullNameTextField.getText().trim();
userName = userNameTextField.getText().trim();
password = passwordTextField.getText().trim();

for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
AbstractButton button = buttons.nextElement();

if(button.isSelected()) {
gender = button.getText();
}
}

Statement statement = DbUtil.getStatement();
String insertQuery = "INSERT INTO users (User_ID, FullName, Sex, Username, Password, Course, User_Type) "
+ "VALUES (NULL, '"+fullName+"', '"+gender+"', '"+userName+"', '"+password+"', '"+selectedCourseFromComboBox+"', '"+SelectedUserTypeFromComboBox+"')";

try {
int insertSuccess = statement.executeUpdate(insertQuery);
if (insertSuccess == 1) {
JOptionPane.showMessageDialog(fullNameTextField, "Saved into database");
}
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}


}
});
lblNewLabel = new JLabel("HERALD COLLEGE KATHMANDU");
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setForeground(new Color(255, 255, 128));
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
JRadioButton rdbtnOthers = new JRadioButton("Others");
rdbtnOthers.setBackground(Color.LIGHT_GRAY);
GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
groupLayout.setHorizontalGroup(
	groupLayout.createParallelGroup(Alignment.LEADING)
		.addGroup(groupLayout.createSequentialGroup()
			.addGap(275)
			.addComponent(addBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(290, Short.MAX_VALUE))
		.addGroup(groupLayout.createSequentialGroup()
			.addGap(127)
			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(101, Short.MAX_VALUE))
		.addGroup(groupLayout.createSequentialGroup()
			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(genderLabel, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(NameLabrl, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(selectUserTypeComboBox, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(87)
					.addComponent(selectUserTypeLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(fullNameTextField, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
						.addComponent(passwordTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
						.addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(maleRadioBtn)
							.addGap(39)
							.addComponent(femaleRadioBtn)
							.addGap(31)
							.addComponent(rdbtnOthers)
							.addGap(77))
						.addComponent(selectCourseComboBox, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
					.addGap(61))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(selectCourseLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(108))))
);
groupLayout.setVerticalGroup(
	groupLayout.createParallelGroup(Alignment.LEADING)
		.addGroup(groupLayout.createSequentialGroup()
			.addGap(25)
			.addComponent(lblNewLabel)
			.addGap(39)
			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(NameLabrl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				.addComponent(fullNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(29)
			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(rdbtnOthers)
				.addComponent(femaleRadioBtn)
				.addComponent(maleRadioBtn)
				.addComponent(genderLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
			.addGap(43)
			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(90))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(selectUserTypeLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(selectCourseLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)))
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(selectUserTypeComboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(addBtn))
				.addComponent(selectCourseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(28))
);
frame.getContentPane().setLayout(groupLayout);
}
}