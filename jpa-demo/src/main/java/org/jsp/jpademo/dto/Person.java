package org.jsp.jpademo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@NamedQuery(name="FindByName",query="select p from Person p where p.name=?1")
@NamedQueries(value= {@NamedQuery(name="FindByAge",query="select p from Person p where p.age=?1"),
@NamedQuery(name="FindByPhone",query="select p from Person p where p.phone=?1")
,@NamedQuery(name="FindByEmail",query="select p from Person p where p.email=?1")})
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 45, name = "name")
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(unique = true, nullable = false)
	private long phone;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
