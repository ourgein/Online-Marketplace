package Online_Shopping_Platform;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.util.regex.Pattern;
import javax.swing.JButton;

public class sign_up {

	public JFrame frmSignUp;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_up window = new sign_up();
					window.frmSignUp.setVisible(true);
					window.frmSignUp.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sign_up() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUp = new JFrame();
		frmSignUp.setTitle("Sign Up");
		frmSignUp.setBounds(100, 100, 1039, 700);
		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignUp.getContentPane().setLayout(null);

		TextField user_text = new TextField();
		user_text.setBounds(435, 82, 236, 33);
		user_text.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
		frmSignUp.getContentPane().add(user_text);

		TextField email_text = new TextField();
		email_text.setBounds(435, 142, 236, 33);
		frmSignUp.getContentPane().add(email_text);

		TextField name_text = new TextField();
		name_text.setBounds(435, 200, 236, 33);
		frmSignUp.getContentPane().add(name_text);

		TextField phone_text = new TextField();
		phone_text.setBounds(435, 258, 236, 33);
		frmSignUp.getContentPane().add(phone_text);

		TextField address_text = new TextField();
		address_text.setBounds(435, 316, 236, 33);
		frmSignUp.getContentPane().add(address_text);

		JPasswordField password_text = new JPasswordField();
		password_text.setBounds(435, 374, 236, 33);
		frmSignUp.getContentPane().add(password_text);

		JPasswordField password_text_again = new JPasswordField();
		password_text_again.setBounds(435, 432, 236, 33);
		frmSignUp.getContentPane().add(password_text_again);

		Button button = new Button("Sign Up");
		button.setBounds(464, 491, 140, 43);
		button.setFont(new Font("Apple Symbols", Font.BOLD, 22));
		button.setForeground(UIManager.getColor("Button.foreground"));
		button.setBackground(UIManager.getColor("Button.background"));
		frmSignUp.getContentPane().add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shop", "root",
							"enteryourpassword");

					String username = user_text.getText();
					String email = email_text.getText();
					String name = name_text.getText();
					String address = address_text.getText();
					String phone = phone_text.getText();
					String password = new String(password_text.getPassword());
					String password_a = new String(password_text_again.getPassword());

					if (username.isEmpty() || email.isEmpty() || name.isEmpty() || address.isEmpty() || phone.isEmpty()
							|| password.isEmpty() || password_a.isEmpty()) {
						JOptionPane.showMessageDialog(null, "All the fields must be filled");
					} else if (!isValidEmail(email)) {
						JOptionPane.showMessageDialog(null, "Invalid email format!");
					} else if (!password.equals(password_a)) {
						JOptionPane.showMessageDialog(null, "Passwords do not match!");
					} else {
						PreparedStatement ps = con.prepareStatement(
								"INSERT INTO customer (username, password, email, name, address, phone) VALUES (?, ?, ?, ?, ?, ?)");
						ps.setString(1, username);
						ps.setString(2, password);
						ps.setString(3, email);
						ps.setString(4, name);
						ps.setString(5, address);
						ps.setString(6, phone);

						int rowsAffected = ps.executeUpdate(); // Use executeUpdate() for INSERT

						if (rowsAffected > 0) {
							JOptionPane.showMessageDialog(null, "Sign Up Successful!");
							openProductsPage(); // Sign Up başarılı olduğunda products sayfasını aç
						} else {
							JOptionPane.showMessageDialog(null, "Sign Up Failed!");
						}
					}

					con.close(); // Close the connection after use

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()); // Display specific error message
					ex.printStackTrace(); // Print the stack trace for debugging
				}
			}
		});

		Label label_1 = new Label("Fast, Secure, Efficient Marketplace");
		label_1.setBounds(317, 10, 454, 38);
		label_1.setAlignment(Label.CENTER);
		label_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 23));
		frmSignUp.getContentPane().add(label_1);

		Label label_2 = new Label("Username");
		label_2.setBounds(297, 82, 172, 33);
		label_2.setAlignment(Label.CENTER);
		frmSignUp.getContentPane().add(label_2);

		Label email = new Label("E-Mail");
		email.setBounds(297, 142, 172, 33);
		email.setBackground(new Color(238, 237, 237));
		email.setAlignment(Label.CENTER);
		frmSignUp.getContentPane().add(email);

		Label name = new Label("Name");
		name.setBounds(297, 200, 172, 33);
		name.setBackground(new Color(238, 237, 237));
		name.setAlignment(Label.CENTER);
		frmSignUp.getContentPane().add(name);

		Label phone = new Label("Phone");
		phone.setBounds(297, 258, 172, 33);
		phone.setBackground(new Color(238, 237, 237));
		phone.setAlignment(Label.CENTER);
		frmSignUp.getContentPane().add(phone);

		Label address = new Label("Address");
		address.setBounds(297, 316, 172, 33);
		address.setBackground(new Color(238, 237, 237));
		address.setAlignment(Label.CENTER);
		frmSignUp.getContentPane().add(address);

		Label passwordd = new Label("Password");
		passwordd.setBounds(297, 374, 172, 33);
		passwordd.setAlignment(Label.CENTER);
		frmSignUp.getContentPane().add(passwordd);

		Label password_again = new Label("Password (again)");
		password_again.setBounds(286, 432, 172, 33);
		password_again.setAlignment(Label.CENTER);
		frmSignUp.getContentPane().add(password_again);
	}

	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		return email != null && pat.matcher(email).matches();
	}

	// New method to open the products page
	public void openProductsPage() throws ClassNotFoundException, SQLException, IOException {
		products page = new products();
		page.setVisible(true);
		frmSignUp.dispose(); // Close the Sign Up page
	}
}
