package com.levilee.levipetstore.model.serviceImpl;

import java.util.List;
import com.levilee.levipetstore.model.service.LineItemService;
import com.levilee.levipetstore.orm.dao.LineItemDao;
import com.levilee.levipetstore.orm.entity.LineItem;
import com.levilee.levipetstore.orm.entity.key.LineItemKey;
import com.levilee.levipetstore.orm.util.LogUtil;

public class LineItemServiceImpl implements LineItemService {
    private LineItemDao lineItemDao = new LineItemDao();
	public LineItemDao getLineItemDao() {
		return lineItemDao;
	}

	public void setLineItemDao(LineItemDao lineItemDao) {
		this.lineItemDao = lineItemDao;
	}

	@Override
	public boolean add(LineItem lineItem) {
		try {
			lineItemDao.add(lineItem);
		} catch (Exception e) {
			LogUtil.log.error("LineItem添加失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean add(int orderid, int linenum, String itemid,
			int quantity, double unitprice) {
		LineItemKey key = new LineItemKey();
		LineItem item = new LineItem();
		key.setOrderid(orderid);
		key.setLinenum(linenum);
		item.setLineItemKey(key);
		item.setItemid(itemid);
		item.setQuantity(quantity);
		item.setUnitprice(unitprice);
		try {
			lineItemDao.add(item);
		} catch (Exception e) {
			LogUtil.log.error("添加Lineitem失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(LineItem lineItem) {
		try {
			lineItemDao.delete(lineItem);
		} catch (Exception e) {
			LogUtil.log.error("LineItem删除失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(LineItemKey key) {
		try {
			lineItemDao.delete(key);
		} catch (Exception e) {
			LogUtil.log.error("LineItem删除失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<LineItem> getLineItems() {
		List<LineItem> list = null;
		try {
			list = lineItemDao.get();
		} catch (Exception e) {
			LogUtil.log.error("获取失败");
			e.printStackTrace();
		}
		LogUtil.log.info("获取LineItem信息成功");
		return list;
	}

	@Override
	public List<LineItem> getLineItems(int orderid) {
		List<LineItem> list = null;
		try {
			list = lineItemDao.getByCondition("  where orderid="+orderid);
		} catch (Exception e) {
			LogUtil.log.error("获取失败");
			e.printStackTrace();
			return null;
		}
		LogUtil.log.info("获取LineItem信息成功");
		return list;
	}

	@Override
	public LineItem getLineItem(LineItemKey key) {
		LineItem item = null;
		try {
			item = (LineItem) lineItemDao.get(key);
		} catch (Exception e) {
			LogUtil.log.error("查询LineItem失败");
			e.printStackTrace();
		}
		return item;
	}

}
