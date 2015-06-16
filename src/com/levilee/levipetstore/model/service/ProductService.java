package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Product;

public interface ProductService {
	//获取所有产品
	public List<Product> getProducts();
	//获得某个分类的产品
	public List<Product> getProducts(String category);

}
