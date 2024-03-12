package coursework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import backend.DbUtil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherDashBoard {

JFrame frame;
private CardLayout cl_cardPanel = new CardLayout(0, 0);
private JPanel cardPanel;
private JPanel gradespanel;
private JTable marksTable;
private static DefaultTableModel studentDetailDefaultTableModel = new DefaultTableModel(
new Object[][] {
{null, null, null, null},
{null, null, null, null},
{null, null, null, null},
{null, null, null, null},
},
new String[] {
"Id", "Student Name", "Semester", "Level"
}
);
private static DefaultTableModel studentMarksDefaultTableModel=new DefaultTableModel(
new Object[][] {
{"", null, null, null, null, null, null, null, null, null, null},
{null, null, null, null, null, null, null, null, null, null, null},
{null, null, null, null, null, null, null, null, null, null, null},
},
new String[] {
"Student ID", "Student Name", "Level", "module1", "module2", "module 3", "module4", "module5", "module6", "module7", "module8"
});

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
private JTable studentDetailTable;
private JTable moduleAssignedTable;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
TeacherDashBoard window = new TeacherDashBoard();
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
public TeacherDashBoard() {
initialize();
}
public static void getStudentDataFromDb() {
Statement statement = DbUtil.getStatement();
String selectQuery = "SELECT * FROM `student`";

ResultSet resultSet;
try {
resultSet = statement.executeQuery(selectQuery);
studentDetailDefaultTableModel.setRowCount(0);
while(resultSet.next()) {
int studentIdFromDb = resultSet.getInt("Id");
String studentNameFromDb = resultSet.getString("Student_Name");
String semesterFromDb = resultSet.getString("Semester");
String levelFromDb = resultSet.getString("Level");

studentDetailDefaultTableModel.addRow(new Object[] {
studentIdFromDb,
studentNameFromDb,
semesterFromDb,
levelFromDb
});

}
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}
public static void getMarksDataInTableFromDb(){
Statement statement = DbUtil.getStatement();
String selectQuery = "SELECT * FROM `marks`";

ResultSet resultSet;
try {
resultSet = statement.executeQuery(selectQuery);
studentMarksDefaultTableModel.setRowCount(0);
while(resultSet.next()) {
int idFromDb = resultSet.getInt("student_id");
String nameFromDb = resultSet.getString("Student_Name");
int levelFromDb = resultSet.getInt("Level");
int Module1FromDb = resultSet.getInt("Module_1");
int Module2FromDb = resultSet.getInt("Module_2");
int Module3FromDb = resultSet.getInt("Module_3");
int Module4FromDb = resultSet.getInt("Module_4");
int Module5FromDb = resultSet.getInt("Module_5");
int Module6FromDb = resultSet.getInt("Module_6");
int Module7FromDb = resultSet.getInt("Module_7");
int Module8FromDb = resultSet.getInt("Module_8");

studentMarksDefaultTableModel.addRow(new Object[] {
idFromDb,
nameFromDb,
levelFromDb,
Module1FromDb,
Module2FromDb,
Module3FromDb,
Module4FromDb,
Module5FromDb,
Module6FromDb,
Module7FromDb,
Module8FromDb

});

}
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}


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

JPanel panel_1 = new JPanel();
panel_1.setBackground(new Color(0, 64, 0));

cardPanel = new JPanel();
cardPanel.setBackground(new Color(188, 188, 188));
GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
groupLayout.setHorizontalGroup(
	groupLayout.createParallelGroup(Alignment.LEADING)
		.addGroup(groupLayout.createSequentialGroup()
			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
			.addGap(18)
			.addComponent(cardPanel, GroupLayout.PREFERRED_SIZE, 620, Short.MAX_VALUE)
			.addContainerGap())
);
groupLayout.setVerticalGroup(
	groupLayout.createParallelGroup(Alignment.LEADING)
		.addGroup(groupLayout.createSequentialGroup()
			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(cardPanel, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE))
			.addContainerGap())
);
cardPanel.setLayout(cl_cardPanel);

JPanel moduleAssignedPanel = new JPanel();
moduleAssignedPanel.setBackground(new Color(255, 255, 128));
cardPanel.add(moduleAssignedPanel, "name_2375164175100");

JPanel panel_2 = new JPanel();
panel_2.setBackground(new Color(255, 255, 255));
JLabel lblNewLabel_1 = new JLabel("Modules Assigned");
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
GroupLayout gl_moduleAssignedPanel = new GroupLayout(moduleAssignedPanel);
gl_moduleAssignedPanel.setHorizontalGroup(
	gl_moduleAssignedPanel.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_moduleAssignedPanel.createSequentialGroup()
			.addContainerGap()
			.addGroup(gl_moduleAssignedPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_moduleAssignedPanel.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_moduleAssignedPanel.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addGap(128))))
);
gl_moduleAssignedPanel.setVerticalGroup(
	gl_moduleAssignedPanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_moduleAssignedPanel.createSequentialGroup()
			.addGap(33)
			.addComponent(lblNewLabel_1)
			.addGap(45)
			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(13, Short.MAX_VALUE))
);
panel_2.setLayout(null);

