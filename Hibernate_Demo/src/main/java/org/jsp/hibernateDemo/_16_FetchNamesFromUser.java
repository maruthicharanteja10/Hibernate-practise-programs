package org.jsp.hibernateDemo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class _16_FetchNamesFromUser {
	public static void main(String[] args) {
		String qry = "select u.name from User u";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Query<String> q = s.createQuery(qry);
		List<String> users = q.getResultList();
		System.out.println("Names of Users");
		System.out.println("-------------------");
		for (String u : users) {
			System.out.println(u);
		}
	}
}
