package models;

import java.sql.PreparedStatement;

import entites.Purchaseinvoices;


public class Purchaseinvoices_model {
	public boolean Create(Purchaseinvoices purchaseinvoices) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into purchaseinvoices(SupplierID, InvoiceDate, TotalAmount) values(?,?,?)");
			preparedStatement.setInt(1, purchaseinvoices.getSupplierID());
			preparedStatement.setDate(2, new java.sql.Date(purchaseinvoices.getInvoiceDate().getTime()));
			preparedStatement.setBigDecimal(3, purchaseinvoices.getTotalAmount());
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
