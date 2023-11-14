package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entites.Purchaseinvoicedetails;

public class Purchaseinvoicedetails_model {
	public boolean Create(Purchaseinvoicedetails purchaseinvoicedetails) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into purchaseinvoicedetails(InvoiceID, ProductID, Quantity, UnitPrice) values(?,?,?,?)");
			preparedStatement.setInt(1, purchaseinvoicedetails.getInvoiceID());
			preparedStatement.setInt(2, purchaseinvoicedetails.getProductID());
			preparedStatement.setInt(3, purchaseinvoicedetails.getQuantity());
			preparedStatement.setBigDecimal(4, purchaseinvoicedetails.getUnitPrice());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<Purchaseinvoicedetails> findInvoice_id() {
		List<Purchaseinvoicedetails> purchaseinvoicedetails = new ArrayList<Purchaseinvoicedetails>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from purchaseinvoicedetails where InvoiceID = ? ");// java.sql
			preparedStatement.setInt(1, 0);
			ResultSet resultSet = preparedStatement.executeQuery();// java.sql
			while (resultSet.next()) {// .next la kiem tra xem co con dong hay ko
				Purchaseinvoicedetails purchaseinvoicedetail = new Purchaseinvoicedetails();
			
				purchaseinvoicedetail.setDetailID(resultSet.getInt("DetailsID"));
				purchaseinvoicedetail.setInvoiceID(resultSet.getInt("InvoiceID"));
				purchaseinvoicedetail.setProductID(resultSet.getInt("ProductID"));
				purchaseinvoicedetail.setQuantity(resultSet.getInt("Quantity"));
				purchaseinvoicedetail.setUnitPrice(resultSet.getBigDecimal("UnitPrice"));
				purchaseinvoicedetails.add(purchaseinvoicedetail);
			}
		} catch (Exception e) {
			purchaseinvoicedetails = null;
		} finally {
			ConnectDB.disconnect();
		}
		return purchaseinvoicedetails;
	}
	
	public boolean Update(Purchaseinvoicedetails purchaseinvoicedetails) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update purchaseinvoicedetails set InvoiceID = ? where DetailsID = ?");
			preparedStatement.setInt(1,purchaseinvoicedetails.getInvoiceID());
			preparedStatement.setInt(2,purchaseinvoicedetails.getDetailID());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean deletepurchase_id(){
		boolean result = true  ; 
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement
					("delete from purchaseinvoicedetails where InvoiceID = ?");//java.sql
			preparedStatement.setInt(1, 0);
			result = preparedStatement.executeUpdate()>0 ; //tu hieu luon :)) la neu them dc thi so dong se tang 
		} catch (Exception e) {
			e.printStackTrace();
			 result = false ; 
		}finally {
			ConnectDB.disconnect();
		} return result; 
	}
}
