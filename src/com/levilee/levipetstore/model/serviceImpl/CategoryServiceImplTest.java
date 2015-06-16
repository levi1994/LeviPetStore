package com.levilee.levipetstore.model.serviceImpl;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.levilee.levipetstore.orm.dao.CategoryDao;
import com.levilee.levipetstore.orm.entity.Category;

public class CategoryServiceImplTest {
	private CategoryServiceImpl service = new CategoryServiceImpl();
	private CategoryDao dao = new CategoryDao();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCategory() {
		Category c = null;
		c = service.getCategory("BIRDS");
		assertEquals("BIRDS", c.getCatid());
	}

	@Test
	public void testGetCategories() {
		List<Category> list = (List<Category>) service.getCategories();
		assertEquals("BIRDS", list.get(0).getCatid());
	}

	@Test
	public void testAdd() {
		service.add("test", "test", "test");
		assertEquals("test", ((Category) dao.get("test")).getCatid());
		dao.delete("test");
	}

	@Test
	public void testDeleteString() {
		Category c = new Category();
		c.setCatid("test");
		c.setDescn("test");
		c.setName("test");
		dao.add(c);
		assertEquals("test", ((Category) dao.get("test")).getCatid());
		service.delete("test");
		assertNull(dao.get("test"));
	}

	@Test
	public void testDeleteCategory() {
		Category c = new Category();
		c.setCatid("test");
		c.setDescn("test");
		c.setName("test");
		dao.add(c);
		assertEquals("test", ((Category) dao.get("test")).getCatid());
		service.delete(c);
		assertNull(dao.get("test"));
	}

}
