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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class payment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextField txt1;
	private JTextField txt2;
	private JComboBox combo3;
	private JComboBox combo4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment();
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
	
	 /**
     * Validate the input fields.
     */
    private boolean validateFields() {
        String name = txt1.getText();
        String lastName = txt2.getText();
        String selectedMonth = (String) combo3.getSelectedItem();
        String selectedAmount = (String) combo4.getSelectedItem();

        if (name.trim().isEmpty() || lastName.trim().isEmpty()) {
            showMessage("Please Search both First Name and Last Name.", "Validation Error");
            comboBox.requestFocus();
            return false;
        }

        if ("Select Month".equals(selectedMonth)) {
            showMessage("Please select a valid Month.", "Validation Error");
            combo4.requestFocus();
            return false;
        }
        
        if ("Select amount".equals(selectedAmount)) {
            showMessage("Please select a valid Amount.", "Validation Error");
            combo4.requestFocus();
            return false;
        }

        return true;
    }

    /**
     * Show a message dialog.
     */
    private void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }

	/**
	 * Create the frame.
	 */
	public payment() {
		super("Add Customer");
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
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
					PreparedStatement st1 = connection.prepareStatement("select name,lastname from data where name=?");
				
					String name = (String) comboBox.getSelectedItem();
					st1.setString(1, name);
					
					ResultSet rs = st1.executeQuery();
					if(rs.next()==false) {
						JOptionPane.showMessageDialog(null, "record not found");
						
						txt1.setText("");
						txt2.setText("");
						
						comboBox.requestFocus();
					}else {
						
						String name1 = rs.getString(1);
						String lastname = rs.getString(2);
						
						txt1.setText(name1);
						txt2.setText(lastname);
						
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
		txt1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt1.setBounds(707, 295, 238, 27);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name          :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(479, 348, 218, 27);
		contentPane.add(lblNewLabel_2);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt2.setBounds(707, 348, 238, 27);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		combo3 = new JComboBox();
		combo3.setBackground(new Color(255, 255, 255));
		combo3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		combo3.setBounds(707, 417, 238, 27);
		contentPane.add(combo3);
		combo3.addItem("Select Month");
		combo3.addItem("Jan - Feb");
		combo3.addItem("March - April");
		combo3.addItem("May - June");
		combo3.addItem("July - Aug");
		combo3.addItem("Sept - Oct");
		combo3.addItem("Nov - Dec");
		combo3.setSelectedIndex(0);
	
		JLabel lblNewLabel_4 = new JLabel("Month                :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(479, 417, 218, 27);
		contentPane.add(lblNewLabel_4);
		
		combo4 = new JComboBox();
		combo4.setBackground(new Color(255, 255, 255));
		combo4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		combo4.setBounds(707, 477, 238, 27);
		contentPane.add(combo4);
		combo4.addItem("Select Amount");
		combo4.addItem("900RS");
		combo4.addItem("1500RS");
		combo4.addItem("2000RS");
		combo3.setSelectedIndex(0);
		
		JButton btnNewButton_1 = new JButton("Pay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if (validateFields()) {
				String name = txt1.getText();
				String lname = txt2.getText();
				String month = (String) combo3.getSelectedItem();
				String amount = (String) combo4.getSelectedItem();
				
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
			
			PreparedStatement st1 = connection.prepareStatement("INSERT INTO pay(name,lname,month,amount) values(?,?,?,?)");
			st1.setString(1, name);
			st1.setString(2, lname);
			st1.setString(3, month);
			st1.setString(4, amount);
			
			
				
			int a = st1.executeUpdate();
			if (a > 0) {
				JOptionPane.showMessageDialog(null, "Payment Successfully");
				
				txt1.setText("");
				txt2.setText("");
				combo3.setSelectedIndex(0);
				combo4.setSelectedIndex(0);
				
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Enter the record First");
			}
			
			connection.close();
				
				} catch(SQLException sqlexception){
						sqlexception.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_1.setBounds(660, 546, 127, 53);
		contentPane.add(btnNewButton_1);
		
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
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt1.setText("");
				txt2.setText("");
				combo3.setSelectedIndex(0);
				combo4.setSelectedIndex(0);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.setBounds(826, 546, 119, 53);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 22, 1340, 691);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	
	}
}
