package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class ServerGUI {

	private JFrame frame;
	private TCPServer S = new TCPServer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI window = new ServerGUI();
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
	public ServerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 51));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start Server");
		btnNewButton.setForeground(new Color(153, 102, 51));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					S.server();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame,
						    "Server failed to start..",
						    "Startup Error",
						    JOptionPane.ERROR_MESSAGE);					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(81, 119, 275, 64);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Stop Server");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(317, 227, 107, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblBrainmathServer = new JLabel("BrainMath Server");
		lblBrainmathServer.setForeground(new Color(139, 69, 19));
		lblBrainmathServer.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblBrainmathServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrainmathServer.setBounds(59, 11, 306, 81);
		frame.getContentPane().add(lblBrainmathServer);
	}
}
