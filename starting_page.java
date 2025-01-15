package Online_Shopping_Platform;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class starting_page extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    starting_page frame = new starting_page();
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
    public starting_page() {
        setTitle("Main Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 293);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("Customer Sign Up");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sign_up nw = new sign_up();
                nw.NewScreen();
            }
        });
        btnNewButton.setBounds(84, 117, 144, 29);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Customer Login");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login nw = new login();
                nw.NewScreen_1();
            }
        });
        btnNewButton_1.setBounds(84, 158, 144, 29);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Admin Sign Up");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin_signup nw = new admin_signup();
                nw.NewScreen_4();
            }
        });
        btnNewButton_2.setBounds(283, 117, 117, 29);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Admin Login");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin_login nw = new admin_login();
                nw.NewScreen_3();
            }
        });
        btnNewButton_3.setBounds(283, 158, 117, 29);
        contentPane.add(btnNewButton_3);
        
        JLabel lblNewLabel = new JLabel("Welcome to EYO Marketplace");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        lblNewLabel.setBounds(148, 59, 221, 16);
        contentPane.add(lblNewLabel);

    }
}
