package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Product;

public interface ProductService {
	//��ȡ���в�Ʒ
	public List<Product> getProducts();
	//���ĳ������Ĳ�Ʒ
	public List<Product> getProducts(String category);

}
