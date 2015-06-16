package com.levilee.levipetstore.model.serviceImpl;

import java.util.List;

import com.levilee.levipetstore.model.service.CartService;
import com.levilee.levipetstore.orm.dao.CartDao;
import com.levilee.levipetstore.orm.entity.Cart;
import com.levilee.levipetstore.orm.entity.key.CartKey;
import com.levilee.levipetstore.orm.util.LogUtil;

public class CartServiceImpl implements CartService {
	private CartDao cartDao ;

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public boolean add(Cart cart) {
		// 1.判断购物车商品是否存在
		// 如果购物车中有相同username相同productid的记录，则不添加纪录
		// 1.查询该用户的记录
		Cart c = null;
		c = (Cart) cartDao.get(cart.getCartKey());
		if (c!=null) {
			LogUtil.log.info("该记录已经存在，正在更改纪录");
			// 将数据更改为总和
			c.setAmount(c.getAmount() + cart.getAmount());
			cartDao.update(c);
		} else {
			LogUtil.log.info("尚未存在该记录，正在新建记录");
			try {
				cartDao.add(cart);
			} catch (Exception e) {
				LogUtil.log.error("记录添加失败");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean add(String userid, String itemid, int amount) {
		// 如果购物车中有相同username相同productid的记录，则不添加纪录
		// 1.查询该用户的记录
		Cart c = null;
		CartKey key = new CartKey();
		key.setUserid(userid);
		key.setItemid(itemid);
		c = (Cart) cartDao.get(key);
		if (c!=null) {
			LogUtil.log.info("该记录已经存在，正在更改纪录");
			// 将数据更改为总和
			c.setAmount(c.getAmount() + amount);
			cartDao.update(c);
		} else {
			LogUtil.log.info("尚未存在该记录，正在新建记录");
			c = new Cart();
			c.setCartKey(key);
			c.setAmount(amount);
			try {
				cartDao.add(c);
			} catch (Exception e) {
				LogUtil.log.error("记录添加失败");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean delete(Cart cart) {
		// TODO Auto-generated method stub
		try {
			cartDao.delete(cart);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.log.error("删除失败");
			return false;
		}
		LogUtil.log.info("购物车删除成功");
		return true;
	}

	@Override
	public boolean delete(String userid) {
		// 直接使用hql语句删除
		try {
			cartDao.update("delete  Cart where userid='" + userid + "'");
		} catch (Exception e) {
			LogUtil.log.error("删除错误：" + "delete  Cart where userid='"
					+ userid + "'");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<?> getCarts() {
		List<Cart> list = null;
		try {
			list = cartDao.get();
		} catch (Exception e) {
			LogUtil.log.error("获取失败");
			e.printStackTrace();
		}
		LogUtil.log.info("获取购物车信息成功");
		return list;
	}

	@Override
	public List<?> getCart(String userid) {
		List<Cart> list = null;
		String hql = "where userid='" + userid + "'";
		System.out.println(hql);
		try {
			list = cartDao.getByCondition(hql);
		} catch (Exception e) {
			LogUtil.log.error("购物车信息获取失败");
			e.printStackTrace();
		}
		LogUtil.log.info("购物车信息获取成功");
		return list;
	}

}
