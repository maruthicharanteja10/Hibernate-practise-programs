package org.jsp.jpademoController;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class _11_FindPersonbyEmail {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Email to search");
		String email = s.next();
		String jpql = "select p from Person p where p.email=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, email);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Person Id:" + p.getId());
			System.out.println("Name :" + p.getName());
			System.out.println("Phone number:" + p.getPhone());
			System.out.println("Email Id:" + p.getEmail());
			System.out.println("Gender:" + p.getGender());
			System.out.println("Age:" + p.getAge());
			System.out.println("----------------");
		} catch (NoResultException e) {
			System.err.println("Invalid Email");
		}
	}
}
