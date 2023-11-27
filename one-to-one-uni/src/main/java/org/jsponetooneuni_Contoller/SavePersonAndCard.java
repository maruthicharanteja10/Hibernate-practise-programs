package org.jsponetooneuni_Contoller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsponetooneuni_dto.AadharCard;
import org.jsponetooneuni_dto.Person;

public class SavePersonAndCard {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("ABC");
		p.setPhone(8888777);
		p.setEmail("abc@gmail.com");
		AadharCard card = new AadharCard();
		card.setNumber(432143214321l);
		card.setDob(LocalDate.parse("1947-08-15"));
		card.setPincode(516360);
		p.setAadhar(card);// Assigning AadharCard for person
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p);// persistent state
		
		transaction.begin();
		transaction.commit();
	}
}
