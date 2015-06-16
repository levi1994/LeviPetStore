package com.levilee.levipetstore.model.serviceImpl;

import java.util.List;

import com.levilee.levipetstore.model.service.AccountService;
import com.levilee.levipetstore.orm.dao.AccountDao;
import com.levilee.levipetstore.orm.dao.SignonDao;
import com.levilee.levipetstore.orm.entity.Account;
import com.levilee.levipetstore.orm.entity.Signon;
import com.levilee.levipetstore.orm.util.LogUtil;

public class AccountServiceImpl implements AccountService {
     AccountDao accountDao ;
     SignonDao signonDao ;
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public SignonDao getSignonDao() {
		return signonDao;
	}

	public void setSignonDao(SignonDao signonDao) {
		this.signonDao = signonDao;
	}

	@Override
	 /*登陆验证*/
	public boolean login(String username, String password) {
		Signon s =(Signon) signonDao.get(username);
		if(s.equals(null)){
			LogUtil.log.debug("用户名不存在");
			return false;
		}
		if(s.getPassword().equals(password)){
			return true;
		}
		return false;
	}

	@Override
	public boolean regist(Signon signOn, Account account) {
	    try {
			signonDao.add(signOn);
			accountDao.add(account);
		} catch (Exception e) {
			LogUtil.log.error("账户添加出错");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<?> getAccounts() {
		List<Account> list;
		try{
		 list = accountDao.get();
		}catch(Exception e){
			LogUtil.log.error("账户信息查询错误");
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public Account getAccount(String userid) {
		Account a=null;
		try{
		 a = (Account) accountDao.get(userid);
		}catch(Exception e){
			LogUtil.log.error("查询失败");
			e.printStackTrace();
			return null;
		}
		return a;
	}

	@Override
	public boolean changeAccount(Account account) {
		try {
			accountDao.update(account);
		} catch (Exception e) {
			LogUtil.log.error("用户信息更新失败");
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean changePassword(String username, String oldPassword,
			String newPassword) {
		//验证账户密码是否正确
		Signon s =(Signon) signonDao.get(username);
		if(s.equals(null)){
			LogUtil.log.debug("用户名不存在");
			return false;
		}
		//如果账户密码正确
		if(s.getPassword().equals(oldPassword)){
			//新建一个账号对象
			Signon signon = new Signon();
			//设值
			signon.setUsername(username);
			signon.setPassword(newPassword);
			signonDao.update(signon);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAccount(String username) {
		try{
		accountDao.delete(username);
		signonDao.delete(username);}catch(Exception e){
			LogUtil.log.error("删除失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
