package com.levilee.levipetstore.model.service;

import java.sql.Date;

import com.levilee.levipetstore.orm.entity.Orderstatus;

public interface OrderstatusService {
	//���
	public boolean add(int orderid,int linenum,Date timestamp,String status);
	//ɾ��
	public boolean delete(int orderid,int linenum);
	//�޸�
    public boolean update(Orderstatus orderstatus);
    //��ѯ
    public Orderstatus getOrderstatus(int orderid,int linenum);

}
