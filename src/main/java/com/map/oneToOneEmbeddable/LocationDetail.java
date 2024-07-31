package com.map.oneToOneEmbeddable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;

@Embeddable

public class LocationDetail {

	private int officeNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private ParkingSpot parkingSpot;

	public LocationDetail() {
		super();
	}

	public LocationDetail(int officeNumber, ParkingSpot parkingSpot) {
		super();
		this.officeNumber = officeNumber;
		this.parkingSpot = parkingSpot;
	}

	public int getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

}
