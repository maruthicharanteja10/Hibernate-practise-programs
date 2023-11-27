package org.jspmanytooneuni_Controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jspmanytooneuni_dto.Hospital;

public class _06_FindHospitalByFounder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the founder name of hospital to get hospitaldetails");
		String founder = s.next();
		String qry = "select h from Hospital h where h.founder=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, founder);
		List<Hospital> hs = q.getResultList();
		if (hs.size() > 0) {
			for (Hospital h : hs) {
				System.out.println("Hospital ID :" + h.getId());
				System.out.println("Hospital Name :" + h.getName());
				System.out.println("Founder :" + h.getFounder());
				System.out.println(" Year of Establishment :" + h.getYear_of_estb());
			}
		} else {
			System.err.println("You have entered an invalid founder Name ");
		}
	}
}
