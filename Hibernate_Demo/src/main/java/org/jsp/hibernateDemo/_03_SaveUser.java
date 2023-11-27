package org.jsp.hibernateDemo;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class _03_SaveUser {
	public static void main(String[] args) {
		User u = new User();
		u.setName("jos");
		u.setEmail("jos@gmail.com");
		u.setPhone(93393989L);
		u.setPassword("jos123");
		System.out.println("User id before Saving: " + u.getId());
		Configuration cfg = new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		Serializable id=s.save(u);
		t.commit();
		System.out.println("User save with Id:"+id);		
	}
}
