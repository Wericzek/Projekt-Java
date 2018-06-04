package nawa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import log4j.pack.Log4j;

public class Baza {
	
	String connectionUrl = "jdbc:sqlite:lib/BazaProjekt.db";
	static final Logger log = Logger.getLogger(Log4j.class);
	LinkedList<Coach> coachesList =  new LinkedList<Coach>();
	LinkedList<Player> playersList = new LinkedList<Player>();
	int index;
	static Connection con;
	Player player = new Player();
	Coach  coach = new Coach();
		
	public Baza() throws SQLException {
		DriverManager.registerDriver(new org.sqlite.JDBC());
		con = DriverManager.getConnection(connectionUrl);

		
	}

	public static void main(String[] args) throws SQLException  {
       Baza baza = new Baza();
       baza.searchByFirstName("Piotr");
/*		String SQL = "SELECT * FROM player;";
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
		con.close();*/
		
}
		public LinkedList<Coach> loadCoaches(LinkedList<Coach> lista){
			coachesList = lista;
			return coachesList;
			
		}
		
		public LinkedList<Player> loadPlayers(LinkedList<Player> lista){
			playersList = lista;
			return playersList;
			
		}
		
		public Player searchByFirstName(String name) throws SQLException {
			Statement st_name = con.createStatement();
			String zapytanie = "SELECT * from player where first_name='"+name+"';";
			ResultSet rt_name = st_name.executeQuery(zapytanie);
			while(rt_name.next()) {
				log.debug(rt_name.getInt("id") + "-" + rt_name.getString("first_name") + " "+rt_name.getString("surname"));
			}
			st_name.close();
			rt_name.close();
			con.close();
			return null;
			
		}
}
