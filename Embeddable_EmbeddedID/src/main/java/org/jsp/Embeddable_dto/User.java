package org.jsp.Embeddable_dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class User {
	@EmbeddedId
	private UserID id;
	private int age;
	private String name;

	public UserID getId() {
		return id;
	}

	public void setId(UserID id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
