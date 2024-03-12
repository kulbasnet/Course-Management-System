package coursework;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.DbUtil;
import javax.swing.JTextPane;

public class StudentDashBoard {

JFrame frame;
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
private CardLayout cl_cardPanel = new CardLayout(0, 0);
private JPanel cardPanel;
private JTable viewTeacherstable;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
StudentDashBoard window = new StudentDashBoard();
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
public StudentDashBoard() {
initialize();
}

public StudentDashBoard(String uname) {
welcomeLabel.setText("Welcome"+uname);
initialize();
}
private static DefaultTableModel assignedModuleDefaultTableModel=new DefaultTableModel(
new Object[][] {
{null, null, null, null, null},
{null, null, null, null, null},
{null, null, null, null, null},
},
new String[] {
"Teacher_Name", "Module_1", "Module_2", "Module_3", "Module_4"
}
);
private JLabel welcomeLabel;
private JTextField studentIdTextField;


public static void getAssignedModuleDataFromDb() {
Statement statement = DbUtil.getStatement();
String selectQuery = "SELECT * FROM `assigned_modules`";

ResultSet resultSet;
try {
resultSet = statement.executeQuery(selectQuery);
assignedModuleDefaultTableModel.setRowCount(0);
while(resultSet.next()) {
String teacherNameFromDb = resultSet.getString("Teacher_Name");
String module1FromDb= resultSet.getString("Module_1");
String module2FromDb= resultSet.getString("Module_2");
String module3FromDb= resultSet.getString("Module_3");
String module4FromDb= resultSet.getString("Module_4");

assignedModuleDefaultTableModel.addRow(new Object[] {
teacherNameFromDb,
module1FromDb,
module2FromDb,
module3FromDb,
module4FromDb
});

}
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}
/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(new Color(255, 255, 255));
frame.setBounds(100, 100, 901, 579);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

JPanel panel_1 = new JPanel();
panel_1.setBackground(new Color(0, 64, 0));

cardPanel = new JPanel();
cardPanel.setBackground(new Color(188, 188, 188));
GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
groupLayout.setHorizontalGroup(
	groupLayout.createParallelGroup(Alignment.LEADING)
		.addGroup(groupLayout.createSequentialGroup()
			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
			.addGap(34)
			.addComponent(cardPanel, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
			.addContainerGap())
);
groupLayout.setVerticalGroup(
	groupLayout.createParallelGroup(Alignment.TRAILING)
		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(cardPanel, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
			.addContainerGap())
		.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
);
cardPanel.setLayout(cl_cardPanel);

JPanel coursepanel = new JPanel();
coursepanel.setBackground(new Color(0, 64, 0));
cardPanel.add(coursepanel, "name_2375164175100");
JLabel lblNewLabel_1 = new JLabel("MODULES INFO");
lblNewLabel_1.setForeground(new Color(255, 255, 128));
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
JPanel modulepanel = new JPanel();
modulepanel.setBackground(new Color(255, 255, 128));
modulepanel.setLayout(null);
GroupLayout gl_coursepanel = new GroupLayout(coursepanel);
gl_coursepanel.setHorizontalGroup(
	gl_coursepanel.createParallelGroup(Alignment.TRAILING)
		.addGroup(Alignment.LEADING, gl_coursepanel.createSequentialGroup()
			.addGap(110)
			.addGroup(gl_coursepanel.createParallelGroup(Alignment.TRAILING, false)
				.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(modulepanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
			.addContainerGap(61, Short.MAX_VALUE))
);
gl_coursepanel.setVerticalGroup(
	gl_coursepanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_coursepanel.createSequentialGroup()
			.addGap(47)
			.addComponent(lblNewLabel_1)
			.addGap(33)
			.addComponent(modulepanel, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(96, Short.MAX_VALUE))
);

JButton btnNewButton = new JButton("BIT");
btnNewButton.setBounds(91, 46, 72, 27);
modulepanel.add(btnNewButton);
btnNewButton.setBackground(new Color(192, 192, 192));
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
BitPage bitPage=new BitPage();
bitPage.setVisible(true);
}
});
btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JButton btnNewButton_1 = new JButton("BIBM");
btnNewButton_1.setBounds(240, 48, 72, 23);
modulepanel.add(btnNewButton_1);
btnNewButton_1.setBackground(new Color(192, 192, 192));
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
BibmPage bibmPage=new BibmPage();
bibmPage.setVisible(true);
}
});
btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
JLabel lblNewLabel_3 = new JLabel("BBA");
lblNewLabel_3.setBounds(91, 154, 76, 27);
modulepanel.add(lblNewLabel_3);
lblNewLabel_3.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
JLabel lblNewLabel_2 = new JLabel("CSIT");
lblNewLabel_2.setBounds(177, 150, 53, 34);
modulepanel.add(lblNewLabel_2);
lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
JLabel lblNewLabel_4 = new JLabel("MBA");
lblNewLabel_4.setBounds(283, 158, 45, 18);
modulepanel.add(lblNewLabel_4);
lblNewLabel_4.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
JLabel lblNewLabel_5 = new JLabel("BBA,CSIT and MBA are currently not available.");
lblNewLabel_5.setBounds(47, 246, 335, 18);
modulepanel.add(lblNewLabel_5);
lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 16));
coursepanel.setLayout(gl_coursepanel);

