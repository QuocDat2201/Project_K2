package entites;

import java.math.BigDecimal;
import java.util.Date;

public class CombinedData {
    private int saleID;
    private Date invoiceDate;
    private String customerName;
    private int productID;
    private int quantity;
    private BigDecimal price;
    private boolean status ; 

    public CombinedData(int saleID, Date invoiceDate, String customerName, int productID, int quantity, BigDecimal price) {
        this.saleID = saleID;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

	public int getSaleID() {
		return saleID;
	}

	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
}

