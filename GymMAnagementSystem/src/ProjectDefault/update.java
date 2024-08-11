package ProjectDefault;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class update extends JFrame {

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
	private JComboBox comboBox;
    private JLabel lbl1;
    private String imagePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void refreshComboBox() {
        comboBox.removeAllItems(); // Clear existing items
        loadcombo(); // Reload items from the database
        comboBox.setSelectedItem(""); // Set the selected item to empty
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
	private void loadImage(String imagePath) {
	    try {
	        ImageIcon icon = new ImageIcon(imagePath);
	        Image image = icon.getImage().getScaledInstance(lbl1.getWidth(), lbl1.getHeight(), Image.SCALE_SMOOTH);
	        lbl1.setIcon(new ImageIcon(image));
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle the exception, for example, show a default image or a placeholder
	    }
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

    private void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
	/**
	 * Create the frame.
	 */
	public update() {
		super("Update");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 775);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		JLabel lblNewLabel = new JLabel("Update Customer Information\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setBounds(408, 42, 627, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(145, 173, 157, 35);
		contentPane.add(lblNewLabel_1);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt1.setBounds(327, 173, 229, 30);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(639, 167, 151, 35);
		contentPane.add(lblNewLabel_2);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt2.setBounds(814, 173, 229, 30);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Age :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(145, 242, 73, 35);
		contentPane.add(lblNewLabel_3);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt3.setBounds(327, 242, 229, 30);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(639, 236, 113, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date of Birth :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(145, 316, 173, 35);
		contentPane.add(lblNewLabel_5);
		
		txt5 = new JTextField();
		txt5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt5.setBounds(327, 316, 229, 30);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(640, 308, 99, 35);
		contentPane.add(lblNewLabel_6);
		
		txt6 = new JTextField();
		txt6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt6.setBounds(814, 308, 229, 30);
		contentPane.add(txt6);
		txt6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Contact :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(145, 388, 113, 35);
		contentPane.add(lblNewLabel_7);
		
		txt7 = new JTextField();
		txt7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt7.setBounds(327, 388, 229, 30);
		contentPane.add(txt7);
		txt7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Address :");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(639, 380, 120, 35);
		contentPane.add(lblNewLabel_8);
		
		txt8 = new JTextField();
		txt8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt8.setBounds(814, 380, 281, 116);
		contentPane.add(txt8);
		txt8.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Height :");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_9.setBounds(145, 468, 106, 30);
		contentPane.add(lblNewLabel_9);
		
		txt9 = new JTextField();
		txt9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt9.setBounds(327, 468, 229, 30);
		contentPane.add(txt9);
		txt9.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Weight :");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_10.setBounds(145, 536, 113, 30);
		contentPane.add(lblNewLabel_10);
		
		txt10 = new JTextField();
		txt10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txt10.setBounds(327, 536, 229, 30);
		contentPane.add(txt10);
		txt10.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Membership :");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_11.setBounds(639, 536, 173, 30);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				main f=new main();
				f.show();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(352, 627, 157, 61);
		contentPane.add(btnNewButton);
		
		combo4 = new JComboBox();
		combo4.setBackground(new Color(255, 255, 255));
		combo4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		combo4.setBounds(814, 242, 229, 30);
		contentPane.add(combo4);
		combo4.addItem("Select Gender");
		combo4.addItem("Male");
		combo4.addItem("Female");
		
		combo11 = new JComboBox();
		combo11.setBackground(new Color(255, 255, 255));
		combo11.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		combo11.setBounds(814, 536, 229, 30);
		contentPane.add(combo11);
		combo11.addItem("Select Membership");
		combo11.addItem("Normal");
		combo11.addItem("Preminum");
		combo11.addItem("Extra Preminum");
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				combo4.setSelectedItem("Male");
				txt5.setText("");
				txt6.setText("");
				txt7.setText("");
				txt8.setText("");
				txt9.setText("");
				txt10.setText("");
				combo11.setSelectedItem("Normal");
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(814, 627, 157, 61);
		contentPane.add(btnNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setEditable(true);
		comboBox.setBounds(137, 58, 237, 30);
		loadcombo();
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Vedant@123");
					PreparedStatement st1 = connection.prepareStatement("select name,lastname,age,gender,dob,email,contact,addres,height,weight,membership,image from data where name=?");
				
					String name = (String) comboBox.getSelectedItem();
					st1.setString(1, name);
					
					ResultSet rs = st1.executeQuery();
					if(rs.next()==false) {
						JOptionPane.showMessageDialog(null, "record not found");
						
						txt1.setText("");
						txt2.setText("");
						txt3.setText("");
						combo4.setSelectedItem("");
						txt5.setText("");
						txt6.setText("");
						txt7.setText("");
						txt8.setText("");
						txt9.setText("");
						txt10.setText("");
						combo11.setSelectedItem("");
						
						comboBox.requestFocus();
					}else {
						
						String name1 = rs.getString(1);
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
						String imagepath = rs.getString("image");

						
						txt1.setText(name1);
						txt2.setText(lastname);
						txt3.setText(age);
						combo4.setSelectedItem(gender);
						txt5.setText(dob);
						txt6.setText(email);
						txt7.setText(contact);
						txt8.setText(addres);
						txt9.setText(height);
						txt10.setText(weight);
						combo11.setSelectedItem(membership);
						loadImage(imagepath);
						
						comboBox.requestFocus();
					}
					connection.close();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(212, 99, 106, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
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
					PreparedStatement st1 = connection.prepareStatement("update data set name=?,lastname=?,age=?,gender=?,dob=?,email=?,contact=?,addres=?,height=?,weight=?,membership=?,image=? where name=?");
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
					st1.setString(13, (String) comboBox.getSelectedItem());
					
					int a = st1.executeUpdate();
					if(a > 0) {
					JOptionPane.showMessageDialog(null, "Data Updated Successfully");
					
					comboBox.setSelectedItem("");
					
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
					
					comboBox.requestFocus();
					refreshComboBox();
					
					}else {
					JOptionPane.showMessageDialog(null, "Search Record First.......!");
	
					comboBox.setSelectedItem("");
					
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
					
					comboBox.requestFocus();
					}
					connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.setBounds(587, 627, 152, 61);
		contentPane.add(btnNewButton_3);
		
		lbl1 = new JLabel("no image");
		lbl1.setBounds(1100, 170, 215, 181);
		contentPane.add(lbl1);
		
		JButton btnNewButton_4 = new JButton("Add Image");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose an image");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int result = fileChooser.showOpenDialog(update.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    // Store the file path
                    imagePath = selectedFile.getAbsolutePath();

                    // Display the selected image in the JLabel
                    ImageIcon icon = new ImageIcon(imagePath);
                    Image image = icon.getImage().getScaledInstance(lbl1.getWidth(), lbl1.getHeight(), Image.SCALE_SMOOTH);
                    lbl1.setIcon(icon);
                }

			}
		});
		btnNewButton_4.setBounds(1178, 388, 106, 46);
		contentPane.add(btnNewButton_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 21, 1340, 693);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	}
}
