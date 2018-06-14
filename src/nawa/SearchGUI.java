package nawa;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 344, 347);
		
		JTextArea textUserData = new JTextArea();
		textUserData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textUserData.setText(PlayerData);
		textUserData.setLineWrap(true);
		textUserData.setEditable(false);	
		
		JScrollPane scrollUserData = new JScrollPane(textUserData, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollUserData.setBounds(60, 30, 200, 250);
		frame.getContentPane().add(scrollUserData);
		
		
				
		JLabel lblPlayersData = new JLabel("Player's Data:");
		lblPlayersData.setBounds(116, 11, 112, 14);
		frame.getContentPane().add(lblPlayersData);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(229, 285, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}
