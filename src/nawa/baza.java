package nawa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baza {

	public static void main(String[] args) throws SQLException {

		String connectionUrl = "jdbc:sqlite:D:/WERI/javadb/BazaProjekt.db";

		DriverManager.registerDriver(new org.sqlite.JDBC());
		Connection con = DriverManager.getConnection(connectionUrl);

		String SQL = "SELECT * FROM club;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);

		while (rs.next()) {
			System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
		}

		rs.close();
		st.close();
		con.close();
		System.out.println('w');

	}

}
