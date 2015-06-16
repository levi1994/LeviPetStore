package com.levilee.levipetstore.model.serviceImpl;

import java.util.List;

import com.levilee.levipetstore.model.service.ProductService;
import com.levilee.levipetstore.orm.dao.ProductDao;
import com.levilee.levipetstore.orm.entity.Product;
import com.levilee.levipetstore.orm.util.LogUtil;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDao();
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getProducts() {
		 List<Product> list = null;
		 try {
			list = productDao.get();
		} catch (Exception e) {
			LogUtil.log.error("查询产品失败");
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<Product> getProducts(String category) {
		 List<Product> list = null;
		 try {
			list = productDao.getByCondition(" where category='"+category+"'");
		} catch (Exception e) {
			LogUtil.log.error("查询产品失败");
			e.printStackTrace();
			return null;
		}
		return list;
	}

}
