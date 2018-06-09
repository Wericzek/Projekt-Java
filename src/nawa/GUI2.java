package nawa;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class GUI2 {

	private JFrame frame;
	private Baza baza;
	String name=null;

	/**
	 * Launch the application.
	 */
	public static void CoachWindow(Baza baza) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2(baza);
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
	public GUI2(Baza baza) {
		initialize();
		this.baza = baza;
		System.out.println("Created GUI2");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtTitle = new JTextPane();
		txtTitle.setBounds(0, 0, 600, 20);
		txtTitle.setText("Coach Mode");
		frame.getContentPane().add(txtTitle);
		
		JButton btnShowProfile = new JButton("Show Profile");
		btnShowProfile.setBounds(20, 30, 150, 30);
		frame.getContentPane().add(btnShowProfile);
		btnShowProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		
			}
		});
		
		JButton btnShowPlayers = new JButton("Show Players");
		btnShowPlayers.setBounds(20, 70, 150, 30);
		frame.getContentPane().add(btnShowPlayers);
		btnShowPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					Player search = baza.showAllPlayers(name);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				});
				
	
		JButton btnShowClub = new JButton("Show Club");
		btnShowClub.setBounds(20, 110, 150, 30);
		frame.getContentPane().add(btnShowClub);
		btnShowClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		
	}
		});
		
		JButton btnAddPlayer = new JButton("Add Player");
		btnAddPlayer.setBounds(20, 150, 150, 30);
		frame.getContentPane().add(btnAddPlayer);
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		JButton btnAddMatch = new JButton("Add Match");
		btnAddMatch.setBounds(20, 190, 150, 30);
		frame.getContentPane().add(btnAddMatch);
		btnAddMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		
	}
		});
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(450, 300, 100, 30);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		System.exit(0);
	}

			
		});


}
}