JScrollPane moduleAssignedScrollPane = new JScrollPane();
moduleAssignedScrollPane.setBounds(0, 0, 600, 386);
panel_2.add(moduleAssignedScrollPane);

moduleAssignedTable = new JTable();
moduleAssignedTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
moduleAssignedTable.setModel(assignedModuleDefaultTableModel);
moduleAssignedTable.getColumnModel().getColumn(0).setPreferredWidth(98);
moduleAssignedScrollPane.setViewportView(moduleAssignedTable);
moduleAssignedPanel.setLayout(gl_moduleAssignedPanel);

JPanel studentDetailspanel = new JPanel();
studentDetailspanel.setBackground(new Color(255, 255, 255));
cardPanel.add(studentDetailspanel, "name_6771723028700");

JPanel panel_5 = new JPanel();

JScrollPane scrollPane_1 = new JScrollPane();

studentDetailTable = new JTable();
studentDetailTable.setModel(studentDetailDefaultTableModel);
scrollPane_1.setViewportView(studentDetailTable);
JLabel lblNewLabel_2 = new JLabel("Know About Students");
lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
GroupLayout gl_studentDetailspanel = new GroupLayout(studentDetailspanel);
gl_studentDetailspanel.setHorizontalGroup(
	gl_studentDetailspanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_studentDetailspanel.createSequentialGroup()
			.addGroup(gl_studentDetailspanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentDetailspanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 609, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
				.addGroup(gl_studentDetailspanel.createSequentialGroup()
					.addGap(218)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
			.addContainerGap())
);
gl_studentDetailspanel.setVerticalGroup(
	gl_studentDetailspanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_studentDetailspanel.createSequentialGroup()
			.addGap(104)
			.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		.addGroup(Alignment.TRAILING, gl_studentDetailspanel.createSequentialGroup()
			.addContainerGap(50, Short.MAX_VALUE)
			.addComponent(lblNewLabel_2)
			.addGap(47)
			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
			.addGap(71))
);
GroupLayout gl_panel_5 = new GroupLayout(panel_5);
gl_panel_5.setHorizontalGroup(
	gl_panel_5.createParallelGroup(Alignment.LEADING)
		.addGap(0, 600, Short.MAX_VALUE)
);
gl_panel_5.setVerticalGroup(
	gl_panel_5.createParallelGroup(Alignment.LEADING)
		.addGap(0, 417, Short.MAX_VALUE)
);
panel_5.setLayout(gl_panel_5);
studentDetailspanel.setLayout(gl_studentDetailspanel);

gradespanel = new JPanel();
gradespanel.setBackground(new Color(255, 255, 255));
cardPanel.add(gradespanel, "name_654778417627200");
gradespanel.setLayout(null);

JPanel panel_4 = new JPanel();
panel_4.setBackground(new Color(255, 255, 255));
panel_4.setBounds(10, 92, 623, 426);
gradespanel.add(panel_4);

JScrollPane studentScrollPane = new JScrollPane();

JButton addButton = new JButton("Add");
addButton.setBackground(new Color(192, 192, 192));
addButton.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 12));
addButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
MarksPage markspage=new MarksPage();
markspage.setVisible(true);
}
});
GroupLayout gl_panel_4 = new GroupLayout(panel_4);
gl_panel_4.setHorizontalGroup(
	gl_panel_4.createParallelGroup(Alignment.TRAILING)
		.addGroup(Alignment.LEADING, gl_panel_4.createSequentialGroup()
			.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_4.createSequentialGroup()
					.addGap(509)
					.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				.addComponent(studentScrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE))
			.addContainerGap(20, Short.MAX_VALUE))
);
gl_panel_4.setVerticalGroup(
	gl_panel_4.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel_4.createSequentialGroup()
			.addComponent(studentScrollPane, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(addButton)
			.addContainerGap(35, Short.MAX_VALUE))
);

