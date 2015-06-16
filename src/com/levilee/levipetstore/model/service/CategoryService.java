package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Category;


public interface CategoryService {
	//����ָ��id��ȡCategory
	public Category getCategory(String catid);
	public List<Category> getCategories();
	//���category
	public boolean add(String catid,String name,String descn);
	//ɾ��category
	public boolean delete(String catid);
	public boolean delete(Category category);
}
