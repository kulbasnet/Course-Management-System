package coursework;


import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.DbUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MarksPage extends JDialog {

private final JPanel contentPanel = new JPanel();
private JLabel studentNameLabel;
private JTextField studentNameTextField;
private JTextField moduleOneTextField;
private JTextField moduleTwoTextField;
private JTextField moduleThreeTextField;
private JTextField moduleFourTextField;
private JTextField moduleFiveTextField;
private JTextField moduleSixTextField;
private JTextField moduleSevenTextField;
private JTextField moduleEightTextField;
private JComboBox getLevelComboBox;




private JButton addMarksBtn;
private String selectedLevelFromComboBox = "";
private String studentName = "";
private String moduleOne = "";
private String moduleTwo = "";
private String moduleThree = "";
private String moduleFour = "";
private String moduleFive = "";
private String moduleSix = "";
private String moduleSeven = "";
private String moduleEight = "";

public JTextField getStudentNameTextField() {
return studentNameTextField;
}

public JTextField getModuleOneTextField() {
return moduleOneTextField;
}

public JTextField getModuleTwoTextField() {
return moduleTwoTextField;
}

public JTextField getModuleThreeTextField() {
return moduleThreeTextField;
}

public JTextField getModuleFourTextField() {
return moduleFourTextField;
}

public JTextField getModuleFiveTextField() {
return moduleFiveTextField;
}

public JTextField getModuleSixTextField() {
return moduleSixTextField;
}

public JTextField getModuleSevenTextField() {
return moduleSevenTextField;
}

public JTextField getModuleEightTextField() {
return moduleEightTextField;
}

public JButton getAddMarksBtn() {
return addMarksBtn;
}

public JComboBox getSelectedLevelFromComboBox() {
return getLevelComboBox;
}




public static void main(String[] args) {
try {
MarksPage dialog = new MarksPage();
dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
dialog.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}

public MarksPage() {
	getContentPane().setBackground(new Color(0, 64, 0));
setBounds(100, 100, 753, 431);
getContentPane().setLayout(new BorderLayout());
contentPanel.setBackground(new Color(0, 64, 0));
contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
getContentPane().add(contentPanel, BorderLayout.NORTH);
{
studentNameLabel = new JLabel("Student Name");
studentNameLabel.setForeground(new Color(255, 255, 255));
studentNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
}
JLabel levelLabel = new JLabel("Level");
levelLabel.setForeground(new Color(255, 255, 255));
levelLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
JPanel cardPanel = new JPanel();
studentNameTextField = new JTextField();
studentNameTextField.setBackground(new Color(255, 255, 255));
studentNameTextField.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 12));
studentNameTextField.setColumns(10);

getLevelComboBox = new JComboBox();
getLevelComboBox.setBackground(new Color(192, 192, 192));
getLevelComboBox.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 12));
getLevelComboBox.addItemListener(new ItemListener() {
public void itemStateChanged(ItemEvent e) {
if (e.getStateChange() == 1) {
selectedLevelFromComboBox = (String) e.getItem();
System.out.println(e.getItem());
}
}
});
getLevelComboBox.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));

