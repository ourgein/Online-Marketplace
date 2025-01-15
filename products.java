package Online_Shopping_Platform;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;
import javax.swing.UIManager;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import java.awt.List;
import java.awt.FlowLayout;
import java.sql.PreparedStatement;
import javax.swing.JLabel;

public class products extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void NewScreen_6() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					products frame = new products();
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
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public products() throws SQLException, ClassNotFoundException, IOException {
		setTitle("HomePage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		contentPane = new JPanel();
		contentPane.setToolTipText("\n");
		contentPane.setBackground(UIManager.getColor("DesktopIcon.borderRimColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("URL", "root", "enteryourpassword");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Product");

		JButton btnNewButton_3 = new JButton("Products");
		btnNewButton_3.setBounds(677, 16, 107, 29);
		btnNewButton_3.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_3.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					category cat = new category();
					cat.setVisible(true);
					setVisible(false);
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});

		// Define a panel to contain your product information

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(256, 16, 80, 29);
		btnNewButton.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login loginpage = new login();
				loginpage.setVisible(true);
				setVisible(false);

			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		JButton btnSgnUp = new JButton("Sign Up");
		btnSgnUp.setBounds(337, 16, 89, 29);
		btnSgnUp.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnSgnUp.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSgnUp.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnSgnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign_up page2 = new sign_up();
				page2.frmSignUp.setVisible(true);
				setVisible(false);

			}
		});
		contentPane.add(btnSgnUp);

		JButton btnContact = new JButton("Best Seller");
		btnContact.setBounds(438, 16, 107, 29);
		btnContact.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnContact.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnContact.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				best_seller nw = new best_seller();
				nw.NewScreen_5();
			}
		});
		contentPane.add(btnContact);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_1 = new JButton("Orders");
		btnNewButton_1.setBounds(943, 3, 130, 51);
		btnNewButton_1.setFont(new Font("Andale Mono", Font.BOLD, 21));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders nw = new Orders();
				nw.NewScreen_9();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(""));
		contentPane.add(btnNewButton_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(5, 55, 1068, 12);
		separator.setForeground(UIManager.getColor("EditorPane.caretForeground"));
		contentPane.add(separator);

		JPanel panel = new JPanel();
		panel.setForeground(Color.ORANGE);
		panel.setBackground(new Color(238, 238, 237));
		panel.setBounds(5, 68, 1068, 190);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 270, 1068, 190);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 470, 1068, 190);
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("EYO Marketplace");
		lblNewLabel.setFont(new Font("Avenir Next", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon("src/Image/shop-icon.png"));
		lblNewLabel.setBounds(5, -3, 296, 59);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Today's Deal");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_2.setBounds(545, 16, 131, 29);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("New Reales");
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_4.setBounds(785, 16, 146, 29);
		contentPane.add(btnNewButton_4);

		int counter = 0;
		while (rs.next()) {
			// Assuming your product table has columns named "product_name" and "price"
			String productName = rs.getString("name");
			double price = rs.getDouble("price");
			int stock = rs.getInt("stock");
			int id = rs.getInt("product_id");

			// Create HTML-formatted text to display both text and image
			String labelText = "<html><body>" + "<b>" + productName + "</b><br>" + "$" + price + "<br>"
					+ "</body></html>";

			String stockText = "  Stock :" + stock;

			// Create a button
			JButton button = new JButton("Add Bag");
			button.setPreferredSize(new Dimension(100, 20)); // Width, Height

			JLabel stockLabel = new JLabel(stockText); // Ensure stockText is properly initialized with current stock

			button.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String checkStockSql = "SELECT stock FROM Product WHERE product_id = ?";
			        String updateStockSql = "UPDATE Product SET stock = stock - 1 WHERE product_id = ?";
			        try (Connection con = DriverManager.getConnection("URL", "root", "enteryourpassword");
			             PreparedStatement checkStmt = con.prepareStatement(checkStockSql)) {

			            checkStmt.setInt(1, id);
			            ResultSet rs = checkStmt.executeQuery();

			            if (rs.next()) {
			                int currentStock = rs.getInt("stock");
			                if (currentStock > 0) {
			                    try (PreparedStatement updateStmt = con.prepareStatement(updateStockSql)) {
			                        updateStmt.setInt(1, id);
			                        int affectedRows = updateStmt.executeUpdate();
			                        if (affectedRows > 0) {
			                            JOptionPane.showMessageDialog(null, "Bag added!");
			                            stockLabel.setText("Stock: " + (currentStock - 1)); // Update the stock label on the GUI

			                            // Assuming ordersFrame is an instance of your Orders frame and is accessible here
			                            Orders orders = new Orders();
			                            orders.setVisible(true);
			                            orders.addItemToTable(new Object[]{"Order Item ID", "Order ID", id, 1, "Calculated Subtotal"});
			                        } else {
			                            JOptionPane.showMessageDialog(null, "Unable to add product to bag!");
			                        }
			                    }
			                } else {
			                    JOptionPane.showMessageDialog(null, "Product is out of stock!");
			                }
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Error accessing/updating stock!");
			        }
			    }
			});


			// Create JLabel to display product information (text and image)
			JLabel productLabel = new JLabel(labelText);

			JPanel productPanel = new JPanel();
			productPanel.setBackground(UIManager.getColor("CheckBox.background"));
			productPanel.setPreferredSize(new Dimension(250, 250));

			// Add JLabel to the panel
			productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
			productPanel.add(productLabel);
			productPanel.add(button);
			productPanel.add(stockLabel);

			productPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						show_product go = new show_product(id);
						go.setVisible(true);
						setVisible(false);

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});

			if (counter < 5)
				panel.add(productPanel);
			else if (counter < 10)
				panel_1.add(productPanel);
			else
				panel_2.add(productPanel);

			counter++;

		}
	}

	public products(String username) throws SQLException, IOException, ClassNotFoundException {
		setTitle("Star Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		contentPane = new JPanel();
		contentPane.setToolTipText("\n");
		contentPane.setBackground(UIManager.getColor("DesktopIcon.borderRimColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("URL", "root", "enteryourpassword");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Product");

		JButton btnNewButton_3 = new JButton("Products");
		btnNewButton_3.setBounds(667, 16, 131, 29);
		btnNewButton_3.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_3.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					category cat = new category();
					cat.setVisible(true);
					setVisible(false);
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});

		// Define a panel to contain your product information

		JButton btnNewButton = new JButton("Welcome " + username);
		btnNewButton.setBounds(250, 16, 200, 29);
		btnNewButton.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton.setForeground(UIManager.getColor("ComboBox.foreground"));
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		JButton btnSgnUp = new JButton("Sign Up");
		btnSgnUp.setBounds(337, 16, 89, 29);
		btnSgnUp.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnSgnUp.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSgnUp.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnSgnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign_up page2 = new sign_up();
				page2.frmSignUp.setVisible(true);
				setVisible(false);

			}
		});
		contentPane.add(btnSgnUp);

		JButton btnContact = new JButton("Best Seller");
		btnContact.setBounds(438, 16, 107, 29);
		btnContact.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnContact.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnContact.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				best_seller nw = new best_seller();
				nw.NewScreen_5();
			}
		});
		contentPane.add(btnContact);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_1 = new JButton("Orders");
		btnNewButton_1.setBounds(943, 3, 130, 51);
		btnNewButton_1.setFont(new Font("Andale Mono", Font.BOLD, 21));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders nw = new Orders();
				nw.NewScreen_9();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(""));
		contentPane.add(btnNewButton_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(5, 55, 1068, 12);
		separator.setForeground(UIManager.getColor("EditorPane.caretForeground"));
		contentPane.add(separator);

		JPanel panel = new JPanel();
		panel.setForeground(Color.ORANGE);
		panel.setBackground(new Color(238, 238, 237));
		panel.setBounds(5, 68, 1068, 190);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 270, 1068, 190);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 470, 1068, 190);
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("EYO Marketplace");
		lblNewLabel.setFont(new Font("Avenir Next", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon("src/Image/shop-icon.png"));
		lblNewLabel.setBounds(5, -3, 296, 59);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Today's Deal");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_2.setBounds(545, 16, 131, 29);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton("New Releases");
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_4.setBounds(785, 16, 117, 29);
		contentPane.add(btnNewButton_4);

		int counter = 0;
		while (rs.next()) {
			// Assuming your product table has columns named "name", "price", "stock", and
			// "image_name"
			String productName = rs.getString("name");
			double price = rs.getDouble("price");
			int stock = rs.getInt("stock");
			int id = rs.getInt("product_id");

			// Create ImageIcon from the BufferedImage

			// Create HTML-formatted text to display both text and image
			String labelText = "<html><body>" + "<b>" + productName + "</b><br>" + "$" + price + "<br>"
					+ "</body></html>";

			String stockText = "  Stock: " + stock;

			// Create a button
			JButton button = new JButton("Add Bag");
			button.setPreferredSize(new Dimension(100, 20)); // Width, Height

			JLabel stockLabel = new JLabel(stockText); // Ensure stockText is properly initialized with current stock

			button.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        String checkStockSql = "SELECT stock FROM Product WHERE product_id = ?";
			        String updateStockSql = "UPDATE Product SET stock = stock - 1 WHERE product_id = ?";
			        try (Connection con = DriverManager.getConnection("URL", "root", "enteryourpassword");
			             PreparedStatement checkStmt = con.prepareStatement(checkStockSql)) {

			            checkStmt.setInt(1, id);
			            ResultSet rs = checkStmt.executeQuery();

			            if (rs.next()) {
			                int currentStock = rs.getInt("stock");
			                if (currentStock > 0) {
			                    try (PreparedStatement updateStmt = con.prepareStatement(updateStockSql)) {
			                        updateStmt.setInt(1, id);
			                        int affectedRows = updateStmt.executeUpdate();
			                        if (affectedRows > 0) {
			                            JOptionPane.showMessageDialog(null, "Bag added!");
			                            stockLabel.setText("Stock: " + (currentStock - 1)); // Update the stock label on the GUI

			                            // Assuming ordersFrame is an instance of your Orders frame and is accessible here
			                            Orders orders = new Orders();
			                            orders.setVisible(true);
			                            orders.addItemToTable(new Object[]{"Order Item ID", "Order ID", id, 1, "Calculated Subtotal"});
			                        } else {
			                            JOptionPane.showMessageDialog(null, "Unable to add product to bag!");
			                        }
			                    }
			                } else {
			                    JOptionPane.showMessageDialog(null, "Product is out of stock!");
			                }
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Error accessing/updating stock!");
			        }
			    }
			});

			// Create JLabel to display product information (text and image)
			JLabel productLabel = new JLabel(labelText);

			JPanel productPanel = new JPanel();
			productPanel.setBackground(UIManager.getColor("CheckBox.background"));
			productPanel.setPreferredSize(new Dimension(250, 250));

			// Add JLabel to the panel
			productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
			productPanel.add(productLabel);
			productPanel.add(button);
			productPanel.add(stockLabel);

			productPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						show_product go = new show_product(id);
						go.setVisible(true);
						setVisible(false);

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});

			if (counter < 5)
				panel.add(productPanel);
			else if (counter < 10)
				panel_1.add(productPanel);
			else
				panel_2.add(productPanel);

			counter++;
		}
	}
}
