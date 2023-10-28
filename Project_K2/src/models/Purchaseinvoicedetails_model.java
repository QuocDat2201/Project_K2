package models;

import java.sql.PreparedStatement;

import entites.Purchaseinvoicedetails;

public class Purchaseinvoicedetails_model {
	public boolean Create(Purchaseinvoicedetails purchaseinvoicedetails) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into purchaseinvoicedetails(InvoiceID, ProductID, Quantity, UnitPrice) values(?,?,?,?)");
			preparedStatement.setInt(1, purchaseinvoicedetails.getInvoiceID());
			preparedStatement.setInt(2, purchaseinvoicedetails.getProductID());
			preparedStatement.setInt(3, purchaseinvoicedetails.getQuantity());
			preparedStatement.setBigDecimal(4, purchaseinvoicedetails.getUnitPrice());
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
