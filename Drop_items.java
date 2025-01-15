package Online_Shopping_Platform;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Drop_items extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen_7() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drop_items frame = new Drop_items();
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
	public Drop_items() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Drop Item");
		btnNewButton.setBounds(199, 122, 117, 29);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Name of the Product");
		lblNewLabel.setBounds(27, 78, 150, 16);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(189, 73, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		// Add ActionListener to the button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productName = textField.getText();
				dropProduct(productName);
			}
		});
	}

	/**
	 * Drop product from the database.
	 */
	private void dropProduct(String productName) {
		String url = "jdbc:mysql://localhost:3306/Shop"; // Change to your database URL
		String user = "root"; // Change to your database username
		String password = "Darende250"; // Change to your database password

		String sql = "DELETE FROM Product WHERE name = ?"; // Change to your table and column names

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, productName);
			int affectedRows = pstmt.executeUpdate();

			if (affectedRows > 0) {
				System.out.println("Product dropped successfully.");
			} else {
				System.out.println("Product not found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
