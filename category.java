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
import java.awt.FlowLayout;

public class category extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel categorypanel;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public void run_frame() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					category frame = new category();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public category() throws SQLException, ClassNotFoundException, IOException {
		setTitle("Category");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		categorypanel = new JPanel();
		categorypanel.setToolTipText("\n");
		categorypanel.setBackground(UIManager.getColor("DesktopIcon.borderRimColor"));
		categorypanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(categorypanel);

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("URL", "root", "enteryourpassword");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
		categorypanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.ORANGE);
		panel.setBackground(new Color(238, 238, 237));
		panel.setBounds(5, 35, 1068, 190);
		categorypanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 480, 1068, 190);
		categorypanel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 258, 1068, 190);
		categorypanel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_1_1_1 = new JLabel("Yiyecek İçecek");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(20, 441, 224, 40);
		categorypanel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Kırtasiye");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(20, 224, 224, 40);
		categorypanel.add(lblNewLabel_1_1);

		int counter = 0;
		while (rs.next()) {
			// Assuming your product table has columns named "product_name" and "price"
			String productName = rs.getString("name");
			double price = rs.getDouble("price");
			int stock = rs.getInt("stock");


			// Create HTML-formatted text to display both text and image
			String labelText = "<html><body>" + "<b>" + productName + "</b><br>" + "$" + price + "<br>" + "</body></html>";

			String stockText = "  Stock :" + stock;

			// Create a button
			JButton button = new JButton("Add Bag");

			// Set preferred size for the button
			button.setPreferredSize(new Dimension(100, 20)); // Width, Height

			// Button pressed add bag
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Action to perform when the button is clicked
					// For example, you can display a message dialog
					JOptionPane.showMessageDialog(null, "Bag added!");
				}
			});

			// Create JLabel to display product information (text and image)
			JLabel productLabel = new JLabel(labelText);
			JLabel stockLabel = new JLabel(stockText);

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
						JOptionPane.showMessageDialog(null, "Go Page");
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});


			counter++;

		}

		// Geri dön butonunu oluştur
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			products nw;
			try {
				nw = new products();
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			products.NewScreen_6();

			}
		});
		backButton.setBounds(973, 6, 100, 30);
		categorypanel.add(backButton);
		
				JLabel lblNewLabel_1 = new JLabel("Mutfak");
				lblNewLabel_1.setBounds(20, 5, 66, 25);
				categorypanel.add(lblNewLabel_1);
				lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

	}
}
