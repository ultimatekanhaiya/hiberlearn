package com.map.oneToOneEmbeddable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ParkingSpot {
	@Id
	private int parkingId;

	private String garage;

	@OneToOne(mappedBy = "location.parkingSpot")
	private Worker assignedTo;

	public ParkingSpot() {
		super();
	}

	public ParkingSpot(int parkingId, String garage, Worker assignedTo) {
		super();
		this.parkingId = parkingId;
		this.garage = garage;
		this.assignedTo = assignedTo;
	}

	public int getParkingId() {
		return parkingId;
	}

	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}

	public String getGarage() {
		return garage;
	}

	public void setGarage(String garage) {
		this.garage = garage;
	}

	public Worker getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Worker assignedTo) {
		this.assignedTo = assignedTo;
	}

}
