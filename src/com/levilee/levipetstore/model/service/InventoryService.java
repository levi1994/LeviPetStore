package com.levilee.levipetstore.model.service;

import java.util.List;
public interface InventoryService {
	 //查询某件物品的剩余量
	 public int getQty(String itemid);
	 //获得所有
	 public List<InventoryService> getInventories();
	 //添加
	 public boolean add(String itemid,int qty);
	 //修改
	 public boolean changeQty(String itemid,int number);
	 //删除
	 public boolean delete(String itemid);
}
