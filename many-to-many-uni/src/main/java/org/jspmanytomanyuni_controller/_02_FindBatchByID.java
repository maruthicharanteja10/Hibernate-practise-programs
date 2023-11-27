package org.jspmanytomanyuni_controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jspmanytomanyuni_dto.Batch;
public class _02_FindBatchByID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Batch ID to get the Batch Details");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Batch b = manager.find(Batch.class, id);
		if (b != null) {
			System.out.println("ID :" + b.getId());
			System.out.println("Subject :" + b.getSubject());
			System.out.println("Batch Code :" + b.getBatch_code());
			System.out.println("Trainer :" + b.getTrainer());
		} else {
			System.err.println("You have entered an invalid ID");
		}
	}
}
