package Online_Shopping_Platform;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;
import javax.swing.UIManager;
import javax.imageio.ImageIO;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class show_product extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public show_product(int id) throws SQLException, ClassNotFoundException, IOException {

		String productName = " ";
		double price;
		int stock;
		URL url;
		BufferedImage image = null;
		int sent_id;

		// Create ImageIcon from the BufferedImage
		ImageIcon icon;

		String stockText = " ";
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

		JButton btnNewButton_3 = new JButton("Categories");
		btnNewButton_3.setBounds(667, 16, 131, 29);
		btnNewButton_3.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_3.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		// Define a panel to contain your product information

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(347, 16, 90, 29);
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
		btnSgnUp.setBounds(442, 16, 108, 29);
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

		JButton btnContact = new JButton("Contact");
		btnContact.setBounds(555, 16, 107, 29);
		btnContact.setBackground(UIManager.getColor("ComboBox.foreground"));
		btnContact.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnContact.setForeground(UIManager.getColor("ComboBox.foreground"));
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnContact);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_1 = new JButton("My Bag");
		btnNewButton_1.setBounds(861, 5, 130, 51);
		btnNewButton_1.setFont(new Font("Andale Mono", Font.BOLD, 21));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("/Users/iefeatas/Downloads/shopping-cart_3737372 (1).png"));
		contentPane.add(btnNewButton_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(5, 55, 1068, 12);
		separator.setForeground(UIManager.getColor("EditorPane.caretForeground"));
		contentPane.add(separator);

		JLabel lblNewLabel = new JLabel("EYO Marketplace");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					products p = new products();
					p.setVisible(true);
					setVisible(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		lblNewLabel.setFont(new Font("Avenir Next", Font.BOLD, 30));
		lblNewLabel.setIcon(new ImageIcon("/Users/iefeatas/Desktop/CV/shop-icon.png"));
		lblNewLabel.setBounds(5, -3, 296, 59);
		contentPane.add(lblNewLabel);

		while (rs.next()) {
			// Assuming your product table has columns named "product_name" and "price"

			if (id == rs.getInt("product_id")) {

				productName = rs.getString("name");
				price = rs.getDouble("price");
				stock = rs.getInt("stock");
				sent_id = rs.getInt("product_id");

				// Create ImageIcon from the BufferedImage

				stockText = "Stock :" + stock;

				break;

			}

		}

		JPanel panel = new JPanel();
		panel.setBounds(15, 79, 1024, 550);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel picture_label = new JLabel("New label");
		picture_label.setIcon(new ImageIcon(image));
		picture_label.setBounds(51, 55, 300, 300);
		panel.add(picture_label);

		JLabel name_label = new JLabel(productName);
		name_label.setFont(new Font("Andale Mono", Font.BOLD, 35));
		name_label.setBounds(456, 55, 300, 40);
		panel.add(name_label);

		JButton btnNewButton_1_1 = new JButton("Add Bag");
		btnNewButton_1_1.setFont(new Font("Andale Mono", Font.BOLD, 21));
		btnNewButton_1_1.setBounds(456, 238, 130, 56);
		panel.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Add Favorites");
		btnNewButton_1_1_1.setIcon(new ImageIcon("/Users/iefeatas/Desktop/Favorites-icon (2).png"));
		btnNewButton_1_1_1.setFont(new Font("Andale Mono", Font.BOLD, 21));
		btnNewButton_1_1_1.setBounds(598, 238, 250, 56);
		panel.add(btnNewButton_1_1_1);

		JLabel info_label = new JLabel(stockText);
		info_label.setFont(new Font("Andale Mono", Font.BOLD, 25));
		info_label.setBounds(456, 90, 300, 40);
		panel.add(info_label);

		JLabel go_favorites = new JLabel("");
		go_favorites.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		go_favorites.setToolTipText("Favorites");
		go_favorites.setIcon(new ImageIcon("/Users/iefeatas/Desktop/Favorites-icon (2).png"));
		go_favorites.setBounds(1003, 6, 48, 48);
		contentPane.add(go_favorites);

	}
}
