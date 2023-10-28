package models;

import java.sql.PreparedStatement;

import entites.Suppliers;

public class Suppliers_model {
	public boolean Create(Suppliers suppliers) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into supplier(SupplierName, ContactName, Email, Phone) values(?,?,?,?)");
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
}