addMarksBtn = new JButton("Add");
addMarksBtn.setBackground(new Color(192, 192, 192));
addMarksBtn.setFont(new Font("Times New Roman", Font.ITALIC, 14));
addMarksBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
if(e.getActionCommand().equals("Add")) {
studentName = studentNameTextField.getText().trim();
moduleOne = moduleOneTextField.getText().trim();
moduleTwo = moduleTwoTextField.getText().trim();
moduleThree = moduleThreeTextField.getText().trim();
moduleFour = moduleFourTextField.getText().trim();
moduleFive = moduleFiveTextField.getText().trim();
moduleSix = moduleSixTextField.getText().trim();
moduleSeven = moduleSevenTextField.getText().trim();
moduleEight = moduleEightTextField.getText().trim();

Statement statement = DbUtil.getStatement();

String insertQuery = "INSERT INTO `marks` (`student_id`, `Student_Name`, `Level`, `Module_1`, `Module_2`, `Module_3`, `Module_4`, `Module_5`, `Module_6`, `Module_7`, `Module_8`) "
+ "VALUES (NULL, '"+studentName+"', '"+selectedLevelFromComboBox+"', '"+moduleOne+"', '"+moduleTwo+"', '"+moduleThree+"', '"+moduleFour+"', '"+moduleFive+"', '"+moduleSix+"', '"+moduleSeven+"', '"+moduleEight+"');";

try {
int insertSuccess = statement.executeUpdate(insertQuery);
if(insertSuccess == 1) {
JOptionPane.showMessageDialog(studentNameTextField, "Saved into database");
}
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
TeacherDashBoard.getMarksDataInTableFromDb();

}
}
});
GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
gl_contentPanel.setHorizontalGroup(
	gl_contentPanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPanel.createSequentialGroup()
			.addContainerGap()
			.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(cardPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
					.addComponent(addMarksBtn, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPanel.createSequentialGroup()
						.addComponent(studentNameLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addGap(32)
						.addComponent(levelLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(getLevelComboBox, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
			.addContainerGap())
);
gl_contentPanel.setVerticalGroup(
	gl_contentPanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPanel.createSequentialGroup()
			.addContainerGap()
			.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(studentNameLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(levelLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addComponent(getLevelComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(18)
			.addComponent(addMarksBtn)
			.addGap(10)
			.addComponent(cardPanel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
			.addContainerGap())
);
cardPanel.setLayout(new CardLayout(0, 0));
{
JPanel yearOnePanel = new JPanel();
yearOnePanel.setBackground(new Color(255, 255, 128));
cardPanel.add(yearOnePanel, "name_51234653992900");

JLabel moduleOneLabel = new JLabel("Numerical Method And Concurrency");
moduleOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
moduleOneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel moduleTwoLabel = new JLabel("Concept and Tech of Artificial Intelligence");
moduleTwoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel moduleThreeLabel = new JLabel("Object Oreinted Design and Programming");
moduleThreeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel moduleFourLabel = new JLabel("Academic Skills and Team-Based Learning");
moduleFourLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel moduleFiveLabel = new JLabel("Embedded system Programming");
moduleFiveLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel moduleSixLabel = new JLabel("High Performance Computing");
moduleSixLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel moduleSevenLabel = new JLabel("Internet Software Architecture");
moduleSevenLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

JLabel moduleEightLabel = new JLabel("Cloud System Programming");
moduleEightLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

moduleOneTextField = new JTextField();
moduleOneTextField.setBackground(new Color(255, 255, 255));
moduleOneTextField.setColumns(10);

moduleTwoTextField = new JTextField();
moduleTwoTextField.setBackground(new Color(255, 255, 255));
moduleTwoTextField.setColumns(10);

moduleThreeTextField = new JTextField();
moduleThreeTextField.setBackground(new Color(255, 255, 255));
moduleThreeTextField.setColumns(10);

moduleFourTextField = new JTextField();
moduleFourTextField.setBackground(new Color(255, 255, 255));
moduleFourTextField.setColumns(10);

moduleFiveTextField = new JTextField();
moduleFiveTextField.setBackground(new Color(255, 255, 255));
moduleFiveTextField.setColumns(10);

moduleSixTextField = new JTextField();
moduleSixTextField.setBackground(new Color(255, 255, 255));
moduleSixTextField.setColumns(10);

moduleSevenTextField = new JTextField();
moduleSevenTextField.setBackground(new Color(255, 255, 255));
moduleSevenTextField.setColumns(10);

moduleEightTextField = new JTextField();
moduleEightTextField.setBackground(new Color(255, 255, 255));
moduleEightTextField.setColumns(10);
GroupLayout gl_yearOnePanel = new GroupLayout(yearOnePanel);
gl_yearOnePanel.setHorizontalGroup(
	gl_yearOnePanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_yearOnePanel.createSequentialGroup()
			.addContainerGap()
			.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.LEADING, false)
				.addComponent(moduleThreeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(moduleTwoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(moduleOneLabel, GroupLayout.PREFERRED_SIZE, 79, Short.MAX_VALUE)
				.addComponent(moduleFourLabel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(moduleOneTextField, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
				.addComponent(moduleTwoTextField, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
				.addComponent(moduleThreeTextField, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
				.addComponent(moduleFourTextField, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
			.addGap(5)
			.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_yearOnePanel.createSequentialGroup()
					.addGap(81)
					.addComponent(moduleFiveLabel, GroupLayout.PREFERRED_SIZE, 211, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED))
				.addGroup(gl_yearOnePanel.createSequentialGroup()
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(moduleSixLabel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(Alignment.LEADING, gl_yearOnePanel.createSequentialGroup()
					.addGap(82)
					.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(moduleEightLabel)
						.addComponent(moduleSevenLabel, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)))
			.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(moduleFiveTextField, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				.addComponent(moduleSevenTextField, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				.addComponent(moduleEightTextField, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
				.addComponent(moduleSixTextField, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
			.addContainerGap(18, Short.MAX_VALUE))
);
gl_yearOnePanel.setVerticalGroup(
	gl_yearOnePanel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_yearOnePanel.createSequentialGroup()
			.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_yearOnePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(moduleOneLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(moduleOneTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(moduleFiveTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_yearOnePanel.createSequentialGroup()
					.addGap(14)
					.addComponent(moduleFiveLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
			.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_yearOnePanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(moduleTwoLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(moduleTwoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(moduleSixTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_yearOnePanel.createSequentialGroup()
					.addGap(25)
					.addComponent(moduleSixLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
			.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_yearOnePanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(moduleThreeLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(moduleThreeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(moduleSevenTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_yearOnePanel.createSequentialGroup()
					.addGap(25)
					.addComponent(moduleSevenLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
			.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
			.addGroup(gl_yearOnePanel.createParallelGroup(Alignment.BASELINE)
				.addComponent(moduleFourLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				.addComponent(moduleFourTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(moduleEightTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(moduleEightLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
			.addGap(27))
);
yearOnePanel.setLayout(gl_yearOnePanel);
}
contentPanel.setLayout(gl_contentPanel);
}
}


