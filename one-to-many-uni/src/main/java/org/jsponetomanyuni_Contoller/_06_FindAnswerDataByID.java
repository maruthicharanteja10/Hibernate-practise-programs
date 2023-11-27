package org.jsponetomanyuni_Contoller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsponetomanyuni_dto.AnswerData;
import org.jsponetomanyuni_dto.QuestionData;

public class _06_FindAnswerDataByID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id for the Answerdata");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		AnswerData qd = manager.find(AnswerData.class, id);
		if (qd != null) {
			System.out.println("Answer ID :" + qd.getId());
			System.out.println("Answer :" + qd.getAnswer());
			System.out.println("AnswerBy  :" + qd.getAnsweredBy(null));
		} else {
			System.err.println("You have entered an invalid ID");
		}
	}
}
