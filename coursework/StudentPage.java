package coursework;
import backend.DbUtil;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StudentPage extends JDialog {

private final JPanel contentPanel = new JPanel();
private JLabel studentNameLabel;
private JTextField studentNameTextField;
private JTextField studentSemesterTextField;
private JTextField studentLevelTextField;
private String studentName;
private String level;
private String semester;
private JButton studentAddBtn;
private JLabel lblNewLabel;

/**
* @return
*/
public JTextField getStudentNameTextField() {
return studentNameTextField;
}

public JTextField getStudentSemesterTextField() {
return studentSemesterTextField;
}

public JTextField getStudentLevelTextField() {
return studentLevelTextField;
}


public JButton getStudentAddBtn() {
return studentAddBtn;
}

public static void main(String[] args) {
try {
StudentPage dialog = new StudentPage();
dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
dialog.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}

public StudentPage() {
setBounds(100, 100, 417, 345);
getContentPane().setLayout(new BorderLayout());
contentPanel.setBackground(new Color(0, 64, 0));
contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
getContentPane().add(contentPanel, BorderLayout.CENTER);
{
studentNameLabel = new JLabel("Name");
studentNameLabel.setForeground(new Color(255, 255, 255));
studentNameLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
}
JLabel semesterLabel = new JLabel("Semester");
semesterLabel.setForeground(new Color(255, 255, 255));
semesterLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
JLabel levelLabel = new JLabel("Level");
levelLabel.setForeground(new Color(255, 255, 255));
levelLabel.setFont(new Font("Times New Roman", Font.ITALIC, 14));

studentNameTextField = new JTextField();
studentNameTextField.setBackground(new Color(255, 255, 255));
studentNameTextField.setColumns(10);

studentSemesterTextField = new JTextField();
studentSemesterTextField.setBackground(new Color(255, 255, 255));
studentSemesterTextField.setColumns(10);

studentLevelTextField = new JTextField();
studentLevelTextField.setBackground(new Color(255, 255, 255));
studentLevelTextField.setColumns(10);

studentAddBtn = new JButton("Add");
studentAddBtn.setBackground(new Color(192, 192, 192));
studentAddBtn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
studentAddBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

if(e.getActionCommand().equals("Add")) {
studentName = studentNameTextField.getText().trim();
semester = studentSemesterTextField.getText().trim();
level = studentLevelTextField.getText().trim();


Statement statement = DbUtil.getStatement();

String insertQuery = "INSERT INTO student (Id, Student_Name, Semester, Level) "
+ "VALUES (NULL, '"+studentName+"', '"+semester+"', '"+level+"');";

try {
int insertSuccess = statement.executeUpdate(insertQuery);
if(insertSuccess == 1) {
JOptionPane.showMessageDialog(studentNameTextField, "Saved into database");
}
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
AdminDashBoard.getStudentDataFromDb();

}

}
});
lblNewLabel = new JLabel("Add New Student");
lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
lblNewLabel.setForeground(new Color(255, 255, 128));
lblNewLabel.setBackground(new Color(240, 240, 240));
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));

GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
gl_contentPanel.setHorizontalGroup(
	gl_contentPanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPanel.createSequentialGroup()
			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(semesterLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(levelLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(studentNameLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
					.addGap(101)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(studentSemesterTextField)
							.addGap(2))
						.addComponent(studentNameTextField, Alignment.TRAILING)
						.addComponent(studentLevelTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
					.addGap(17))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(173)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentAddBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
);
gl_contentPanel.setVerticalGroup(
	gl_contentPanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPanel.createSequentialGroup()
			.addGap(29)
			.addComponent(lblNewLabel)
			.addGap(33)
			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(studentNameLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
				.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(18)
			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(levelLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
				.addComponent(studentLevelTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(20)
			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(semesterLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
				.addComponent(studentSemesterTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
			.addComponent(studentAddBtn)
			.addGap(24))
);
contentPanel.setLayout(gl_contentPanel);
}

}