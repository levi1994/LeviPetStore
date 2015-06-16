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
	 /*��½��֤*/
	public boolean login(String username, String password) {
		Signon s =(Signon) signonDao.get(username);
		if(s.equals(null)){
			LogUtil.log.debug("�û���������");
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
			LogUtil.log.error("�˻���ӳ���");
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
			LogUtil.log.error("�˻���Ϣ��ѯ����");
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
			LogUtil.log.error("��ѯʧ��");
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
			LogUtil.log.error("�û���Ϣ����ʧ��");
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean changePassword(String username, String oldPassword,
			String newPassword) {
		//��֤�˻������Ƿ���ȷ
		Signon s =(Signon) signonDao.get(username);
		if(s.equals(null)){
			LogUtil.log.debug("�û���������");
			return false;
		}
		//����˻�������ȷ
		if(s.getPassword().equals(oldPassword)){
			//�½�һ���˺Ŷ���
			Signon signon = new Signon();
			//��ֵ
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
			LogUtil.log.error("ɾ��ʧ��");
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
