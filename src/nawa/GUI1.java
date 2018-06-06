package nawa;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;




	public class GUI1 {

		private JFrame frame;
		private JTextField txtUsername;
		private JPasswordField txtPassword;
		private final Action action = new SwingAction();
		boolean coach_alert=false;
		String password=null;
		String username=null;
		Baza baza;


		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUI1 window = new GUI1();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}


		public GUI1() {
			initialize();
		}


		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
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

				}
			});
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
/*					try {
						baza.getPassword(txtUsername.getText());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(baza.real_password == txtPassword.getText()) {
						GUI2.CoachWindow();
					}*/
					
					if(coach_alert == true) {
					GUI2.CoachWindow();
					}
					else {
						GUI3.PlayerWindow();
					}
						

				}
			});

			btnLogin.setBounds(295, 153, 89, 23);
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
				 JFrame exitFrame = new JFrame("Exit");
					if(JOptionPane.showConfirmDialog(exitFrame, "Confirm if you want to exit", "Players Database",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
							System.exit(0);
					}		
				}
			});
			btnExit.setBounds(335, 227, 89, 23);
			frame.getContentPane().add(btnExit);
			
			JRadioButton rdbtnCoach = new JRadioButton("coach");
			rdbtnCoach.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if( rdbtnCoach.isSelected() == true) {
						coach_alert = true;
					}
				}
			});
			rdbtnCoach.setBounds(75, 153, 109, 23);
			frame.getContentPane().add(rdbtnCoach);
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
