package Online_Shopping_Platform;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen_1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
					frame.setResizable(false);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 581);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Apple Braille", Font.BOLD, 22));
		lblNewLabel.setBounds(288, 250, 237, 39);
		contentPane.add(lblNewLabel);

		JLabel lblfre = new JLabel("Password");
		lblfre.setForeground(new Color(0, 0, 0));
		lblfre.setFont(new Font("Apple Braille", Font.BOLD, 22));
		lblfre.setBounds(288, 310, 227, 39);
		contentPane.add(lblfre);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shop", "root",
							"Darende250");

					Statement stm = con.createStatement();

					String username = textField.getText();
					String password = passwordField.getText();

					PreparedStatement ps = con.prepareStatement("SELECT*FROM customer WHERE username=? AND password=?");
					ps.setString(1, username);
					ps.setString(2, password);

					ResultSet rs = ps.executeQuery();

					if (rs.next()) {

						JOptionPane.showMessageDialog(null, "Login succesfully!");
						setVisible(false);
						products page = new products(username);
						page.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Username or Password invalid!!!");
						textField.setText("");
						passwordField.setText("");
						con.close();

					}
				} catch (Exception e1) {
					System.out.println(e1.getMessage());

				}

			}
		});
		btnNewButton.setBounds(467, 372, 157, 39);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(467, 250, 245, 39);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(467, 310, 245, 39);
		contentPane.add(passwordField);

		ImageIcon icon = new ImageIcon("src/Image/login.png"); // Correct file path
        JLabel label = new JLabel(icon);
        label.setBounds(448, 109, 117, 128); // Set the bounds for the label
        contentPane.add(label);


		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src/Image/back.png"));
		lblNewLabel_1.setBounds(0, 0, 1280, 700);
		contentPane.add(lblNewLabel_1);
	}
}