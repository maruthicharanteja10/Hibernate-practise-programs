package org.jsponetoonebi_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsponetoonebi_dto.PanCard;
import org.jsponetoonebi_dto.Person;

public class _08_FindPersonByPanCardID2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter pancard id");
		int card_id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		PanCard card = manager.find(PanCard.class, card_id);
		if (card != null) {
			Person p=card.getPerson();
			System.out.println("person ID:" + p.getId());
			System.out.println("Name :" + p.getEmail());
			System.out.println("Phone :" + p.getPhone());
			System.out.println("Email :" + p.getEmail());
		} else {
			System.err.println("You have Entered an Invalid ID");
		}
	}
}
