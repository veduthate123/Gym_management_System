package ProjectDefault;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		
		super("Login");
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1382, 779);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 22, 365, 695);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\desktop-wallpaper-fitness-motivation-quotes-for-men-gym-funny-gym-thumbnail.jpg"));
		lblNewLabel.setBounds(10, 11, 345, 673);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(385, 23, 971, 695);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Label4 = new JLabel("UserName :\r\n");
		Label4.setBounds(261, 226, 143, 30);
		panel_1.add(Label4);
		Label4.setFont(new Font("Modern No. 20", Font.PLAIN, 27));
		Label4.setForeground(new Color(0, 0, 0));
		
		JLabel Label3 = new JLabel("LOGIN\r\n");
		Label3.setBounds(261, 124, 159, 40);
		panel_1.add(Label3);
		Label3.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 45));
		Label3.setForeground(new Color(0, 0, 0));
		Label3.setBackground(new Color(64, 0, 64));
		
		t1 = new JTextField();
		t1.setBounds(261, 255, 272, 30);
		panel_1.add(t1);
		t1.setToolTipText("");
		t1.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		t1.setColumns(10);
		
		JLabel Label5 = new JLabel("Password :");
		Label5.setBounds(261, 318, 125, 30);
		panel_1.add(Label5);
		Label5.setBackground(new Color(255, 255, 255));
		Label5.setForeground(new Color(0, 0, 0));
		Label5.setFont(new Font("Modern No. 20", Font.PLAIN, 27));
		
		t2 = new JPasswordField();
		t2.setBounds(261, 345, 272, 30);
		panel_1.add(t2);
		t2.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		t2.setEchoChar('*');
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setBounds(261, 380, 147, 23);
		panel_1.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					t2.setEchoChar((char)0);
				}else {
					t2.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		JButton btn4 = new JButton("Reset");
		btn4.setBounds(696, 506, 131, 53);
		panel_1.add(btn4);
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn4.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btn4.setBackground(new Color(192, 192, 192));
			}
		});
		btn4.setBackground(new Color(192, 192, 192));
		btn4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		
		JButton btn3 = new JButton("<html>Change<br/>Password</html>");
		btn3.setBounds(512, 507, 143, 54);
		panel_1.add(btn3);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn3.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn3.setBackground(new Color(192, 192, 192));
			}
		});
		btn3.setBackground(new Color(192, 192, 192));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				changepassword f=new changepassword();
				f.show();
			}
		});
		btn3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		
		JButton btn1 = new JButton("Login");
		btn1.setBounds(326, 505, 131, 54);
		panel_1.add(btn1);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn1.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btn1.setBackground(new Color(192, 192, 192));
			}
		});
		btn1.setBackground(new Color(192, 192, 192));
		btn1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(117, 507, 131, 53);
		panel_1.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(150, 150, 150));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(192, 192,192));
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home f=new home();
				f.show();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String uname = t1.getText();
				String upwd = t2.getText();
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
					
					PreparedStatement st = connection.prepareStatement("select * from users where uname = ? and upwd = ?");
					st.setString(1, uname);
					st.setString(2, upwd);
					ResultSet rs =st.executeQuery();
					if (rs.next()) {
						dispose();
						main ah = new main();
						ah.show();
						JOptionPane.showMessageDialog(null, "You Have Successfully login");
						
					} else if(t1.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Enter Username....!");
						t1.requestFocus();
						
					}else if (t2.getText().trim().isEmpty()){
						JOptionPane.showMessageDialog(null, "Enter Password....!");
						t2.requestFocus();
					}else{
						JOptionPane.showMessageDialog(null, "Wrong Username and Password");
						t1.setText("");
						t2.setText("");
						
						t1.requestFocus();
					}
					
				} catch(SQLException sqlexception){
					sqlexception.printStackTrace();
				}
			}
		});
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	}
}
	 