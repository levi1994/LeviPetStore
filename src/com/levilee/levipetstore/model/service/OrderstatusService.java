package com.levilee.levipetstore.model.service;

import java.sql.Date;

import com.levilee.levipetstore.orm.entity.Orderstatus;

public interface OrderstatusService {
	//Ìí¼Ó
	public boolean add(int orderid,int linenum,Date timestamp,String status);
	//É¾³ı
	public boolean delete(int orderid,int linenum);
	//ĞŞ¸Ä
    public boolean update(Orderstatus orderstatus);
    //²éÑ¯
    public Orderstatus getOrderstatus(int orderid,int linenum);

}
