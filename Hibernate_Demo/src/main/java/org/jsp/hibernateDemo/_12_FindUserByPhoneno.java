package org.jsp.hibernateDemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class _12_FindUserByPhoneno {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the User value to display details");
		Long phone = sc.nextLong();
		String qry = "select u from User u where u.phone=:ph";
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery(qry);
		q.setParameter("ph", phone);
		try {
			User u = q.getSingleResult();
			System.out.println("User id: " + u.getId());
			System.out.println("Name: " + u.getName());
			System.out.println("Phone number: " + u.getPhone());
			System.out.println("Email id: " + u.getEmail());
			System.out.println("-----------------------");
		} catch (NoResultException e) {
			System.err.println("invalid phone number");
		}
	}

}
