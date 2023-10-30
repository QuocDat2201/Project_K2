package entites;

import java.math.BigDecimal;

public class Products {
	private int ProductID;
	private String ProductName;
	private int Category_id;
	private BigDecimal Price;
	private int Quantity;
	private boolean Status;
	
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getCategory_id() {
		return Category_id;
	}
	public void setCategory_id(int category_id) {
		Category_id = category_id;
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
	
}
