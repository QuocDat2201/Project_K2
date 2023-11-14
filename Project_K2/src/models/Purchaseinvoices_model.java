package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entites.Purchaseinvoices;


public class Purchaseinvoices_model {
	public int Create(Purchaseinvoices purchaseinvoices) {
		boolean result = true;
		int newSalesID = -1;
		try {
			Connection connection = ConnectDB.connection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into purchaseinvoices(SupplierID, InvoiceDate, TotalAmount) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, purchaseinvoices.getSupplierID());
			preparedStatement.setDate(2, new java.sql.Date(purchaseinvoices.getInvoiceDate().getTime()));
			preparedStatement.setBigDecimal(3, purchaseinvoices.getTotalAmount());
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows == 0) {
	            // Xử lý lỗi nếu không thêm được bản ghi Sales
	        } else {
	            // Lấy ID mới tạo sau khi thêm
	            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    newSalesID = generatedKeys.getInt(1);
	                } else {
	                    // Xử lý lỗi nếu không lấy được ID mới
	                }
	            }
	        }
		} catch (Exception e) {
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return newSalesID;
	}
}
