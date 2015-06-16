package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Item;

public interface ItemService {
	     //��ӹ��ﳵ��Ʒ
		 public boolean add(Item item);
		 //ɾ�����ﳵ��Ʒ
		 public boolean delete(Item cart);
		 //���ĳ�û����й��ﳵ
		 public boolean delete(String itemid);
		 //��ѯ���еĹ��ﳵ
		 public List<Item> getItems();
		 //��ѯĳ����Ʒ
		 public Item getCart(String itemid);

}
