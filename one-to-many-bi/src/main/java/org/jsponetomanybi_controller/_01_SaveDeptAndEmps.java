package org.jsponetomanybi_controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsponetomanybi_dto.Department;
import org.jsponetomanybi_dto.Employee;

public class _01_SaveDeptAndEmps {
	public static void main(String[] args) {
		Department d = new Department();
		d.setLocation("Tamil nadu");
		d.setName("kollywood");
		Employee e1 = new Employee();
		e1.setName("Jailer");
		e1.setDesgn("jailer");
		e1.setSalary(40000);
		e1.setDept(d);

		Employee e2 = new Employee();
		e2.setName("vikram");
		e2.setDesgn("Agent");
		e2.setSalary(67000);
		e2.setDept(d);

		Employee e3 = new Employee();
		e3.setName("Rolex");
		e3.setDesgn("smuggler");
		e3.setSalary(5000000);
		e3.setDept(d);
//	d.setEmps(new ArrayList<Employee>(Arrays.asList(e1,e2,e3)));
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		d.setEmps(emps);
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(d);
		transaction.begin();
		transaction.commit();
		System.out.println("Inserted succesfully");
	}
}
