package org.jsponetoonebi_Controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsponetoonebi_dto.PanCard;
import org.jsponetoonebi_dto.Person;

public class FindBy {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		PanCard p = manager.find(PanCard.class, 1);
		
	}
}
