package ProjectDefault;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;

public class searc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbldata;
	private JScrollPane scrollPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searc frame = new searc();
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
		void tableloaddata() {
	        try {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
	            PreparedStatement st1 = con.prepareStatement("select * from data");
	            ResultSet rs = st1.executeQuery();
	            DefaultTableModel model = (DefaultTableModel) tbldata.getModel();

	            int cols = rs.getMetaData().getColumnCount();
	            String[] colName = new String[cols];
	            for (int i = 0; i < cols; i++)
	                colName[i] = rs.getMetaData().getColumnName(i + 1);
	            model.setColumnIdentifiers(colName);

	            while (rs.next()) {
	                String name = rs.getString(1);
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
	                String image = rs.getString(12);
	                String lol = rs.getString(13);

	                String[] row = {name, lastname, age, gender, dob, email, contact, addres, height, weight, membership, image, lol};
	                model.addRow(row);
	            }
	            con.close();

	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }

		public searc() {
			super("Add Customer");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1376, 775);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(192, 192, 192));
			contentPane.setBackground(SystemColor.inactiveCaption);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 249, 1171, 440);
		contentPane.add(scrollPane);
		
		tbldata = new JTable();
		tbldata.setBackground(new Color(255, 255, 255));
		tbldata.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tableloaddata();
		scrollPane.setViewportView(tbldata);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				DefaultTableModel obj = (DefaultTableModel) tbldata.getModel();
				TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
				tbldata.setRowSorter(obj1);
				int columnIndex = 1;
				obj1.setRowFilter(RowFilter.regexFilter(textField.getText(),columnIndex));
				
			}
		});
		textField.setBounds(758, 174, 254, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter First Name :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(546, 174, 202, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_1.setBounds(608, 69, 157, 61);
		contentPane.add(lblNewLabel_1);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	}
}



