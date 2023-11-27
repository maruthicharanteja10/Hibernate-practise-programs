package org.jspmanytooneuni_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jspmanytooneuni_dto.Branch;

public class _08_FindBranchByID2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id to get the branch details");
		int id = s.nextInt();
		String qry = "select b from Branch b where b.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
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
