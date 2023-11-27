package org.jsponetoonebi_Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsponetoonebi_dto.PanCard;

public class _11_FindPancardById {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the pancardID");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		PanCard c = manager.find(PanCard.class, id);
		if (c != null) {
			System.out.println("Pancard ID :" + c.getId());
			System.out.println("DOB :" + c.getDob());
			System.out.println("Pancard Number :" + c.getNumber());
			System.out.println("pinCode :" + c.getPincode());
		} else {
			System.err.println("You have entered an invalid pancard number");
		}

	}
}
