package ProjectDefault;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class report extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	private JTextField txt10;
	private JTextField txt11;
	private JLabel lbl1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report frame = new report();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void loadcombo() {
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
			PreparedStatement st1 = connection.prepareStatement("select name from data");
			ResultSet rs = st1.executeQuery();
			
			while(rs.next()) {
			comboBox.addItem(rs.getString("name"));
			comboBox.setSelectedItem("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void loadImage(String imagePath) {
	    try {
	        ImageIcon icon = new ImageIcon(imagePath);
	        Image image = icon.getImage().getScaledInstance(lbl1.getWidth(), lbl1.getHeight(), Image.SCALE_SMOOTH);
	        lbl1.setIcon(new ImageIcon(image));
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception, for example, show a default image or a placeholder
	    }
	}
	/**
	 * Create the frame.
	 */
	public report() {
		super("Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 775);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Print Customer Receipt");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setBounds(462, 11, 491, 61);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setBounds(82, 89, 264, 27);
		loadcombo();
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
					PreparedStatement st1 = connection.prepareStatement("select name,lastname,age,gender,dob,email,contact,addres,height,weight,membership,image from data where name=?");
				
					String name = (String) comboBox.getSelectedItem();
					st1.setString(1, name);
					
					ResultSet rs = st1.executeQuery();
					if(rs.next()==false) {
						JOptionPane.showMessageDialog(null, "record not found");
						
						txt1.setText("");
						txt2.setText("");
						txt3.setText("");
						txt4.setText("");
						txt5.setText("");
						txt6.setText("");
						txt7.setText("");
						txt8.setText("");
						txt9.setText("");
						txt10.setText("");
						txt11.setText("");
						
						comboBox.requestFocus();
					}else {
						
						String name1 = rs.getString(1);
						String lastname = rs.getString(2);
						String age = rs.getString(3);
						String gender = rs.getString(4);
						String dob = rs.getString(5);
						String email = rs.getString(6);
						String contact = rs.getString(7);
						String addres = rs.getString(8);
						String height = rs.getString(9);
						String weight = rs.getString(10);
						String membership = rs.getString(11);
						String imagepath = rs.getString("image");
						
						txt1.setText(name1);
						txt2.setText(lastname);
						txt3.setText(age);
						txt4.setText(gender);
						txt5.setText(dob);
						txt6.setText(email);
						txt7.setText(contact);
						txt8.setText(addres);
						txt9.setText(height);
						txt10.setText(weight);
						txt11.setText(membership);
						loadImage(imagepath);
						
						comboBox.requestFocus();
					}
					connection.close();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(134, 128, 108, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("First Name   :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(38, 181, 139, 27);
		contentPane.add(lblNewLabel_2);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt1.setEditable(false);
		txt1.setBounds(183, 185, 185, 27);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name    :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(38, 233, 139, 27);
		contentPane.add(lblNewLabel_3);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt2.setBounds(183, 233, 185, 27);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Age               :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(38, 282, 139, 27);
		contentPane.add(lblNewLabel_4);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt3.setEditable(false);
		txt3.setBounds(183, 286, 185, 27);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender          :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(38, 338, 146, 27);
		contentPane.add(lblNewLabel_5);
		
		txt4 = new JTextField();
		txt4.setEditable(false);
		txt4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt4.setBounds(183, 338, 185, 27);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Date of Birth :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(38, 390, 146, 27);
		contentPane.add(lblNewLabel_6);
		
		txt5 = new JTextField();
		txt5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt5.setEditable(false);
		txt5.setBounds(183, 390, 185, 27);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email            :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(38, 447, 139, 21);
		contentPane.add(lblNewLabel_7);
		
		txt6 = new JTextField();
		txt6.setEditable(false);
		txt6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt6.setBounds(183, 441, 185, 27);
		contentPane.add(txt6);
		txt6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Contact         :");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(38, 498, 146, 21);
		contentPane.add(lblNewLabel_8);
		
		txt7 = new JTextField();
		txt7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt7.setEditable(false);
		txt7.setBounds(183, 492, 185, 27);
		contentPane.add(txt7);
		txt7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Address        : ");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(38, 544, 146, 21);
		contentPane.add(lblNewLabel_9);
		
		txt8 = new JTextField();
		txt8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt8.setEditable(false);
		txt8.setBounds(183, 536, 185, 29);
		contentPane.add(txt8);
		txt8.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Height           :");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_10.setBounds(38, 589, 146, 27);
		contentPane.add(lblNewLabel_10);
		
		txt9 = new JTextField();
		txt9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt9.setEditable(false);
		txt9.setBounds(183, 585, 185, 27);
		contentPane.add(txt9);
		txt9.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Weight          :");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_11.setBounds(38, 638, 146, 27);
		contentPane.add(lblNewLabel_11);
		
		txt10 = new JTextField();
		txt10.setEditable(false);
		txt10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt10.setBounds(183, 638, 185, 27);
		contentPane.add(txt10);
		txt10.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Membership  :");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_12.setForeground(new Color(0, 0, 0));
		lblNewLabel_12.setBounds(38, 683, 146, 21);
		contentPane.add(lblNewLabel_12);
		
		txt11 = new JTextField();
		txt11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt11.setEditable(false);
		txt11.setBounds(183, 676, 185, 27);
		contentPane.add(txt11);
		txt11.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				main ah = new main();
				ah.show();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setBounds(462, 638, 113, 52);
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		textArea.setBounds(582, 109, 752, 507);
		contentPane.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(393, 180, 168, 156);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbl1 = new JLabel("New label");
		lbl1.setBounds(10, 5, 148, 140);
		panel.add(lbl1);
		
		JButton btnNewButton_3 = new JButton("Receipt");
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txt1.getText();
				String lastname = txt2.getText();
				String age = txt3.getText();
				String gender = txt4.getText();
				String dob = txt5.getText();
				String email = txt6.getText();
				String contact = txt7.getText();
				String addres = txt8.getText();
				String height = txt9.getText();
				String weight = txt10.getText();
				String membership = txt11.getText();
				
				if(comboBox.equals("") ) {
					JOptionPane.showMessageDialog(null, "Search Record First","Message", JOptionPane.OK_OPTION);
				}else {
					
				textArea.append("\t Customer Record \n" + 
				"\n=======================================================\n" +
				"First Name : \t\t" + txt1.getText() + "\n\n" +
				"LastName :\t\t" + txt2.getText() + "\n\n" + 
				"Age :\t\t" + txt3.getText() + "\n\n" +
				"Gender :\t\t" + txt4.getText() + "\n\n" +
				"Date of Birth :\t\t" + txt5.getText() + "\n\n" +
				"Email :\t\t" + txt6.getText() + "\n\n" +
				"Contact :\t\t" + txt7.getText() + "\n\n" +
				"Address :\t\t" + txt8.getText() + "\n\n" +
				"Height :\t\t" + txt9.getText() + "\n\n" +
				"Weight :\t\t" + txt10.getText() + "\n\n" +
				"Membership :\t\t" + txt11.getText() + "\n" +
				"=========================================================="
				);	
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_3.setBounds(893, 638, 113, 52);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Print");
		btnNewButton_4.setBackground(new Color(192, 192, 192));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textArea.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Search Record First","Message", JOptionPane.OK_OPTION);
					}else {
					textArea.print();
					JOptionPane.showMessageDialog(null, "Record Print Successfully");
					}
					textArea.setText("");
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_4.setBounds(1117, 639, 113, 52);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.setSelectedItem("");
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
				txt6.setText("");
				txt7.setText("");
				txt8.setText("");
				txt9.setText("");
				txt10.setText("");
				txt11.setText("");
				textArea.setText("");
				comboBox.setSelectedItem("");
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_2.setBounds(668, 642, 108, 52);
		contentPane.add(btnNewButton_2);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

	}
}
