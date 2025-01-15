package Online_Shopping_Platform;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class adminpanel {

	public JFrame frmAdminPanel;
	private JTable table;

	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void NewScreen_2() throws SQLException, ClassNotFoundException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpanel window = new adminpanel();
					window.frmAdminPanel.setVisible(true);
					window.frmAdminPanel.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public adminpanel() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmAdminPanel = new JFrame();
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Image/logo.png"));
		frmAdminPanel.getContentPane().setBackground(new Color(176, 196, 222));
		frmAdminPanel.setBounds(100, 100, 962, 489);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.getContentPane().setLayout(null);

		// Diğer komponentlerinizin eklenmesi...

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 90, 846, 259);
		frmAdminPanel.getContentPane().add(scrollPane);

		JTable table = new JTable();
		table.setBackground(SystemColor.window);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		scrollPane.setViewportView(table);

		// Veritabanı bağlantısı
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shop", "root", "Darende250");

		// Veritabanından veri çekme
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT name, price, stock FROM Product");
		ResultSetMetaData rsmd = rs.getMetaData();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int cols = rsmd.getColumnCount();
		String[] colName = new String[cols];
		for (int i = 0; i < cols; i++) {
			colName[i] = rsmd.getColumnName(i + 1);
		}
		model.setColumnIdentifiers(colName);

		Object[] row = new Object[cols];
		while (rs.next()) {
			for (int i = 0; i < cols; i++) {
				row[i] = rs.getObject(i + 1);
			}
			model.addRow(row);
		}

		stmt.close();
		con.close();

		JButton btnNewButton = new JButton("My Products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(126, 21, 117, 29);
		frmAdminPanel.getContentPane().add(btnNewButton);

		JButton btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrders.setBounds(255, 21, 117, 29);
		frmAdminPanel.getContentPane().add(btnOrders);

		JButton btnNewButton_1_1 = new JButton("Add Items");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Product addpage = new Add_Product();
				addpage.frame.setVisible(true);
				frmAdminPanel.setVisible(false);
			}
		});
		btnNewButton_1_1.setBounds(384, 21, 140, 29);
		frmAdminPanel.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Drop Items");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drop_items nw = new Drop_items();
				nw.NewScreen_7();

			}
		});
		btnNewButton_1_2.setBounds(536, 21, 117, 29);
		frmAdminPanel.getContentPane().add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("Update Items");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_stock nw = new Update_stock();
				nw.NewScreen_8();
			}
		});
		btnNewButton_1_3.setBounds(671, 21, 117, 29);
		frmAdminPanel.getContentPane().add(btnNewButton_1_3);

	}
}