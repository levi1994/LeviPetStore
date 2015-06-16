package com.levilee.levipetstore.model.service;

import com.levilee.levipetstore.orm.entity.Profile;

public interface ProfileService {
     //添加
	public boolean add(Profile profile);
	//查询
	public Profile get(String userid);
	//更新
	public boolean update(Profile profile);
	
}
