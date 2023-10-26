package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Users;

public class UsersModel {
	 public List<Users> findAll(){
		 List<Users> users = new ArrayList<Users>();
		 try {
			 PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from users");
			 ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Users user = new Users() ;
					user.setUserID(resultSet.getInt("UserID"));
					user.setUsername(resultSet.getString("Username"));
					user.setPassword(resultSet.getString("Password"));
					user.setRoleID(resultSet.getInt("RoleID"));
					users.add(user);
				}
		} catch (Exception e) {
			users = null ; 
		}finally {
			ConnectDB.disconnect();
		}return users ; 
	 }
	 
	 public Users login(String username , String password) {
		 UsersModel usersModel = new UsersModel() ; 
		 for(Users user : usersModel.findAll()) {
			 if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
				 return user ; 
			 }
		 }return null ; 
	 }
}
