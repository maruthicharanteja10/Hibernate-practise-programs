package org.jsponetoonebi_Controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetoonebi_dto.PanCard;

public class _13_FindPancardByDobAndNumber {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the pancard number and DOB(YYYY-MM-DD) ");
		long number = s.nextLong();
		LocalDate dob = LocalDate.parse(s.next());
		String qry = "select c from PanCard c where c.number=?1 and c.dob=?2";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, number);
		q.setParameter(2, dob);
		try {
			PanCard c = (PanCard) q.getSingleResult();
			System.out.println("Pancard ID :" + c.getId());
			System.out.println("DOB :" + c.getDob());
			System.out.println("Pancard Number :" + c.getNumber());
			System.out.println("pinCode :" + c.getPincode());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid pancard number");
		}
	}
}
