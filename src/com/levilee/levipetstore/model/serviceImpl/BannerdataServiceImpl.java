package com.levilee.levipetstore.model.serviceImpl;

import java.util.List;

import com.levilee.levipetstore.model.service.BannerdataService;
import com.levilee.levipetstore.orm.dao.BannerdataDao;
import com.levilee.levipetstore.orm.entity.Bannerdata;
import com.levilee.levipetstore.orm.util.LogUtil;

public class BannerdataServiceImpl implements BannerdataService {
     private BannerdataDao bannerdataDao = new BannerdataDao();
	public BannerdataDao getBannerdataDao() {
		return bannerdataDao;
	}

	public void setBannerdataDao(BannerdataDao bannerdataDao) {
		this.bannerdataDao = bannerdataDao;
	}

	@Override
	public Bannerdata getBannerdata(String favcategory) {
		try{
			Bannerdata c = (Bannerdata) bannerdataDao.get(favcategory);
			return c;
			}catch(NullPointerException e){
				LogUtil.log.error("当前favcategory不存在，查询错误");
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public List<Bannerdata> getBannerdatas() {
		List<Bannerdata> list = null;
		try{
			list = bannerdataDao.get();
			return list;
		}catch(NullPointerException e){
			LogUtil.log.error("当前id不存在，查询错误");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(String favcategory, String bannername) {
		Bannerdata c = new Bannerdata();
		try {
			c.setBannername(bannername);
			c.setFavcategory(favcategory);
			bannerdataDao.add(c);
		} catch (Exception e) {
			LogUtil.log.error("添加分类失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String favcategory) {
		try {
			bannerdataDao.delete(favcategory);
		} catch (Exception e) {
			LogUtil.log.error("删除favcategory失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Bannerdata bannerdata) {
		try {
			bannerdataDao.delete(bannerdata);
		} catch (Exception e) {
			LogUtil.log.error("删除分类失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
