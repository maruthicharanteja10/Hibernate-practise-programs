package org.jspmanytomanyuni_controller;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jspmanytomanyuni_dto.Batch;
public class _05_FindBatchBySubject {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the subject to get the batch details");
		String subject = s.nextLine();
		String qry = "select b from Batch b where b.subject=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, subject);
		List<Batch> bt = q.getResultList();
		if (bt.size() > 0) {
			for (Batch b : bt) {
				System.out.println("ID :" + b.getId());
				System.out.println("Subject :" + b.getSubject());
				System.out.println("Batch Code :" + b.getBatch_code());
				System.out.println("Trainer :" + b.getTrainer());
			}
		} else {
			System.err.println("You have entered an invalid Subject");
		}
	}
}
