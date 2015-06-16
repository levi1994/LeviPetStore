package com.levilee.levipetstore.model.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.levilee.levipetstore.orm.dao.CartDao;
import com.levilee.levipetstore.orm.entity.Cart;
import com.levilee.levipetstore.orm.entity.key.CartKey;

public class CartServiceImplTest {
    private CartServiceImpl service = new CartServiceImpl();
    private CartDao cartDao = new CartDao();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testAddCart() {
		//1.新建Cart
		Cart cart = new Cart();
		//1.1构造用户名
		int t = (int) (Math.random()*10000);
		CartKey key = new CartKey();
		key.setUserid("a");
		key.setItemid("EST-"+t);
		cart.setCartKey(key);
		cart.setAmount(1);
		service.add(cart);
		System.out.println(((Cart)cartDao.get(key)).getAmount());
		assertEquals(1,((Cart)cartDao.get(key)).getAmount());
		//清除测试数据
		cartDao.delete(key);
	}
	@Test
	public void testAddStringStringInt() {
				//1.1构造用户名
				int t = (int) (Math.random()*10000);
				service.add("a","EST-"+t,1);
				CartKey key = new CartKey();
				key.setUserid("a");
				key.setItemid("EST-"+t);
				assertEquals(1,((Cart)cartDao.get(key)).getAmount());
				//清除测试数据
				cartDao.delete(key);
	}

	@Test
	public void testDeleteCart() {
		Cart cart = new Cart();
		CartKey cartKey = new CartKey();
		cartKey.setUserid("test");
		cartKey.setItemid("test");
		cart.setCartKey(cartKey);
		cart.setAmount(1);
		boolean b = service.add(cart);
		assertEquals(true, b);
		service.delete(cart);
		assertNull(cartDao.get(cartKey));
	}

	@Test
	public void testDeleteString() {
		Cart cart = new Cart();
		CartKey cartKey = new CartKey();
		cartKey.setUserid("test");
		cartKey.setItemid("test");
		cart.setCartKey(cartKey);
		cart.setAmount(1);
		boolean b = service.add(cart);
		assertEquals(true, b);
		service.delete("test");
		assertNull(cartDao.get(cartKey));
	}
	
	@Test
	public void testGetCarts(){
		List<Cart> list = (List<Cart>) service.getCarts();
		assertEquals("a", list.get(0).getCartKey().getUserid());
	}
	
	@Test
	public void testGetCart(){
		List<Cart> list = (List<Cart>) service.getCart("a");
		assertEquals("a", list.get(0).getCartKey().getUserid());
	}

}
