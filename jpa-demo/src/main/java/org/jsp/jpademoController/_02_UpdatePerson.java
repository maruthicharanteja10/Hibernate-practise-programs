package org.jsp.jpademoController;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.jpademo.dto.Person;
public class _02_UpdatePerson {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the person id to update");
		int id = s.nextInt();
		System.out.println("Enter the age,name,phone,gender and email to update");
		Person p = new Person();
		p.setId(id);
		p.setAge(s.nextInt());
		p.setName(s.next());
		p.setPhone(s.nextLong());
		p.setGender(s.next());
		p.setEmail(s.next());
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		manager.merge(p);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("Update succesfully");
	}
}
