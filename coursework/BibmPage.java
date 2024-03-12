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

public class BibmPage extends JDialog {

private final JPanel contentPanel = new JPanel();

/**
* Launch the application.
*/
public static void main(String[] args) {
	try {
		BibmPage dialog = new BibmPage();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
}
}

/**
* Create the dialog.
*/
public BibmPage() {
	setBounds(100, 100, 602, 504);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBackground(new Color(0, 64, 0));
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);
{
	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 255, 128));
	panel.setLayout(null);
	panel.setBounds(0, 93, 121, 346);
	contentPanel.add(panel);
{
	JLabel lblNewLabel = new JLabel("Level 4");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	lblNewLabel.setBounds(22, 10, 79, 17);
	panel.add(lblNewLabel);
}
{
	JLabel lblNewLabel_1 = new JLabel("Finance");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	lblNewLabel_1.setBounds(10, 51, 111, 17);
	panel.add(lblNewLabel_1);
}
{
	JLabel lblNewLabel_1_2 = new JLabel("Statistics");
	lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	lblNewLabel_1_2.setBounds(0, 78, 121, 17);
	panel.add(lblNewLabel_1_2);
}
{
	JLabel lblNewLabel_1_2_1 = new JLabel("Business");
	lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	lblNewLabel_1_2_1.setBounds(0, 105, 121, 17);
	panel.add(lblNewLabel_1_2_1);
	}
{
	JLabel lblNewLabel_1_3 = new JLabel("Accounting");
	lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	lblNewLabel_1_3.setBounds(0, 132, 121, 17);
	panel.add(lblNewLabel_1_3);
	}
}
{
	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 255, 128));
	panel.setLayout(null);
	panel.setBounds(132, 94, 142, 345);
	contentPanel.add(panel);
	JLabel lblLevel = new JLabel("Level 5");
	lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
	lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	lblLevel.setBounds(0, 10, 142, 17);
	panel.add(lblLevel);
	{
		JLabel lblNewLabel_1 = new JLabel("Professional Learning");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 51, 142, 17);
		panel.add(lblNewLabel_1);
}
{
	JLabel lblNewLabel_1_2 = new JLabel("Digital Marketing");
	lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	lblNewLabel_1_2.setBounds(0, 78, 142, 17);
	panel.add(lblNewLabel_1_2);
	}
{
	JLabel lblNewLabel_1_2_1 = new JLabel("ABC");
	lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	lblNewLabel_1_2_1.setBounds(0, 105, 142, 17);
	panel.add(lblNewLabel_1_2_1);
	}
{
	JLabel lblNewLabel_1_3 = new JLabel("Economics");
	lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	lblNewLabel_1_3.setBounds(0, 132, 142, 17);
	panel.add(lblNewLabel_1_3);
	}
}
{
	JPanel panel_2 = new JPanel();
	panel_2.setBackground(new Color(255, 255, 128));
	panel_2.setLayout(null);
	panel_2.setBounds(284, 94, 172, 345);
	contentPanel.add(panel_2);
	{
		JLabel lblLevel_1 = new JLabel("Level 6");
		lblLevel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLevel_1.setBounds(0, 10, 167, 17);
		panel_2.add(lblLevel_1);
}
{
	JLabel lblNewLabel_1_4_1 = new JLabel("MicroEconomics");
	lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
	lblNewLabel_1_4_1.setBounds(0, 49, 172, 15);
	panel_2.add(lblNewLabel_1_4_1);
}
{
	JLabel lblNewLabel_1_4_2 = new JLabel("Human Resource");
	lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	lblNewLabel_1_4_2.setBounds(0, 74, 172, 17);
	panel_2.add(lblNewLabel_1_4_2);
}
{
	JComboBox comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"Public Relations", "Academics"}));
	comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	comboBox.setBounds(0, 101, 167, 27);
	panel_2.add(comboBox);
}
{
	JComboBox comboBox_1 = new JComboBox();
	comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"FYP", "PYT"}));
	comboBox_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
	comboBox_1.setBounds(0, 138, 167, 27);
	panel_2.add(comboBox_1);
	}
}
{
	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 255, 128));
	panel.setLayout(null);
	panel.setBounds(466, 93, 121, 346);
	contentPanel.add(panel);
	{
		JLabel lblLevel_2 = new JLabel("Level 7");
		lblLevel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLevel_2.setBounds(0, 10, 121, 17);
		panel.add(lblLevel_2);
	}
	{
		JLabel lblNewLabel_1 = new JLabel("Finance");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 51, 121, 17);
		panel.add(lblNewLabel_1);
	}
	{
		JLabel lblNewLabel_1_2 = new JLabel("Statistics");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(0, 78, 121, 17);
		panel.add(lblNewLabel_1_2);
	}
	{
		JLabel lblNewLabel_1_2_1 = new JLabel("Business");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(0, 105, 121, 17);
		panel.add(lblNewLabel_1_2_1);
	}
	{
		JLabel lblNewLabel_1_3 = new JLabel("Accounting");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(0, 132, 121, 17);
		panel.add(lblNewLabel_1_3);
	}
}
	JLabel lblNewLabel_2 = new JLabel("Courses offered to BIBM Students");
	lblNewLabel_2.setForeground(new Color(255, 255, 128));
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setBackground(new Color(0, 64, 0));
	lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	lblNewLabel_2.setBounds(156, 37, 289, 34);
	contentPanel.add(lblNewLabel_2);
}
}