package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Recieve;
import entites.Suppliers;

public class Recieve_model {
	public boolean Create(Recieve recieve) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into recieve(customer_recieve, address,phone,email,reason,date) values(?,?,?,?,?,?)");			
			preparedStatement.setString(1, recieve.getCustomer_recieve());
			preparedStatement.setString(2, recieve.getAddress());
			preparedStatement.setString(3, recieve.getPhone());
			preparedStatement.setString(4, recieve.getEmail());
			preparedStatement.setString(5, recieve.getReason());
			preparedStatement.setDate(6, new java.sql.Date(recieve.getDate().getTime()));
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<Recieve> findAll() {
        List<Recieve> recieves= new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT * FROM  recieve");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	Recieve recieve=new Recieve();
            	recieve.setAddress(resultSet.getString("address"));
            	recieve.setCustomer_recieve(resultSet.getString("customer_recieve"));
            	recieve.setDate(resultSet.getDate("date"));
            	recieve.setEmail(resultSet.getString("email"));
            	recieve.setId_recieve(resultSet.getInt("id_recieve"));
            	recieve.setPhone(resultSet.getString("phone"));
            	recieve.setReason(resultSet.getString("reason"));
            	
    
            	recieves.add(recieve);
            }
        } catch (Exception e) {
        	recieves = null;
        	 e.printStackTrace();
        } finally {
            ConnectDB.disconnect();
        }
        return recieves;
    }
}
