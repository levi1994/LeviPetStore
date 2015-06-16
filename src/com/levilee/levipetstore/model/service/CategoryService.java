package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Category;


public interface CategoryService {
	//根据指定id获取Category
	public Category getCategory(String catid);
	public List<Category> getCategories();
	//添加category
	public boolean add(String catid,String name,String descn);
	//删除category
	public boolean delete(String catid);
	public boolean delete(Category category);
}
