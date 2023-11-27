package org.jsp.jpademoController;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class _15_FetchNamesUsingAge {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter age of the person");
		int age = s.nextInt();
		String jpql = "select p from Person p where age=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, age);
		List<Person> ps = q.getResultList();
		System.out.println("Names of the person whose age is "+age);
		for (Person p : ps) {
			System.out.println(p.getName());
		}
	}
}
