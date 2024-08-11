package ProjectDefault;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.FlowLayout;

public class addpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JComboBox combo4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	private JTextField txt10;
	private JComboBox combo11;
	private String imagePath;
	private JButton btn4;
	private JLabel lbl_img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addpage frame = new addpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	    private boolean validateInputs() {
	        if (!validateName()) return false;
	        if (!validateLastName()) return false;
	        if (!validateAge()) return false;
	        if (!validateGender()) return false;
	        if (!validateDOB()) return false;
	        if (!validateEmail()) return false;
	        if (!validateContact()) return false;
	        if (!validateAddress()) return false;
	        if (!validateHeight()) return false;
	        if (!validateWeight()) return false;
	        if (!validateMembership()) return false;
	        if (!validateImage()) return false;

	        return true;
	    }

	    // Validation methods for each field

	    private boolean validateName() {
	        String name = txt1.getText();
	        if (name.isEmpty()) {
	            showMessage("Please enter a First Name.", "Validation Error");
	            txt1.requestFocus();
	            return false;
	        }
	        if (!name.matches("[a-zA-Z]+")) {
	            showMessage("Please enter a valid Name with alphabets only.", "Validation Error");
	            txt1.setText("");
	            txt1.requestFocus();
	            return false;
	        }
	        return true;
	    }

	    private boolean validateLastName() {
	        String lastName = txt2.getText();
	        if (lastName.isEmpty()) {
	            showMessage("Please enter a Last Name.", "Validation Error");
	            txt2.requestFocus();
	            return false;
	        }
	        if (!lastName.matches("[a-zA-Z]+")) {
	            showMessage("Please enter a valid Name with alphabets only.", "Validation Error");
	            txt2.setText("");
	            txt2.requestFocus();
	            return false;
	        }
	        return true;
	    }

	    private boolean validateAge() {
	        String age = txt3.getText();
	        if (age.isEmpty()) {
	            showMessage("Please enter an Age.", "Validation Error");
	            txt3.requestFocus();
	            return false;
	        }
	        return true;
	    }

	    private boolean validateGender() {
	    	 Object selectedGender = combo4.getSelectedItem();
	    	    if (selectedGender == "Select Gender") {
	    	        showMessage("Please select a Gender.", "Validation Error");
	    	        combo4.requestFocus();
	    	        return false;
	    	    }
	        return true;
	    }

	    private boolean validateDOB() {
	        String dob = txt5.getText();
	        if (dob.isEmpty()) {
	            showMessage("Please enter a Date of Birth.", "Validation Error");
	            txt5.requestFocus();
	            return false;
	        }
	        return true;
	    }

	    private boolean validateEmail() {
	        String email = txt6.getText();
	   	        if (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
	            showMessage("Please enter a valid Email address.", "Validation Error");
	            txt6.setText("");
	            txt6.requestFocus();
	            return false;
	        }
	        return true;
	    }

	    private boolean validateContact() {
	        String contact = txt7.getText();
	        if (contact.isEmpty()) {
	            showMessage("Please enter a Contact number.", "Validation Error");
	            txt7.requestFocus();
	            return false;
	        }
	        if (!contact.matches("\\d{10}")) {
	            showMessage("Please enter a valid 10-digit Contact number.", "Validation Error");
	            txt7.setText("");
	            txt7.requestFocus();
	            return false;
	        }
	        return true;
	    }

	    private boolean validateAddress() {
	        String address = txt8.getText();
	        if (address.isEmpty()) {
	            showMessage("Please enter an Address.", "Validation Error");
	            txt8.requestFocus();
	            return false;
	        }
	        return true;
	    }

	    private boolean validateHeight() {
	    	 String heightStr = txt9.getText().trim();

	    	    if (heightStr.isEmpty()) {
	    	        showMessage("Please enter a Height.", "Validation Error");
	    	        txt9.requestFocus();
	    	        return false;
	    	    }

	    	    try {
	    	        double height = Double.parseDouble(heightStr);

	    	        // Assuming a reasonable range for height (adjust as needed)
	    	        if (height < 50 || height > 170) {
	    	            showMessage("Please enter a valid Height between 50 and 170 CM.", "Validation Error");
	    	            txt9.setText("");
	    	            txt9.requestFocus();
	    	            return false;
	    	        }

	    	    } catch (NumberFormatException e) {
	    	        showMessage("Please enter a valid numeric Height.", "Validation Error");
	    	        txt9.setText("");
	    	        txt9.requestFocus();
	    	        return false;
	    	    }
	        return true;
	    }

	    private boolean validateWeight() {
	    	String weightStr = txt10.getText().trim();

	        if (weightStr.isEmpty()) {
	            showMessage("Please enter a Weight.", "Validation Error");
	            txt10.requestFocus();
	            return false;
	        }

	        try {
	            double weight = Double.parseDouble(weightStr);

	            // Assuming a reasonable range for weight (adjust as needed)
	            if (weight < 10 || weight > 100) {
	                showMessage("Please enter a valid Weight between 10 and 100 KG.", "Validation Error");
	                txt10.setText("");
	                txt10.requestFocus();
	                return false;
	            }

	        } catch (NumberFormatException e) {
	            showMessage("Please enter a valid numeric Weight.", "Validation Error");
	            txt10.setText("");
	            txt10.requestFocus();
	            return false;
	        }	        return true;
	    }

	    private boolean validateMembership() {
	    	Object selectedMembership = combo11.getSelectedItem();
    	    if (selectedMembership == "Select Membership") {
    	        showMessage("Please select a Membership.", "Validation Error");
    	        combo11.requestFocus();
    	        return false;
    	    }
	        return true;
	    }
	    
	    private boolean validateImage() {
	        if (imagePath == null || imagePath.isEmpty()) {
	            showMessage("Please select an image.", "Validation Error");
	            btn4.requestFocusInWindow();
	            return false;
	        }
	        return true;
	    }

	    private void showMessage(String message, String title) {
	        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	    }
	 /**
	 * Create the frame.
	 */
	public addpage() {
		super("Add Customer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 775);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Registration\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setBounds(482, 43, 431, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(124, 149, 133, 30);
		contentPane.add(lblNewLabel_1);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt1.setBounds(307, 149, 222, 30);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name :\r\n");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(575, 146, 127, 30);
		contentPane.add(lblNewLabel_2);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt2.setBounds(746, 149, 229, 31);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\r\nAge :");
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(128, 227, 61, 30);
		contentPane.add(lblNewLabel_3);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt3.setBounds(309, 224, 222, 30);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(578, 226, 101, 30);
		contentPane.add(lblNewLabel_4);
		
		combo4 = new JComboBox();
		combo4.setBackground(new Color(255, 255, 255));
		combo4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		combo4.setBounds(746, 227, 229, 30);
		contentPane.add(combo4);
		combo4.addItem("Select Gender");
		combo4.addItem("Male");
		combo4.addItem("Female");
		combo4.setSelectedIndex(0);
		
		JLabel lblNewLabel_5 = new JLabel("Date of Birth :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(124, 304, 180, 30);
		contentPane.add(lblNewLabel_5);
		
		txt5 = new JTextField();
		txt5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt5.setBounds(310, 304, 222, 30);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(575, 302, 94, 30);
		contentPane.add(lblNewLabel_6);
		
		txt6 = new JTextField();
		txt6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt6.setBounds(746, 308, 228, 30);
		contentPane.add(txt6);
		txt6.setColumns(10);
		
		txt7 = new JTextField();
		txt7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt7.setBounds(309, 377, 220, 31);
		contentPane.add(txt7);
		txt7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Address :");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(575, 381, 121, 30);
		contentPane.add(lblNewLabel_8);
		
		txt8 = new JTextField();
		txt8.setScrollOffset(1);
		txt8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt8.setBounds(746, 384, 306, 106);
		contentPane.add(txt8);
		txt8.setColumns(10);
		
		txt9 = new JTextField();
		txt9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt9.setBounds(307, 451, 222, 30);
		contentPane.add(txt9);
		txt9.setColumns(10);
		
		txt10 = new JTextField();
		txt10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txt10.setBounds(307, 521, 222, 30);
		contentPane.add(txt10);
		txt10.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("MemberShip :");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_11.setBounds(575, 523, 180, 28);
		contentPane.add(lblNewLabel_11);
		
		combo11 = new JComboBox();
		combo11.setBackground(new Color(255, 255, 255));
		combo11.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		combo11.setBounds(746, 525, 234, 30);
		combo11.addItem("Select Membership");
		contentPane.add(combo11);
		combo11.addItem("Normal");
		combo11.addItem("Preminum");
		combo11.addItem("Extra Preminum");
		combo11.setSelectedIndex(0);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 21, 1340, 693);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Contact :");
		lblNewLabel_7.setBounds(114, 358, 113, 24);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JLabel lblNewLabel_9 = new JLabel("Height :");
		lblNewLabel_9.setBounds(114, 431, 102, 30);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JLabel lblNewLabel_10 = new JLabel("Weight :");
		lblNewLabel_10.setBounds(114, 500, 109, 30);
		panel.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JButton btn1 = new JButton("Back");
		btn1.setBounds(189, 587, 127, 60);
		panel.add(btn1);
		btn1.setBackground(new Color(192, 192, 192));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				main f=new main();
				f.show();
			}
		});
		btn1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		
		JButton btn2 = new JButton("Submit");
		btn2.setBounds(435, 586, 121, 61);
		panel.add(btn2);
		btn2.setBackground(new Color(192, 192, 192));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						String name = txt1.getText();
						String lastname = txt2.getText();
						String age = txt3.getText();
						String gender = (String) combo4.getSelectedItem();
						String dob = txt5.getText();
						String email = txt6.getText();
						String contact = txt7.getText();
						String addres = txt8.getText();
						String height = txt9.getText();
						String weight = txt10.getText();
						String membership = (String) combo11.getSelectedItem();
				
		if (validateInputs()) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
					
					PreparedStatement st1 = connection.prepareStatement("INSERT INTO data(name,lastname,age,gender,dob,email,contact,addres,height,weight,membership,image) values(?,?,?,?,?,?,?,?,?,?,?,?)");
					st1.setString(1, name);
					st1.setString(2, lastname);
					st1.setString(3, age);
					st1.setString(4, gender);
					st1.setString(5, dob);
					st1.setString(6, email);
					st1.setString(7, contact);
					st1.setString(8, addres);
					st1.setString(9, height);
					st1.setString(10, weight);
					st1.setString(11, membership);
					st1.setString(12, imagePath);
						
					int a = st1.executeUpdate();
					if (a > 0) {
						JOptionPane.showMessageDialog(null, "Data Added Successfully");
						
						txt1.setText("");
						txt2.setText("");
						txt3.setText("");
						combo4.setSelectedIndex(0);
						txt5.setText("");
						txt6.setText("");
						txt7.setText("");
						txt8.setText("");
						txt9.setText("");
						txt10.setText("");
						combo11.setSelectedIndex(0);
						lbl_img.setIcon(new ImageIcon("C:\\Users\\admin\\Documents\\ved.jpg"));
						
						txt1.requestFocus();
					}
					else {
						JOptionPane.showMessageDialog(null, "Enter the data First");
					}
					
					connection.close();
					
				} catch(SQLException sqlexception){
					sqlexception.printStackTrace();
				}
			}
		}
		});
		btn2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		
		JButton btn = new JButton("Reset\r\n");
		btn.setBounds(661, 586, 113, 61);
		panel.add(btn);
		btn.setBackground(new Color(192, 192, 192));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				combo4.setSelectedIndex(0);
				txt5.setText("");
				txt6.setText("");
				txt7.setText("");
				txt8.setText("");
				txt9.setText("");
				txt10.setText("");
				combo11.setSelectedIndex(0);
				lbl_img.setIcon(new ImageIcon("C:\\Users\\admin\\Documents\\ved.jpg"));
				
				txt1.requestFocus();
				
			}
		});
		btn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		
		btn4 = new JButton("Add Image");
		btn4.setBounds(1111, 344, 141, 53);
		panel.add(btn4);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JFileChooser fileChooser = new JFileChooser();
	                fileChooser.setDialogTitle("Choose an image");
	                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	                fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));
	                int result = fileChooser.showOpenDialog(addpage.this);

	                if (result == JFileChooser.APPROVE_OPTION) {
	                    File selectedFile = fileChooser.getSelectedFile();

	                    // Store the file path
	                    imagePath = selectedFile.getAbsolutePath();

	                    // Display the selected image in the JLabel
	                    ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH));
	                    lbl_img.setIcon(icon);
	                }
			}
		});
		btn4.setBackground(new Color(192, 192, 192));
		btn4.setFont(new Font("Times New Roman", Font.ITALIC, 23));
		
		
		lbl_img = new JLabel("");
		lbl_img.setBounds(1101, 138, 193, 201);
		panel.add(lbl_img);
		lbl_img.setIcon(new ImageIcon("C:\\Users\\admin\\Documents\\ved.jpg"));
		lbl_img.setBackground(new Color(255, 255, 255));
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	
	}
}

