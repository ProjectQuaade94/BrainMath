

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGui {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
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
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 582, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnLogin.setBounds(216, 242, 132, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(216, 280, 132, 25);
		frame.getContentPane().add(btnCreateUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 194, 250, 35);
		frame.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(157, 165, 86, 16);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(157, 117, 250, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(157, 84, 86, 16);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblMathGame = new JLabel("Math Game");
		lblMathGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblMathGame.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblMathGame.setBounds(130, 13, 301, 48);
		frame.getContentPane().add(lblMathGame);
	}
}
