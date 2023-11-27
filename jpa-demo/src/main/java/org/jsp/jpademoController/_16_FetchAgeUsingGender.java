package org.jsp.jpademoController;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class _16_FetchAgeUsingGender {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Gender of the person");
		String gender = s.next();
		String jpql = "select p from Person p where p.gender=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, gender);
		List<Person> ps = q.getResultList();
		System.out.println("Names of the person whose gender is " + gender);
		for (Person p : ps) {
			System.out.println(p.getAge());
		}
	}
}
