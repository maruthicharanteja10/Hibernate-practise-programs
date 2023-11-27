package org.jsp.jpademoController;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Person;

public class _14_FetchNames {
	public static void main(String[] args) {
		String jpql = "select p from Person p";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(jpql);
		List<Person> ps = q.getResultList();
		System.out.println("All ids from the person table");
		for (Person p : ps) {
			System.out.println(p.getName());
		}
	}
}
