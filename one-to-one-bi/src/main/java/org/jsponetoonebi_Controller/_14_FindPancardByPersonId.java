package org.jsponetoonebi_Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsponetoonebi_dto.PanCard;

public class _14_FindPancardByPersonId {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter person ID");
		int id = s.nextInt();
		String qry1 = "select c from PanCard c where c.person.id=?1";
		String qry2 = "select p.card from Person p where p.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry2);
		q.setParameter(1, id);
		try {
			PanCard c = (PanCard) q.getSingleResult();
			System.out.println("Pancard ID :" + c.getId());
			System.out.println("DOB :" + c.getDob());
			System.out.println("Pancard Number :" + c.getNumber());
			System.out.println("pinCode :" + c.getPincode());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid person ID");
		}
	}
}
