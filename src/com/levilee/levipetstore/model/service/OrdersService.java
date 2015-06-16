package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Orders;

public interface OrdersService {
	//Ìí¼Ó¶©µ¥
	public boolean add(Orders orders);
	//É¾³ý¶©µ¥
	public boolean delete(int orderid);
	//ÐÞ¸Ä¶©µ¥
	public boolean update(Orders orders);
	//²éÑ¯¶©µ¥
	public List<Orders> getOrders();
	public Orders getOrder(int orderid);

}
