package com.map.oneToMany.unidirectional;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cinema {

	@Id
	@Column(name = "cinema_id")
	private int cinemaId;

	@Column(name = "brand_name")
	private String brandName;

	private String address;

	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	private List<Screen> screen;

	public Cinema() {
		super();
	}

	public Cinema(int cinemaId, String brandName, String address, List<Screen> screen) {
		super();
		this.cinemaId = cinemaId;
		this.brandName = brandName;
		this.address = address;
		this.screen = screen;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Screen> getScreen() {
		return screen;
	}

	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}

}
