package org.jsp.jpademoController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
     EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA");
     System.out.println(factory);
	}
}
