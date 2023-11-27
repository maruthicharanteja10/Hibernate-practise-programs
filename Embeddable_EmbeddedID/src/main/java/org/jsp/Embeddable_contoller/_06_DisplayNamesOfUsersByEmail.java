package org.jsp.Embeddable_contoller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Embeddable_dto.User;

public class _06_DisplayNamesOfUsersByEmail {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Email to get the User details");
		String email = s.next();
		String qry = "select u from User u where u.id.email=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);

		List<User> us = q.getResultList();
		if (us.size() > 0) {
			for (User u : us) {
				System.out.println("Name :" + u.getName());
			}
		} else {
			System.out.println("You have entered an invalid email");
		}
	}
}
