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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Update_stock extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void NewScreen_8() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_stock frame = new Update_stock();
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
	public Update_stock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name of the Product to Update");
		lblNewLabel.setBounds(16, 69, 196, 16);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(213, 64, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("New Stock of the Product");
		lblNewLabel_1.setBounds(16, 107, 185, 16);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(213, 102, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Update Item");
		btnNewButton.setBounds(145, 171, 117, 29);
		contentPane.add(btnNewButton);

		// Add ActionListener to the button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productName = textField.getText();
				String newStock = textField_1.getText();
				updateStock(productName, newStock);
			}
		});
	}

	/**
	 * Update the stock of the product in the database.
	 */
	private void updateStock(String productName, String newStock) {
		String url = "URL"; // Change to your database URL
		String user = "root"; // Change to your database username
		String password = "enteryourpassword"; // Change to your database password

		String sql = "UPDATE Product SET stock = ? WHERE name = ?"; // Change to your table and column names

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, Integer.parseInt(newStock));
			pstmt.setString(2, productName);
			int affectedRows = pstmt.executeUpdate();

			if (affectedRows > 0) {
				JOptionPane.showMessageDialog(null, "Product stock updated successfully.");
				System.out.println("Product stock updated successfully.");
			} else {
				JOptionPane.showMessageDialog(null, "Product not found.");
				System.out.println("Product not found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Invalid stock value. Please enter a valid number.");
		}
	}
}
