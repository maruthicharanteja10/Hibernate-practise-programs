package org.jsp.Embeddable_contoller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Embeddable_dto.User;

public class _08_DisplayAgeOfUsersByEmailAndName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Email and Name to get the User details");
		String email = s.next();
		String name = s.next();
		String qry = "select u from User u where u.id.email=?1 and u.name=?2";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, name);
		try {
			User u = (User) q.getSingleResult();
			System.out.println("Age :" + u.getAge());
		} catch (NoResultException e) {
			System.out.println("You have entered an invalid phone number");
		}
	}
}
