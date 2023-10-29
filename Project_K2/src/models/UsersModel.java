package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import entites.Users;

public class UsersModel {
	public List<Users> findAll() {
		List<Users> users = new ArrayList<Users>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from users");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Users user = new Users();
				user.setUserID(resultSet.getInt("UserID"));
				user.setUsername(resultSet.getString("Username"));
				user.setPassword(resultSet.getString("Password"));
				user.setRoleID(resultSet.getInt("RoleID"));
				users.add(user);
			}
		} catch (Exception e) {
			users = null;
		} finally {
			ConnectDB.disconnect();
		}
		return users;
	}

	public Users login(String username, String password) {
		UsersModel usersModel = new UsersModel();
		for (Users user : usersModel.findAll()) {
			boolean hashpass = BCrypt.checkpw(password, user.getPassword());
			if (user.getUsername().equalsIgnoreCase(username) && hashpass == true) {
				return user;
			}
		}
		return null;
	}

	public boolean register(Users users) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into users(Username, Password, RoleID) values(?,?,?)");
			preparedStatement.setString(1, users.getUsername());
			preparedStatement.setString(2, users.getPassword());
			preparedStatement.setInt(3, users.getRoleID());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		
		return result;
	}
}
