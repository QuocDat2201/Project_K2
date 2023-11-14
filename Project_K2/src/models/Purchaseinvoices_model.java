package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entites.Purchaseinvoicedetails;
import entites.Purchaseinvoices;
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
<<<<<<< HEAD

	public List<Purchaseinvoices> findAll() {
		
		List<Purchaseinvoices> purchaseinvoices = new ArrayList<Purchaseinvoices>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from purchaseinvoices");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Purchaseinvoices purchaseinvoice = new Purchaseinvoices();	
				purchaseinvoice.setInvoiceID(resultSet.getInt("InvoiceID"));
				purchaseinvoice.setSupplierID(resultSet.getInt("SupplierID"));
				purchaseinvoice.setInvoiceDate(resultSet.getDate("InvoiceDate"));
				purchaseinvoice.setTotalAmount(resultSet.getBigDecimal("TotalAmount"));
=======
	
	public List<Purchaseinvoices> findAll() {
		List<Purchaseinvoices> purchaseinvoices = new ArrayList<Purchaseinvoices>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from purchaseinvoices");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Purchaseinvoices purchaseinvoice = new Purchaseinvoices();
				purchaseinvoice.setInvoiceID(resultSet.getInt("InvoiceID"));
				purchaseinvoice.setSupplierID(resultSet.getInt("SupplierID"));
				purchaseinvoice.setInvoiceDate(resultSet.getDate("InvoiceDate"));
				purchaseinvoice.setTotalAmount(resultSet.getBigDecimal("TotalAmount"));
				
>>>>>>> branch 'main' of https://github.com/QuocDat2201/Project_K2
				purchaseinvoices.add(purchaseinvoice);
			}
		} catch (Exception e) {
			purchaseinvoices = null;
		} finally {
			ConnectDB.disconnect();
		}
		return purchaseinvoices;
	}
}
