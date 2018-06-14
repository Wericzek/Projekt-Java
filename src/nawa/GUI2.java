package nawa;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

public class GUI2 {

	private JFrame frame;
	private Baza baza;
	String name=null;
	private JTextField textSearchBy;
	String PlayerData = "";

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

	public GUI2(Baza baza) {
		initialize();
		this.baza = baza;
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 518, 379);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtTitle = new JTextPane();
		txtTitle.setBounds(220, 0, 110, 28);
		txtTitle.setText("Coach Mode");
		txtTitle.setFont(new Font("Calibri Light",Font.PLAIN,15));
		txtTitle.setOpaque(false);
		txtTitle.setEditable(false);
		frame.getContentPane().add(txtTitle);
		
		JButton btnShowProfile = new JButton("Show Profile");
		btnShowProfile.setBounds(41, 167, 150, 30);
		frame.getContentPane().add(btnShowProfile);
		btnShowProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		
			}
		});
		
		JButton btnShowPlayers = new JButton("Show Players");
		btnShowPlayers.setBounds(41, 208, 150, 30);
		frame.getContentPane().add(btnShowPlayers);
		btnShowPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					PlayerData = baza.showAllPlayers();
					SearchGUI.SearchWindow(PlayerData, baza);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				});
		
		JButton btnAddPlayer = new JButton("Add Player");
		btnAddPlayer.setBounds(41, 249, 150, 30);
		frame.getContentPane().add(btnAddPlayer);
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		JButton btnAddMatch = new JButton("Add Match");
		btnAddMatch.setBounds(41, 290, 150, 30);
		frame.getContentPane().add(btnAddMatch);
		btnAddMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		
	}
		});
		/*JButton btnExit = new JButton("Exit");
		btnExit.setBounds(390, 300, 100, 30);
		frame.getContentPane().add(btnExit);*/
		
		
		
		
		textSearchBy = new JTextField();
		textSearchBy.setBounds(30, 31, 453, 20);
		frame.getContentPane().add(textSearchBy);
		textSearchBy.setColumns(10);
		
		JCheckBox chckbxFirstName = new JCheckBox("First Name");
		chckbxFirstName.setBounds(41, 92, 106, 23);
		frame.getContentPane().add(chckbxFirstName);
		
		JCheckBox chckbxSurname = new JCheckBox("Surname");
		chckbxSurname.setBounds(149, 92, 77, 23);
		frame.getContentPane().add(chckbxSurname);
		
		JCheckBox chckbxClub = new JCheckBox("Club");
		chckbxClub.setBounds(241, 92, 51, 23);
		frame.getContentPane().add(chckbxClub);
		
		JCheckBox chckbxAge = new JCheckBox("Age");
		chckbxAge.setBounds(322, 92, 51, 23);
		frame.getContentPane().add(chckbxAge);
		
		JCheckBox chckbxHeight = new JCheckBox("Height");
		chckbxHeight.setBounds(390, 92, 77, 23);
		frame.getContentPane().add(chckbxHeight);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxFirstName.isSelected() == true) {
					String name = textSearchBy.getText();
					try {
						PlayerData = baza.searchByFirstName(name);
						SearchGUI.SearchWindow(PlayerData, baza);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
				if(chckbxAge.isSelected()==true) {
					String age = textSearchBy.getText();
					try {
						PlayerData = baza.searchByAge(age);
						SearchGUI.SearchWindow(PlayerData, baza);
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(chckbxSurname.isSelected() == true) {
					String surname = textSearchBy.getText();
					try {
						PlayerData = baza.searchBySurname(surname);
						SearchGUI.SearchWindow(PlayerData, baza);
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(chckbxHeight.isSelected() == true) {
					String height = textSearchBy.getText();
					try {
						PlayerData = baza.searchByHeight(height);
						SearchGUI.SearchWindow(PlayerData, baza);
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(chckbxClub.isSelected() == true) {
					String club = textSearchBy.getText();
					try {
						PlayerData = baza.searchByClub(club);
						SearchGUI.SearchWindow(PlayerData, baza);
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
			}
		});
		btnSearch.setBounds(383, 134, 100, 30);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblSearchBy = new JLabel("Search players by:");
		lblSearchBy.setBounds(30, 62, 106, 13);
		frame.getContentPane().add(lblSearchBy);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 79, 453, 52);
		panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBounds(30, 154, 173, 175);
		panel_1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frame.getContentPane().add(panel_1);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit_1.setBounds(403, 306, 89, 23);
		frame.getContentPane().add(btnExit_1);
		
	/*	btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFrame exitFrame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(exitFrame, "Confirm if you want to exit", "Players Database",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {						
					System.exit(0);
				}		
	}

			
		});*/


}
}

