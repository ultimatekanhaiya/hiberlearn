package com.collection;

import java.time.LocalDate;
import java.util.Map;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.JoinColumn;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private int ticketId;

	@Column(name = "booking_date")
	private LocalDate bookingDate;

	private boolean isActive;

	@ElementCollection
	@CollectionTable(name = "ticket_price_mapping", joinColumns = {
			@JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id") })
	@MapKeyColumn(name = "seat_type")
	@Column(name = "price")
	private Map<String, Double> seatPriceMap;

	public Ticket() {
		super();
	}

	public Ticket(int ticketId, LocalDate bookingDate, boolean isActive, Map<String, Double> seatPriceMap) {
		super();
		this.ticketId = ticketId;
		this.bookingDate = bookingDate;
		this.isActive = isActive;
		this.seatPriceMap = seatPriceMap;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Map<String, Double> getSeatPriceMap() {
		return seatPriceMap;
	}

	public void setSeatPriceMap(Map<String, Double> seatPriceMap) {
		this.seatPriceMap = seatPriceMap;
	}

}
