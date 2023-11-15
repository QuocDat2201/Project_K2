package entites;

import java.util.Date;

public class Recieve {
	private int id_recieve ; 
	private String customer_recieve ; 
	private String address ; 
	private String phone ; 
	private String email ; 
	private String reason ; 
	private String product_name ; 
	private int quantity ;
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private Date date ;
	public int getId_recieve() {
		return id_recieve;
	}
	public void setId_recieve(int id_recieve) {
		this.id_recieve = id_recieve;
	}
	public String getCustomer_recieve() {
		return customer_recieve;
	}
	public void setCustomer_recieve(String customer_recieve) {
		this.customer_recieve = customer_recieve;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	} 
	
}
