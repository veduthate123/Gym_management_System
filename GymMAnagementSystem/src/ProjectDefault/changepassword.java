package ProjectDefault;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class changepassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changepassword frame = new changepassword();
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
	public changepassword() {
		super("changepassword");
		setResizable(false);
		setBackground(new Color(255, 128, 128));
		setDefaultCloseOperation(JFrame.CENTER_ALIGNMENT);
		setBounds(100, 100, 647, 252);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField txt1 = new JTextField();
		txt1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		txt1.setBounds(310, 57, 256, 31);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JButton btn1 = new JButton("Submit");
		btn1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btn1.setBackground(new Color(192, 192, 192));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				String upwd = txt1.getText();
				try {
//					System.out.println("Update password name " + upwd);
//					System.out.println("update password");
//					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
					PreparedStatement st =con.prepareStatement("Update users set upwd=?");
					
					st.setString(1, upwd);
					st.executeUpdate();
					if (txt1.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(btn1, "Enter New Password..!");
						txt1.requestFocus();
					} else  {
						
						JOptionPane.showMessageDialog(btn1, "Password Updated Successfully..!");
						dispose();
						login ah = new login();
						ah.show();
					}
				
				} catch(SQLException sqlException){
					sqlException.printStackTrace();
				}
				
				}
			});
		btn1.setBounds(165, 119, 113, 49);
		contentPane.add(btn1);
		
		JLabel lblNewLabel = new JLabel("Enter New Password :-\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(69, 57, 238, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login ah = new login();
				ah.show();
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBounds(305, 121, 113, 49);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 11, 611, 191);
		contentPane.add(panel);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	}

	private void setDefaultCloseOperation(float centerAlignment) {
		// TODO Auto-generated method stub
		
	}
}
