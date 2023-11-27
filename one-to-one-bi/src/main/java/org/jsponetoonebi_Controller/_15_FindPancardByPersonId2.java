package org.jsponetoonebi_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsponetoonebi_dto.*;

public class _15_FindPancardByPersonId2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Person ID");
		int person_id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Person p = manager.find(Person.class, person_id);
		if(p!=null) {
			PanCard c=p.getCard();
			System.out.println("Pancard ID :" + c.getId());
			System.out.println("DOB :" + c.getDob());
			System.out.println("Pancard Number :" + c.getNumber());
			System.out.println("pinCode :" + c.getPincode());
		}

	}
}
