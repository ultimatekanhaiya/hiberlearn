package com.map.oneToOneEmbeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Worker {
	@Id
	@Column(name = "worker_id")
	private int workerId;

	private String name;
	
	private LocationDetail location;

	public Worker() {
		super();
	}

	public Worker(int workerId, String name, LocationDetail location) {
		super();
		this.workerId = workerId;
		this.name = name;
		this.location = location;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocationDetail getLocation() {
		return location;
	}

	public void setLocation(LocationDetail location) {
		this.location = location;
	}

}
