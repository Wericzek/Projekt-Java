package nawa;


public class Coach {
	
	int ID;
	String first_name;
	String surname;
	String login;
	String password;
		
	public Coach(int id, String n, String s, String l, String p) {
		ID = id;
		first_name = n;
		surname = s;
		login = l;
		password = p;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID=ID;
	}
	public String getFirst_Name() {
		return first_name;
	}
	public void setFirst_Name(String first_name) {
		this.first_name=first_name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname=surname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login=login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String display() {
		String CoachesData = "\nname: " + first_name + "\n" + "Surname: " + surname + "\n";
		return CoachesData;
	}
	

}
