package Online_Shopping_Platform;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class admin_signup extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen_4() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_signup frame = new admin_signup();
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
	public admin_signup() {
		setTitle("Admin Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adminName = name.getText();
				String adminEmail = email.getText();
				String adminPassword = new String(passwordField.getPassword());

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shop", "root",
							"Darende250");
					String query = "INSERT INTO admin (name, email, password) VALUES (?, ?, ?)";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, adminName);
					pstmt.setString(2, adminEmail);
					pstmt.setString(3, adminPassword);
					pstmt.executeUpdate();
					con.close();

					adminpanel nw = new adminpanel();
					adminpanel.NewScreen_2();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(170, 180, 117, 29);
		contentPane.add(btnNewButton);

		name = new JTextField();
		name.setBounds(170, 48, 130, 26);
		contentPane.add(name);
		name.setColumns(10);

		email = new JTextField();
		email.setBounds(170, 91, 130, 26);
		contentPane.add(email);
		email.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(170, 142, 124, 26);
		contentPane.add(passwordField);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(90, 53, 61, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(90, 96, 61, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(90, 147, 61, 16);
		contentPane.add(lblNewLabel_2);
	}
}
