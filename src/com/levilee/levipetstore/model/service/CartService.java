package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Cart;

/*购物车业务逻辑*/
public interface CartService {
      //添加购物车商品
	 public boolean add(Cart cart);
	 public boolean add(String userid, String itemid, int amount);
	 //删除购物车商品
	 public boolean delete(Cart cart);
	 //清空某用户所有购物车
	 public boolean delete(String userid);
	 //查询所有的购物车
	 public List<?> getCarts();
	 //查询某人的购物车
	 public List<?> getCart(String userid);
	
}
