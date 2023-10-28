package models;

import java.sql.PreparedStatement;

import entites.Category;

public class Category_model {
	public boolean Create(Category category) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into category(CategoryName) values(?)");
			preparedStatement.setString(1, category.getCategoryName());
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
