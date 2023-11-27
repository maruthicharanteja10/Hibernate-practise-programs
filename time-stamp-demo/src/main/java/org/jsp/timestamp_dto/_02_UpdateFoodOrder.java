package org.jsp.timestamp_dto;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.timestamp_Controller.FoodOrder;

public class _02_UpdateFoodOrder {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder order = manager.find(FoodOrder.class, 3);
		
		order.setFood_item("chicken 65");
		order.setCost(220);
		manager.persist(order);
		transaction.begin();
		transaction.commit();
		System.out.println("Update ordered succesfully");
	}
}
