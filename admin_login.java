package Online_Shopping_Platform;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class admin_login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen_3() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_login frame = new admin_login();
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
	public admin_login() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adminName = textField.getText();
				String adminPassword = new String(passwordField.getPassword());

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shop", "root",
							"Darende250");
					String query = "SELECT * FROM admin WHERE name = ? AND password = ?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, adminName);
					pstmt.setString(2, adminPassword);
					ResultSet rs = pstmt.executeQuery();

					if (rs.next()) {
						// Login successful
						JOptionPane.showMessageDialog(null, "Login Succesfully!");
						adminpanel nw = new adminpanel();
						adminpanel.NewScreen_2();
					} else {
						// Login failed
						JOptionPane.showMessageDialog(null, "Invalid credentials!");
						System.out.println("Invalid credentials");
					}
					con.close();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(164, 173, 117, 29);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(151, 67, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(151, 122, 130, 26);
		contentPane.add(passwordField);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(65, 72, 61, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(65, 127, 61, 16);
		contentPane.add(lblNewLabel_1);
	}
}
