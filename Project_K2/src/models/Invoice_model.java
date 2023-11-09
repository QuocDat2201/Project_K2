package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Invoices;
import entites.Products;


public class Invoice_model {
	public boolean Create(Invoices invoices) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into invoices( InvoiceDate, CustomerName, Status,Total) values(?,?,?,?)");
			
			preparedStatement.setDate(1, new java.sql.Date(invoices.getInvoiceDate().getTime()));
			preparedStatement.setString(2, invoices.getCustomerName());
			preparedStatement.setBoolean(3, invoices.isStatus());
			preparedStatement.setBigDecimal(4, invoices.getTotal());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	public List<Double> findtotal() {
		List<Double> total = new ArrayList<Double>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT SUM(s.Price)as total FROM invoices i JOIN sales s ON i.SaleID=s.SaleID JOIN products p ON s.ProductID = p.ProductID JOIN category c ON p.Category_id= c.CategoryID GROUP BY c.CategoryName;");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				total.add(resultSet.getDouble("total"));
			}
		} catch (Exception e) {
			total = null;
		} finally {
			ConnectDB.disconnect();
		}
		return total;
	}
	public List<Invoices> findAll() {
		List<Invoices> invoices = new ArrayList<Invoices>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from invoices");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Invoices invoice = new Invoices();
				invoice.setInvoiceID(resultSet.getInt("InvoiceID"));
				invoice.setInvoiceDate(resultSet.getDate("InvoiceDate"));
				invoice.setCustomerName(resultSet.getString("CustomerName"));
				invoice.setStatus(resultSet.getBoolean("Status"));
				invoice.setTotal(resultSet.getBigDecimal("Total"));
				invoices.add(invoice);
			}
		} catch (Exception e) {
			invoices = null;
		} finally {
			ConnectDB.disconnect();
		}
		return invoices;
	}
	
	
	public boolean update(Invoices invoices){
		boolean result = true  ; 
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement
					("update invoices set status = ? where InvoiceID = ?");//java.sql
			preparedStatement.setBoolean(1, invoices.isStatus());
			preparedStatement.setInt(2, invoices.getInvoiceID());
			result = preparedStatement.executeUpdate()>0 ; //tu hieu luon :)) la neu them dc thi so dong se tang 
		} catch (Exception e) {
			e.printStackTrace();
			 result = false ; 
		}finally {
			ConnectDB.disconnect();
		} return result; 
	}
}
