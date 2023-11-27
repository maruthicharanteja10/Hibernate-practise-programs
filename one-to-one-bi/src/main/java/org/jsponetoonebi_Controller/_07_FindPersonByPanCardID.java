package org.jsponetoonebi_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsponetoonebi_dto.*;

public class _07_FindPersonByPanCardID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Pancard ID");
		int card_id = s.nextInt();
		String qry1 = "select p from Person p where p.card.id=?1"; //Method1
		String qry2 = "select c.person from PanCard c where c.id=?1";//Method 2
		EntityManager manager=Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q=manager.createQuery(qry2);
		q.setParameter(1, card_id);
		try {
			Person p=(Person)q.getSingleResult();
			System.out.println("person ID:" + p.getId());
			System.out.println("Name :" + p.getName());
			System.out.println("Phone :" + p.getPhone());
			System.out.println("Email :" + p.getEmail());
		}
		catch(NoResultException e) {
			System.err.println("You have entered pancard id is invalid");
		}
	}
}
