package nawa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import log4j.pack.Log4j;

public class baza {

	public static void main(String[] args) throws SQLException {

		String connectionUrl = "jdbc:sqlite:lib/BazaProjekt.db";
		final Logger log = Logger.getLogger(Log4j.class);

		DriverManager.registerDriver(new org.sqlite.JDBC());
		Connection con = DriverManager.getConnection(connectionUrl);

		String SQL = "SELECT * FROM player;";
		String Coach = "SELECT * FROM coach;";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		
		Statement coach = con.createStatement();
		ResultSet rcoach = coach.executeQuery(Coach);


		while (rs.next()) {			
			log.debug(rs.getInt("id") + " - " + rs.getString("first_name") + " " + rs.getString("surname"));
			
		}
		
		while(rcoach.next()) {
			log.debug(rcoach.getInt("id") + "-" + rcoach.getString("first_name") + " "+rcoach.getString("surname"));
		}

		rs.close();
		st.close();
		coach.close();
		rcoach.close();
		con.close();
		
		
		

	}

}
