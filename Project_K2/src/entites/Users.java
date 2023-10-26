package entites;

public class Users {
	private int UserID;
	private String Username;
	private String password;
	private int RoleID;
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleID() {
		return RoleID;
	}
	public void setRoleID(int roleID) {
		RoleID = roleID;
	}
	public Users(int userID, String username, String password, int roleID) {
		super();
		UserID = userID;
		Username = username;
		this.password = password;
		RoleID = roleID;
	}
	public Users() {
		super();
	}
	
	
}
