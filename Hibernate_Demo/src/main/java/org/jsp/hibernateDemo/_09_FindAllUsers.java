package org.jsp.hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class _09_FindAllUsers {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery("select u from User u");
		List<User> users = q.getResultList();
		for (User u : users) {
			System.out.println("User id: "+u.getId());
			System.out.println("Name: "+u.getName());
			System.out.println("Phoneno: "+u.getPhone());
			System.out.println("Email id :"+u.getEmail());
			System.out.println("------------------------");
		}
	}
}
