package com.levilee.levipetstore.model.serviceImpl;

import java.util.List;

import com.levilee.levipetstore.model.service.ItemService;
import com.levilee.levipetstore.orm.dao.ItemDao;
import com.levilee.levipetstore.orm.entity.Item;
import com.levilee.levipetstore.orm.util.LogUtil;

public class ItemServiceImpl implements ItemService {
     private ItemDao itemDao = new ItemDao();
	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public boolean add(Item item) {
		try {
			itemDao.add(item);
		} catch (Exception e) {
			LogUtil.log.error("itemÃÌº” ß∞‹");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Item item) {
		try {
			itemDao.add(item);
		} catch (Exception e) {
			LogUtil.log.error("item…æ≥˝ ß∞‹");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String itemid) {
		try {
			itemDao.delete(itemid);
		} catch (Exception e) {
			LogUtil.log.error("item…æ≥˝ ß∞‹");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Item> getItems() {
		List<Item> list  = null;
		try {
			list = itemDao.get();
		} catch (Exception e) {
			LogUtil.log.error("item≤È—Ø ß∞‹");
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public Item getCart(String itemid) {
		Item item = null;
		try {
			item = (Item) itemDao.get(itemid);
		} catch (Exception e) {
			LogUtil.log.error("item≤È—Ø ß∞‹");
			e.printStackTrace();
			return null;
		}
		return item;
	}

}
