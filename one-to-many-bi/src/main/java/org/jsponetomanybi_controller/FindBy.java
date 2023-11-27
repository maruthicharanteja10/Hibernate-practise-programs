package org.jsponetomanybi_controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsponetomanybi_dto.Department;
import org.jsponetomanybi_dto.Employee;

public class FindBy {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
//		Employee p = manager.find(Employee.class, 1);
		Department d = manager.find(Department.class, 1);
	}
}
