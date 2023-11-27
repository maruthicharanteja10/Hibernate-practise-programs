package org.jsp.jpademoController;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class _18_FindAgeByNamedQuery {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the age to search");
		int age = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createNamedQuery("FindByAge");
		q.setParameter(1, age);
		List<Person> ps = q.getResultList();
		if (ps.size() != 0) {
			for (Person p : ps) {

				System.out.println("Person Id:" + p.getId());
				System.out.println("Name :" + p.getName());
				System.out.println("Phone number:" + p.getPhone());
				System.out.println("Email Id:" + p.getEmail());
				System.out.println("Gender:" + p.getGender());
				System.out.println("Age:" + p.getAge());
				System.out.println("----------------");
			}
		} else {
			System.err.println("Invalid age");
		}
	}
}
