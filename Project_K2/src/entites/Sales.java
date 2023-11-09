package entites;

import java.math.BigDecimal;

public class Sales {
	private int SaleID;
	private int ProductID;
	private int Quantity;
	private BigDecimal Price;
	private int Invoice_id;
	public int getInvoice_id() {
		return Invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		Invoice_id = invoice_id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	private String ProductName;
	
	public int getSaleID() {
		return SaleID;
	}
	public void setSaleID(int saleID) {
		SaleID = saleID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
	
	
}
