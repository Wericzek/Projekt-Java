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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height=height;
	}
	public int getSpike() {
		return spike;
	}
	public void setSpike(int spike) {
		this.spike=spike;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block=block;
	}
	public int getPositionID() {
		return positionID;
	}
	public void setPositionID(int positionID) {
		this.positionID=positionID;
	}
	public int getClubID() {
		return clubID;
	}
	public void setClubID(int clubID) {
		this.clubID=clubID;
	}

}

