package org.jspmanytooneuni_Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspmanytooneuni_dto.Branch;

public class _13_FindBranchByHospitalName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the hospital name to get the branch details");
		String name = s.next();
		String qry = "select b from Branch b where b.hospital.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
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
			System.err.println("You have entered an invalid name ");
		}
	}
}
