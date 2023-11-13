package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Customer;

public class CustomerModel {
    private List<Customer> customerList;

    public CustomerModel() {
        customerList = new ArrayList<>();
    }

    // Phương thức để thêm một khách hàng vào danh sách
    public boolean create(Customer customer) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = ConnectDB.connection()
                    .prepareStatement("INSERT INTO customer(Name, PhoneNumber, Point, Rank) VALUES(?,?,?,?)");
            preparedStatement.setString(1, customer.getNameString());
            preparedStatement.setString(2, customer.getPhoneString());
            preparedStatement.setInt(3, customer.getPoint());
            preparedStatement.setInt(4, customer.getRank());
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            ConnectDB.disconnect();
        }
        return result;
    }
    public boolean Update(Customer customer) {
        boolean result = true;
        try {
            PreparedStatement preparedStatement = ConnectDB.connection()
                    .prepareStatement("UPDATE `customer` SET  `Name` = ?, `Point` = ? WHERE `customer`.`PhoneNumber` = ?");
   
           preparedStatement.setString(1, customer.getNameString());
            preparedStatement.setInt(2, customer.getPoint());
            preparedStatement.setString(3, customer.getPhoneString());
           
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            ConnectDB.disconnect();
        }
        return result;
    }
    // Phương thức để truy xuất tất cả khách hàng
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("CustomerId"));
                customer.setNameString(resultSet.getString("Name"));
                customer.setPhoneString(resultSet.getString("PhoneNumber"));
                customer.setPoint(resultSet.getInt("Point"));
                customer.setRank(resultSet.getInt("Rank"));
                customers.add(customer);
            }
        } catch (Exception e) {
            customers = null;
        } finally {
            ConnectDB.disconnect();
        }
        return customers;
    }
}
