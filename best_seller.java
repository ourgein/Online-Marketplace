package Online_Shopping_Platform;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class best_seller extends JFrame {

	private JPanel contentPane;
	private JLabel imageLabel;
	private ImageIcon imageIcon;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void NewScreen_5() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					best_seller frame = new best_seller();
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
	public best_seller() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Best Seller Product");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setBounds(80, 6, 280, 68);
		contentPane.add(lblNewLabel);

		// Resmi ekleyin
		imageLabel = new JLabel("");
		imageLabel.setBounds(49, 75, 350, 150); // Görüntü etiketinin konumunu ve boyutunu ayarlayın
		contentPane.add(imageLabel);
		
		btnNewButton = new JButton("Go back");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(161, 237, 117, 29);
		contentPane.add(btnNewButton);

		// Görüntü dosyasını yükleyin (örn. "path/to/image.jpg")
		imageIcon = new ImageIcon("src/Image/bestseller.png");
		updateImageLabel();

		// Çerçevenin boyutu değiştiğinde görüntüyü yeniden boyutlandırın
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				updateImageLabel();
			}
		});
	}

	// Görüntü etiketini yeniden boyutlandır
	private void updateImageLabel() {
		int width = imageLabel.getWidth();
		int height = imageLabel.getHeight();
		Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		imageLabel.setIcon(new ImageIcon(scaledImage));
	}
}
