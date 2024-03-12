package coursework;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BitPage extends JDialog {

private final JPanel contentPanel = new JPanel();

/**
* Launch the application.
*/
public static void main(String[] args) {
try {
BitPage dialog = new BitPage();
dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
dialog.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}

/**
* Create the dialog.
*/
public BitPage() {
setBounds(100, 100, 655, 497);
getContentPane().setLayout(new BorderLayout());
contentPanel.setBackground(new Color(0, 64, 0));
contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
getContentPane().add(contentPanel, BorderLayout.CENTER);
contentPanel.setLayout(null);

JPanel panel = new JPanel();
panel.setBackground(new Color(255, 255, 128));
panel.setBounds(10, 83, 199, 350);
contentPanel.add(panel);
panel.setLayout(null);

JLabel lblNewLabel = new JLabel("Level 4");
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
lblNewLabel.setBounds(0, 10, 199, 17);
panel.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Fundamentals of Computing");
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1.setBounds(0, 51, 199, 17);
panel.add(lblNewLabel_1);

JLabel lblNewLabel_1_2 = new JLabel("Computational Mathematics");
lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_2.setBounds(10, 78, 179, 17);
panel.add(lblNewLabel_1_2);

JLabel lblNewLabel_1_2_1 = new JLabel("Internet Software Architecture");
lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_2_1.setBounds(0, 105, 199, 17);
panel.add(lblNewLabel_1_2_1);

JLabel lblNewLabel_1_3 = new JLabel("Academic Skills and Team Based Learning");
lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_3.setBounds(0, 132, 199, 17);
panel.add(lblNewLabel_1_3);
JLabel lblNewLabel_1_3_1 = new JLabel("Embedded System Programming");
lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_3_1.setBounds(0, 159, 199, 17);
panel.add(lblNewLabel_1_3_1);
JLabel lblNewLabel_1_3_1_1 = new JLabel("Introductory Programming and problem Solving");
lblNewLabel_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_3_1_1.setBounds(0, 186, 199, 17);
panel.add(lblNewLabel_1_3_1_1);

JPanel panel_1 = new JPanel();
panel_1.setBackground(new Color(255, 255, 128));
panel_1.setBounds(219, 83, 204, 350);
contentPanel.add(panel_1);
panel_1.setLayout(null);

JLabel lblLevel = new JLabel("Level 5");
lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 20));
lblLevel.setBounds(0, 10, 204, 17);
panel_1.add(lblLevel);

JLabel lblNewLabel_1_4 = new JLabel("Cloud computing");
lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_4.setBounds(0, 55, 204, 17);
panel_1.add(lblNewLabel_1_4);

JLabel lblNewLabel_1_5 = new JLabel("Numerical Methods");
lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_5.setBounds(0, 106, 189, 17);
panel_1.add(lblNewLabel_1_5);

JLabel lblNewLabel_1_5_1 = new JLabel("Artificial Technologies");
lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_5_1.setBounds(0, 134, 204, 17);
panel_1.add(lblNewLabel_1_5_1);

JLabel lblNewLabel_1_5_1_1 = new JLabel("Object Oriented  Designs");
lblNewLabel_1_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_5_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_5_1_1.setBounds(0, 161, 204, 17);
panel_1.add(lblNewLabel_1_5_1_1);
JLabel lblNewLabel_1_5_1_1_1 = new JLabel("Complex systems");
lblNewLabel_1_5_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_5_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_5_1_1_1.setBounds(0, 79, 204, 17);
panel_1.add(lblNewLabel_1_5_1_1_1);
JLabel lblNewLabel_1_5_1_1_2 = new JLabel("Human- Computer Interactions");
lblNewLabel_1_5_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_5_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_5_1_1_2.setBounds(0, 184, 204, 17);
panel_1.add(lblNewLabel_1_5_1_1_2);
JLabel lblNewLabel_2 = new JLabel("Courses offered to BIT Students");
lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_2.setForeground(new Color(255, 255, 128));
lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
lblNewLabel_2.setBounds(194, 28, 289, 34);
contentPanel.add(lblNewLabel_2);

JPanel panel_2 = new JPanel();
panel_2.setBackground(new Color(255, 255, 128));
panel_2.setBounds(433, 83, 199, 350);
contentPanel.add(panel_2);
panel_2.setLayout(null);

JLabel lblLevel_1 = new JLabel("Level 6");
lblLevel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblLevel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
lblLevel_1.setBounds(0, 10, 199, 17);
panel_2.add(lblLevel_1);

JLabel lblNewLabel_1_4_1 = new JLabel("High Performance Computing");
lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_4_1.setBounds(0, 57, 199, 17);
panel_2.add(lblNewLabel_1_4_1);

JLabel lblNewLabel_1_4_2 = new JLabel("Project Management and Professionalism");
lblNewLabel_1_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
lblNewLabel_1_4_2.setBounds(10, 82, 179, 17);
panel_2.add(lblNewLabel_1_4_2);

JComboBox comboBox = new JComboBox();
comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
comboBox.setModel(new DefaultComboBoxModel(new String[] {"Concepts of AI", "UI UX"}));
comboBox.setBounds(20, 121, 169, 21);
panel_2.add(comboBox);

JComboBox comboBox_1 = new JComboBox();
comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Machine learning", "high level programming"}));
comboBox_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
comboBox_1.setBounds(20, 165, 159, 21);
panel_2.add(comboBox_1);
}
}