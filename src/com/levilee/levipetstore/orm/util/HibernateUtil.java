package com.levilee.levipetstore.orm.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.levilee.levipetstore.orm.entity.Sequence;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	static {
		try {
			 ApplicationContext context =null;
			 try{
			  context = new ClassPathXmlApplicationContext("applicationContext.xml");
			 }catch(Exception e){
				 e.printStackTrace();
			 }
			 sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		} catch (HibernateException e) {
			LogUtil.log.error("sessionFactory¥¥Ω®“Ï≥£");
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		Session session = null;
		if (null == session || false == session.isOpen()) {
			session = sessionFactory.openSession();
		}

		return session;
	}

	public static void closeSession(Session session) {
		try {
			if (null != session && session.isOpen())
				session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	public static int getId(String name){
		int t;
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Sequence sequence = (Sequence) session.get(Sequence.class, name);
		t = sequence.getNextid();
		sequence.setNextid(t+1);
		tx.commit();
		session.close();
		return t;
	}
	public static void main(String[] args) {
		System.out.println(getId("linenum"));
	}
}
