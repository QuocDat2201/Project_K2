package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Customer;
import entites.Suppliers;

public class Suppliers_model {
	public boolean Create(Suppliers suppliers) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into suppliers(SupplierName, ContactName, Email, Phone) values(?,?,?,?)");
			preparedStatement.setString(1, suppliers.getSupplierName());
			preparedStatement.setString(2, suppliers.getContactName());
			preparedStatement.setString(3, suppliers.getEmail());
			preparedStatement.setString(4, suppliers.getPhone());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	 public List<Suppliers> findAll() {
	        List<Suppliers> suppleirs= new ArrayList<>();
	        try {
	            PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT * FROM  suppliers");
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                Suppliers supplier=new Suppliers();
	               // supplier.setSupplierID(resultSet.getInt("SupplierID"));
	                supplier.setSupplierName(resultSet.getString("SupplierName"));
	                supplier.setContactName(resultSet.getString("ContactName"));
	                supplier.setEmail(resultSet.getString("Email"));
	                supplier.setPhone(resultSet.getString("Phone"));
	                suppleirs.add(supplier);
	            }
	        } catch (Exception e) {
	        	 suppleirs = null;
	        	 e.printStackTrace();
	        } finally {
	            ConnectDB.disconnect();
	        }
	        return  suppleirs;
	    }
}
