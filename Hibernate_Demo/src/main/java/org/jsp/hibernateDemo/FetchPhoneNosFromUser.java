package org.jsp.hibernateDemo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhoneNosFromUser {
	public static void main(String[] args) {
		String qry = "select u from User u";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery(qry);
		List<User> users = q.getResultList();
		System.out.println("PhoneNumbers of Users");
		System.out.println("-------------------");
		for (User u : users) {
			System.out.println(u.getPhone());
		}
	}
}
