package org.jsp.jpademoController;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Person;

public class HibernateLifeCycle {
	public static void main(String[] args) {
		Person p = new Person();// transient state
		p.setName("ABC");
		p.setAge(25);
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p); // persistent state
		transaction.begin();
		transaction.commit();
		p.setAge(21);
		p.setName("Tej");
		transaction.begin();
		transaction.commit();
		p.setAge(35);
		p.setName("virat");
		transaction.begin();
		transaction.commit();
		manager.detach(p); // detached state
		p.setAge(30);
		p.setName("charan");
		transaction.begin();
		transaction.commit();
	}
}
