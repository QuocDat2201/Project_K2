package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	        // Xử lý lỗi nếu có lỗi trong quá trình thêm bản ghi
	    } finally {
	        ConnectDB.disconnect();
	    }
	    
	    return newSalesID;
	}


}
