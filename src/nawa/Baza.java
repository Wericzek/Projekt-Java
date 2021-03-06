package nawa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import log4j.pack.Log4j;

public class Baza {
	
	String connectionUrl = "jdbc:sqlite:lib/BazaProjekt.db";
	static final Logger log = Logger.getLogger(Log4j.class);
	LinkedList<Coach> coachesList =  new LinkedList<Coach>();
	static LinkedList<Player> playersList = new LinkedList<Player>();
	int logedPlayerID;
	Connection con;
	Player player;
	Coach  coach;
	String real_password = null;
	
	
		
	public Baza() throws SQLException {
		DriverManager.registerDriver(new org.sqlite.JDBC());
		con = DriverManager.getConnection(connectionUrl);
	      loadPlayers();
	      loadCoaches();

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
		
		public String searchByFirstName(String name) throws SQLException {
			Statement st_name = con.createStatement();
			Statement st_name2 = con.createStatement();
			String zapytanie = "SELECT * from player where first_name='"+name+"';";
			String zapytanie2 ="SELECT a.name, b.first_name FROM Club a NATURAL JOIN Player b WHERE first_name='"+name+"';";
			ResultSet rt_name = st_name.executeQuery(zapytanie);
			ResultSet rt_name2 = st_name2.executeQuery(zapytanie2);
			String PlayerData = "";
			String enter = "\n";
			int index = 0;
			while(rt_name.next()) {				
				PlayerData += enter + "name: " + rt_name.getString("first_name") + enter + "Surname: " + rt_name.getString("surname") +
						      enter + "Age: " + rt_name.getInt("age") + enter + "Height: " + rt_name.getInt("height") + enter + "Spike: " +
						      rt_name.getInt("Spike") + enter + "Block: " + rt_name.getInt("Block") + enter + "Club: " +
						      rt_name2.getString("name") + enter + enter;
			    index++;
			}
			st_name.close();
			rt_name.close();
			return PlayerData;
		}
			
			
			
			
			public String searchByUsername(String username) throws SQLException {
				Statement st_name = con.createStatement();
				Statement st_name2 = con.createStatement();
				String zapytanie = "SELECT * from player where login='"+username+"';";
				String zapytanie2 ="SELECT a.name, b.first_name FROM Club a NATURAL JOIN Player b WHERE login='"+username+"';";
				ResultSet rt_name = st_name.executeQuery(zapytanie);
				ResultSet rt_name2 = st_name2.executeQuery(zapytanie2);
				String PlayerData = "";
				String enter = "\n";
				int index = 0;
				while(rt_name.next()) {				
					PlayerData += enter + "name: " + rt_name.getString("first_name") + enter + "Surname: " + rt_name.getString("surname") +
							      enter + "Age: " + rt_name.getInt("age") + enter + "Height: " + rt_name.getInt("height") + enter + "Spike: " +
							      rt_name.getInt("Spike") + enter + "Block: " + rt_name.getInt("Block") + enter + "Club: " +
							      rt_name2.getString("name") + enter + enter;
				    index++;
				}
				st_name.close();
				rt_name.close();
				return PlayerData;
			
		}
			
			public String searchByAge(String age) throws SQLException {
				Statement st_name = con.createStatement();
				Statement st_name2 = con.createStatement();
				String zapytanie = "SELECT * from player where age='"+age+"';";
				String zapytanie2 ="SELECT a.name, b.first_name FROM Club a NATURAL JOIN Player b WHERE age='"+age+"';";
				ResultSet rt_name = st_name.executeQuery(zapytanie);
				ResultSet rt_name2 = st_name2.executeQuery(zapytanie2);
				String PlayerData = "";
				String enter = "\n";
				int index = 0;
				while(rt_name.next()) {				
					PlayerData += enter + "name: " + rt_name.getString("first_name") + enter + "Surname: " + rt_name.getString("surname") +
							      enter + "Age: " + rt_name.getInt("age") + enter + "Height: " + rt_name.getInt("height") + enter + "Spike: " +
							      rt_name.getInt("Spike") + enter + "Block: " + rt_name.getInt("Block") + enter + "Club: " +
							      rt_name2.getString("name") + enter + enter;
				    index++;
				}
				st_name.close();
				rt_name.close();
				return PlayerData;
			
		}
			

			public String searchByHeight(String height) throws SQLException {
				Statement st_name = con.createStatement();
				Statement st_name2 = con.createStatement();
				String zapytanie = "SELECT * from player where height='"+height+"';";
				String zapytanie2 ="SELECT a.name, b.first_name FROM Club a NATURAL JOIN Player b WHERE height='"+height+"';";
				ResultSet rt_name = st_name.executeQuery(zapytanie);
				ResultSet rt_name2 = st_name2.executeQuery(zapytanie2);
				String PlayerData = "";
				String enter = "\n";
				int index = 0;
				while(rt_name.next()) {				
					PlayerData += enter + "name: " + rt_name.getString("first_name") + enter + "Surname: " + rt_name.getString("surname") +
							      enter + "Age: " + rt_name.getInt("age") + enter + "Height: " + rt_name.getInt("height") + enter + "Spike: " +
							      rt_name.getInt("Spike") + enter + "Block: " + rt_name.getInt("Block") + enter + "Club: " +
							      rt_name2.getString("name") + enter + enter;
				    index++;
				}
				st_name.close();
				rt_name.close();
				return PlayerData;
			
		}
			

			public String searchByClub(String club) throws SQLException {
				Statement st_name = con.createStatement();
				Statement st_name2 = con.createStatement();
				String zapytanie = "SELECT * FROM Player NATURAL JOIN Club a where a.name='"+club+"';";
				
				String zapytanie2 ="SELECT name from Club WHERE name='"+club+"';";
				ResultSet rt_name = st_name.executeQuery(zapytanie);
				ResultSet rt_name2 = st_name2.executeQuery(zapytanie2);
				String PlayerData = "";
				String enter = "\n";
				int index = 0;
				while(rt_name.next()) {				
					PlayerData += enter + "name: " + rt_name.getString("first_name") + enter + "Surname: " + rt_name.getString("surname") +
							      enter + "Age: " + rt_name.getInt("age") + enter + "Height: " + rt_name.getInt("height") + enter + "Spike: " +
							      rt_name.getInt("Spike") + enter + "Block: " + rt_name.getInt("Block") + enter + "Club: " +
							      rt_name2.getString("name") + enter + enter;
				    index++;
				}
				st_name.close();
				rt_name.close();
				return PlayerData;
			
		}

			public String searchBySurname(String surname) throws SQLException {
				Statement st_name = con.createStatement();
				Statement st_name2 = con.createStatement();
				String zapytanie = "SELECT * from player where surname='"+surname+"';";
				String zapytanie2 ="SELECT a.name, b.first_name FROM Club a NATURAL JOIN Player b WHERE surname='"+surname+"';";
				ResultSet rt_name = st_name.executeQuery(zapytanie);
				ResultSet rt_name2 = st_name2.executeQuery(zapytanie2);
				String PlayerData = "";
				String enter = "\n";
				int index = 0;
				while(rt_name.next()) {				
					PlayerData += enter + "name: " + rt_name.getString("first_name") + enter + "Surname: " + rt_name.getString("surname") +
							      enter + "Age: " + rt_name.getInt("age") + enter + "Height: " + rt_name.getInt("height") + enter + "Spike: " +
							      rt_name.getInt("Spike") + enter + "Block: " + rt_name.getInt("Block") + enter + "Club: " +
							      rt_name2.getString("name") + enter + enter;
				    index++;
				}
				st_name.close();
				rt_name.close();
				return PlayerData;
			
		}
			
			
			
			
		public String showAllPlayers() throws SQLException {
			Statement st_showAll = con.createStatement();
			String zapytanie = "SELECT * from player";
			ResultSet rt_showAll= st_showAll.executeQuery(zapytanie);			
			String allPlayers = "";
			String enter = "\n";
			while(rt_showAll.next()) {
				
				allPlayers += enter + "name: " + rt_showAll.getString("first_name") + enter + "Surname: " + rt_showAll.getString("surname") +
					      enter + "Age: " + rt_showAll.getInt("age") + enter + "Height: " + rt_showAll.getInt("height") + enter + "Spike: " +
					      rt_showAll.getInt("Spike") + enter + "Block: " + rt_showAll.getInt("Block") + enter + "Club: " +
					      rt_showAll.getString("clubID") + enter + enter;				
			}
			st_showAll.close();
			rt_showAll.close();
			return allPlayers;
			
		}
		
		public void addPlayer(String first_name, String surname, String login, String password, String age, String height, String spike, String block, String position, String club) throws SQLException {
			
            Statement st1 = con.createStatement();
			String query = "INSERT INTO Player (first_name, surname, login, password, age, height, spike, block, positionID, clubID) VALUES ('"+first_name+"','"+surname+"','"+login+"','"+password+"','"+age+"','"+height+"','"+spike+"','"+block+"','"+position+"','"+club+"')"; 
				
			
			
			st1.execute(query);
			st1.close();
		
			
		}
		
		public void changePassword(String username, String password) throws SQLException {
			
			Statement st2 = con.createStatement();
			
			String zapytanie = "UPDATE Player SET password='"+password+"' WHERE login='"+username+"';";
			st2.execute(zapytanie);
			st2.close();
		}
		
		
		public String getPassword(String login, String table) throws SQLException {
			Statement st_pswd = con.createStatement();
			String zapytanie = "SELECT * from '" + table + "' where login='"+login+"';";
			ResultSet rt_pswd = st_pswd.executeQuery(zapytanie);
			
			while(rt_pswd.next()) {
				real_password = rt_pswd.getString("password");
			}
			
			st_pswd.close();
			rt_pswd.close();
			
			return real_password;
		}
		
		
		public String displayLinkedList(char player_or_coach, int id) {
		    String stats = "";
			if( player_or_coach == 'p') {
/*				for(int i = 0; i < playersList.size(); i++) {
						log.debug(playersList.get(i));
					}*/
				stats = playersList.get(id-1).display();
			}
			
			else if( player_or_coach == 'c') {
	/*			for(int i = 0; i < coachesList.size(); i++) {
					log.debug(coachesList.get(i));
				}*/
				stats = coachesList.get(id-1).display();
					
		    }
			
			return stats;
		}


		

		

       

}

