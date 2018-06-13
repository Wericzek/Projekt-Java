package nawa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class GUI3 {

	private JFrame frame;
	private Baza baza;
	private JTextField txtSearchby;
	String username;
	String PlayerData;
	
	/**
	 * Launch the application.
	 */
	public static void PlayerWindow(Baza baza, String username) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI3 window = new GUI3(baza, username);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI3(Baza baza, String username) {
		initialize();
		this.baza = baza;
		this.username = username;
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 231, 256);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnShowProfile = new JButton("SHOW PROFILE");
		btnShowProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PlayerData = baza.searchByUsername(username);
					SearchGUI.SearchWindow(PlayerData, baza);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnShowProfile.setBounds(95, 156, 115, 23);
		frame.getContentPane().add(btnShowProfile);
		
		txtSearchby = new JTextField();
		txtSearchby.setBounds(26, 24, 173, 23);
		frame.getContentPane().add(txtSearchby);
		txtSearchby.setColumns(10);
		
		JCheckBox chckbxFirstName = new JCheckBox("First Name");
		chckbxFirstName.setBounds(28, 54, 97, 23);
		frame.getContentPane().add(chckbxFirstName);
		
		JCheckBox chckbxSurname = new JCheckBox("Surname");
		chckbxSurname.setBounds(28, 80, 97, 23);
		frame.getContentPane().add(chckbxSurname);
		
		JCheckBox chckbxClub = new JCheckBox("Club");
		chckbxClub.setBounds(28, 106, 59, 23);
		frame.getContentPane().add(chckbxClub);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxFirstName.isSelected() == true) {
					String name = txtSearchby.getText();
					try {
						PlayerData = baza.searchByFirstName(name);
						SearchGUI.SearchWindow(PlayerData, baza);
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		btnSearch.setBounds(105, 106, 94, 23);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(95, 188, 115, 23);
		frame.getContentPane().add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 200, 127);
		frame.getContentPane().add(panel);
	}
}
