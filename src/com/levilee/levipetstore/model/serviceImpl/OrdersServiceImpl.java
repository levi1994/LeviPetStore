package com.levilee.levipetstore.model.serviceImpl;

import java.util.List;

import com.levilee.levipetstore.model.service.OrdersService;
import com.levilee.levipetstore.orm.dao.OrdersDao;
import com.levilee.levipetstore.orm.entity.Orders;
import com.levilee.levipetstore.orm.util.HibernateUtil;
import com.levilee.levipetstore.orm.util.LogUtil;

public class OrdersServiceImpl implements OrdersService {
    private OrdersDao ordersDao = new OrdersDao();
	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public boolean add(Orders orders) {
		//1.���ɶ�����
		int orderid = HibernateUtil.getId("ordernum");
		orders.setOrderid(orderid);
		try {
			ordersDao.add(orders);
		} catch (Exception e) {
			LogUtil.log.error("��Ӷ�������");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int orderid) {
		try {
			ordersDao.delete(orderid);
		} catch (Exception e) {
			LogUtil.log.error("����ɾ��error");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Orders orders) {
		try {
			ordersDao.update(orders);
		} catch (Exception e) {
			LogUtil.log.error("���ݸ���ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Orders> getOrders() {
		List<Orders> list=null ;
		try {
			list = ordersDao.get();
		} catch (Exception e) {
			LogUtil.log.error("��ȡ����ʧ��");
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public Orders getOrder(int orderid) {
		Orders o=null;
	    try {
			o = (Orders) ordersDao.get(orderid);
		} catch (Exception e) {
			LogUtil.log.error("������ȡʧ��");
			e.printStackTrace();
			return null;
		}
		return o;
	}
}
