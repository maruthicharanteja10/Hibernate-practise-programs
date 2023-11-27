package org.jspmanytooneuni_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jspmanytooneuni_dto.Hospital;
public class _03_FindHospitalByID2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the hospitalID to get hospital details");
		int id = s.nextInt();
		String qry = "select h from Hospital h where h.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			Hospital h = (Hospital) q.getSingleResult();
			System.out.println("Hospital ID :" + h.getId());
			System.out.println("Hospital Name :" + h.getName());
			System.out.println("Founder :" + h.getFounder());
			System.out.println(" Year of Establishment :" + h.getYear_of_estb());
		} catch (NoResultException e) {

		}
	}
}
