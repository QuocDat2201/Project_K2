package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Role;
import entites.Role;


public class Role_model {
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<Role>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from role");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Role role = new Role();
				role.setRole_id(resultSet.getInt("Role_id"));
				role.setRole_Name(resultSet.getString("Role_Name"));
				roles.add(role);
			}
		} catch (Exception e) {
			roles = null;
		} finally {
			ConnectDB.disconnect();
		}
		return roles;
	}
	public boolean Create(Role role) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into role(Role_Name) values(?)");
			preparedStatement.setString(1, role.getRole_Name());
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
