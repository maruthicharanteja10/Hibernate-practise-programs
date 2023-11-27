package org.jsp.hibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class _10_FindUserByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the User value to display details");
		String name = sc.next();
		String qry = "select u from User u where u.name=?1";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery(qry);
		q.setParameter(1, name);
		List<User> users = q.getResultList();
		if (users.size() > 0) {
			for (User u : users) {
				System.out.println("User id: " + u.getId());
				System.out.println("Name: " + u.getName());
				System.out.println("Phone number: " + u.getPhone());
				System.out.println("Email id: " + u.getEmail());
				System.out.println("-----------------------");
			}
		} else {
			System.err.println("No User found with entered name");
		}
	}
}
