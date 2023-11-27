package org.jsponetoonebi_Controller;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsponetoonebi_dto.PanCard;
import org.jsponetoonebi_dto.Person;

import java.util.*;
public class _01_SavePersonAndCard {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter name,Phoneno and Email");
		String name=s.next();
		long phone=s.nextLong();
		String email=s.next();
		Person p = new Person();
		p.setName(name);
		p.setPhone(phone);
		p.setEmail(email);
		System.out.println("Enter pancard number,DOB(yyyy-mm-dd) and pincode");
		long pannum=s.nextLong();
		String DOB=s.next();
		int pin=s.nextInt();
		PanCard card = new PanCard();//tranisent state 
		card.setNumber(pannum);
		card.setDob(LocalDate.parse(DOB));
		card.setPincode(pin);
		p.setCard(card);//Assigning pancard for person
		card.setPerson(p);//Assigning person for pancard
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p);// persistent state
		
		transaction.begin();
		transaction.commit();
		System.out.println("Inserted succesfully");
	}
}