JPanel ViewTeachers = new JPanel();
ViewTeachers.setBackground(new Color(255, 255, 255));
cardPanel.add(ViewTeachers, "name_654778417627200");
ViewTeachers.setLayout(null);

JScrollPane viewTeachersscrollPane = new JScrollPane();
viewTeachersscrollPane.setBounds(0, 81, 584, 379);
ViewTeachers.add(viewTeachersscrollPane);

viewTeacherstable = new JTable();
viewTeacherstable.setModel(assignedModuleDefaultTableModel);
viewTeacherstable.getColumnModel().getColumn(0).setPreferredWidth(103);
viewTeachersscrollPane.setViewportView(viewTeacherstable);
JLabel lblNewLabel_6 = new JLabel(" Know About Teachers ");
lblNewLabel_6.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
lblNewLabel_6.setBounds(235, 39, 163, 13);
ViewTeachers.add(lblNewLabel_6);

JPanel gradespanel = new JPanel();
gradespanel.setBackground(new Color(255, 255, 255));
cardPanel.add(gradespanel, "name_654836395527700");
gradespanel.setLayout(null);

JPanel panel_6 = new JPanel();
panel_6.setBounds(3, 129, 562, 371);
gradespanel.add(panel_6);
panel_6.setLayout(null);

JLabel StudentNameLabel = new JLabel("Student Name");
StudentNameLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 12));
StudentNameLabel.setBounds(23, 23, 91, 13);
panel_6.add(StudentNameLabel);

JLabel studentLevelLabel = new JLabel("Level");
studentLevelLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 12));
studentLevelLabel.setBounds(23, 46, 82, 25);
panel_6.add(studentLevelLabel);

JLabel moduleOneLabel = new JLabel("Numerical Method And Concurrency");
moduleOneLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleOneLabel.setBounds(99, 128, 199, 13);
panel_6.add(moduleOneLabel);

JLabel moduleTwoLabel = new JLabel("Concept and Tech of Artificial Intelligence");
moduleTwoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleTwoLabel.setBounds(98, 152, 234, 13);
panel_6.add(moduleTwoLabel);

JLabel moduleThreeLabel = new JLabel("Object Oreinted Design and Programming");
moduleThreeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleThreeLabel.setBounds(99, 178, 244, 13);
panel_6.add(moduleThreeLabel);

JLabel moduleFourLabel = new JLabel("Academic Skills and Team-Based Learning");
moduleFourLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleFourLabel.setBounds(99, 205, 234, 13);
panel_6.add(moduleFourLabel);

JLabel moduleFiveLabel = new JLabel("Embedded system Programming");
moduleFiveLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleFiveLabel.setBounds(98, 228, 216, 13);
panel_6.add(moduleFiveLabel);

JLabel moduleSixLabel = new JLabel("High Performance Computing");
moduleSixLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleSixLabel.setBounds(101, 259, 207, 13);
panel_6.add(moduleSixLabel);

JLabel moduleSevenLabel = new JLabel("Internet Software Architecture");
moduleSevenLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleSevenLabel.setBounds(97, 288, 228, 13);
panel_6.add(moduleSevenLabel);

JLabel moduleEightLabel = new JLabel("Cloud System Programming");
moduleEightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleEightLabel.setBounds(100, 316, 192, 13);
panel_6.add(moduleEightLabel);

JLabel nameLabel = new JLabel(".");
nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
nameLabel.setBounds(153, 22, 82, 13);
panel_6.add(nameLabel);

JLabel levelLabel = new JLabel(".");
levelLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
levelLabel.setBounds(153, 51, 82, 13);
panel_6.add(levelLabel);

JLabel moduleOneMarksLabel = new JLabel("..");
moduleOneMarksLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleOneMarksLabel.setBounds(381, 125, 82, 13);
panel_6.add(moduleOneMarksLabel);

JLabel moduleTwoMarksLabel = new JLabel("..");
moduleTwoMarksLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleTwoMarksLabel.setBounds(379, 150, 82, 13);
panel_6.add(moduleTwoMarksLabel);

JLabel moduleThreeMarksLabel = new JLabel("..");
moduleThreeMarksLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleThreeMarksLabel.setBounds(380, 178, 82, 13);
panel_6.add(moduleThreeMarksLabel);

