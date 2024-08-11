package ProjectDefault;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
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
import java.awt.SystemColor;

public class report2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report2 frame = new report2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void loadcombo() {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
			PreparedStatement st1 = connection.prepareStatement("select name from pay");
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
	/**
	 * Create the frame.
	 */
	public report2() {
		super("Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 775);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payments Fees\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setBounds(561, 43, 316, 61);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setEditable(true);
		comboBox.setBounds(586, 132, 258, 33);
		loadcombo();
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
					PreparedStatement st1 = connection.prepareStatement("select name,lname,month,amount from pay where name=?");
				
					String name = (String) comboBox.getSelectedItem();
					st1.setString(1, name);
					
					ResultSet rs = st1.executeQuery();
					if(rs.next()==false) {
						JOptionPane.showMessageDialog(null, "record not found");
						
						txt1.setText("");
						txt2.setText("");
						txt3.setText("");
						txt4.setText("");
						
						comboBox.requestFocus();
					}else {
						
						String name1 = rs.getString(1);
						String lastname = rs.getString(2);
						String month = rs.getString(3);
						String amount = rs.getString(4);
						txt1.setText(name1);
						txt2.setText(lastname);
						txt3.setText(month);
						txt4.setText(amount);
						
						comboBox.requestFocus();
					}
					connection.close();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(650, 190, 127, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("First Name         :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(479, 292, 218, 27);
		contentPane.add(lblNewLabel_1);
		
		txt1 = new JTextField();
		txt1.setBackground(new Color(255, 255, 255));
		txt1.setEditable(false);
		txt1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt1.setBounds(707, 295, 238, 27);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name          :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(479, 348, 218, 27);
		contentPane.add(lblNewLabel_2);
		
		txt2 = new JTextField();
		txt2.setBackground(new Color(255, 255, 255));
		txt2.setEditable(false);
		txt2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt2.setBounds(707, 348, 238, 27);
		contentPane.add(txt2);
		txt2.setColumns(10);
	
		JLabel lblNewLabel_4 = new JLabel("Month                :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(479, 417, 218, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Amount              :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(479, 477, 218, 27);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				main f=new main();
				f.show();
			}
		});
		btnNewButton_2.setBounds(479, 546, 127, 53);
		contentPane.add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		textArea.setEditable(false);
		textArea.setBounds(995, 59, 355, 540);
		contentPane.add(textArea);
		
		JButton btnNewButton_4 = new JButton("Receipt");
		btnNewButton_4.setBackground(new Color(192, 192, 192));
		btnNewButton_4.setBounds(666, 546, 119, 53);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		
		JButton btnNewButton_5 = new JButton("Print");
		btnNewButton_5.setBackground(new Color(192, 192, 192));
		btnNewButton_5.setBounds(1211, 614, 119, 46);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textArea.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Search Record First","Message", JOptionPane.OK_OPTION);
					}else {
					textArea.print();
					JOptionPane.showMessageDialog(null, "Record Print Successfully");
					}
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		
		txt3 = new JTextField();
		txt3.setBackground(new Color(255, 255, 255));
		txt3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt3.setEditable(false);
		txt3.setBounds(707, 417, 238, 27);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt4.setBackground(new Color(255, 255, 255));
		txt4.setEditable(false);
		txt4.setBounds(707, 479, 238, 27);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedItem("");
				txt1.setText("");
				txt3.setText("");
				txt4.setText("");
			
				comboBox.requestFocus();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setBounds(828, 546, 119, 50);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 22, 1340, 692);
		contentPane.add(panel);
		panel.setLayout(null);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.append("\t Customer Record \n" + 
						"\n=======================================================\n" +
						"First Name : \t\t" + txt1.getText() + "\n\n" +
						"LastName :\t\t" + txt2.getText() + "\n\n" + 
						"Month :\t\t" + txt3.getText() + "\n\n" +
						"Amount :\t\t" + txt4.getText() + "\n\n" +
						"=========================================================="
						);
			}
		});
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	
	}
}
