package nawa;

import java.awt.EventQueue;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		try {
			Baza baza = new Baza();
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					GUI1 window = new GUI1(baza);
				}
			});			
		} catch (SQLException e1) {
			System.out.println("Nie mozna sie polaczyc z baza");
			e1.printStackTrace();
		}
		
		
	}

}