marksTable = new JTable();
marksTable.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
String studentId=marksTable.getValueAt(marksTable.getSelectedRow(),0).toString();
Object[] options = { "Update Marks", "Delete Marks" };

int n = JOptionPane.showOptionDialog(null,
"Do you want to update or delete marks?",
" Update or Delete marks", JOptionPane.DEFAULT_OPTION,
JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
if(n == 0) {
MarksPage updateMarksPage=new MarksPage();
updateMarksPage.setVisible(true);
updateMarksPage.setTitle("Update Marks Page");

JButton updateBtn = updateMarksPage.getAddMarksBtn();
updateBtn.setText("Update");


String name="";
String selectedLevelFromComboBox="";
String module1="";
String module2="";
String module3="";
String module4="";
String module5="";
String module6="";
String module7="";
String module8="";

for(int columnIndex = 1; columnIndex < marksTable.getColumnCount(); columnIndex++) {
if(name.isEmpty()) {
name = marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
} else if(selectedLevelFromComboBox.isEmpty()){
selectedLevelFromComboBox = marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
} else if(module1.isEmpty()){
module1 = marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
} else if(module2.isEmpty()) {
module2= marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
}
else if(module3.isEmpty()) {
module3= marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
}
else if(module4.isEmpty()) {
module4= marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
}
else if(module5.isEmpty()) {
module5= marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
}
else if(module6.isEmpty()) {
module6= marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
}
else if(module7.isEmpty()) {
module7= marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
}
else if(module8.isEmpty()) {
module8= marksTable.getValueAt(marksTable.getSelectedRow(), columnIndex).toString();
}

}
updateMarksPage.getStudentNameTextField().setText(name);

updateMarksPage.getModuleOneTextField().setText(module1);
updateMarksPage.getModuleTwoTextField().setText(module2);
updateMarksPage.getModuleThreeTextField().setText(module3);
updateMarksPage.getModuleFourTextField().setText(module4);
updateMarksPage.getModuleFiveTextField().setText(module5);
updateMarksPage.getModuleSixTextField().setText(module6);
updateMarksPage.getModuleSevenTextField().setText(module7);
updateMarksPage.getModuleEightTextField().setText(module8);



JComboBox levelComboBox = updateMarksPage.getSelectedLevelFromComboBox();
ComboBoxModel model = levelComboBox.getModel();

for(int i = 0; i <= 2; i++) {
if(model.getElementAt(i).equals(selectedLevelFromComboBox)) {
model.setSelectedItem(model.getElementAt(i));
break;
}
}
updateBtn.setActionCommand("Update");
updateBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JTextField studentNameTextField=updateMarksPage.getStudentNameTextField();
JTextField moduleOne=updateMarksPage.getModuleOneTextField();
JTextField moduleTwo=updateMarksPage.getModuleTwoTextField();
JTextField moduleThree=updateMarksPage.getModuleThreeTextField();
JTextField moduleFour=updateMarksPage.getModuleFourTextField();
JTextField moduleFive=updateMarksPage.getModuleFiveTextField();
JTextField moduleSix=updateMarksPage.getModuleSixTextField();
JTextField moduleSeven=updateMarksPage.getModuleSevenTextField();
JTextField moduleEight=updateMarksPage.getModuleEightTextField();


JComboBox levelTextField=updateMarksPage.getSelectedLevelFromComboBox();



String updatedStudentName=studentNameTextField.getText().trim();
String updatedModuleOne=moduleOne.getText().trim();
String updatedModuleTwo=moduleTwo.getText().trim();
String updatedModuleThree=moduleThree.getText().trim();
String updatedModuleFour=moduleFour.getText().trim();
String updatedModuleFive=moduleFive.getText().trim();
String updatedModuleSix=moduleSix.getText().trim();
String updatedModuleSeven=moduleSeven.getText().trim();
String updatedModuleEight=moduleEight.getText().trim();

ComboBoxModel comboBoxModel = levelComboBox.getModel();
Object selectedItem = comboBoxModel.getSelectedItem();
String updatedSelectedLevel = selectedItem.toString();


String updatedQuery = "UPDATE `marks` SET `Student_Name` = '"+updatedStudentName+"',"
+ " `Level` = '"+updatedSelectedLevel+"', `Module_1` = '"+updatedModuleOne+"', `Module_2` = '"+updatedModuleTwo+"', `Module_3` = '"+updatedModuleThree+"', "
+ "`Module_4` = '"+updatedModuleFour+"', `Module_5` = '"+updatedModuleFive+"', `Module_6` = '"+updatedModuleSix+"', `Module_7` = '"+updatedModuleSeven+"', "
+ "`Module_8` = '"+updatedModuleEight+" 'WHERE `marks`.`student_id`="+studentId+";";
Statement statement=DbUtil.getStatement();

try {
int updateSuccess = statement.executeUpdate(updatedQuery);
if(updateSuccess == 1) {
JOptionPane.showMessageDialog(studentScrollPane, "Data is Updated");
} else {
JOptionPane.showMessageDialog(studentScrollPane, "Something went wrong while updating");
}

} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
TeacherDashBoard.getMarksDataInTableFromDb();
}
});
} else if (n==1) {
Statement statement=DbUtil.getStatement();
String deleteQuery="Delete FROM marks WHERE `marks`.`student_id`="+studentId+" ";
try {
int deleteSuccess=statement.executeUpdate(deleteQuery);
if(deleteSuccess==1) {
JOptionPane.showMessageDialog(studentScrollPane, "DELETED!!!");
}else {
JOptionPane.showMessageDialog(studentScrollPane, "Something went wrong!!!");

}
}catch(SQLException e1) {
e1.printStackTrace();
}
TeacherDashBoard.getMarksDataInTableFromDb();
}




}
});
marksTable.setModel(studentMarksDefaultTableModel);
studentScrollPane.setViewportView(marksTable);
panel_4.setLayout(gl_panel_4);
JLabel lblNewLabel_3 = new JLabel("Students Performance");
lblNewLabel_3.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
lblNewLabel_3.setBounds(249, 38, 170, 20);
gradespanel.add(lblNewLabel_3);


