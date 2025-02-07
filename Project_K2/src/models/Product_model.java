package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Category;
import entites.Products;

public class Product_model {
	public boolean Create(Products products) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into products(ProductName, Category_id, Price, Quantity, Status) values(?,?,?,?,?)");
			preparedStatement.setString(1, products.getProductName());
			preparedStatement.setInt(2, products.getCategory_id());
			preparedStatement.setBigDecimal(3, products.getPrice());
			preparedStatement.setInt(4, products.getQuantity());
			preparedStatement.setBoolean(5, products.isStatus());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public List<Products> findAll() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from products");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}

	public Products find(int id) {
		Products product = new Products();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from products where ProductID = ? ");// java.sql
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				
			}
		} catch (Exception e) {
			product = null;
		} finally {
			ConnectDB.disconnect();
		}
		return product;
	}
	
	public int findCID(int id) {
		int Product_Number = 0;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select count(*) as productnumber from products where Category_id = ? ");// java.sql
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Product_Number = resultSet.getInt("productnumber");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return Product_Number;
	}
	
	public List<Products> Search(String name) {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products where ProductName like ?");// java.sql
			preparedStatement.setString(1, name + "%");
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Search_Cateogry(int id) {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products where Category_id = ?");// java.sql
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Search_Status(boolean status) {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products where Status = ?");// java.sql
			preparedStatement.setBoolean(1, status);
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_ID_asc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by ProductID asc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_ID_desc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by ProductID desc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Name_asc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by ProductName asc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Name_desc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by ProductName desc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Cateogry_asc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by Category_id asc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Cateogry_desc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by Category_id desc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Price_asc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by price asc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Price_desc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by price desc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Quantity_asc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by quantity asc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Quantity_desc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by quantity desc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Status_asc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by status asc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public List<Products> Sort_Status_desc() {
		List<Products> products = new ArrayList<Products>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from products order by status desc");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Products product = new Products();
				product.setProductID(resultSet.getInt("ProductID"));
				product.setProductName(resultSet.getString("ProductName"));
				product.setCategory_id(resultSet.getInt("Category_id"));
				product.setPrice(resultSet.getBigDecimal("Price"));
				product.setQuantity(resultSet.getInt("Quantity"));
				product.setStatus(resultSet.getBoolean("Status"));
				products.add(product);
			}
		} catch (Exception e) {
			products = null;
		} finally {
			ConnectDB.disconnect();
		}
		return products;
	}
	
	public boolean Delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("delete from products where ProductID = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}

		return result;
	}
	
	public boolean DeleteAll(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("delete from products where Category_id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}

		return result;
	}
	
	public boolean Update(Products products) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update products set ProductName = ?, Category_id = ?, Price = ?, Quantity = ?, Status = ? where ProductID = ?");
			preparedStatement.setString(1, products.getProductName());
			preparedStatement.setInt(2, products.getCategory_id());
			preparedStatement.setBigDecimal(3, products.getPrice());
			preparedStatement.setInt(4, products.getQuantity());
			preparedStatement.setBoolean(5, products.isStatus());
			preparedStatement.setInt(6, products.getProductID());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean UpdateQuantity(Products products) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update products set Quantity = ? where ProductID = ?");
			
			preparedStatement.setInt(1, products.getQuantity());
			preparedStatement.setInt(2, products.getProductID());
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
