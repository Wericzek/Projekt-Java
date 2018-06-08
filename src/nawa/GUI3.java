package nawa;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GUI3 {

	private JFrame frame;
	private Baza baza;
	
	/**
	 * Launch the application.
	 */
	public static void PlayerWindow(Baza baza) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI3 window = new GUI3(baza);
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
	public GUI3(Baza baza) {
		initialize();
		this.baza = baza;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
