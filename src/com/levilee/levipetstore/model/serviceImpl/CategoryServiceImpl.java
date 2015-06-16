package com.levilee.levipetstore.model.serviceImpl;

import java.util.List;

import com.levilee.levipetstore.model.service.CategoryService;
import com.levilee.levipetstore.orm.dao.CategoryDao;
import com.levilee.levipetstore.orm.entity.Category;
import com.levilee.levipetstore.orm.util.LogUtil;

public class CategoryServiceImpl implements CategoryService{
    private CategoryDao categoryDao = new CategoryDao();
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	@Override
	public Category getCategory(String catid) {
		try{
			Category c = (Category) categoryDao.get(catid);
			return c;
			}catch(NullPointerException e){
				LogUtil.log.error("当前id不存在，查询错误");
				e.printStackTrace();
			}
			return null;
	}
	@Override
	public List<Category> getCategories() {
		List<Category> list = null;
		try{
			list = categoryDao.get();
			return list;
		}catch(NullPointerException e){
			LogUtil.log.error("当前id不存在，查询错误");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(String catid,String name,String descn) {
		Category c = new Category();
		try {
			c.setCatid(catid);
			c.setDescn(descn);
			c.setName(name);
			categoryDao.add(c);
		} catch (Exception e) {
			LogUtil.log.error("添加分类失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String catid) {
		try {
			categoryDao.delete(catid);
		} catch (Exception e) {
			LogUtil.log.error("删除分类失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Category category) {
		try {
			categoryDao.delete(category);
		} catch (Exception e) {
			LogUtil.log.error("删除分类失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
