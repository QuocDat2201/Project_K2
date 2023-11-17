package entites;

import java.math.BigDecimal;

public class ProductTopsaler {
private String nameString;
private BigDecimal totalBigDecimal;
private int quantity ;
public String getNameString() {
	return nameString;
}
public void setNameString(String nameString) {
	this.nameString = nameString;
}
public BigDecimal getTotalBigDecimal() {
	return totalBigDecimal;
}
public void setTotalBigDecimal(BigDecimal totalBigDecimal) {
	this.totalBigDecimal = totalBigDecimal;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
