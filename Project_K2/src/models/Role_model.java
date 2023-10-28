package models;

import java.sql.PreparedStatement;

import entites.Role;


public class Role_model {
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
