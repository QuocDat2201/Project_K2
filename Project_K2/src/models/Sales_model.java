package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entites.Invoices;
import entites.Sales;


public class Sales_model {
	public boolean Create(Sales sales) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into sales(ProductID, Quantity, Price) values(?,?,?)");
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
	public int getNewlyCreatedSalesID(Sales sales) {
		boolean result = true ; 
	    int newSalesID = -1; // Một giá trị mặc định nếu không tìm thấy ID mới

	    try {
	        Connection connection = ConnectDB.connection();
	        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sales (ProductID, Quantity, Price) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	        
	        // Thêm các giá trị cần thiết vào prepared statement
	        preparedStatement.setInt(1, sales.getProductID());
	        preparedStatement.setInt(2, sales.getQuantity());
	        preparedStatement.setBigDecimal(3, sales.getPrice());
	        
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
	    	e.printStackTrace();
	    	result = false;
	        // Xử lý lỗi nếu có lỗi trong quá trình thêm bản ghi
	    } finally {
	        ConnectDB.disconnect();
	    }
	    
	    return newSalesID;
	}
	
	public List<Sales> findAll() {
		List<Sales> sales = new ArrayList<Sales>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from sales");// java.sql
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Sales sale = new Sales();
				sale.setSaleID(resultSet.getInt("SaleID"));
				sale.setProductID(resultSet.getInt("ProductID"));
				sale.setQuantity(resultSet.getInt("Quantity"));
				sale.setPrice(resultSet.getBigDecimal("Price"));
				
				sales.add(sale);
			}
		} catch (Exception e) {
			sales = null;
		} finally {
			ConnectDB.disconnect();
		}
		return sales;
	}
	
	public boolean delete(int id){
		boolean result = true  ; 
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement
					("delete from sales where SaleID = ?");//java.sql
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate()>0 ; //tu hieu luon :)) la neu them dc thi so dong se tang 
		} catch (Exception e) {
			e.printStackTrace();
			 result = false ; 
		}finally {
			ConnectDB.disconnect();
		} return result; 
	}

}
