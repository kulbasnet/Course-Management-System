package coursework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import backend.DbUtil;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class CourseForm extends JDialog {

private final JPanel contentPanel;
private JTextField courseNameTextField;
private JTextField noOfModulesTextField;
private JTextField lengthTextField;
private JButton addCourseBtn;
private JCheckBox isActivatedCheckBox;

private String courseName = "";
private String noOfModules = "";
private String isActivated = "NO";
private String length = "";
private JLabel lblNewLabel;


public JCheckBox getIsActivatedCheckBox() {
return isActivatedCheckBox;
}

public JTextField getCourseNameTextField() {
return courseNameTextField;
}

public JTextField getNoOfModulesTextField() {
return noOfModulesTextField;
}

public JTextField getLengthTextField() {
return lengthTextField;
}

public JButton getAddCourseBtn() {
return addCourseBtn;
}


public CourseForm() {
setBounds(100, 100, 413, 394);
contentPanel = new JPanel();
contentPanel.setBackground(new Color(0, 64, 0));
setContentPane(contentPanel);

JLabel courseNameLabel = new JLabel("Course Name");
courseNameLabel.setForeground(new Color(255, 255, 255));
courseNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel noOfModulesLabel = new JLabel("No. Of Modules");
noOfModulesLabel.setForeground(new Color(255, 255, 255));
noOfModulesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel lengthLabel = new JLabel("Length");
lengthLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lengthLabel.setForeground(new Color(255, 255, 255));

isActivatedCheckBox = new JCheckBox("Activated");
isActivatedCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
isActivatedCheckBox.setBackground(new Color(192, 192, 192));

courseNameTextField = new JTextField();
courseNameTextField.setBackground(new Color(255, 255, 255));
courseNameTextField.setColumns(10);

noOfModulesTextField = new JTextField();
noOfModulesTextField.setBackground(new Color(255, 255, 255));
noOfModulesTextField.setColumns(10);

lengthTextField = new JTextField();
lengthTextField.setBackground(new Color(255, 255, 255));
lengthTextField.setColumns(10);

addCourseBtn = new JButton("Add");
addCourseBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
addCourseBtn.setBackground(new Color(192, 192, 192));
addCourseBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

if(e.getActionCommand().equals("Add")) {
courseName = courseNameTextField.getText().trim();
noOfModules = noOfModulesTextField.getText().trim();
length = lengthTextField.getText().trim();


if(isActivatedCheckBox.isSelected()) {
isActivated = "YES";
} else {
isActivated = "NO";
}

Statement statement = DbUtil.getStatement();

String insertQuery = "INSERT INTO course (Course_Id, Course_Name, No_Of_Modules, Active_Status, Length)"
+ " VALUES (NULL, '"+courseName+"', '"+noOfModules+"', '"+isActivated+"', '"+length+"');";

try {
int insertSuccess = statement.executeUpdate(insertQuery);
if(insertSuccess == 1) {
JOptionPane.showMessageDialog(lengthTextField, "Saved into database");
}
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
AdminDashBoard.getCourseDataFromDb();

}

}
});
lblNewLabel = new JLabel("New Course");
lblNewLabel.setForeground(new Color(255, 255, 128));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));


GroupLayout groupLayout = new GroupLayout(getContentPane());
groupLayout.setHorizontalGroup(
	groupLayout.createParallelGroup(Alignment.LEADING)
		.addGroup(groupLayout.createSequentialGroup()
			.addGap(27)
			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(courseNameLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				.addComponent(noOfModulesLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lengthLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
			.addGap(31)
			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lengthTextField, 183, 183, 183)
				.addComponent(noOfModulesTextField, 183, 183, 183)
				.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(isActivatedCheckBox)))
			.addContainerGap(27, GroupLayout.PREFERRED_SIZE))
		.addGroup(groupLayout.createSequentialGroup()
			.addGap(88)
			.addComponent(addCourseBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addGap(118))
		.addGroup(groupLayout.createSequentialGroup()
			.addGap(105)
			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(117, Short.MAX_VALUE))
);
groupLayout.setVerticalGroup(
	groupLayout.createParallelGroup(Alignment.LEADING)
		.addGroup(groupLayout.createSequentialGroup()
			.addGap(24)
			.addComponent(lblNewLabel)
			.addGap(18)
			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(courseNameLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(noOfModulesLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addComponent(noOfModulesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
				.addComponent(lengthLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
				.addComponent(lengthTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(18)
			.addComponent(isActivatedCheckBox)
			.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
			.addComponent(addCourseBtn)
			.addGap(28))
);
getContentPane().setLayout(groupLayout);
contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));


}


}
