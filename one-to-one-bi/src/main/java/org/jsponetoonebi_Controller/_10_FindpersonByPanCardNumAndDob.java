package org.jsponetoonebi_Controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetoonebi_dto.Person;

public class _10_FindpersonByPanCardNumAndDob {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Pancard number");
		long pannum = s.nextLong();
		System.out.println("Enter the DOB(YYYY-MM-DD) in these format");
		LocalDate dob = LocalDate.parse(s.next());

		String qry1 = "select p from Person p where p.card.number=?1 and p.card.dob=?2";
		String qry2 = "select c.person from PanCard c where c.number=?1 and c.dob=?2";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry2);
		q.setParameter(1, pannum);
		q.setParameter(2, dob);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("person ID:" + p.getId());
			System.out.println("Name :" + p.getEmail());
			System.out.println("Phone :" + p.getPhone());
			System.out.println("Email :" + p.getEmail());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid pancard number");
		}
	}
}
