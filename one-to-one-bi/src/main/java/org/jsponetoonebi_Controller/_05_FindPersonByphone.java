package org.jsponetoonebi_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetoonebi_dto.Person;
public class _05_FindPersonByphone {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Phone number");
		long phone = s.nextLong();
		String qry = "select p from Person p where p.phone=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("person ID:" + p.getId());
			System.out.println("Name :" + p.getName());
			System.out.println("Phone :" + p.getPhone());
			System.out.println("Email :" + p.getEmail());
		} catch (NoResultException e) {
			System.err.println("You have Entered an invalid Phone Number");
		}
	}
}
