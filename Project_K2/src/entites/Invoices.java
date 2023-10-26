package entites;

import java.util.Date;

public class Invoices {
	private int InvoiceID;
	private int SaleID;
	private Date InvoiceDate;
	private String CustomerName;
	private boolean Status;
	
	public int getInvoiceID() {
		return InvoiceID;
	}
	public void setInvoiceID(int invoiceID) {
		InvoiceID = invoiceID;
	}
	public int getSaleID() {
		return SaleID;
	}
	public void setSaleID(int saleID) {
		SaleID = saleID;
	}
	public Date getInvoiceDate() {
		return InvoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		InvoiceDate = invoiceDate;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	
	
}
