package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.LineItem;
import com.levilee.levipetstore.orm.entity.key.LineItemKey;

public interface LineItemService {
	 //���
	 public boolean add(LineItem cart);
	 public boolean add(int orderid, int linenum, String itemid,int quantity,double unitprice);
	 //ɾ��
	 public boolean delete(LineItem lineItem);
	 public boolean delete(LineItemKey key);
	 //��ѯ���еĹ��ﳵ
	 public List<LineItem> getLineItems();
	 //���ĳ��������������Ʒ
	 public List<LineItem> getLineItems(int orderid);
	 //��õ���������Ʒ
	 public LineItem getLineItem(LineItemKey key);
}
