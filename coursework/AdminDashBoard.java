package coursework;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import backend.DbUtil;
import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminDashBoard{

	JFrame frame;
	private CardLayout cl_cardPanel = new CardLayout(0, 0);
	private JPanel cardPanel;
	private JTable teacherTable;
	private static DefaultTableModel tutorDefaultTableModel = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
},
			new String[] {
					"ID", "Name", "Phone Number", "Address", "Sex", "Module Assigned", "Date Of Birth", "Full Time"
});

	private static DefaultTableModel courseDefaultTableModel = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
},
			new String[] {
					"Course ID", "Course Name", "No. Of Modules", "Active Status", "Length"
});

	private static DefaultTableModel studentDefaultTableModel = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
					"Id", "Student_Name", "Semester", "Level"
});

	private JTable table;
	private JTable courseTable;
	private JTable studentTable;
	private JLabel welcomeLabel;

/**
* Launch the application.
*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashBoard window = new AdminDashBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/**
* Create the application.
* @throws SQLException
*/
	public AdminDashBoard()  {
		initialize();
	}

	public AdminDashBoard(String uname)  {
		initialize();
		welcomeLabel.setText("Welcome"+uname);
}

	public static void getTutorDataInTableFromDb(){
		Statement statement = DbUtil.getStatement();
		String selectQuery = "SELECT * FROM `tutor`";
		
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(selectQuery);
			tutorDefaultTableModel.setRowCount(0);
			while(resultSet.next()) {
				int idFromDb = resultSet.getInt("Id");
				String nameFromDb = resultSet.getString("Name");
				BigDecimal numberFromDb = resultSet.getBigDecimal("Phone_Number");
				String addressFromDb = resultSet.getString("Address");
				String sexFromDb = resultSet.getString("Sex");
				String moduleAssignedFromDb = resultSet.getString("Module_Assigned");
				Date dateOfBirthFromDb = resultSet.getDate("Date_Of_Birth");
				String fullTimeFromDb = resultSet.getString("Full_Time");
				
				tutorDefaultTableModel.addRow(new Object[] {
						idFromDb,
						nameFromDb,
						numberFromDb,
						addressFromDb,
						sexFromDb,
						moduleAssignedFromDb,
						dateOfBirthFromDb,
						fullTimeFromDb
				});

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getCourseDataFromDb() {
		Statement statement = DbUtil.getStatement();
		String selectQuery = "SELECT * FROM `course`";

		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(selectQuery);
			courseDefaultTableModel.setRowCount(0);
			while(resultSet.next()) {
				int courseIdFromDb = resultSet.getInt("Course_Id");
				String courseNameFromDb = resultSet.getString("Course_Name");
				int noOfModulesFromDb = resultSet.getInt("No_Of_Modules");
				String activeStatusFromDb = resultSet.getString("Active_Status");
				int lengthFromDb = resultSet.getInt("Length");

				courseDefaultTableModel.addRow(new Object[] {
						courseIdFromDb,
						courseNameFromDb,
						noOfModulesFromDb,
						activeStatusFromDb,
						lengthFromDb
				});

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

	public static void getStudentDataFromDb() {
		Statement statement = DbUtil.getStatement();
		String selectQuery = "SELECT * FROM `student`";

		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(selectQuery);
			studentDefaultTableModel.setRowCount(0);
			while(resultSet.next()) {
				int studentIdFromDb = resultSet.getInt("Id");
				String studentNameFromDb = resultSet.getString("Student_Name");
				String semesterFromDb = resultSet.getString("Semester");
				String levelFromDb = resultSet.getString("Level");

				studentDefaultTableModel.addRow(new Object[] {
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



/**
* Initialize the contents of the frame.
* @throws SQLException
*/
private void initialize(){
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 912, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 64, 0));

		cardPanel = new JPanel();
		cardPanel.setBackground(new Color(188, 188, 188));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
		.addGroup(groupLayout.createSequentialGroup()
			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(cardPanel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
			.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
		.addGroup(groupLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(cardPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addContainerGap())
		.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
);
		cardPanel.setLayout(cl_cardPanel);
		
		JPanel coursePanel = new JPanel();
		coursePanel.setBackground(new Color(255, 255, 128));
		cardPanel.add(coursePanel, "name_3194150471600");
		
		JScrollPane courseScrollPane = new JScrollPane();



		JButton addCourseBtn = new JButton("Add Course");
		addCourseBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		addCourseBtn.setBackground(new Color(192, 192, 192));
		addCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseForm addNewCourse = new CourseForm();
				addNewCourse.setVisible(true);
			}
		});
		JLabel lblNewLabel = new JLabel("COURSES INFO");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		GroupLayout gl_coursePanel = new GroupLayout(coursePanel);
		gl_coursePanel.setHorizontalGroup(
			gl_coursePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_coursePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(courseScrollPane, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
				.addGroup(gl_coursePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(addCourseBtn, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addGap(489))
				.addGroup(gl_coursePanel.createSequentialGroup()
					.addGap(223)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(246, Short.MAX_VALUE))
		);
		gl_coursePanel.setVerticalGroup(
			gl_coursePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_coursePanel.createSequentialGroup()
					.addGap(16)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(courseScrollPane, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(addCourseBtn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(85, Short.MAX_VALUE))
		);

			courseTable = new JTable();
			courseTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					String courseId = courseTable.getValueAt(courseTable.getSelectedRow(), 0).toString();
					String courseName = courseTable.getValueAt(courseTable.getSelectedRow(), 1).toString();
					
					Object[] options = { "Update Course", "Delete Course"};
					int n = JOptionPane.showOptionDialog(null,
							"Do you want to update or deactivate or delete course?",
							" Update ot Deactivate or Delete Course", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					
					if(n == 0) { //update

						CourseForm updateCoursePage = new CourseForm();
						updateCoursePage.setVisible(true);
						updateCoursePage.setTitle("Update Course Page");

						JButton updateBtn = updateCoursePage.getAddCourseBtn();
						updateBtn.setText("Update");

						String name = "";
						String noOfModules = "";
						String isActive = "";
						String length = "";
						
						for(int columnIndex = 1; columnIndex < courseTable.getColumnCount(); columnIndex++) {
							if(name.isEmpty()) {
								name = courseTable.getValueAt(courseTable.getSelectedRow(), columnIndex).toString();
							} else if(noOfModules.isEmpty()){
								noOfModules = courseTable.getValueAt(courseTable.getSelectedRow(), columnIndex).toString();
							} else if(isActive.isEmpty()){
								isActive = courseTable.getValueAt(courseTable.getSelectedRow(), columnIndex).toString();
							} else if(length.isEmpty()) {
								length = courseTable.getValueAt(courseTable.getSelectedRow(), columnIndex).toString();
}
}
						updateCoursePage.getCourseNameTextField().setText(name);
						updateCoursePage.getNoOfModulesTextField().setText(noOfModules);
						updateCoursePage.getLengthTextField().setText(length);

						JCheckBox isActiveCheckBox = updateCoursePage.getIsActivatedCheckBox();
						if(isActive.equals("YES")) {
							isActiveCheckBox.setSelected(true);
						} else if(isActive.equals("NO")) {
							isActiveCheckBox.setSelected(false);
}

		updateBtn.setActionCommand("Update");
			updateBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Update")) {
				JTextField courseNameTextField = updateCoursePage.getCourseNameTextField();
				JTextField noOfModulesTextField = updateCoursePage.getNoOfModulesTextField();
				JTextField lengthTextField = updateCoursePage.getLengthTextField();
				JCheckBox isActiveCheckBox1 = updateCoursePage.getIsActivatedCheckBox();
				String oldCourseName = (String)courseTable.getValueAt(courseTable.getSelectedRow(), 1);
				
				String updatedCourseName = courseNameTextField.getText().trim();
				String updatedNoOfModules = noOfModulesTextField.getText().trim();
				String updatedLength = lengthTextField.getText().trim();
				String updatedIsActive = "NO";
		
		
				if(isActiveCheckBox.isSelected()) {
					updatedIsActive = "YES";
				} else {
					updatedIsActive = "NO";
				}
		
				String updateQuery = "UPDATE `course` SET "
						+ "`Course_Name` = '"+updatedCourseName+"', `No_Of_Modules` = '"+updatedNoOfModules+"', "
						+ "`Active_Status` = '"+updatedIsActive+"', `Length` = '"+updatedLength+"'"
						+ " WHERE `course`.`Course_Id` = "+courseId+"";
		
		
				Statement statement = DbUtil.getStatement();
				try {
					int updateSuccess = statement.executeUpdate(updateQuery);
					if(updateSuccess == 1) {
						JOptionPane.showMessageDialog(courseNameTextField, "Data is Updated");
					} else {
						JOptionPane.showMessageDialog(courseNameTextField, "Something went wrong while updating");
		}
		
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				AdminDashBoard.getCourseDataFromDb(); // refersh JTable
		
				System.out.println("Update button is working");
			}
			}
		
			}
		);
		
					}else if(n == 2) { // delete course
						
						String deleteModuleQuery = "DELETE FROM module "
								+ "WHERE `module`.`Course_Name` = '"+courseName +"'";
						String deleteCourseQuery = "DELETE FROM course "
								+ "WHERE `course`.`Course_Id` = '"+courseId+"'";
		
						Statement statement = DbUtil.getStatement();
						try {
							statement.executeUpdate(deleteModuleQuery);
							statement.executeUpdate(deleteCourseQuery);
							JOptionPane.showMessageDialog(courseScrollPane, "Successfully deleted course and its realted modules as well from Database!");
						} catch (SQLException e1) {
							e1.printStackTrace();
		}
		
						AdminDashBoard.getCourseDataFromDb();
		}
		}
		});
		
			courseTable.setModel(courseDefaultTableModel);
			courseTable.getColumnModel().getColumn(0).setPreferredWidth(64);
			courseTable.getColumnModel().getColumn(1).setPreferredWidth(96);
			courseTable.getColumnModel().getColumn(2).setPreferredWidth(88);
			courseTable.getColumnModel().getColumn(3).setPreferredWidth(80);
			courseScrollPane.setViewportView(courseTable);
			coursePanel.setLayout(gl_coursePanel);
		
			JPanel studentPanel = new JPanel();
			studentPanel.setBackground(new Color(255, 255, 255));
			cardPanel.add(studentPanel, "name_6771723028700");
		
			JScrollPane studentScrollPane = new JScrollPane();
		
			JButton addStudentBtn = new JButton("Add Student");
		addStudentBtn.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 12));
		addStudentBtn.setBackground(new Color(192, 192, 192));
		addStudentBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		StudentPage studentPage = new StudentPage();
		studentPage.setVisible(true);
		}
		});
		JLabel lblNewLabel_1 = new JLabel("STUDENTS INFO");
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
		GroupLayout gl_studentPanel = new GroupLayout(studentPanel);
		gl_studentPanel.setHorizontalGroup(
			gl_studentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_studentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_studentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_studentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(addStudentBtn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addComponent(studentScrollPane, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_studentPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(243))))
		);
		gl_studentPanel.setVerticalGroup(
			gl_studentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_studentPanel.createSequentialGroup()
					.addGap(15)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(studentScrollPane, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addStudentBtn, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(86))
		);
		
		studentTable = new JTable();
		studentTable.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		String studentId = studentTable.getValueAt(studentTable.getSelectedRow(), 0).toString();
		
		Object[] options = { "Update Student", "Delete Student" };
		int n = JOptionPane.showOptionDialog(null,
		"Do you want to update student?",
		"Delete Student", JOptionPane.DEFAULT_OPTION,
		JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		
		if(n == 0) { //update
		
		StudentPage updateStudentPage = new StudentPage();
		updateStudentPage.setVisible(true);
		updateStudentPage.setTitle("Update Student Page");
		
		JButton updateBtn = updateStudentPage.getStudentAddBtn();
		updateBtn.setText("Update");
		
		String name = "";
		String semester = "";
		String level = "";
		
		for(int columnIndex = 1; columnIndex < studentTable.getColumnCount(); columnIndex++) {
		if(name.isEmpty()) {
		name = studentTable.getValueAt(studentTable.getSelectedRow(), columnIndex).toString();
		} else if(semester.isEmpty()){
		semester = studentTable.getValueAt(studentTable.getSelectedRow(), columnIndex).toString();
		} else if(level.isEmpty()){
		level = studentTable.getValueAt(studentTable.getSelectedRow(), columnIndex).toString();
		}
		}
		
		// System.out.println("name" +name);
		// System.out.println("modules" +noOfModules);
		// System.out.println("active" +isActive);
		// System.out.println("length" +length);
		
		updateStudentPage.getStudentNameTextField().setText(name);
		updateStudentPage.getStudentSemesterTextField().setText(semester);
		updateStudentPage.getStudentLevelTextField().setText(level);
		
		updateBtn.setActionCommand("Update");
		updateBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Update")) {
		JTextField studentNameTextField = updateStudentPage.getStudentNameTextField();
		JTextField studentSemesterTextField = updateStudentPage.getStudentSemesterTextField();
		JTextField studentLevelTextField = updateStudentPage.getStudentLevelTextField();
		
		String updatedStudentName = studentNameTextField.getText().trim();
		String updatedSemester = studentSemesterTextField.getText().trim();
		String updatedLevel = studentLevelTextField.getText().trim();
		
		String updateQuery = "UPDATE `student` SET "
		+ "`Student_Name` = '"+updatedStudentName+"', "
		+ "`Semester` = '"+updatedSemester+"', `Level` = '"+updatedLevel+"'"
		+ " WHERE `student`.`Id` = "+studentId+"";
		
		
		Statement statement = DbUtil.getStatement();
		try {
		int updateSuccess = statement.executeUpdate(updateQuery);
		if(updateSuccess == 1) {
		JOptionPane.showMessageDialog(studentNameTextField, "Data is Updated");
		} else {
		JOptionPane.showMessageDialog(studentNameTextField, "Something went wrong while updating");
		}
		
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		AdminDashBoard.getStudentDataFromDb();
		
		System.out.println("Update button is working");
		}
		}
		
		}
		);
		
		
		} else if(n == 1) {
		Statement statement = DbUtil.getStatement();
		
		String deleteQuery =  "DELETE FROM student WHERE `student`.`Id` = "+studentId+" ";
		try {
		int deleteSuccess = statement.executeUpdate(deleteQuery);
		if(deleteSuccess == 1) {
		JOptionPane.showMessageDialog(studentScrollPane, "Deleted!!!");
		} else {
		JOptionPane.showMessageDialog(studentScrollPane, "Something went wrong");
		}
		} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		
		AdminDashBoard.getStudentDataFromDb();
		
		}
		
		}
		});
		studentTable.setModel(studentDefaultTableModel);
		studentTable.getColumnModel().getColumn(1).setPreferredWidth(101);
		studentScrollPane.setViewportView(studentTable);
		studentPanel.setLayout(gl_studentPanel);
		
		JPanel teacherPanel = new JPanel();
		teacherPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(teacherPanel, "name_245905159712600");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton addTutorBtn = new JButton("Add Tutor");
		addTutorBtn.setBackground(new Color(192, 192, 192));
		addTutorBtn.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 12));
		addTutorBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		TutorPage addTutorPage = new TutorPage();
		addTutorPage.setVisible(true);
		}
		});
		JLabel lblNewLabel_2 = new JLabel("TEACHERS INFO");
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 15));
		GroupLayout gl_teacherPanel = new GroupLayout(teacherPanel);
		gl_teacherPanel.setHorizontalGroup(
			gl_teacherPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
				.addGroup(gl_teacherPanel.createSequentialGroup()
					.addContainerGap(513, Short.MAX_VALUE)
					.addComponent(addTutorBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_teacherPanel.createSequentialGroup()
					.addContainerGap(260, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(237))
		);
		gl_teacherPanel.setVerticalGroup(
			gl_teacherPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_teacherPanel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addTutorBtn)
					.addGap(85))
		);
		
		teacherTable = new JTable();
		teacherTable.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
			System.out.println("row selected");
			System.out.println(teacherTable.getSelectedRow());
		
			Object[] options = {"Update", "Delete"};
			int n = JOptionPane.showOptionDialog(null, "Do you want to Update or Delete?", "Update or Delete teacher"
					,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); // showOptionDialog returns 0 if update is selected and returns 1 if delete is selected
			if(n == 0) { //update
				TutorPage updateTutorPage = new TutorPage();
				updateTutorPage.setVisible(true);
				updateTutorPage.setTitle("Update Tutor Form");
		
				JButton updateBtn = updateTutorPage.getAddBtn();
				updateBtn.setText("Update");
		
				String name = "";
				String phoneNumber = "";
				String address = "";
				String sex = "";
				String isFullTime = "NO";
				String selectedModuleFromComboBox = "";
				String dateOfBirth = "";
				int selectedRowNo = teacherTable.getSelectedRow();
				
				for(int columnIndex = 1; columnIndex < teacherTable.getColumnCount(); columnIndex++) {
					if(name.isEmpty()) {
						name = teacherTable.getValueAt(teacherTable.getSelectedRow(), columnIndex).toString();
					} else if(phoneNumber.isEmpty()){
						phoneNumber = teacherTable.getValueAt(teacherTable.getSelectedRow(), columnIndex).toString();
					} else if(address.isEmpty()){
						address = teacherTable.getValueAt(teacherTable.getSelectedRow(), columnIndex).toString();
					} else if(sex.isEmpty()){
						sex = (String)teacherTable.getValueAt(teacherTable.getSelectedRow(), columnIndex).toString();
					} else if(selectedModuleFromComboBox.isEmpty()){
						selectedModuleFromComboBox = teacherTable.getValueAt(teacherTable.getSelectedRow(), columnIndex).toString();
					} else if(dateOfBirth.isEmpty()){
						dateOfBirth = teacherTable.getValueAt(teacherTable.getSelectedRow(), columnIndex).toString();
					} else {
						isFullTime = teacherTable.getValueAt(teacherTable.getSelectedRow(), columnIndex).toString();
					}
		}
		
				updateTutorPage.getNameTextField().setText(name);
				updateTutorPage.getNumberTextField().setText(phoneNumber.toString());
				updateTutorPage.getAddressTextField().setText(address);
				ButtonGroup buttonGroup = updateTutorPage.getButtonGroup();
		
		
				for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
		
					if(sex.equals(button.getText())) {
						button.setSelected(true);
		}
		}
				updateTutorPage.getDobTextField().setText(dateOfBirth);
		
				JCheckBox isFullTimeCheckBox = updateTutorPage.getIsFullTimeCheckBox();
		
				if(isFullTime.equals("YES")) {
					isFullTimeCheckBox.setSelected(true);
				} else if(isFullTime.equals("NO")){
					isFullTimeCheckBox.setSelected(false);
		}
		
				JComboBox assignedModuleComboBox = updateTutorPage.getModuleAssignedComboBox();
				ComboBoxModel model = assignedModuleComboBox.getModel();
		
				for(int i = 0; i <= 2; i++) {
					if(model.getElementAt(i).equals(selectedModuleFromComboBox)) {
						model.setSelectedItem(model.getElementAt(i));
						break;
		}
		}
				updateBtn.setActionCommand("Update");
				updateBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getActionCommand().equals("Update")) {
		
							JTextField fullNameTextField = updateTutorPage.getNameTextField();
							JTextField addressTextField = updateTutorPage.getAddressTextField();
							JTextField numberTextField = updateTutorPage.getNumberTextField();
							JComboBox moduleAssignedTextField1 = updateTutorPage.getModuleAssignedComboBox();
							JCheckBox isFullTimeCheckBox1 = updateTutorPage.getIsFullTimeCheckBox();
		
							BigDecimal oldMobileNumber = (BigDecimal) teacherTable.getValueAt(teacherTable.getSelectedRow(), 2);
		
							String updatedName = fullNameTextField.getText().trim();
							String updatedNumber = numberTextField.getText().trim();
							String updatedAddress = addressTextField.getText().trim();
							String updatedSelectedModule = "";
							String updatedIsFullTime = "NO";
		
			ComboBoxModel comboBoxModel = assignedModuleComboBox.getModel();
			Object selectedItem = comboBoxModel.getSelectedItem();
			updatedSelectedModule = selectedItem.toString();
		
			if(isFullTimeCheckBox.isSelected()) {
				updatedIsFullTime = "YES";
			} else {
				updatedIsFullTime = "NO";
			}
		
			int updatedRowId = selectedRowNo + 1;
		
			String updatedQuery = "UPDATE `tutor` SET "
					+ "`Name` = '"+updatedName+"', "
					+ "`Phone_Number` = '"+updatedNumber+"',"
					+ " `Address` = '"+updatedAddress+"', "
					+ " `Module_Assigned` = '"+updatedSelectedModule+"', "
					+ "`Full_Time` = '"+updatedIsFullTime+"' "
					+ "WHERE `tutor`.`Phone_Number` = "+oldMobileNumber+" ";
		
			Statement statement = DbUtil.getStatement();
			try {
				int updateSuccess = statement.executeUpdate(updatedQuery);
				if(updateSuccess == 1) {
					JOptionPane.showMessageDialog(scrollPane, "Data is Updated");
				} else {
					JOptionPane.showMessageDialog(scrollPane, "Something went wrong while updating");
		}
		
			} catch (SQLException e1) {
		// TODO Auto-generated catch block
				e1.printStackTrace();
		}
			AdminDashBoard.getTutorDataInTableFromDb();
		
			System.out.println("Update button is working");
		}
		
		}
		});
		// JOptionPane.showMessageDialog(scrollPane, "row is updated");
			} else if(n == 1){ // delete
				BigDecimal deleteMobileNumber = (BigDecimal) teacherTable.getValueAt(teacherTable.getSelectedRow(), 2);
				Statement statement = DbUtil.getStatement();
		
				String deleteQuery =  "DELETE FROM tutor WHERE `tutor`.`Phone_Number` = "+deleteMobileNumber+" ";
				try {
					int deleteSuccess = statement.executeUpdate(deleteQuery);
					if(deleteSuccess == 1) {
						JOptionPane.showMessageDialog(scrollPane, "Deleted!!!");
					} else {
						JOptionPane.showMessageDialog(scrollPane, "Something went wrong");
		}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
		}
		
				AdminDashBoard.getTutorDataInTableFromDb();
			}
		
		}
		});
			teacherTable.setDefaultEditor(Object.class, null);
		
			teacherTable.setModel(tutorDefaultTableModel);
			teacherTable.getColumnModel().getColumn(2).setPreferredWidth(86);
			teacherTable.getColumnModel().getColumn(5).setPreferredWidth(90);
			scrollPane.setViewportView(teacherTable);
			teacherPanel.setLayout(gl_teacherPanel);
			
			JPanel reportPanel = new JPanel();
			reportPanel.setBackground(new Color(255, 255, 255));
			cardPanel.add(reportPanel, "name_606568182121800");
			reportPanel.setLayout(null);
		
			JPanel panel = new JPanel();
			panel.setBounds(44, 428, 535, 100);
			reportPanel.add(panel);
		
			JButton generateReportButton = new JButton("Generate Report");
			generateReportButton.setBackground(new Color(192, 192, 192));
			generateReportButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			generateReportButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GenerateReportPage generateReportPage=new GenerateReportPage();
					generateReportPage.setVisible(true);
				}
			});
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(189)
					.addComponent(generateReportButton, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
					.addGap(201))
		);
			gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(39)
							.addComponent(generateReportButton, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addGap(36))
		);
			panel.setLayout(gl_panel);
		
		
			JButton courseBtn = new JButton("Courses");
			courseBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			courseBtn.setBackground(new Color(192, 192, 192));
			courseBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cl_cardPanel.show(cardPanel, "name_3194150471600");
		}
		});
		
		JButton studentsBtn = new JButton("Students");
		studentsBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		studentsBtn.setBackground(new Color(192, 192, 192));
		studentsBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		cl_cardPanel.show(cardPanel, "name_6771723028700");
		}
		});
		
		JButton tutorBtn = new JButton("Tutor");
		tutorBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tutorBtn.setBackground(new Color(192, 192, 192));
		tutorBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		cl_cardPanel.show(cardPanel, "name_245905159712600");
		}
		});
		
		JButton reportBtn = new JButton("Report");
		reportBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		reportBtn.setBackground(new Color(192, 192, 192));
		reportBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		cl_cardPanel.show(cardPanel, "name_606568182121800");
		}
		});
		
		welcomeLabel = new JLabel("Course Management");
		welcomeLabel.setForeground(new Color(255, 255, 128));
		welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		table = new JTable();
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		logoutBtn.setBackground(new Color(192, 192, 192));
		logoutBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		new LoginPage();
		frame.setVisible(false);
		}
		});
		JLabel lblNewLabel_3 = new JLabel("DASHBOARD");
		lblNewLabel_3.setForeground(new Color(255, 255, 128));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(logoutBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(reportBtn, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(courseBtn, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(studentsBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(tutorBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
					.addGap(36)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeLabel, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(59, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(39)
					.addComponent(welcomeLabel, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addGap(45)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addComponent(courseBtn, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(studentsBtn, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tutorBtn, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(reportBtn, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addGap(120)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(logoutBtn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addGap(166))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
		
		AdminDashBoard.getTutorDataInTableFromDb();
		AdminDashBoard.getCourseDataFromDb();
		AdminDashBoard.getStudentDataFromDb();
		}
		}
