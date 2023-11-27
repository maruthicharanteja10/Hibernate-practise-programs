package org.jsp.Embeddable_contoller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.Embeddable_contoller.*;
import org.jsp.Embeddable_dto.User;

public class _04_FindUserByName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name to get the User details");
		String name = s.next();
		String qry = "select u from User u where u.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<User> us = q.getResultList();
		if (us.size() > 0) {
			for (User u : us) {
				System.out.println("Name :" + u.getName());
				System.out.println("Age :" + u.getAge());
				System.out.println("Phone number: " + u.getId().getPhone());
				System.out.println("Email: " + u.getId().getEmail());
				System.out.println("--------------------------");
			}
		} else {
			System.out.println("You have entered an invalid name");
		}
	}
}
