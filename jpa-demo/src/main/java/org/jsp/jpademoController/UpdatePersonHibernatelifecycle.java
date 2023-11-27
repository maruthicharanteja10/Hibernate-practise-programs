package org.jsp.jpademoController;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Person;

public class UpdatePersonHibernatelifecycle {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person p = manager.find(Person.class, 2); // persistent state
		p.setAge(30);
		transaction.begin();
		transaction.commit();
	}
}
