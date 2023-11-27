package org.jsponetoonebi_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsponetoonebi_dto.PanCard;
public class _18_FindPancardByPhoneAndName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Name and Phone Number");
		String name = s.next();
		long phone=s.nextLong();
		String qry = "select c from PanCard c where c.person.name=?1 and c.person.phone=?2";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		q.setParameter(2, phone);
		try {
			PanCard c = (PanCard) q.getSingleResult();
			System.out.println("Pancard ID :" + c.getId());
			System.out.println("DOB :" + c.getDob());
			System.out.println("Pancard Number :" + c.getNumber());
			System.out.println("pinCode :" + c.getPincode());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid Name or phoneno");
		}
	}
}
