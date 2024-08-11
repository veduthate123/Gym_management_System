package ProjectDefault;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class listdata extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTable tbldata;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listdata frame = new listdata();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public listdata() {
		super("Data List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1377, 773);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("Show");
		btn1.setBackground(new Color(192, 192, 192));
		btn1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
					PreparedStatement st1 = con.prepareStatement("select * from data");
					ResultSet rs = st1.executeQuery();
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tbldata.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					
					while(rs.next()) {
						String name= rs.getString(1);
						String lastname = rs.getString(2);
						String age=rs.getString(3);
						String gender = rs.getString(4);
						String dob = rs.getString(5);
						String email= rs.getString(6);
						String contact = rs.getString(7);
						String addres = rs.getString(8);
						String height = rs.getString(9);
						String weight = rs.getString(10);
						String membership = rs.getString(11);
						String image = rs.getString(12);
						String lol = rs.getString(13); 
						
						
						
						String [] row = {name,lastname,age,gender,dob,email,contact,addres,height,weight,membership,image,lol};
						model.addRow(row);
					}
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn1.setBounds(34, 195, 122, 65);
		contentPane.add(btn1);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home f=new home();
				f.show();
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBounds(34, 362, 122, 65);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Data List");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 60));
		lblNewLabel.setBounds(584, 33, 245, 58);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 102, 1095, 323);
		contentPane.add(scrollPane);
		
		tbldata = new JTable();
		scrollPane.setViewportView(tbldata);
		tbldata.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tbldata.setEnabled(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(232, 443, 1095, 247);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Pay List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
					PreparedStatement st1 = con.prepareStatement("select * from pay");
					ResultSet rs = st1.executeQuery();
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					
					while(rs.next()) {
						String name= rs.getString(1);
						String lname = rs.getString(2);
						String month=rs.getString(3);
						String amount = rs.getString(4);
						String lol = rs.getString(5);
						
						String [] row = {name,lname,month,amount,lol};
						model.addRow(row);
					}
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setBounds(34, 511, 122, 65);
		contentPane.add(btnNewButton_1);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 21, 1341, 684);
		contentPane.add(panel);
		panel.setLayout(null);
		
		

		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

	}
}
