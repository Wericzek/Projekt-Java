package nawa;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import log4j.pack.Log4j;




	public class GUI1 {

		private JFrame frame;
		private JTextField txtUsername;
		private JPasswordField txtPassword; 
		private JRadioButton rdbtnCoach;
		private final Action action = new SwingAction();
		boolean coach_alert=false;
		String password=null;
		String username=null;
		Baza baza;
		Logger log =  Logger.getLogger(Log4j.class);


		public static void main(String[] args) {
			
			try {
				Baza baza = new Baza();
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						GUI1 window = new GUI1(baza);
						window.frame.setVisible(true);
					}
				});			
			} catch (SQLException e1) {
				System.out.println("Nie mozna sie polaczyc z baza");
				e1.printStackTrace();
			}
	
		}


		public GUI1(Baza baza) {
			this.baza = baza;
			initialize();
		}


		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 449, 301);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setBounds(90, 70, 111, 24);
			frame.getContentPane().add(lblUsername);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setBounds(90, 105, 111, 24);
			frame.getContentPane().add(lblPassword);
			
			txtUsername = new JTextField();
			txtUsername.setBounds(215, 72, 168, 22);
			frame.getContentPane().add(txtUsername);
			txtUsername.setColumns(10);
			
			txtPassword = new JPasswordField();
			txtPassword.setBounds(215, 105, 168, 22);
			frame.getContentPane().add(txtPassword);
			
			JButton btnLogin = new JButton("Login");
			
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					 username = txtUsername.getText();
					 password = txtPassword.getText();
					 
					log.debug("Action event happened");
					 
					 try {
							
							if(rdbtnCoach.isSelected()) {
								String pass = baza.getPassword(txtUsername.getText(), "Coach"); 
								if(pass.equals(txtPassword.getText())) {
										GUI2.CoachWindow(baza);
								} 
							    else {
								JFrame errorFrame = new JFrame("Wrong Password or Login");
								JOptionPane.showMessageDialog(errorFrame, "Incorrect Login or Password, try again");
								txtUsername.setText("");
								txtPassword.setText("");
								
								}
							}
							else {
								String pass = baza.getPassword(txtUsername.getText(), "Player"); 
								if(pass.equals(txtPassword.getText())) {
										GUI3.PlayerWindow(baza);
								}
								else {
									JFrame errorFrame = new JFrame("Wrong Password or Login");
									JOptionPane.showMessageDialog(errorFrame, "Incorrect Login or Password, try again");
									txtUsername.setText("");
									txtPassword.setText("");									
								}
							}
							
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
						
					 
				}
			});

			btnLogin.setBounds(294, 153, 89, 23);
			frame.getContentPane().add(btnLogin);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(65, 57, 318, 2);
			frame.getContentPane().add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(65, 140, 318, 2);
			frame.getContentPane().add(separator_1);
			
			JLabel lblPlayersDatabase = new JLabel("Players Database");
			lblPlayersDatabase.setFont(new Font("Calibri Light", Font.PLAIN, 15));
			lblPlayersDatabase.setBounds(170, 11, 111, 35);
			frame.getContentPane().add(lblPlayersDatabase);
			
			JButton btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try {
					baza.con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 JFrame exitFrame = new JFrame("Exit");
					if(JOptionPane.showConfirmDialog(exitFrame, "Confirm if you want to exit", "Players Database",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
							System.exit(0);
					}		
				}
			});
			btnExit.setBounds(364, 228, 59, 23);
			frame.getContentPane().add(btnExit);
			
			rdbtnCoach = new JRadioButton("coach");
			rdbtnCoach.setBounds(215, 150, 64, 23);
			frame.getContentPane().add(rdbtnCoach);
			
			frame.setVisible(true);
		}
		private class SwingAction extends AbstractAction {
			public SwingAction() {
				putValue(NAME, "SwingAction");
				putValue(SHORT_DESCRIPTION, "Some short description");
			}
			public void actionPerformed(ActionEvent e) {
			}
		}
	}
