package org.jspmanytooneuni_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jspmanytooneuni_dto.Branch;

public class _10_FindBranchByphone {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the phone number to get the branch details");
		long phone = s.nextLong();
		String qry = "select b from Branch b where b.phone=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		try {
			Branch b = (Branch) q.getSingleResult();
			System.out.println("Branch ID :" + b.getId());
			System.out.println("Branch Name :" + b.getName());
			System.out.println("Branch Phoneno :" + b.getPhone());
			System.out.println("Branch Email :" + b.getEmail());
			System.out.println("Branch City :" + b.getCity());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid ID");
		}
	}
}
