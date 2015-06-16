package com.levilee.levipetstore.model.serviceImpl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.levilee.levipetstore.orm.entity.Account;
import com.levilee.levipetstore.orm.entity.Signon;

public class AccountServiceImplTest {
    private AccountServiceImpl service = new AccountServiceImpl();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		assertEquals(true, service.login("j2ee", "j2ee"));
	}

	@Test
	public void testRegist() {
		Signon signon=new Signon();
		int t = (int) (Math.random()*10000);
		String username ="Test"+t;
		signon.setUsername(username);
		signon.setPassword(username);
		Account account = new Account();
		account.setUserid(username);
		assertEquals(true,service.regist(signon,account));
		//清除测试注册信息
		service.deleteAccount(username);
	}

	@Test
	public void testGetAccounts() {
		assertNotNull(service.getAccounts().get(0));
	}

	@Test
	public void testGetAccount() {
		assertEquals("a", service.getAccount("a").getEmail());
	}

	@Test
	public void testChangeAccount() {
		//1.对账户信息进行改变
		int t  =  (int) (Math.random()*10000);
		String firstname="Test"+t;
		Account account = service.getAccount("a");
		account.setFirstname(firstname);
		service.changeAccount(account);
		assertEquals(firstname, service.getAccount("a").getFirstname());
	}

	@Test
	public void testChangePassword() {
		        //1.生成随机密码
				int t  =  (int) (Math.random()*10000);
				String password="Test"+t;
				//2.获取旧的密码
				String oldPassword =((Signon) (service.signonDao.get("a"))).getPassword();
				//3.改变密码
				service.changePassword("a", oldPassword, password);
				//4.使用新密码尝试登陆
				assertEquals(true, service.login("a", password));
	}

}
