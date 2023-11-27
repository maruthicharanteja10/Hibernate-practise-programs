package org.jspmanytomanyuni_controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jspmanytomanyuni_dto.Batch;
public class _03_FindBatchByID2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Id to get the Batch details");
		int id = s.nextInt();
		String qry = "select d from Batch d where d.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			Batch b = (Batch) q.getSingleResult();
			System.out.println("ID :" + b.getId());
			System.out.println("Subject :" + b.getSubject());
			System.out.println("Batch Code :" + b.getBatch_code());
			System.out.println("Trainer :" + b.getTrainer());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid ID");
		}
	}

}
