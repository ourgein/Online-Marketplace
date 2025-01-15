package Online_Shopping_Platform;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class Orders extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private static final String DB_URL = "URL";
	private static final String USER = "root";
	private static final String PASS = "enteryourpassword";

	public Orders() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		String[] columnNames = { "Order Item ID", "Order ID", "Product ID", "Quantity", "Subtotal" };
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnNames);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	public void addItemToTable(Object[] rowData) {
		tableModel.addRow(rowData);
		insertOrderItem(rowData); // Call to insert the data into the database
	}

	private void insertOrderItem(Object[] rowData) {
		String sql = "INSERT INTO Order_item (order_item_id, order_id, product_id, quantity, subtotal) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// Check if the rowData contains valid data
			if (rowData[0] instanceof Integer) { // Assuming the first element should be an integer ID
				for (int i = 0; i < rowData.length; i++) {
					pstmt.setObject(i + 1, rowData[i]); // Ensure the data is set correctly for each column
				}
				pstmt.executeUpdate();
			} else {
				System.out.println(
						"Invalid data type encountered, not inserting to database: " + Arrays.toString(rowData));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
		}
	}

	public static void NewScreen_9() {
		EventQueue.invokeLater(() -> {
			try {
				Orders frame = new Orders();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
