package coursework;
	
	
import java.awt.BorderLayout;
import backend.DbUtil;
import java.awt.FlowLayout;
	
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
	import javax.swing.JRadioButton;
	import javax.swing.JCheckBox;
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
import javax.swing.SwingConstants;
	
	public class TutorPage extends JDialog {
	
	private final JPanel formPanel = new JPanel();
	private JTextField nameTextField;
	private JTextField numberTextField;
	private JTextField addressTextField;
	private JTextField dobTextField;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private final ButtonGroup buttonGroup=new ButtonGroup();
	private String name="";
	private String mobile_number="";
	private String address="";
	private String gender="";
	private String isfulltime="NO";
	private String selectedModuleFromComboBox="";
	private String dateOfBirth="";
	private JComboBox moduleAssignedcomboBox;
	private JCheckBox isFullTimeCheckBox;
	private JButton addButton;
	private JRadioButton rdbtnOther;
	private JLabel lblNewLabel;
	public JComboBox getModuleAssignedComboBox() {
	return moduleAssignedcomboBox;
	}
	
	public JCheckBox getIsFullTimeCheckBox() {
	return isFullTimeCheckBox;
	}
	
	public JTextField getNameTextField() {
	return nameTextField;
	}
	
	public JTextField getNumberTextField() {
	return numberTextField;
	}
	
	public JTextField getAddressTextField() {
	return addressTextField;
	}
	
	public JTextField getDobTextField() {
	return dobTextField;
	}
	
	public ButtonGroup getButtonGroup() {
	return buttonGroup;
	}
	
	public JButton getAddBtn() {
	return addButton;
	}
	
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
	try {
	TutorPage dialog = new TutorPage();
	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	dialog.setVisible(true);
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	
	/**
	* Create the dialog.
	*/
	public TutorPage() {
	setBounds(100, 100, 470, 507);
	getContentPane().setLayout(new BorderLayout());
	formPanel.setBackground(new Color(0, 64, 0));
	formPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(formPanel, BorderLayout.SOUTH);
	JLabel nameLabel = new JLabel("Full Name");
	nameLabel.setForeground(new Color(255, 255, 255));
	nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	JLabel numberLabel = new JLabel("Phone Number");
	numberLabel.setForeground(new Color(255, 255, 255));
	numberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	
	nameTextField = new JTextField();
	nameTextField.setBackground(new Color(255, 255, 255));
	nameTextField.setColumns(10);
	
	numberTextField = new JTextField();
	numberTextField.setBackground(new Color(255, 255, 255));
	numberTextField.setColumns(10);
	
	JLabel addressLabel = new JLabel("Address");
	addressLabel.setForeground(new Color(255, 255, 255));
	addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	
	addressTextField = new JTextField();
	addressTextField.setBackground(new Color(255, 255, 255));
	addressTextField.setColumns(10);
	
	JLabel sexLabel = new JLabel("Sex");
	sexLabel.setForeground(new Color(255, 255, 255));
	sexLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	
	maleRadioButton = new JRadioButton("Male");
	maleRadioButton.setBackground(new Color(255, 255, 255));
	maleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
	buttonGroup.add(maleRadioButton);
	
	femaleRadioButton = new JRadioButton("Female");
	femaleRadioButton.setBackground(new Color(255, 255, 255));
	femaleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
	buttonGroup.add(femaleRadioButton);
	
	JLabel dobLabel = new JLabel("Date of Birth");
	dobLabel.setForeground(new Color(255, 255, 255));
	dobLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	
	dobTextField = new JTextField();
	dobTextField.setBackground(new Color(255, 255, 255));
	dobTextField.setColumns(10);
	
	isFullTimeCheckBox = new JCheckBox("Full Time");
	isFullTimeCheckBox.setBackground(new Color(255, 255, 255));
	isFullTimeCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	
	JLabel moduleassignedLabel = new JLabel("Module Assigned");
	moduleassignedLabel.setForeground(new Color(255, 255, 255));
	moduleassignedLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	
	moduleAssignedcomboBox = new JComboBox();
	moduleAssignedcomboBox.setBackground(new Color(192, 192, 192));
	
	moduleAssignedcomboBox.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 12));
	moduleAssignedcomboBox.setModel(new DefaultComboBoxModel(new String[] {"NMC", "AI", "OODP", "ISA"}));
	moduleAssignedcomboBox.addItemListener(new ItemListener() {
	public void itemStateChanged(ItemEvent e) {
	if(e.getStateChange()==1) {
	selectedModuleFromComboBox=(String) e.getItem();
	System.out.println(e.getItem());
	}
	}
	});
	
	addButton = new JButton("ADD");
	addButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	addButton.setBackground(new Color(192, 192, 192));
	addButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	if(e.getActionCommand().equals("ADD")) {
	name = nameTextField.getText().trim();
	mobile_number = numberTextField.getText().trim();
	dateOfBirth = dobTextField.getText().trim();
	address = addressTextField.getText().trim();
	
	for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	AbstractButton button = buttons.nextElement();
	
	if(button.isSelected()) {
	gender = button.getText();
	}
	}
	
	if(isFullTimeCheckBox.isSelected()) {
	isfulltime = "YES";
	} else {
	isfulltime = "NO";
	}
	Statement statement = DbUtil.getStatement();
	
	String insertQuery = "INSERT INTO `tutor` (`Id`, `Name`, `Phone_Number`, `Address`, `Sex`, `Module_Assigned`, `Date_of_Birth`, `Full_Time`)"
	+ " VALUES (NULL, '"+name+"', '"+mobile_number+"', '"+address+"', '"+gender+"', '"+selectedModuleFromComboBox+"', '"+dateOfBirth+"','"+isfulltime+"')";
	try {
	int insertSuccess = statement.executeUpdate(insertQuery);
	if (insertSuccess == 1) {
	JOptionPane.showMessageDialog(nameTextField, "Saved into database");
	}
	} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	AdminDashBoard.getTutorDataInTableFromDb();
	}
	
	
	}
	});
	rdbtnOther = new JRadioButton("Others");
	rdbtnOther.setBackground(new Color(255, 255, 255));
	rdbtnOther.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lblNewLabel = new JLabel("Add New Tutor");
	lblNewLabel.setForeground(new Color(255, 255, 128));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
	GroupLayout gl_formPanel = new GroupLayout(formPanel);
	gl_formPanel.setHorizontalGroup(
		gl_formPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_formPanel.createSequentialGroup()
				.addContainerGap(305, Short.MAX_VALUE)
				.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
				.addGap(246))
			.addGroup(gl_formPanel.createSequentialGroup()
				.addGap(94)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
				.addGap(130))
			.addGroup(gl_formPanel.createSequentialGroup()
				.addGap(38)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_formPanel.createSequentialGroup()
						.addComponent(sexLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
					.addGroup(gl_formPanel.createSequentialGroup()
						.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_formPanel.createSequentialGroup()
								.addComponent(moduleassignedLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(dobLabel, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
									.addGroup(gl_formPanel.createSequentialGroup()
										.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(numberLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
											.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
										.addGap(34)))
								.addGroup(gl_formPanel.createSequentialGroup()
									.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_formPanel.createSequentialGroup()
								.addComponent(moduleAssignedcomboBox, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_formPanel.createSequentialGroup()
								.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
									.addComponent(numberTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
									.addGroup(Alignment.TRAILING, gl_formPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(addressTextField, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
									.addGroup(Alignment.TRAILING, gl_formPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(maleRadioButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addGap(62)
										.addComponent(femaleRadioButton)
										.addGap(63)
										.addComponent(rdbtnOther, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
									.addComponent(isFullTimeCheckBox, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addComponent(dobTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
								.addGap(64))))))
	);
	gl_formPanel.setVerticalGroup(
		gl_formPanel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_formPanel.createSequentialGroup()
				.addGap(48)
				.addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
				.addGap(25)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(numberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(numberLabel))
				.addGap(18)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
					.addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnOther, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(femaleRadioButton)
						.addComponent(maleRadioButton))
					.addComponent(sexLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
				.addGap(40)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(dobTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(dobLabel, GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE))
				.addGap(18)
				.addComponent(isFullTimeCheckBox)
				.addGap(19)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
					.addComponent(moduleassignedLabel)
					.addComponent(moduleAssignedcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(57)
				.addComponent(addButton)
				.addGap(24))
	);
	formPanel.setLayout(gl_formPanel);
	}
	}
	
