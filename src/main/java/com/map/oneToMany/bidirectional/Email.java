package com.map.oneToMany.bidirectional;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Email {
	@Id
	@Column(name = "email_id")
	private int id;

	private String email;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Person person;

	public Email() {
		super();
	}

	public Email(int id, String email, Person person) {
		super();
		this.id = id;
		this.email = email;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", email=" + email + ", emp=" + person + "]";
	}

}