JLabel moduleFourMarksLabel = new JLabel("..");
moduleFourMarksLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleFourMarksLabel.setBounds(383, 206, 82, 13);
panel_6.add(moduleFourMarksLabel);

JLabel moduleFiveMarksLabel = new JLabel("..");
moduleFiveMarksLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleFiveMarksLabel.setBounds(382, 240, 82, 13);
panel_6.add(moduleFiveMarksLabel);

JLabel moduleSixMarksLabel = new JLabel("..");
moduleSixMarksLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleSixMarksLabel.setBounds(385, 272, 82, 13);
panel_6.add(moduleSixMarksLabel);

JLabel moduleSevenMarksLabel = new JLabel("..");
moduleSevenMarksLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleSevenMarksLabel.setBounds(384, 297, 82, 13);
panel_6.add(moduleSevenMarksLabel);

JLabel moduleEightMarksLabel = new JLabel("..");
moduleEightMarksLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
moduleEightMarksLabel.setBounds(383, 322, 82, 13);
panel_6.add(moduleEightMarksLabel);
JLabel lblNewLabel_8 = new JLabel("Module Name");
lblNewLabel_8.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 12));
lblNewLabel_8.setBounds(99, 85, 99, 13);
panel_6.add(lblNewLabel_8);
JLabel lblNewLabel_9 = new JLabel("Score");
lblNewLabel_9.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 12));
lblNewLabel_9.setBounds(364, 85, 45, 13);
panel_6.add(lblNewLabel_9);

JLabel studentIdLabel = new JLabel("Student Id");
studentIdLabel.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
studentIdLabel.setBounds(10, 72, 82, 24);
gradespanel.add(studentIdLabel);

studentIdTextField = new JTextField();
studentIdTextField.setBounds(102, 76, 72, 19);
gradespanel.add(studentIdTextField);
studentIdTextField.setColumns(10);

JButton checkButton = new JButton("Check ");
checkButton.setBackground(new Color(255, 255, 255));
checkButton.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 13));
checkButton.addActionListener(new ActionListener() {
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
}
});
checkButton.setBounds(467, 75, 95, 21);
gradespanel.add(checkButton);
JLabel lblNewLabel_7 = new JLabel("Check Grades");
lblNewLabel_7.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
lblNewLabel_7.setBounds(238, 24, 107, 24);
gradespanel.add(lblNewLabel_7);


JButton assignmentsBtn = new JButton("Logout");
assignmentsBtn.setBackground(new Color(192, 192, 192));
assignmentsBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
assignmentsBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {


new LoginPage();
frame.setVisible(false);

}
});

JButton modulesButton = new JButton("Modules");
modulesButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
modulesButton.setBackground(new Color(192, 192, 192));
modulesButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
cl_cardPanel.show(cardPanel, "name_2375164175100");
}
});

JButton gradesBtn =  new JButton("Grades");
gradesBtn.setBackground(new Color(192, 192, 192));
gradesBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
gradesBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
cl_cardPanel.show(cardPanel, "name_654836395527700");
}
});

welcomeLabel = new JLabel("Course Managment");
welcomeLabel.setForeground(new Color(255, 255, 128));
welcomeLabel.setBackground(new Color(192, 192, 192));
welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

JButton btnNewButton_2 = new JButton("View Teachers");
btnNewButton_2.setBackground(new Color(192, 192, 192));
btnNewButton_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
cl_cardPanel.show(cardPanel, "name_654778417627200");

}
});
btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
JLabel lblNewLabel = new JLabel("DASHBOARD");
lblNewLabel.setForeground(new Color(255, 255, 128));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
GroupLayout gl_panel_1 = new GroupLayout(panel_1);
gl_panel_1.setHorizontalGroup(
	gl_panel_1.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_panel_1.createSequentialGroup()
			.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(assignmentsBtn, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(modulesButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
						.addComponent(gradesBtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))))
			.addGap(52))
		.addGroup(gl_panel_1.createSequentialGroup()
			.addGap(35)
			.addComponent(welcomeLabel, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
			.addGap(36))
);
gl_panel_1.setVerticalGroup(
	gl_panel_1.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel_1.createSequentialGroup()
			.addGap(37)
			.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
			.addGap(55)
			.addComponent(lblNewLabel)
			.addGap(26)
			.addComponent(modulesButton)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(btnNewButton_2)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(gradesBtn, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
			.addGap(101)
			.addComponent(assignmentsBtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(131, Short.MAX_VALUE))
);
panel_1.setLayout(gl_panel_1);
frame.getContentPane().setLayout(groupLayout);
StudentDashBoard.getAssignedModuleDataFromDb();
}
}