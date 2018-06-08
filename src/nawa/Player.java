package nawa;

public class Player {
	int ID;
	String first_name;
	String surname;
	String login;
	String password;
	int age;
	int height;
	int spike;
	int block;
	int positionID;
	int clubID;
	public Player(int id, String f, String s, String l, String p, int a, int h, int sp, int b, int pos, int c_id) {
		ID = id;
		first_name = f;
		surname = s;
		login = l;
		password = p;
		age = a;
		height = h;
		spike = sp;
		block = b;
		positionID = pos;
		clubID = c_id;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getSurname() {
		return surname;
	}
	
}

