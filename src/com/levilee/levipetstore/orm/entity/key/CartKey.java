package com.levilee.levipetstore.orm.entity.key;

import java.io.Serializable;

public class CartKey implements Serializable{
	private static final long serialVersionUID = 1L;
	private String itemid;
	private String userid;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

}
