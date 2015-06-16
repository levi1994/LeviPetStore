package com.levilee.levipetstore.orm.entity;

import com.levilee.levipetstore.orm.entity.key.LineItemKey;

public class LineItem {
  private LineItemKey lineItemKey;
  private int quantity;
  private String itemid;
  private double unitprice;

public LineItemKey getLineItemKey() {
	return lineItemKey;
}
public void setLineItemKey(LineItemKey lineItemKey) {
	this.lineItemKey = lineItemKey;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getItemid() {
	return itemid;
}
public void setItemid(String itemid) {
	this.itemid = itemid;
}
public double getUnitprice() {
	return unitprice;
}
public void setUnitprice(double unitprice) {
	this.unitprice = unitprice;
}

}
