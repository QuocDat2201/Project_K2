package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public List<Products> findAll(){
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from products");//java.sql
			ResultSet resultSet = preparedStatement.executeQuery();//java.sql
			while(resultSet.next()) {//.next la kiem tra xem co con dong hay ko
			Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null ; 
		}finally {
			ConnectDB.disconnect();
		}return products ; 
	}
}



