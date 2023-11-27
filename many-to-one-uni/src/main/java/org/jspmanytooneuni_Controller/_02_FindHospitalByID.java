package org.jspmanytooneuni_Controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jspmanytooneuni_dto.Hospital;

public class _02_FindHospitalByID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the hospitalID to get hospital details");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Hospital h = manager.find(Hospital.class, id);
		if (h != null) {
			System.out.println("Hospital ID :" + h.getId());
			System.out.println("Hospital Name :" + h.getName());
			System.out.println("Founder :" + h.getFounder());
			System.out.println(" Year of Establishment :" + h.getYear_of_estb());
		}
	}
}
