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
		// 1.�жϹ��ﳵ��Ʒ�Ƿ����
		// ������ﳵ������ͬusername��ͬproductid�ļ�¼������Ӽ�¼
		// 1.��ѯ���û��ļ�¼
		Cart c = null;
		c = (Cart) cartDao.get(cart.getCartKey());
		if (c!=null) {
			LogUtil.log.info("�ü�¼�Ѿ����ڣ����ڸ��ļ�¼");
			// �����ݸ���Ϊ�ܺ�
			c.setAmount(c.getAmount() + cart.getAmount());
			cartDao.update(c);
		} else {
			LogUtil.log.info("��δ���ڸü�¼�������½���¼");
			try {
				cartDao.add(cart);
			} catch (Exception e) {
				LogUtil.log.error("��¼���ʧ��");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean add(String userid, String itemid, int amount) {
		// ������ﳵ������ͬusername��ͬproductid�ļ�¼������Ӽ�¼
		// 1.��ѯ���û��ļ�¼
		Cart c = null;
		CartKey key = new CartKey();
		key.setUserid(userid);
		key.setItemid(itemid);
		c = (Cart) cartDao.get(key);
		if (c!=null) {
			LogUtil.log.info("�ü�¼�Ѿ����ڣ����ڸ��ļ�¼");
			// �����ݸ���Ϊ�ܺ�
			c.setAmount(c.getAmount() + amount);
			cartDao.update(c);
		} else {
			LogUtil.log.info("��δ���ڸü�¼�������½���¼");
			c = new Cart();
			c.setCartKey(key);
			c.setAmount(amount);
			try {
				cartDao.add(c);
			} catch (Exception e) {
				LogUtil.log.error("��¼���ʧ��");
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
			LogUtil.log.error("ɾ��ʧ��");
			return false;
		}
		LogUtil.log.info("���ﳵɾ���ɹ�");
		return true;
	}

	@Override
	public boolean delete(String userid) {
		// ֱ��ʹ��hql���ɾ��
		try {
			cartDao.update("delete  Cart where userid='" + userid + "'");
		} catch (Exception e) {
			LogUtil.log.error("ɾ������" + "delete  Cart where userid='"
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
			LogUtil.log.error("��ȡʧ��");
			e.printStackTrace();
		}
		LogUtil.log.info("��ȡ���ﳵ��Ϣ�ɹ�");
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
			LogUtil.log.error("���ﳵ��Ϣ��ȡʧ��");
			e.printStackTrace();
		}
		LogUtil.log.info("���ﳵ��Ϣ��ȡ�ɹ�");
		return list;
	}

}
