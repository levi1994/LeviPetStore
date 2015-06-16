package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Item;

public interface ItemService {
	     //添加购物车商品
		 public boolean add(Item item);
		 //删除购物车商品
		 public boolean delete(Item cart);
		 //清空某用户所有购物车
		 public boolean delete(String itemid);
		 //查询所有的购物车
		 public List<Item> getItems();
		 //查询某个商品
		 public Item getCart(String itemid);

}
