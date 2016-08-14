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
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;

public class MainGUI {

	private JFrame frame;
	private JTextField textField;
	private Game G;
	private JPasswordField passwordField;
	private JPanel game, createUser, login, menu, store, about;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JLabel lblCreateUser;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblConfirmPassword;
	private JPasswordField passwordField_2;
	private JLabel lblNewLabel_2;
	private JButton btnLogout,btnNewButton,btnCreateAccount;
	private JLabel lblMathbrain;
	private JLabel loginLabel,lblUsername,lblPassword;
	private JLabel lblChallengeMode;
	private JLabel lblCoins;
	private JLabel label;
	private JLabel lblSkips;
	private JLabel lblNewLabel_5;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblStore;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JButton button;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JLabel lblSkipsCost;
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
		
		JSlider slider = new JSlider();
		slider.setMaximum(5);
		slider.setBounds(29, 239, 191, 38);
		menu.add(slider);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Division \u00F7");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(574, 280, 161, 23);
		menu.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Multiplication \u00D7");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBounds(574, 254, 161, 23);
		menu.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Subtraction \u2212");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_2.setBounds(574, 228, 161, 23);
		menu.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Addition +");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_3.setBounds(574, 202, 161, 23);
		menu.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Difficulty:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(29, 166, 191, 29);
		menu.add(lblNewLabel_3);
		
		JLabel lblMode = new JLabel("Mode:");
		lblMode.setToolTipText("");
		lblMode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMode.setBounds(574, 166, 161, 29);
		menu.add(lblMode);
		
		lblChallengeMode = new JLabel("Challenge Mode");
		lblChallengeMode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChallengeMode.setBounds(29, 199, 190, 29);
		menu.add(lblChallengeMode);
		
		lblCoins = new JLabel("Quaade94");
		lblCoins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCoins.setBounds(29, 52, 166, 29);
		menu.add(lblCoins);
		
		label = new JLabel("Coins: 0");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(29, 94, 166, 17);
		menu.add(label);
		
		lblSkips = new JLabel("Skips: 5");
		lblSkips.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSkips.setBounds(29, 122, 166, 17);
		menu.add(lblSkips);
		
		JButton btnNewButton_2 = new JButton("about");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			about.setVisible(true);
			menu.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(633, 394, 102, 23);
		menu.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Start!");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setVisible(true);
				menu.setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_3.setBounds(280, 201, 204, 53);
		menu.add(btnNewButton_3);
		
		btnNewButton_5 = new JButton("Store");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.setVisible(true);
				menu.setVisible(false);
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_5.setBounds(29, 394, 148, 43);
		menu.add(btnNewButton_5);
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
		lblCreateUser.setBounds(198, 31, 366, 88);
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
		store.setLayout(null);
		
		lblStore = new JLabel("Store");
		lblStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblStore.setBounds(256, 47, 248, 65);
		store.add(lblStore);
		
		label_5 = new JLabel("Coins: 0");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(30, 96, 166, 17);
		store.add(label_5);
		
		label_6 = new JLabel("Skips: 5");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(30, 124, 166, 17);
		store.add(label_6);
		
		label_7 = new JLabel("Quaade94");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_7.setBounds(30, 54, 166, 29);
		store.add(label_7);
		
		button = new JButton("back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				store.setVisible(false);
			}
		});
		button.setBounds(633, 428, 102, 23);
		store.add(button);
		
		btnNewButton_6 = new JButton("Buy skip");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!G.buyskip()){
						JOptionPane.showMessageDialog(null, "You have insuffient funds to do that");
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(305, 252, 157, 23);
		store.add(btnNewButton_6);
		
		lblSkipsCost = new JLabel("Skips cost 50 coins");
		lblSkipsCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkipsCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSkipsCost.setBounds(305, 212, 157, 29);
		store.add(lblSkipsCost);
		store.setVisible(false);

		game = new JPanel();
		frame.getContentPane().add(game, "name_187482918030731");
		game.setLayout(null);
		
		label_1 = new JLabel("BrainMath");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		label_1.setBounds(221, 20, 323, 82);
		game.add(label_1);
		
		label_2 = new JLabel("Quaade94");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(30, 46, 166, 29);
		game.add(label_2);
		
		label_3 = new JLabel("Coins: 0");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(30, 88, 166, 17);
		game.add(label_3);
		
		label_4 = new JLabel("Skips: 5");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(30, 116, 166, 17);
		game.add(label_4);
		game.setVisible(false);

		lblMathbrain = new JLabel("MathBrain");
		lblMathbrain.setBounds(249, 51, 245, 67);
		login.add(lblMathbrain);
		lblMathbrain.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblMathbrain.setHorizontalAlignment(SwingConstants.CENTER);

		loginLabel = new JLabel("Invented, Designed, Developed and funded by Lars Quaade Sørensen");
		loginLabel.setBounds(157, 184, 460, 19);
		login.add(loginLabel);

		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnNewButton = new JButton("Login");
		btnNewButton.setBounds(286, 382, 158, 23);
		login.add(btnNewButton);

		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(286, 416, 158, 23);
		login.add(btnCreateAccount);

		passwordField = new JPasswordField();
		passwordField.setBounds(286, 334, 158, 20);
		login.add(passwordField);

		textField = new JTextField();
		textField.setBounds(286, 284, 158, 20);
		login.add(textField);
		textField.setColumns(10);

		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(286, 264, 119, 14);
		login.add(lblUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(286, 315, 119, 14);
		login.add(lblPassword);
		
		about = new JPanel();
		frame.getContentPane().add(about, "name_211010110522870");
		about.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("About");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(268, 32, 248, 65);
		about.add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.setVisible(true);
				about.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(633, 428, 102, 23);
		about.add(btnNewButton_4);
		
		lblNewLabel_5 = new JLabel("<html><body><p>This game was created by Lars Quaade with the idea of improving math skills and speed for people at any level of expertise.</p>\r\n<p>\r\n<br>\r\nUpon pressing 'Start' you will be given a math question. You will need to type the answer you believe is correct and then hit 'enter'. For each correct answer you will recieve 5 coins and for each wrong answer, you will loose 1 coin. There are 4 modes (Addition, Subtraction, Multiplication and Division) and 5 difficulty levels. The higher the level the higher the numbers. Challenge Mode, which is the highest difficulty, rewards 5 times as many coins and includes all modes. Coins can be spent in the store. Skips can be bought in the store and allow you to skip a question without recieving a reward. Good luck!</p>\r\n</body></html>");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(82, 117, 568, 227);
		about.add(lblNewLabel_5);
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUser.setVisible(true);
				login.setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				menu.setVisible(true);
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
				System.out.println(ans);
				if(ans == 1){
					JOptionPane.showMessageDialog(null, "User not found");
				}else if(ans == 2){
					JOptionPane.showMessageDialog(null, "Wrong password");
				}else if(ans == 3){
					JOptionPane.showMessageDialog(null, "Missing password");
				}else if(ans == 4){
					JOptionPane.showMessageDialog(null, "Missing username");

				}else if(ans == 0){
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
				if(ans == 0){
					//TODO: FIX THIS SO IT WORKS
					
				}
			}
		});
	}
}
