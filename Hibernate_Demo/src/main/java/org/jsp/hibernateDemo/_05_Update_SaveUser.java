package org.jsp.hibernateDemo;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class _05_Update_SaveUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Id:");
		int id = sc.nextInt();
		User u = new User();
		u.setId(id);
		System.out.println("Enter Your name,email,phone and password to update:");
		u.setName(sc.next());
		u.setEmail(sc.next());
		u.setPhone(sc.nextLong());
		u.setPassword(sc.next());
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		s.saveOrUpdate(u);
		
		t.commit();
		System.out.println("User Updated");

	}
}
