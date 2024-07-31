package com.map.oneToMany.bidirectional;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Person {

	@Id
	@Column(name = "person_id")
	private int personId;

	private String name;

	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
	private List<Email> emails;

	private Address address;

	public Person() {
		super();
	}

	public Person(int personId, String name, List<Email> emails, Address address) {
		super();
		this.personId = personId;
		this.name = name;
		this.emails = emails;
		this.address = address;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [personId=" + personId + ", name=" + name + "]";
	}

}
