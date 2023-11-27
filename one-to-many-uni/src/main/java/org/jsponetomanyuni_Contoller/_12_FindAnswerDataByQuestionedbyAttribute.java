package org.jsponetomanyuni_Contoller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsponetomanyuni_dto.AnswerData;

public class _12_FindAnswerDataByQuestionedbyAttribute {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the question for answerdata");
		String questionedby = s.nextLine();
		String qry = "select q.answers from QuestionData q where q.questionedBy=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, questionedby);
		List<AnswerData> ad = q.getResultList();
		if (ad.size() > 0) {
			for (AnswerData p : ad) {
				System.out.println("Answer ID:" + p.getId());
				System.out.println("Answer :" + p.getAnswer());
				System.out.println("AnsweredBy :" + p.getAnsweredBy(null));
				System.out.println("---------------------------");
			}
		} else {
			System.err.println("You have entered an invalid question ID");
		}
	}
}
