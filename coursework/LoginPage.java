package coursework;
import java.awt.EventQueue;
import backend.DbUtil;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
public class LoginPage {
	
JFrame frame;
private JTextField userTextField;
private JPasswordField passwordTextField;
private String selectUserTypeFromComboBox="";
private Connection con;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
LoginPage window = new LoginPage();
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
public LoginPage() {
	 
initialize();

}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(new Color(32, 96, 34));
frame.setBounds(600,250, 480, 520); //x coordinate.
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
frame.setVisible(true);

JLabel usernamelabel = new JLabel("Username");
usernamelabel.setForeground(new Color(255, 255, 255));
usernamelabel.setBackground(new Color(192, 192, 192));
usernamelabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
usernamelabel.setBounds(58, 110, 85, 23);
frame.getContentPane().add(usernamelabel);

userTextField = new JTextField();
userTextField.setBackground(new Color(255, 255, 255));
userTextField.setBounds(170, 112, 133, 23);
frame.getContentPane().add(userTextField);
userTextField.setColumns(10);

JLabel passwordlabel = new JLabel("Password");
passwordlabel.setForeground(new Color(255, 255, 255));
passwordlabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
passwordlabel.setBounds(58, 169, 71, 23);
frame.getContentPane().add(passwordlabel);

passwordTextField = new JPasswordField();
passwordTextField.setBackground(new Color(255, 255, 255));
passwordTextField.setBounds(170, 171, 133, 23);
frame.getContentPane().add(passwordTextField);



JLabel selectuserlabel = new JLabel("Select User");
selectuserlabel.setForeground(new Color(255, 255, 255));
selectuserlabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
selectuserlabel.setBounds(186, 261, 90, 23);
frame.getContentPane().add(selectuserlabel);

JComboBox comboBox = new JComboBox();
comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
comboBox.setBackground(new Color(255, 255, 255));
comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Student", "Teacher"}));
comboBox.setBounds(175, 294, 128, 21);
frame.getContentPane().add(comboBox);

comboBox.addItemListener(new ItemListener() {
public void itemStateChanged(ItemEvent e) {
if(e.getStateChange() == 1) {
selectUserTypeFromComboBox = (String) e.getItem();
System.out.println(e.getItem());
}

}
});


JButton loginButton = new JButton("Login");
loginButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
loginButton.setBackground(new Color(255, 255, 255));
loginButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String username = userTextField.getText().trim();
String password=String.valueOf(passwordTextField.getPassword());
String userType=comboBox.getSelectedItem().toString();

String checkQuery = "SELECT * FROM users " + "WHERE Username = '" + username + "' "
+ "AND Password = '" + password + "' " + "AND User_Type='" + userType + "' ";

Statement statement = DbUtil.getStatement();
try {
ResultSet resultSet = statement.executeQuery(checkQuery);
if (resultSet.next()) {
if(userType.equals("Student")){
StudentDashBoard studentDashboard = new StudentDashBoard();
studentDashboard.frame.setVisible(true);
frame.setVisible(false);
} else if(userType.equals("Admin")) {
AdminDashBoard adminDashBoard = new AdminDashBoard();
adminDashBoard.frame.setVisible(true);
frame.setVisible(false);
} else if(userType.equals("Teacher")) {
TeacherDashBoard teacherDashBoard = new TeacherDashBoard();
teacherDashBoard.frame.setVisible(true);
frame.setVisible(false);
} else {
JOptionPane.showMessageDialog(passwordTextField, "Username or password is wrong!");
}
}
}catch (SQLException e1) {
e1.printStackTrace();
}
String selectQuery = "SELECT Username, Password, User_Type FROM users";
       try{
        Statement st = con.createStatement();
           
           ResultSet rs = st.executeQuery(selectQuery);
           

                   while(rs.next()) {
                      if(username.equals(rs.getString("Username")) && password.equals(rs.getString("Password"))) {
                    AdminDashBoard window = new AdminDashBoard();
        window.frame.setVisible(true);
                   JOptionPane.showMessageDialog(null,"Logged in successfully");
//                       } else{
//                JOptionPane.showMessageDialog(null,"Invalid username and password");
           }
               
                   }
               


       }catch(SQLException ex){
           ex.printStackTrace();
       }



}
});
loginButton.setBounds(335, 399, 85, 21);
frame.getContentPane().add(loginButton);
frame.getContentPane().setLayout(null);
// frame.getContentPane().add(mainIcon);
// frame.getContentPane().add(iconLabel1);
frame.getContentPane().add(usernamelabel);
frame.getContentPane().add(userTextField);
// frame.getContentPane().add(iconLabel3);
frame.getContentPane().add(passwordlabel);
frame.getContentPane().add(passwordTextField);
// frame.getContentPane().add(checkBox);
// frame.getContentPane().add(loginAsLabel);
// frame.getContentPane().add(iconLabel5);
frame.getContentPane().add(comboBox);
frame.getContentPane().add(loginButton);

JButton createButton = new JButton("Create");
createButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
createButton.setBackground(new Color(255, 255, 255));
createButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
UserRegistration userregistration= new UserRegistration();
userregistration.frame.setVisible(true);
}
});
createButton.setBounds(58, 399, 85, 21);
frame.getContentPane().add(createButton);
JLabel lblNewLabel = new JLabel("WELCOME TO HCK");
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setForeground(new Color(255, 255, 128));
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
lblNewLabel.setBounds(88, 28, 275, 32);
frame.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("Don't have an account?");
lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD | Font.ITALIC, 12));
lblNewLabel_1.setBounds(30, 376, 142, 13);
frame.getContentPane().add(lblNewLabel_1);
}
}