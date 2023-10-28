package models;

import java.sql.PreparedStatement;

import entites.Sales;


public class Sales_model {
	public boolean Create(Sales sales) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into sale(ProductID, Quantity, Price) values(?,?,?)");
			preparedStatement.setInt(1, sales.getProductID());
			preparedStatement.setInt(2, sales.getQuantity());
			preparedStatement.setBigDecimal(3, sales.getPrice());
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
