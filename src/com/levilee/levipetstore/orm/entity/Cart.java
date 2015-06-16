package com.levilee.levipetstore.orm.entity;

import com.levilee.levipetstore.orm.entity.key.CartKey;

public class Cart {
	private CartKey cartKey;
	private int amount;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public CartKey getCartKey() {
		return cartKey;
	}
	public void setCartKey(CartKey cartKey) {
		this.cartKey = cartKey;
	}


}
