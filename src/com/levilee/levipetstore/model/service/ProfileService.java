package com.levilee.levipetstore.model.service;

import com.levilee.levipetstore.orm.entity.Profile;

public interface ProfileService {
     //���
	public boolean add(Profile profile);
	//��ѯ
	public Profile get(String userid);
	//����
	public boolean update(Profile profile);
	
}
