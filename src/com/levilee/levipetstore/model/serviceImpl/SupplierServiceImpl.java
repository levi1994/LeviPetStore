package com.levilee.levipetstore.model.serviceImpl;

import com.levilee.levipetstore.model.service.SupplierService;
import com.levilee.levipetstore.orm.dao.SupplierDao;
import com.levilee.levipetstore.orm.entity.Supplier;
import com.levilee.levipetstore.orm.util.LogUtil;

public class SupplierServiceImpl implements SupplierService{
    private SupplierDao supplierDao = new SupplierDao();
	public SupplierDao getSupplierDao() {
		return supplierDao;
	}
	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}
	@Override
	public Supplier get(int suppid) {
		Supplier s = null;
		try {
			s = (Supplier) supplierDao.get(suppid);
		} catch (Exception e) {
			LogUtil.log.error("获取厂商信息失败");
			e.printStackTrace();
			return null;
		}
		return s;
	}

}
