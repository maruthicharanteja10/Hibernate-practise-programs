package org.jsp.employeeapp.impl;

import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dto.Employee;
import java.util.*;

public class EmployeeImpl {
	static EmployeeDao dao = new EmployeeDao();
	static Scanner s = new Scanner(System.in);

	public static void save() {
		System.out.println("Enter the name,phone,email,designtaion,salary and password to save Employee");
		Employee e = new Employee();
		e.setName(s.next());
		e.setPhone(s.nextLong());
		e.setEmail(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPassword(s.next());
		e = dao.saveEmployee(e);
		System.out.println("Employee Saved with Id:" + e.getId());
	}

	public static void update() {
		System.out.println("Enter the Employee Id to update");
		int eid = s.nextInt();
		System.out.println("Enter the name,phone,email,designtaion,salary and password to save Employee");
		Employee e = new Employee();
		e.setId(eid);
		e.setName(s.next());
		e.setPhone(s.nextLong());
		e.setEmail(s.next());
		e.setDesg(s.next());
		e.setSalary(s.nextDouble());
		e.setPassword(s.next());
		e = dao.updateEmployee(e);
		System.out.println("Employee Updated");
	}

	public static void findById() {
		System.out.println("Enter the Employee Id to display details");
		int eid = s.nextInt();
		Employee e = dao.findById(eid);
		if (e != null) {
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Email id:" + e.getEmail());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("You have entered an Invalid Id");
		}
	}

	public static void delete() {
		System.out.println("Enter the Employee Id to delete");
		int eid = s.nextInt();
		boolean deleted = dao.deleteById(eid);
		if (deleted) {
			System.out.println("Employee deleted");
		} else {
			System.err.println("Cannot delete Employee!!As You have entered an Invalid Id");
		}
	}

	public static void verifyById() {
		System.out.println("Enter the Employee Id and password to verify");
		int eid = s.nextInt();
		String password = s.next();
		Employee e = dao.verifyEmployee(eid, password);
		if (e != null) {
			System.out.println("verification Succesfull");
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Email id:" + e.getEmail());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("You have entered an Invalid Id or Password");
		}
	}

	public static void verifyByPhone() {
		System.out.println("Enter the Employee Phone and password to verify");
		long phone = s.nextLong();
		String password = s.next();
		Employee e = dao.verifyEmployee(phone, password);
		if (e != null) {
			System.out.println("verification Succesfull");
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Email id:" + e.getEmail());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("You have entered an Invalid Phone Number or Password");
		}
	}

	public static void verifyByEmail() {
		System.out.println("Enter the Employee Email and password to verify");
		String email = s.next();
		String password = s.next();
		Employee e = dao.verifyEmployee(email, password);
		if (e != null) {
			System.out.println("verification Succesfull");
			System.out.println("Employee Id:" + e.getId());
			System.out.println("Employee Name:" + e.getName());
			System.out.println("Designation:" + e.getDesg());
			System.out.println("Salary:" + e.getSalary());
			System.out.println("Email id:" + e.getEmail());
			System.out.println("Phone Number:" + e.getPhone());
		} else {
			System.err.println("You have entered an Invalid Email Id or Password");
		}
	}
}
