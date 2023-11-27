package org.jsp.jpademoController;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class _06_FindByPhone {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the phoneno to display person  details");
		long phone = s.nextLong();
		String jpql = "select p from Person p where p.phone=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, phone);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Person Id:" + p.getId());
			System.out.println("Name :" + p.getName());
			System.out.println("Phone number:" + p.getPhone());
			System.out.println("Email Id:" + p.getEmail());
			System.out.println("Gender:" + p.getGender());
			System.out.println("Age:" + p.getAge());
		} catch (NoResultException e) {
			System.err.println("Invalid phoneno");
		}
	}
}
