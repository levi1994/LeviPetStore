package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Orders;

public interface OrdersService {
	//��Ӷ���
	public boolean add(Orders orders);
	//ɾ������
	public boolean delete(int orderid);
	//�޸Ķ���
	public boolean update(Orders orders);
	//��ѯ����
	public List<Orders> getOrders();
	public Orders getOrder(int orderid);

}
