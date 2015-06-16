package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.LineItem;
import com.levilee.levipetstore.orm.entity.key.LineItemKey;

public interface LineItemService {
	 //添加
	 public boolean add(LineItem cart);
	 public boolean add(int orderid, int linenum, String itemid,int quantity,double unitprice);
	 //删除
	 public boolean delete(LineItem lineItem);
	 public boolean delete(LineItemKey key);
	 //查询所有的购物车
	 public List<LineItem> getLineItems();
	 //获得某个订单的所有商品
	 public List<LineItem> getLineItems(int orderid);
	 //获得单个订单商品
	 public LineItem getLineItem(LineItemKey key);
}
