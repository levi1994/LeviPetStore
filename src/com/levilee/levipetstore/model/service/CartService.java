package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Cart;

/*���ﳵҵ���߼�*/
public interface CartService {
      //��ӹ��ﳵ��Ʒ
	 public boolean add(Cart cart);
	 public boolean add(String userid, String itemid, int amount);
	 //ɾ�����ﳵ��Ʒ
	 public boolean delete(Cart cart);
	 //���ĳ�û����й��ﳵ
	 public boolean delete(String userid);
	 //��ѯ���еĹ��ﳵ
	 public List<?> getCarts();
	 //��ѯĳ�˵Ĺ��ﳵ
	 public List<?> getCart(String userid);
	
}
