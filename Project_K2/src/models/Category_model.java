package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Category;
import entites.Products;

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

	public List<Category> findAll() {
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from category");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Category category = new Category();
				category.setCategoryID(resultSet.getInt("CategoryID"));
				category.setCategoryName(resultSet.getString("CategoryName"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			categories = null;
		} finally {
			ConnectDB.disconnect();
		}

		return categories;
	}

	public Category find(int id) {
		Category categories = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from category where CategoryID = ?");// java.sql
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				categories = new Category();
				categories.setCategoryID(resultSet.getInt("CategoryID"));
				categories.setCategoryName(resultSet.getString("CategoryName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			categories = null;
		} finally {
			ConnectDB.disconnect();
		}

		return categories;
	}
	public Category find2(int id) {
		Category category = new Category() ;		 
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from category where CategoryID = ?");// java.sql
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				category = new Category() ;
				category.setCategoryID(resultSet.getInt("CategoryID"));
				category.setCategoryName(resultSet.getString("CategoryName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			category = null;
		} finally {
			ConnectDB.disconnect();
		}
		return category;
	}
	
	public List<Category> Search(String name) {
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from category where CategoryName like ?");// java.sql
			preparedStatement.setString(1, name + "%");
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Category category = new Category();
				category.setCategoryID(resultSet.getInt("CategoryID"));
				category.setCategoryName(resultSet.getString("CategoryName"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			categories = null;
		} finally {
			ConnectDB.disconnect();
		}

		return categories;
	}
	
	public List<Category> Sort_CatName_asc() {
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from category order by CategoryName asc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Category category = new Category();
				category.setCategoryID(resultSet.getInt("CategoryID"));
				category.setCategoryName(resultSet.getString("CategoryName"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			categories = null;
		} finally {
			ConnectDB.disconnect();
		}

		return categories;
	}
	
	public List<Category> Sort_CatName_desc() {
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from category order by CategoryName desc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Category category = new Category();
				category.setCategoryID(resultSet.getInt("CategoryID"));
				category.setCategoryName(resultSet.getString("CategoryName"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			categories = null;
		} finally {
			ConnectDB.disconnect();
		}

		return categories;
	}
	
	public List<Category> Sort_CatID_asc() {
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from category order by CategoryID asc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Category category = new Category();
				category.setCategoryID(resultSet.getInt("CategoryID"));
				category.setCategoryName(resultSet.getString("CategoryName"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			categories = null;
		} finally {
			ConnectDB.disconnect();
		}

		return categories;
	}
	
	public List<Category> Sort_CatID_desc() {
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from category order by CategoryID desc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Category category = new Category();
				category.setCategoryID(resultSet.getInt("CategoryID"));
				category.setCategoryName(resultSet.getString("CategoryName"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
			categories = null;
		} finally {
			ConnectDB.disconnect();
		}

		return categories;
	}
}
