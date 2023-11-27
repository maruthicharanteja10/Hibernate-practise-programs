package org.jsponetomanyuni_Contoller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsponetomanyuni_dto.AnswerData;
import org.jsponetomanyuni_dto.QuestionData;
public class _07_FindAnswerDataByID2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id for the Answerdata");
		int id = s.nextInt();
		String qry = "select a from AnswerData a where a.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			AnswerData qd = (AnswerData) q.getSingleResult();
			System.out.println("Answer ID :" + qd.getId());
			System.out.println("Answer :" + qd.getAnswer());
			System.out.println("AnswerBy  :" + qd.getAnsweredBy(null));
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid id ");
		}
	}
}
