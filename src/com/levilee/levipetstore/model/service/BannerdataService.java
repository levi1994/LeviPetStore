package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Bannerdata;

public interface BannerdataService {
	//根据指定id获取Bannerdata
		public Bannerdata getBannerdata(String favcategory);
		public List<Bannerdata> getBannerdatas();
		//添加Bannerdata
		public boolean add(String favcategory,String bannername);
		//删除Bannerdata
		public boolean delete(String favcategory);
		public boolean delete(Bannerdata bannerdata);
}
