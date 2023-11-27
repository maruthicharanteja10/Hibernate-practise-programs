package org.jspmanytooneuni_Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspmanytooneuni_dto.Branch;

public class _15_FindBranchByyear_of_establishment {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the established year to get the branch details");
		int year = s.nextInt();
		String qry = "select b from Branch b where b.hospital.year_of_estb=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, year);
		List<Branch> br = q.getResultList();
		if (br.size() > 0) {
			for (Branch b : br) {
				System.out.println("Branch ID :" + b.getId());
				System.out.println("Branch Name :" + b.getName());
				System.out.println("Branch Phoneno :" + b.getPhone());
				System.out.println("Branch Email :" + b.getEmail());
				System.out.println("Branch City :" + b.getCity());
				System.out.println("---------------------");
			}
		} else {
			System.err.println("You have entered an invalid year ");
		}

	}
}
