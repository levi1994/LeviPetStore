package com.levilee.levipetstore.orm.entity.key;

import java.io.Serializable;

public class LineItemKey  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int orderid;
    private int linenum;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getLinenum() {
		return linenum;
	}
	public void setLinenum(int linenum) {
		this.linenum = linenum;
	}
}
