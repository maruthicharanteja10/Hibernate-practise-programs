package org.jspmanytooneuni_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jspmanytooneuni_dto.Branch;

public class _07_FindBranchByID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id to get the branch details");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Branch b = manager.find(Branch.class, id);
		if (b != null) {
			System.out.println("Branch ID :" + b.getId());
			System.out.println("Branch Name :" + b.getName());
			System.out.println("Branch Phoneno :" + b.getPhone());
			System.out.println("Branch Email :" + b.getEmail());
			System.out.println("Branch City :" + b.getCity());
		} else {
			System.err.println("You have entered an invalid ID");
		}

	}
}
