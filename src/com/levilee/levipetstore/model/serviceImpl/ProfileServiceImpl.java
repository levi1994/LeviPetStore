package com.levilee.levipetstore.model.serviceImpl;

import com.levilee.levipetstore.model.service.ProfileService;
import com.levilee.levipetstore.orm.dao.ProfileDao;
import com.levilee.levipetstore.orm.entity.Profile;
import com.levilee.levipetstore.orm.util.LogUtil;

public class ProfileServiceImpl implements ProfileService {
    private ProfileDao profileDao = new ProfileDao();
	public ProfileDao getProfileDao() {
		return profileDao;
	}

	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}

	@Override
	public boolean add(Profile profile) {
		try {
			profileDao.add(profile);
		} catch (Exception e) {
			LogUtil.log.error("添加Profile失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Profile get(String userid) {
		Profile p = null;
		try {
			p = (Profile) profileDao.get(userid);
		} catch (Exception e) {
			LogUtil.log.error("Profile获取失败");
			e.printStackTrace();
			return null;
		}
		return p;
	}

	@Override
	public boolean update(Profile profile) {
		try {
			profileDao.update(profile);
		} catch (Exception e) {
			LogUtil.log.error("Profile更新失败i");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
