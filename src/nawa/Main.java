package nawa;

import java.awt.EventQueue;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import log4j.pack.Log4j;

public class Main {

	static Logger log = Logger.getLogger(Log4j.class);
	public static void main(String[] args) {
		
		try {
			Baza baza = new Baza();
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					GUI1 window = new GUI1(baza);
				}
			});			
		} catch (SQLException e1) {
			log.debug("Nie mozna sie polaczyc z baza");
			e1.printStackTrace();
		}
		
		
	}

}
