package entites;

import java.math.BigDecimal;

public class Purchaseinvoicedetails {
	private int DetailID;
	private int InvoiceID;
	private int ProductID;
	private int Quantity;
	private BigDecimal unitPrice;
	
	public int getDetailID() {
		return DetailID;
	}
	public void setDetailID(int detailID) {
		DetailID = detailID;
	}
	public int getInvoiceID() {
		return InvoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		InvoiceID = invoiceID;
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
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
