package com.map.oneToMany.unidirectional;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Screen {

	@Id
	@Column(name = "screen_id")
	private int screenId;

	@Column(name = "screen_type")
	private String screenType;

	@Column(name = "movie_id")
	private int movieId; 

	private String showTiming;

	private int totalSeats;

	private int filledSeats;

	@Temporal(TemporalType.DATE)
	private Date showDate;

	@ManyToOne
	@JoinColumn(name = "cinema_id")
	private Cinema cinema;

	public Screen() {
		super();
	}

	public Screen(int screenId, String screenType, int movieId, String showTiming, int totalSeats, int filledSeats,
			Date showDate, Cinema cinema) {
		super();
		this.screenId = screenId;
		this.screenType = screenType;
		this.movieId = movieId;
		this.showTiming = showTiming;
		this.totalSeats = totalSeats;
		this.filledSeats = filledSeats;
		this.showDate = showDate;
		this.cinema = cinema;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(String showTiming) {
		this.showTiming = showTiming;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getFilledSeats() {
		return filledSeats;
	}

	public void setFilledSeats(int filledSeats) {
		this.filledSeats = filledSeats;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

}
