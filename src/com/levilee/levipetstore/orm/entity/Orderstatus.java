package com.levilee.levipetstore.orm.entity;

import java.sql.Date;

import com.levilee.levipetstore.orm.entity.key.OrderstatusKey;

public class Orderstatus {
	private OrderstatusKey orderstatusKey;
	private Date timestamp;
	private String status;
	public OrderstatusKey getOrderstatusKey() {
		return orderstatusKey;
	}
	public void setOrderstatusKey(OrderstatusKey orderstatusKey) {
		this.orderstatusKey = orderstatusKey;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
