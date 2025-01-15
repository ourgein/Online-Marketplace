package Online_Shopping_Platform;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Add_Product {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Product window = new Add_Product();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_Product() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 952, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 242, 242));
		panel.setBounds(0, 0, 1080, 700);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("My Products");
		btnNewButton.setBounds(240, 21, 117, 29);
		panel.add(btnNewButton);

		JButton btnOrders = new JButton("Orders");
		btnOrders.setBounds(255, 21, 117, 29);
		frame.getContentPane().add(btnOrders);

		JButton btnNewButton_1_1 = new JButton("Drop Items");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drop_items nw = new Drop_items();
				nw.NewScreen_7();
			}
		});
		btnNewButton_1_1.setBounds(384, 21, 140, 29);
		panel.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Update Items");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_stock nw = new Update_stock();
				nw.NewScreen_8();
			}
		});
		btnNewButton_1_2.setBounds(536, 21, 117, 29);
		panel.add(btnNewButton_1_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Name",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(593, 80, 262, 59);
		panel.add(panel_2);
		panel_2.setLayout(null);

		textField = new JTextField();
		textField.setBounds(6, 18, 250, 35);
		panel_2.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/iefeatas/Downloads/mba13-midnight-select-202402.jpg"));
		lblNewLabel.setBounds(100, 98, 322, 300);
		panel.add(lblNewLabel);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Price (\u20BA)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1.setBounds(593, 164, 262, 59);
		panel.add(panel_2_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(6, 18, 250, 35);
		panel_2_1.add(textField_1);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Stock",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_2.setBounds(593, 250, 262, 59);
		panel.add(panel_2_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(6, 18, 250, 35);
		panel_2_2.add(textField_2);

		JButton btnNewButton_3 = new JButton("Upload Product");
		btnNewButton_3.setBounds(593, 334, 270, 50);
		panel.add(btnNewButton_3);

		// Add action listener to the "Upload Product" button
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String price = textField_1.getText();
				String stock = textField_2.getText();
				// Call method to upload product details to MySQL database
				uploadProduct(name, price, stock);
				JOptionPane.showMessageDialog(null, "Successfully Add!");
			}
			
		});
	}

	/**
	 * Method to upload product details to MySQL database.
	 */
	private void uploadProduct(String name, String price, String stock) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/Shop"; // Replace with your database URL
		String jdbcUser = "root"; // Replace with your database username
		String jdbcPassword = "Darende250"; // Replace with your database password

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// Establish a connection to the database
			connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

			// Prepare SQL insert statement
			String sql = "INSERT INTO Product (name, price, stock) VALUES (?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, price);
			preparedStatement.setString(3, stock);
			// Execute the insert statement
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new product was inserted successfully!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close resources
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}