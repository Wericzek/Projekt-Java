package nawa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGui {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtSurname;
	private JTextField txtAge;
	private JTextField txtHeight;
	private JTextField txtSpike;
	private JTextField txtBlock;
	private JTextField txtPosition;
	private JTextField txtClub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGui window = new AddGui();
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
	public AddGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(10, 33, 56, 14);
		frame.getContentPane().add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(70, 30, 111, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(70, 67, 111, 20);
		frame.getContentPane().add(txtSurname);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(70, 107, 111, 20);
		frame.getContentPane().add(txtAge);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		txtHeight.setBounds(70, 148, 111, 20);
		frame.getContentPane().add(txtHeight);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 110, 46, 14);
		frame.getContentPane().add(lblAge);
		
		JLabel lblNewLabel = new JLabel("Height");
		lblNewLabel.setBounds(10, 151, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSpike = new JLabel("Spike");
		lblSpike.setBounds(205, 36, 46, 14);
		frame.getContentPane().add(lblSpike);
		
		JLabel lblBlock = new JLabel("Block");
		lblBlock.setBounds(205, 73, 46, 14);
		frame.getContentPane().add(lblBlock);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(205, 113, 46, 14);
		frame.getContentPane().add(lblPosition);
		
		JLabel lblClub = new JLabel("Club");
		lblClub.setBounds(205, 154, 46, 14);
		frame.getContentPane().add(lblClub);
		
		txtSpike = new JTextField();
		txtSpike.setColumns(10);
		txtSpike.setBounds(261, 33, 111, 20);
		frame.getContentPane().add(txtSpike);
		
		txtBlock = new JTextField();
		txtBlock.setColumns(10);
		txtBlock.setBounds(261, 70, 111, 20);
		frame.getContentPane().add(txtBlock);
		
		txtPosition = new JTextField();
		txtPosition.setColumns(10);
		txtPosition.setBounds(261, 110, 111, 20);
		frame.getContentPane().add(txtPosition);
		
		txtClub = new JTextField();
		txtClub.setColumns(10);
		txtClub.setBounds(261, 151, 111, 20);
		frame.getContentPane().add(txtClub);
		
		JButton btnAddPlayer = new JButton("ADD PLAYER");
		btnAddPlayer.setBounds(151, 191, 111, 37);
		frame.getContentPane().add(btnAddPlayer);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExit.setBounds(337, 230, 87, 20);
		frame.getContentPane().add(btnExit);
	}
}
