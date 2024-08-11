package ProjectDefault;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class vvvv extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;
	private JButton btn1;
	private JTextField text;
	private JButton btnNewButton_2;
	private JComboBox comboBox;
	private JButton btnNewButton_3;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JDateChooser txt_date;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vvvv frame = new vvvv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
		
	void loadcombo() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vb?useSSL=false&allowPublicKeyRetrieval=true ", "root", "Vedant@123");
			PreparedStatement st1 = connection.prepareStatement("select uname from new_table");
			ResultSet rs = st1.executeQuery();
			
			while(rs.next()) {
				comboBox.addItem(rs.getString("uname"));
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
	public vvvv() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setBounds(62, 46, 155, 31);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JComboBox combobox = new JComboBox();
		combobox.setBounds(62, 97, 155, 31);
		contentPane.add(combobox);
		combobox.addItem("Male");
		combobox.addItem("Female");
		
//		INSERT DATA QUERY
		btn1 = new JButton("New button");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDateChooser txt_date = new JDateChooser();

				String uname = txt1.getText(); 
				String age = (String) combobox.getSelectedItem();
				
				java.util.Date selectedDate = txt_date.getDate();

				
				SimpleDateFormat formet = new SimpleDateFormat("yyyy-MM-dd");
	            String dob = formet.format(selectedDate);
			
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vb?useSSL=false&allowPublicKeyRetrieval=true ", "root", "Vedant@123");
					
					PreparedStatement st1 = connection.prepareStatement("INSERT INTO new_table(uname,age,dob) values(?,?,?)");
					st1.setString(1, uname);
					st1.setString(2, age);
					st1.setString(3, dob);
					
					int count  = st1.executeUpdate();
					if (count > 0) {
						JOptionPane.showMessageDialog(btn1, "Data Added Successfully");
					}
					else {
						JOptionPane.showMessageDialog(btn1, "Enter the data First");
					}
					
					connection.close();
					
					
					
				} catch(SQLException sqlexception){
					sqlexception.printStackTrace();
				}
		
			}
		});
		btn1.setBounds(92, 180, 117, 36);
		contentPane.add(btn1);
		
	
		txt_date = new JDateChooser();
		txt_date.setDateFormatString("DD-MMM-YYYY");
		txt_date.setBounds(58, 139, 159, 20);
		contentPane.add(txt_date);
		
//		SEARCH QUERY
		JButton btnNewButton = new JButton("search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vb?useSSL=false", "root", "Vedant@123");
					PreparedStatement st1 = connection.prepareStatement("select uname,age from new_table where uname=?");
//					String id = text.getText();
//					st1.setString(1,id);
					
					String uname = (String) comboBox.getSelectedItem();
					st1.setString(1, uname);
					
					
					ResultSet rs = st1.executeQuery();
					
					if(rs.next()==false) {
						JOptionPane.showMessageDialog(null, "record not found");
					}else {
						String uname1 = rs.getString(1);
						String age = rs.getString(2);
						txt1.setText(uname1);
						combobox.setSelectedItem(age);
						
						textArea.setText("***************Your Ricept***************\n");
						textArea.setText(textArea.getText() + "sample :" + " " + uname + "\n");
						textArea.setText(textArea.getText() + age + "\n");
					}
					connection.close();
					
//					txt1.getText().trim().isEmpty()
//					comboBox.equals(comboBox)	

				} catch(SQLException sqlexception){
					sqlexception.printStackTrace();
				}
		
			}
		});
		btnNewButton.setBounds(273, 123, 96, 36);
		contentPane.add(btnNewButton);
		
		text = new JTextField();
		text.setBounds(273, 25, 86, 20);
		contentPane.add(text);
		text.setColumns(10);
		
//		DELECT DATA QUERY
		JButton btnNewButton_1 = new JButton("delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vb?useSSL=false", "root", "Vedant@123");
					PreparedStatement st1 = connection.prepareStatement("delete from new_table where id=?");
					String id = text.getText();
					st1.setString(1, id);
					int a = st1.executeUpdate();
					if(a >0) {
					JOptionPane.showMessageDialog(null, "Data is Deleted", "message", JOptionPane.YES_NO_OPTION);
					}else {
					JOptionPane.showMessageDialog(null, "Record not Found");
					}
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(381, 123, 89, 36);
		contentPane.add(btnNewButton_1);
		
//		UPDATE DATA QUERY
		btnNewButton_2 = new JButton("update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = txt1.getText(); 
				String age = (String) combobox.getSelectedItem();
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vb?useSSL=false", "root", "Vedant@123");
					PreparedStatement st1 = connection.prepareStatement("update new_table set uname=?,age=? where uname=?");
					st1.setString(1, uname);
					st1.setString(2, age);
					st1.setString(3, (String) comboBox.getSelectedItem());
					
					st1.execute();
					textArea.setText("");
					JOptionPane.showMessageDialog(null, "update");
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(283, 180, 101, 36);
		contentPane.add(btnNewButton_2);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(273, 71, 86, 22);
		loadcombo();
		contentPane.add(comboBox);
		
		
		btnNewButton_3 = new JButton("Print");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						textArea.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		});
		btnNewButton_3.setBounds(596, 250, 89, 23);
		contentPane.add(btnNewButton_3);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textArea.setBounds(540, 23, 198, 193);
		contentPane.add(textArea);
		
		lblNewLabel = new JLabel("Sample");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 11, 117, 24);
		contentPane.add(lblNewLabel);
	}
}


//if(!this.jtxtDate.getSelectedItem.toString().isEmpty()) {
//    idc.setDate(this.jtxtDate.getDate);
//} else {
//    JOptionPane.showMessageDialog(rootPane, "pls choose date");
//}

//
//dispose();
//main ah = new main();
//ah.setVisible(true);





