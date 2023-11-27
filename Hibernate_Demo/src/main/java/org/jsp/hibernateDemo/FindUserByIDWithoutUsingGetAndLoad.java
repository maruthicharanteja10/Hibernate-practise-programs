package org.jsp.hibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByIDWithoutUsingGetAndLoad {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id ");
		int id = sc.nextInt();
		String qry = "select u from User u where id=?1";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery(qry);
		q.setParameter(1, id);
		List<User> li = q.getResultList();
		for (User u : li) {
			System.out.println("Id :" + u.getId());
			System.out.println("Name :" + u.getName());
			System.out.println("Phoneno :" + u.getPhone());
			System.out.println("Email :" + u.getEmail());
		}
	}
}
