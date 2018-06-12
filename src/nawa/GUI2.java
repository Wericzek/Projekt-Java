package nawa;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI2 {

	private JFrame frame;
	private Baza baza;
	String name=null;
	private JTextField textSearchBy;
	int PlayerID = 0;

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
		frame.setBounds(200, 200, 518, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtTitle = new JTextPane();
		txtTitle.setBounds(0, 0, 600, 20);
		txtTitle.setText("Coach Mode");
		frame.getContentPane().add(txtTitle);
		
		JButton btnShowProfile = new JButton("Show Profile");
		btnShowProfile.setBounds(76, 167, 150, 30);
		frame.getContentPane().add(btnShowProfile);
		btnShowProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		
			}
		});
		
		JButton btnShowPlayers = new JButton("Show Players");
		btnShowPlayers.setBounds(76, 208, 150, 30);
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
		
		JButton btnAddPlayer = new JButton("Add Player");
		btnAddPlayer.setBounds(76, 249, 150, 30);
		frame.getContentPane().add(btnAddPlayer);
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		JButton btnAddMatch = new JButton("Add Match");
		btnAddMatch.setBounds(76, 290, 150, 30);
		frame.getContentPane().add(btnAddMatch);
		btnAddMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		
	}
		});
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(390, 300, 100, 30);
		frame.getContentPane().add(btnExit);
		
		textSearchBy = new JTextField();
		textSearchBy.setBounds(30, 31, 453, 20);
		frame.getContentPane().add(textSearchBy);
		textSearchBy.setColumns(10);
		
		JCheckBox chckbxFirstName = new JCheckBox("First Name");
		chckbxFirstName.setBounds(30, 82, 77, 23);
		frame.getContentPane().add(chckbxFirstName);
		
		JCheckBox chckbxSurname = new JCheckBox("Surname");
		chckbxSurname.setBounds(119, 82, 77, 23);
		frame.getContentPane().add(chckbxSurname);
		
		JCheckBox chckbxClub = new JCheckBox("Club");
		chckbxClub.setBounds(212, 82, 87, 23);
		frame.getContentPane().add(chckbxClub);
		
		JCheckBox chckbxAge = new JCheckBox("Age");
		chckbxAge.setBounds(301, 82, 87, 23);
		frame.getContentPane().add(chckbxAge);
		
		JCheckBox chckbxHeight = new JCheckBox("Height");
		chckbxHeight.setBounds(393, 82, 97, 23);
		frame.getContentPane().add(chckbxHeight);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 151, 238, 179);
		frame.getContentPane().add(panel);
		
		JLabel lblMenu = new JLabel("Menu:");
		lblMenu.setBounds(129, 134, 46, 14);
		frame.getContentPane().add(lblMenu);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxFirstName.isSelected() == true) {
					String name = textSearchBy.getText();
					try {
						PlayerID = baza.searchByFirstName(name);
						SearchGUI.SearchWindow(PlayerID, baza);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnSearch.setBounds(390, 111, 100, 30);
		frame.getContentPane().add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 85, 460, 20);
		frame.getContentPane().add(panel_1);
		
		JLabel lblSearchBy = new JLabel("Search by:");
		lblSearchBy.setBounds(30, 62, 60, 13);
		frame.getContentPane().add(lblSearchBy);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFrame exitFrame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(exitFrame, "Confirm if you want to exit", "Players Database",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
						
					System.exit(0);
				}		
	}

			
		});


}
}

