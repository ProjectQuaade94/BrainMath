package Client;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainGUI {

	private JFrame frame;
	private JTextField textField;
	private Game G;
	private JPasswordField passwordField;
	private JPanel game, createUser, login, menu, store;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JLabel lblCreateUser;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblConfirmPassword;
	private JPasswordField passwordField_2;
	private JLabel lblNewLabel_2;
	private JButton btnLogout;
	/**
	 * Launch the application.
	 */
	public void mainGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI(G);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public MainGUI(Game G) throws NumberFormatException, Exception {
		this.G = G;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		frame = new JFrame();
		frame.setBounds(100, 100, 761, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		login = new JPanel();
		login.setLayout(null);
		login.setVisible(true);

		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.getContentPane().add(login, "name_187246538660327");

		menu = new JPanel();
		frame.getContentPane().add(menu, "name_187252367957380");
		menu.setLayout(null);
		
		lblNewLabel_2 = new JLabel("BrainMath");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(222, 21, 323, 82);
		menu.add(lblNewLabel_2);
		
		btnLogout = new JButton("logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: LOGOUT
				login.setVisible(true);
				menu.setVisible(false);
			}
		});
		btnLogout.setBounds(633, 428, 102, 23);
		menu.add(btnLogout);
		menu.setVisible(false);

		createUser = new JPanel();
		frame.getContentPane().add(createUser, "name_187255456696026");
		createUser.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(295, 185, 173, 23);
		createUser.add(textField_1);
		textField_1.setColumns(10);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(295, 244, 173, 23);
		createUser.add(passwordField_1);

		lblCreateUser = new JLabel("Create User");
		lblCreateUser.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblCreateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateUser.setBounds(197, 43, 366, 88);
		createUser.add(lblCreateUser);

		btnNewButton_1 = new JButton("Create user");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = 0;
				try {
					ans = G.createUser(textField_1.getText(), passwordField_1.getText(), passwordField_2.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Input Error");
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Input Error");
					e1.printStackTrace();
				}
				if(ans == 1){
					JOptionPane.showMessageDialog(null, "User already exists");
				}else if(ans == 2){
					JOptionPane.showMessageDialog(null, "Passwords do not match");
				}else if(ans == 3){
					JOptionPane.showMessageDialog(null, "Username too short (min 4 characters)");
				}else if(ans == 4){
					JOptionPane.showMessageDialog(null, "Password too short (min 5 characters)");
				}else if(ans == 0){
					menu.setVisible(true);
					createUser.setVisible(false);
					try {
						G.menu();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(295, 352, 173, 23);
		createUser.add(btnNewButton_1);

		lblNewLabel = new JLabel("Create password");
		lblNewLabel.setBounds(295, 219, 173, 14);
		createUser.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Create username");
		lblNewLabel_1.setBounds(295, 162, 173, 14);
		createUser.add(lblNewLabel_1);

		lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setBounds(295, 278, 173, 14);
		createUser.add(lblConfirmPassword);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(295, 300, 173, 23);
		createUser.add(passwordField_2);
		createUser.setVisible(false);

		store = new JPanel();
		frame.getContentPane().add(store, "name_187457035408605");
		store.setVisible(false);

		game = new JPanel();
		frame.getContentPane().add(game, "name_187482918030731");
		game.setVisible(false);

		JLabel lblMathbrain = new JLabel("MathBrain");
		lblMathbrain.setBounds(249, 51, 245, 67);
		login.add(lblMathbrain);
		lblMathbrain.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblMathbrain.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel loginLabel = new JLabel("Invented, Designed, Developed and funded by Lars Quaade Sørensen");
		loginLabel.setBounds(157, 184, 460, 19);
		login.add(loginLabel);

		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(286, 382, 158, 23);
		login.add(btnNewButton);

		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(286, 416, 158, 23);
		login.add(btnCreateAccount);

		passwordField = new JPasswordField();
		passwordField.setBounds(286, 334, 158, 20);
		login.add(passwordField);

		textField = new JTextField();
		textField.setBounds(286, 284, 158, 20);
		login.add(textField);
		textField.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(286, 264, 119, 14);
		login.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(286, 315, 119, 14);
		login.add(lblPassword);
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUser.setVisible(true);
				login.setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = 0;
				try {
					ans = G.login(textField.getText(), passwordField.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Input Error");
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Input Error");
					e1.printStackTrace();
				}
				if(ans == 1){
					JOptionPane.showMessageDialog(null, "User not found");
				}else if(ans == 2){
					JOptionPane.showMessageDialog(null, "Wrong password");
				}else if(ans == 3){
					JOptionPane.showMessageDialog(null, "Missing password");
				}else if(ans == 4){
					JOptionPane.showMessageDialog(null, "Missing username");

				}else if(ans == 0){
					menu.setVisible(true);
					login.setVisible(false);
					try {
						G.menu();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

	}
}
