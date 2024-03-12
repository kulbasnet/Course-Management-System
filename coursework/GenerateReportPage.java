package coursework;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import backend.DbUtil;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;

public class GenerateReportPage extends JDialog {
private final JPanel contentPanel = new JPanel();
private JTextField studentIdTextField;
private String studentName = "";
private String level = "";
private double avg;
private int module_1;
private int module_2;
private int module_3;
private int module_4;
private int module_5;
private int module_6;
private int module_7;
private int module_8;
public static void main(String[] args) {
try {
GenerateReportPage dialog = new GenerateReportPage();
dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
dialog.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}

}
public GenerateReportPage() {
setBounds(100, 100, 670, 631);
getContentPane().setLayout(new BorderLayout());
contentPanel.setBackground(new Color(0, 64, 0));
contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
getContentPane().add(contentPanel, BorderLayout.CENTER);
studentIdTextField = new JTextField();
studentIdTextField.setColumns(10);
JPanel panel = new JPanel();
panel.setBackground(new Color(255, 255, 128));
JLabel studentIdLabel = new JLabel("Please Enter Your Student Id");
studentIdLabel.setForeground(new Color(255, 255, 255));
studentIdLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
JLabel studentNameLabel = new JLabel("Student Name");
studentNameLabel.setForeground(new Color(0, 0, 0));
studentNameLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
studentNameLabel.setBounds(68, 93, 104, 14);
panel.add(studentNameLabel);
JLabel studentLevelLabel = new JLabel("Level");
studentLevelLabel.setForeground(new Color(0, 0, 0));
studentLevelLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
studentLevelLabel.setBounds(71, 121, 80, 14);
panel.add(studentLevelLabel);
JLabel moduleOneLabel = new JLabel("Numerical Method And Concurrency");
moduleOneLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleOneLabel.setBounds(78, 202, 226, 21);
panel.add(moduleOneLabel);


JLabel moduletwoLabel = new JLabel("Concept and Tech of Artificial Intelligence");
moduletwoLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduletwoLabel.setBounds(79, 229, 254, 22);
panel.add(moduletwoLabel);
JLabel moduleThreeLabel = new JLabel("Object Oreinted Design and Programming");
moduleThreeLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleThreeLabel.setBounds(76, 255, 254, 28);
panel.add(moduleThreeLabel);

JLabel moduleFourLabel = new JLabel("Academic Skills and Team-Based Learning");
moduleFourLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleFourLabel.setBounds(75, 285, 254, 22);
panel.add(moduleFourLabel);

JLabel moduleFiveLabel = new JLabel("Embedded system Programming");
moduleFiveLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleFiveLabel.setBounds(78, 317, 202, 21);
panel.add(moduleFiveLabel);

JLabel moduleSixLabel = new JLabel("High Performance Computing");
moduleSixLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleSixLabel.setBounds(75, 351, 190, 19);
panel.add(moduleSixLabel);

JLabel moduleSevenLabel = new JLabel("Internet Software Architecture");
moduleSevenLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleSevenLabel.setBounds(74, 384, 195, 18);
panel.add(moduleSevenLabel);
JLabel moduleEightLabel = new JLabel("Cloud System Programming");

moduleEightLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleEightLabel.setBounds(70, 409, 173, 22);
panel.add(moduleEightLabel);

JLabel overAllMarksLabel = new JLabel("Average");
overAllMarksLabel.setForeground(new Color(0, 0, 0));
overAllMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
overAllMarksLabel.setBounds(411, 93, 62, 14);
panel.add(overAllMarksLabel);

JLabel gradeOverAllLabel = new JLabel("Grade");
gradeOverAllLabel.setForeground(new Color(0, 0, 0));
gradeOverAllLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
gradeOverAllLabel.setBounds(411, 115, 73, 14);
panel.add(gradeOverAllLabel);

JLabel nameLabel = new JLabel("KulBhushsn Basnet");
nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
nameLabel.setBounds(191, 90, 177, 20);
panel.add(nameLabel);

JLabel levelLabel = new JLabel("5");
levelLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 15));
levelLabel.setBounds(192, 120, 46, 14);
panel.add(levelLabel);

JLabel moduleOneMarksLabel = new JLabel("23");
moduleOneMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleOneMarksLabel.setBounds(354, 200, 46, 14);
panel.add(moduleOneMarksLabel);

JLabel moduleTwoMarksLabel = new JLabel("44");
moduleTwoMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleTwoMarksLabel.setBounds(353, 227, 46, 14);
panel.add(moduleTwoMarksLabel);

JLabel moduleThreeMarksLabel = new JLabel("56");
moduleThreeMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleThreeMarksLabel.setBounds(356, 258, 20, 14);
panel.add(moduleThreeMarksLabel);

JLabel moduleFourMarksLabel = new JLabel("43");
moduleFourMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleFourMarksLabel.setBounds(354, 291, 46, 14);
panel.add(moduleFourMarksLabel);

JLabel moduleFiveMarksLabel = new JLabel("33");
moduleFiveMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleFiveMarksLabel.setBounds(353, 326, 46, 14);
panel.add(moduleFiveMarksLabel);
JLabel moduleSixMarksLabel = new JLabel("76");

moduleSixMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleSixMarksLabel.setBounds(355, 355, 46, 14);
panel.add(moduleSixMarksLabel);

JLabel moduleSevenMarksLabel = new JLabel("67");
moduleSevenMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleSevenMarksLabel.setBounds(357, 389, 46, 14);
panel.add(moduleSevenMarksLabel);

JLabel moduleEightMarksLabel = new JLabel("87");
moduleEightMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
moduleEightMarksLabel.setBounds(357, 415, 46, 14);
panel.add(moduleEightMarksLabel);

JLabel averageMarksLabel = new JLabel("89");
averageMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 15));
averageMarksLabel.setBounds(498, 88, 46, 14);
panel.add(averageMarksLabel);

JLabel gradeMarksLabel = new JLabel("D");
gradeMarksLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 15));
gradeMarksLabel.setBounds(494, 117, 46, 14);
panel.add(gradeMarksLabel);

JButton genearteReportBtn = new JButton("Generate Report");
genearteReportBtn.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
genearteReportBtn.setBackground(new Color(192, 192, 192));

genearteReportBtn.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {
String studentId = studentIdTextField.getText().trim();
String selectQuery = "SELECT Student_Name, Level, Module_1, Module_2, Module_3, Module_4, Module_5, Module_6, Module_7, Module_8 FROM marks"
+ " WHERE student_Id = "+studentId+" ";
Statement statement = DbUtil.getStatement();

try {
ResultSet resultSet = statement.executeQuery(selectQuery);

while(resultSet.next()) {

studentName = resultSet.getString("Student_Name");
level = resultSet.getString("Level");
module_1 = resultSet.getInt("Module_1");
module_2 = resultSet.getInt("Module_2");
module_3 = resultSet.getInt("Module_3");
module_4 = resultSet.getInt("Module_4");
module_5 = resultSet.getInt("Module_5");
module_6 = resultSet.getInt("Module_6");
module_7 = resultSet.getInt("Module_7");
module_8 = resultSet.getInt("Module_8");
}

} catch (SQLException e1) {

// TODO Auto-generated catch block

e1.printStackTrace();

}

avg = (module_1 + module_2 + module_3 + module_4 + module_5 + module_6 + module_7 + module_8)/ 8;
String studentName_1 = studentName;
String level_1 = level;
String moduleOneMarks = String.valueOf(module_1);
String moduleTwoMarks = String.valueOf(module_2);
String moduleThreeMarks = String.valueOf(module_3);
String moduleFourMarks = String.valueOf(module_4);
String moduleFiveMarks = String.valueOf(module_5);
String moduleSixMarks = String.valueOf(module_6);
String moduleSevenMarks = String.valueOf(module_7);
String moduleEightMarks = String.valueOf(module_8);
String avgValue = String.valueOf(avg);
String gradeRemarks = "";

nameLabel.setText(studentName_1);
levelLabel.setText(level_1);
moduleOneMarksLabel.setText(moduleOneMarks);
moduleTwoMarksLabel.setText(moduleTwoMarks);
moduleThreeMarksLabel.setText(moduleThreeMarks);
moduleFourMarksLabel.setText(moduleFourMarks);
moduleFiveMarksLabel.setText(moduleFiveMarks);
moduleSixMarksLabel.setText(moduleSixMarks);
moduleSevenMarksLabel.setText(moduleSevenMarks);
moduleEightMarksLabel.setText(moduleEightMarks);
averageMarksLabel.setText(avgValue);

if(avg < 40) {
gradeRemarks = "Fail";
} else if(avg >= 40 && avg < 50) {

gradeRemarks = "D";

} else if(avg >= 50 && avg < 60) {
gradeRemarks = "C";

} else if(avg >= 60 && avg < 70) {
gradeRemarks = "B+";

} else if (avg >= 70 && avg < 90) {
gradeRemarks = "A";

} else if(avg >= 90) {
gradeRemarks = "A+";

}

gradeMarksLabel.setText(gradeRemarks);
}

});

GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
gl_contentPanel.setHorizontalGroup(
	gl_contentPanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPanel.createSequentialGroup()
			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(18)
					.addComponent(studentIdLabel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(studentIdTextField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(485, Short.MAX_VALUE)
					.addComponent(genearteReportBtn)))
			.addContainerGap())
);
gl_contentPanel.setVerticalGroup(
	gl_contentPanel.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_contentPanel.createSequentialGroup()
			.addGap(25)
			.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentIdLabel)
						.addComponent(studentIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(genearteReportBtn)
					.addPreferredGap(ComponentPlacement.RELATED)))
			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
			.addGap(33))
);

panel.setLayout(null);
JLabel lblNewLabel_1 = new JLabel("REPORT CARD");
lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
lblNewLabel_1.setBounds(259, 34, 124, 21);
panel.add(lblNewLabel_1);
JLabel lblNewLabel = new JLabel("Module Name");
lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 12));
lblNewLabel.setBounds(80, 169, 103, 13);
panel.add(lblNewLabel);
JLabel lblNewLabel_2 = new JLabel("Score");
lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 12));
lblNewLabel_2.setBounds(341, 170, 53, 13);
panel.add(lblNewLabel_2);

contentPanel.setLayout(gl_contentPanel);

}
}