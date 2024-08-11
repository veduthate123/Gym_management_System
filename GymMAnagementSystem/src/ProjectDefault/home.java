 package ProjectDefault;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		super("Home");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1379, 776);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Gym Management System");
		lblNewLabel.setForeground(new Color(255, 128, 64));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(344, 96, 754, 52);
		contentPane.add(lblNewLabel);
		
		Button btn1 = new Button("Login");
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
		btn1.setForeground(new Color(0, 0, 0));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login f=new login();
				f.show();
			}
		});
		btn1.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 25));
		btn1.setBounds(902, 578, 138, 65);
		contentPane.add(btn1);
		
		JButton btnNewButton = new JButton("Data List");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(150, 150, 150));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(192, 192, 192));
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				listdata f=new listdata();
				f.show();
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBounds(344, 578, 138, 65);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Only For UniSex Gym....");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		lblNewLabel_1.setBounds(518, 145, 401, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\GymMAnagementSystem\\images\\logo11.jpg"));
		lblNewLabel_3.setBounds(81, 72, 238, 186);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("WWW.unisex.com");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(459, 677, 200, 29);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Contact : 9379696857");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(728, 677, 238, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\fitness-gym-and-equipment-photography-dn9w2z4r8yd2wi47.jpg"));
		lblNewLabel_5.setBounds(24, 23, 1316, 691);
		contentPane.add(lblNewLabel_5);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	
	}
}
