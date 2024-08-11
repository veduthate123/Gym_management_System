package ProjectDefault;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Canvas;

public class main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel_1 = new JLabel("ADMIN PAGE\r\n");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		super("Admin DassBoard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1382, 776);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 23, 1346, 691);
		contentPane.add(panel);
		panel.setLayout(null);
		lblNewLabel_1.setBounds(511, 156, 286, 47);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_1.setFont(new Font("Ravie", Font.PLAIN, 35));
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 984, 45);
		panel.add(menuBar);
		menuBar.setBackground(new Color(0, 0, 0));
		
		JMenu mnNewMenu = new JMenu("Add ");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Elephant", Font.ITALIC, 25));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Customer");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				addpage ah = new addpage();
				ah.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_2.setBackground(new Color(0, 0, 0));
		mntmNewMenuItem_2.setFont(new Font("Elephant", Font.ITALIC, 18));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Update ");
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setFont(new Font("Elephant", Font.ITALIC, 25));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Update Info");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				update ah = new update();
				ah.show();
			}
		});
		mntmNewMenuItem_3.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_3.setBackground(new Color(0, 0, 0));
		mntmNewMenuItem_3.setFont(new Font("Elephant", Font.ITALIC, 18));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Search");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		mnNewMenu_2.setFont(new Font("Elephant", Font.ITALIC, 28));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Search Info\r\n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				searc ah = new searc();
				ah.setVisible(true);
				
			}
		});
		mntmNewMenuItem.setBackground(new Color(0, 0, 0));
		mntmNewMenuItem.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem.setFont(new Font("Elephant", Font.ITALIC, 18));
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Delete Info");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				delete ah = new delete();
				ah.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_4.setBackground(new Color(0, 0, 0));
		mntmNewMenuItem_4.setFont(new Font("Elephant", Font.ITALIC, 18));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Fees Info\r\n");
		mnNewMenu_3.setFont(new Font("Elephant", Font.ITALIC, 25));
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		mnNewMenu_3.setBackground(new Color(240, 240, 240));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Customer Fees");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				payment ah = new payment();
				ah.show();
			}
		});
		mntmNewMenuItem_1.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_1.setBackground(new Color(0, 0, 0));
		mntmNewMenuItem_1.setFont(new Font("Elephant", Font.ITALIC, 20));
		mnNewMenu_3.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_4 = new JMenu("Exercise Rutein");
		mnNewMenu_4.setForeground(new Color(255, 255, 255));
		mnNewMenu_4.setBackground(new Color(0, 0, 0));
		mnNewMenu_4.setFont(new Font("Elephant", Font.ITALIC, 25));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Exercise Info");
		mntmNewMenuItem_5.setFont(new Font("Elephant", Font.ITALIC, 18));
		mntmNewMenuItem_5.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_5.setBackground(new Color(0, 0, 0));
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_5 = new JMenu("Reciept");
		mnNewMenu_5.setForeground(new Color(255, 255, 255));
		mnNewMenu_5.setBackground(new Color(0, 0, 0));
		mnNewMenu_5.setFont(new Font("Elephant", Font.ITALIC, 25));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Customer Receipt\r\n");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				report ah = new report();
				ah.show();
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Elephant", Font.ITALIC, 18));
		mntmNewMenuItem_6.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_6.setBackground(new Color(0, 0, 0));
		mnNewMenu_5.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Payment Receipt");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				report2 ah = new report2();
				ah.show();
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Elephant", Font.ITALIC, 18));
		mntmNewMenuItem_7.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_7.setBackground(new Color(0, 0, 0));
		mnNewMenu_5.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_6 = new JMenu("Logout");
		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Are you Sure...?");
				
				if (a == JOptionPane.YES_OPTION) {
					dispose();
					login obj = new login();
					obj.setVisible(true);
				}else if(a == JOptionPane.NO_OPTION) {
				dispose(); 
				main obj = new main();
				obj.setVisible(true);
			}
		}
		});
		
		mnNewMenu_6.setFont(new Font("Elephant", Font.ITALIC, 25));
		mnNewMenu_6.setBackground(new Color(0, 0, 0));
		mnNewMenu_6.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_6);
		
		JMenu mnNewMenu_7 = new JMenu("Exit");
		mnNewMenu_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main frame = new main();
				if(JOptionPane.showConfirmDialog(null, "Conform You want to exit","message", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		mnNewMenu_7.setForeground(new Color(255, 255, 255));
		mnNewMenu_7.setBackground(new Color(0, 0, 0));
		mnNewMenu_7.setFont(new Font("Elephant", Font.ITALIC, 25));
		menuBar.add(mnNewMenu_7);
		
		JLabel lblNewLabel = new JLabel("Gym Management System");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(SystemColor.inactiveCaption);
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 50));
		lblNewLabel.setBounds(373, 92, 555, 53);
		panel.add(lblNewLabel);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

	}
}
