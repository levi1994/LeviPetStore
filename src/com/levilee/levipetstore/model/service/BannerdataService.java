package com.levilee.levipetstore.model.service;

import java.util.List;

import com.levilee.levipetstore.orm.entity.Bannerdata;

public interface BannerdataService {
	//����ָ��id��ȡBannerdata
		public Bannerdata getBannerdata(String favcategory);
		public List<Bannerdata> getBannerdatas();
		//���Bannerdata
		public boolean add(String favcategory,String bannername);
		//ɾ��Bannerdata
		public boolean delete(String favcategory);
		public boolean delete(Bannerdata bannerdata);
}
