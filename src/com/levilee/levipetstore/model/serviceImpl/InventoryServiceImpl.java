package com.levilee.levipetstore.model.serviceImpl;

import java.util.List;

import com.levilee.levipetstore.model.service.InventoryService;
import com.levilee.levipetstore.orm.dao.InventoryDao;
import com.levilee.levipetstore.orm.entity.Inventory;
import com.levilee.levipetstore.orm.util.LogUtil;

public class InventoryServiceImpl implements InventoryService {
    private InventoryDao inventoryDao = new InventoryDao();
	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	@Override
	public int getQty(String itemid) {
		Inventory in = null;
		try {
			in = (Inventory) inventoryDao.get(itemid);
			return in.getQty();
		} catch (Exception e) {
			LogUtil.log.error("获取产品数量失败");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<InventoryService> getInventories() {
		List<InventoryService> list = null;
		try {
			list = inventoryDao.get();
		} catch (Exception e) {
			LogUtil.log.error("获取产品数量失败");
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public boolean add(String itemid, int qty) {
		Inventory in = new Inventory();
		in.setItemid(itemid);
		in.setQty(qty);
		try {
			inventoryDao.add(in);
		} catch (Exception e) {
			LogUtil.log.error("添加失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean changeQty(String itemid,int number) {
		Inventory in = null;
		try {
			in = (Inventory) inventoryDao.get(itemid);
			in.setQty(in.getQty()+number);
			inventoryDao.update(in);
		} catch (Exception e) {
			LogUtil.log.error("修改qty错误");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String itemid) {
		try {
			inventoryDao.delete(itemid);
		} catch (Exception e) {
		    LogUtil.log.error("删除失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
