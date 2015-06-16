package com.levilee.levipetstore.orm.dao;

import com.levilee.levipetstore.orm.entity.Orderstatus;

public class Main {
	public static void main(String[] args) {
		OrderstatusDao dao = new OrderstatusDao();
		Orderstatus o = (Orderstatus) dao.get().get(0);
		System.out.println(o.getTimestamp());
	}
}
