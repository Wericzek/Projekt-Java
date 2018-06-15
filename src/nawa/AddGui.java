package nawa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent; 

public class AddGui {

	//String connectionUrl = "jdbc:sqlite:lib/BazaProjekt.db";
	private JFrame frame;
	private JTextField txtID;
	private JTextField txtFirstName;
	private JTextField txtSurname;
	private JTextField txtLogin;
	private JTextField txtPassword;
	private JTextField txtAge;
	private JTextField txtHeight;
	private JTextField txtSpike;
	private JTextField txtBlock;
	private JTextField txtPosition;
	private JTextField txtClub;
	Baza baza;
	
	/**
	 * Launch the application.
	 * @throws  
	 */
	public static void main(String[] args)  {
		
					try {
						Baza baza = new Baza();
						
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								AddGui window = new AddGui(baza); 
								window.frame.setVisible(true);
							}
						});			
					} catch (SQLException e1) {
						System.out.println("Nie mozna sie polaczyc z baza");
						e1.printStackTrace();
					}
			
				}
	/**
	 * Create the application.
	 */
	public AddGui(Baza baza) { 
		this.baza = baza;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(10, 30, 60, 20);
		frame.getContentPane().add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(80, 30, 110, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(10, 70, 60, 20);
		frame.getContentPane().add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(80, 70, 110, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 110, 60, 20);
		frame.getContentPane().add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(80, 110, 110, 20);
		frame.getContentPane().add(txtSurname);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 150, 60, 20);
		frame.getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(80, 150, 110, 20);
		frame.getContentPane().add(txtLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 190, 60, 20);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(80, 190, 110, 20);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 230, 60, 20);
		frame.getContentPane().add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(80, 230, 110, 20);
		frame.getContentPane().add(txtAge);
		
		JLabel lblNewLabel = new JLabel("Height");
		lblNewLabel.setBounds(210, 30, 60, 20);
		frame.getContentPane().add(lblNewLabel);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		txtHeight.setBounds(280, 30, 110, 20);
		frame.getContentPane().add(txtHeight);
		
		JLabel lblSpike = new JLabel("Spike");
		lblSpike.setBounds(210, 70, 60, 20);
		frame.getContentPane().add(lblSpike);
		
		txtSpike = new JTextField();
		txtSpike.setColumns(10);
		txtSpike.setBounds(280, 70, 110, 20);
		frame.getContentPane().add(txtSpike);
		
		JLabel lblBlock = new JLabel("Block");
		lblBlock.setBounds(210, 110, 60, 20);
		frame.getContentPane().add(lblBlock);
		
		txtBlock = new JTextField();
		txtBlock.setColumns(10);
		txtBlock.setBounds(280, 110, 110, 20);
		frame.getContentPane().add(txtBlock);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(210, 150, 60, 20);
		frame.getContentPane().add(lblPosition);
		
		txtPosition = new JTextField();
		txtPosition.setColumns(10);
		txtPosition.setBounds(280, 150, 110, 20);
		frame.getContentPane().add(txtPosition);
		
		JLabel lblClub = new JLabel("Club");
		lblClub.setBounds(210, 190, 60, 20);
		frame.getContentPane().add(lblClub);
	
		txtClub = new JTextField();
		txtClub.setColumns(10);
		txtClub.setBounds(280, 190, 110, 20);
		frame.getContentPane().add(txtClub);
		
		JButton btnAddPlayer = new JButton("ADD PLAYER");
		btnAddPlayer.setBounds(300, 240, 110, 35);
		frame.getContentPane().add(btnAddPlayer);
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
				
				try {
			
			    
				String query="INSERT INTO Player (ID,first_name, surname,login,password,age,height,spike,block,positionID,clubID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st1 = baza.con.prepareStatement(query);
				
				st1.setString(1,txtID.getText());
				st1.setString(2,txtFirstName.getText());
				st1.setString(3, txtSurname.getText());
				st1.setString(4, txtLogin.getText());
				st1.setString(5, txtPassword.getText());
				st1.setString(6, txtAge.getText());
				st1.setString(7, txtHeight.getText());
				st1.setString(8, txtSpike.getText());
				st1.setString(9, txtBlock.getText());
				st1.setString(10, txtPosition.getText());
				st1.setString(11, txtClub.getText());
				
				st1.execute();
				
				JOptionPane.showMessageDialog(null, "Zapisano");
				
				st1.close();
			
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			    
			}
		});
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExit.setBounds(300, 300, 110, 20);
		frame.getContentPane().add(btnExit);
	}
}
