package nawa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baza {

	public static void main(String[] args) throws SQLException {

		String connectionUrl = "jdbc:sqlite:lib/BazaProjekt.db";

		DriverManager.registerDriver(new org.sqlite.JDBC());
		Connection con = DriverManager.getConnection(connectionUrl);

		String SQL = "SELECT * FROM player;";
		String Coach = "SELECT * FROM coach;";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		
		Statement coach = con.createStatement();
		ResultSet rcoach = coach.executeQuery(Coach);

		while (rs.next()) {
			System.out.println(rs.getInt("id") + " - " + rs.getString("first_name") + " " + rs.getString("surname"));
			
		}
		while(rcoach.next()) {
			System.out.println(rcoach.getInt("id") + "-" + rcoach.getString("first_name") + " "+rcoach.getString("surname"));
		}

		rs.close();
		st.close();
		coach.close();
		rcoach.close();
		con.close();
		
		
		

	}

}
