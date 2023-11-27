package org.jsponetoonebi_Controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetoonebi_dto.Person;

public class _04_FindPersonByName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the name ");
		String name = s.next();
		String qry = "select p from Person p where p.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<Person> ps = q.getResultList();
		if (ps.size() > 0) {
			for (Person p : ps) {
				System.out.println("person ID:" + p.getId());
				System.out.println("Name :" + p.getName());
				System.out.println("Phone :" + p.getPhone());
				System.out.println("Email :" + p.getEmail());
			}
		} else {
			System.err.println("You have Entered an invalid Name");
		}
	}
}
