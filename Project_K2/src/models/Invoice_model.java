package models;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entites.Invoices;
import entites.Products;


public class Invoice_model {
	public boolean Create(Invoices invoices) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into invoices( InvoiceDate, CustomerName,CustomerPhone, Status,Total) values(?,?,?,?,?)");
			
			preparedStatement.setDate(1, new java.sql.Date(invoices.getInvoiceDate().getTime()));
			preparedStatement.setString(2, invoices.getCustomerName());
			preparedStatement.setString(3, invoices.getCustomerPhone());
			preparedStatement.setBoolean(4, invoices.isStatus());
			preparedStatement.setBigDecimal(5, invoices.getTotal());
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
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT SUM(i.Total)as total FROM invoices i JOIN sales s ON i.InvoiceID=s.Invoice_id JOIN products p ON s.ProductID = p.ProductID JOIN category c ON p.Category_id= c.CategoryID GROUP BY c.CategoryName;");// java.sql
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
				invoice.setCustomerPhone(resultSet.getString("CustomerPhone"));
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
	public Invoices findAllsort() {
		Invoices invoices = new Invoices();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from invoices order by InvoiceID desc limit 1;");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {
				invoices.setInvoiceID(resultSet.getInt("InvoiceID"));
				invoices.setInvoiceDate(resultSet.getDate("InvoiceDate"));
				invoices.setCustomerName(resultSet.getString("CustomerName"));
				invoices.setCustomerPhone(resultSet.getString("CustomerPhone"));
				invoices.setStatus(resultSet.getBoolean("Status"));
				invoices.setTotal(resultSet.getBigDecimal("Total"));
			}
			
		} catch (Exception e) {
			invoices = null;
		} finally {
			ConnectDB.disconnect();
		}
		return invoices;
	}
	public Map<String,List> findProductMap(String name,int month) {
		Map<String, List> map = new HashMap<String, List>();
		List<Date> dates = new ArrayList<Date>();
		List<Double> values = new ArrayList<Double>();
		List<String> nameProduct = new ArrayList<String>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT SUM(s.Quantity*s.Price)as Total ,i.InvoiceDate,p.ProductName FROM invoices i JOIN sales s ON i.InvoiceID=s.Invoice_id JOIN products p ON s.ProductID=p.ProductID WHERE p.ProductName='?' and MONTH(i.InvoiceDate) = ? GROUP BY p.ProductName,i.InvoiceDate;");// java.sql
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, month);
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				dates.add(resultSet.getDate("InvoiceDate"));
				values.add(resultSet.getDouble("Total"));
				nameProduct.add(resultSet.getString("ProductName"));
			}
			map.put("dates",dates);
			map.put("values", values);
			map.put("nameproducts", nameProduct);
			
		} catch (Exception e) {
			map=null;
		} finally {
			ConnectDB.disconnect();
		}
		return map;
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
