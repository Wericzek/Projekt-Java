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
	static LinkedList<Player> playersList = new LinkedList<Player>();
	int index;
	static Connection con;
	Player player;
	Coach  coach;
		
	public Baza() throws SQLException {
		DriverManager.registerDriver(new org.sqlite.JDBC());
		con = DriverManager.getConnection(connectionUrl);

		
	}

	public static void main(String[] args) throws SQLException  {
       Baza baza = new Baza();
       
       //testy 
       baza.loadPlayers();
       baza.searchByFirstName("Piotr");
       con.close();
       
       
       
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
		public LinkedList<Coach> loadCoaches() throws SQLException{
			Statement st_lista = con.createStatement();
			String comand = "SELECT * FROM coach;";
			ResultSet rt_lista = st_lista.executeQuery(comand);
			
			while(rt_lista.next()) {
				coachesList.add(new Coach(rt_lista.getInt("ID"),rt_lista.getString("first_name"),rt_lista.getString("surname"),
						rt_lista.getString("login"),rt_lista.getString("password")));
			}
			st_lista.close();
			rt_lista.close();
			return coachesList;
			
		}
		
		public LinkedList<Player> loadPlayers()throws SQLException{
			Statement st_lista2 = con.createStatement();
			String comand = "SELECT * FROM player;";
			ResultSet rt_lista2 = st_lista2.executeQuery(comand);
			
			while(rt_lista2.next()) {
				playersList.add(new Player(rt_lista2.getInt("ID"),rt_lista2.getString("first_name"),
						rt_lista2.getString("surname"),rt_lista2.getString("login"),
						rt_lista2.getString("password"), rt_lista2.getInt("age"),rt_lista2.getInt("height"),
						rt_lista2.getInt("spike"),rt_lista2.getInt("block"),rt_lista2.getInt("positionID"),rt_lista2.getInt("clubID")));
			}
			st_lista2.close();
			rt_lista2.close();
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
			return null;
			
		}
		
		public void displayLinkedList(char player_or_coach) {
			if( player_or_coach == 'p') {
				for(int i = 0; i < playersList.size(); i++) {
						log.debug(playersList.get(i));
					}
			}
			
			else if( player_or_coach == 'c') {
				for(int i = 0; i < coachesList.size(); i++) {
					log.debug(coachesList.get(i));
				}
					
		    }
		}



}

