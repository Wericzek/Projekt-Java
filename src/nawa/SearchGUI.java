package nawa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class SearchGUI {

	private JFrame frame;
	private String PlayerData;
	private Baza baza;
	/**
	 * Launch the application.
	 */
	public static void SearchWindow(String PlayerData, Baza baza) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGUI window = new SearchGUI(PlayerData, baza);
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
	public SearchGUI(String PlayerData, Baza baza) {
		this.PlayerData = PlayerData;
		this.baza = baza;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 341, 228);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textUserData = new JTextArea();
		textUserData.setBounds(85, 36, 159, 135);
		frame.getContentPane().add(textUserData);
		textUserData.setText(PlayerData);
		textUserData.setEditable(false);
		
		JLabel lblPlayersData = new JLabel("Player's Data:");
		lblPlayersData.setBounds(116, 11, 112, 14);
		frame.getContentPane().add(lblPlayersData);
	}
}