JButton studentDetailButton = new JButton("Student Details");
studentDetailButton.setBackground(new Color(240, 240, 240));
studentDetailButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
studentDetailButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
cl_cardPanel.show(cardPanel, "name_6771723028700");
}
});

JButton moduleAssigendButton = new JButton("Module Assigned");
moduleAssigendButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
moduleAssigendButton.setBackground(new Color(240, 240, 240));
moduleAssigendButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
cl_cardPanel.show(cardPanel, "name_2375164175100");
}
});

JButton gradesButton = new JButton("Grades");
gradesButton.setBackground(new Color(240, 240, 240));
gradesButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
gradesButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
cl_cardPanel.show(cardPanel, "name_654778417627200");
}
});

JLabel welcomeAdminLabel = new JLabel("Course Managment");
welcomeAdminLabel.setForeground(new Color(255, 255, 128));
welcomeAdminLabel.setBackground(new Color(192, 192, 192));
welcomeAdminLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 20));
welcomeAdminLabel.setHorizontalAlignment(SwingConstants.CENTER);

JButton btnNewButton = new JButton("Logout");
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
new LoginPage();
frame.setVisible(false);


}
});
btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
JLabel lblNewLabel = new JLabel("DASHBOARD");
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
GroupLayout gl_panel_1 = new GroupLayout(panel_1);
gl_panel_1.setHorizontalGroup(
	gl_panel_1.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_panel_1.createSequentialGroup()
			.addContainerGap()
			.addComponent(welcomeAdminLabel, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
			.addGap(14))
		.addGroup(gl_panel_1.createSequentialGroup()
			.addGap(49)
			.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
				.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
				.addComponent(gradesButton, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
				.addComponent(studentDetailButton, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
				.addComponent(moduleAssigendButton, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
			.addGap(45))
);
gl_panel_1.setVerticalGroup(
	gl_panel_1.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel_1.createSequentialGroup()
			.addGap(36)
			.addComponent(welcomeAdminLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
			.addGap(39)
			.addComponent(lblNewLabel)
			.addGap(68)
			.addComponent(moduleAssigendButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addGap(18)
			.addComponent(studentDetailButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addGap(18)
			.addComponent(gradesButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addGap(73)
			.addComponent(btnNewButton)
			.addGap(141))
);
panel_1.setLayout(gl_panel_1);
frame.getContentPane().setLayout(groupLayout);

TeacherDashBoard.getMarksDataInTableFromDb();
TeacherDashBoard.getStudentDataFromDb();
      TeacherDashBoard.getAssignedModuleDataFromDb();


}
}
