package models;

import java.sql.Date;
import java.sql.PreparedStatement;

import entites.Invoices;


public class Invoice_model {
	public boolean Create(Invoices invoices) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into invoices(SaleID, InvoiceDate, CustomerName, Status) values(?,?,?,?)");
			preparedStatement.setInt(1, invoices.getSaleID());
			preparedStatement.setDate(2, new java.sql.Date(invoices.getInvoiceDate().getTime()));
			preparedStatement.setString(3, invoices.getCustomerName());
			preparedStatement.setBoolean(4, invoices.isStatus());
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
