package com.levilee.levipetstore.model.service;

import java.util.List;
public interface InventoryService {
	 //��ѯĳ����Ʒ��ʣ����
	 public int getQty(String itemid);
	 //�������
	 public List<InventoryService> getInventories();
	 //���
	 public boolean add(String itemid,int qty);
	 //�޸�
	 public boolean changeQty(String itemid,int number);
	 //ɾ��
	 public boolean delete(String itemid);
}
