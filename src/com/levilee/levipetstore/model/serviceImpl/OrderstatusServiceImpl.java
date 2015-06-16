package com.levilee.levipetstore.model.serviceImpl;

import java.sql.Date;

import com.levilee.levipetstore.model.service.OrderstatusService;
import com.levilee.levipetstore.orm.dao.OrderstatusDao;
import com.levilee.levipetstore.orm.entity.Orderstatus;
import com.levilee.levipetstore.orm.entity.key.OrderstatusKey;
import com.levilee.levipetstore.orm.util.LogUtil;

public class OrderstatusServiceImpl implements OrderstatusService {
    private OrderstatusDao orderstatusDao = new OrderstatusDao();
	@Override
	public boolean add(int orderid, int linenum, Date timestamp, String status) {
		Orderstatus o = new Orderstatus();
		OrderstatusKey key = new OrderstatusKey();
		key.setOrderid(orderid);
		key.setLinenum(linenum);
		o.setOrderstatusKey(key);
		o.setTimestamp(timestamp);
		o.setStatus(status);
		try {
			orderstatusDao.add(o);
		} catch (Exception e) {
			LogUtil.log.error("¶©µ¥×´Ì¬Ìí¼ÓÊ§°Ü");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public OrderstatusDao getOrderstatusDao() {
		return orderstatusDao;
	}

	public void setOrderstatusDao(OrderstatusDao orderstatusDao) {
		this.orderstatusDao = orderstatusDao;
	}

	@Override
	public boolean delete(int orderid, int linenum) {
		OrderstatusKey key = new OrderstatusKey();
		key.setLinenum(linenum);
		key.setOrderid(orderid);
		try {
			orderstatusDao.delete(key);
		} catch (Exception e) {
			LogUtil.log.error("É¾³ý¶©µ¥×´Ì¬Ê§°Ü");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Orderstatus orderstatus) {
		try {
			orderstatusDao.update(orderstatus);
		} catch (Exception e) {
			LogUtil.log.error("¸üÐÂ¶©µ¥×´Ì¬Ê§°Ü");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Orderstatus getOrderstatus(int orderid,int linenum) {
		OrderstatusKey key = new OrderstatusKey();
		key.setLinenum(linenum);
		key.setOrderid(orderid);
		Orderstatus o=null;
		try {
			o = (Orderstatus) orderstatusDao.get(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return o;
	}

}
