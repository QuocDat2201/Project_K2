package models;

import java.sql.PreparedStatement;

import entites.Products;


public class Product_model {
	public boolean Create(Products products) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into product(ProductName, Category_id, Price, Quantity) values(?,?,?,?)");
			preparedStatement.setString(1, products.getProductName());
			preparedStatement.setInt(2, products.getCategory_id());
			preparedStatement.setBigDecimal(3, products.getPrice());
			preparedStatement.setInt(4, products.getQuantity());
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
