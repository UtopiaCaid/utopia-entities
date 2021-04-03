package com.caid.utopia.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_tickets")
public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8386679197471411465L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_no")
	private Integer ticketNo;

	@ManyToOne
	@JoinColumn(name = "flight_no")
	private Flight flight;
	
	@ManyToOne
	@JoinColumn(name = "traveler_id")
	private Traveler traveler;
	
	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
	@Column(name = "confirmation_code")
	@NonNull
	private Integer confirmationCode;
	
	@Column(name = "ticket_price")
	@NonNull
	private float ticketPrice;
	
	@Column(name = "date_issued")
	@NonNull
	private LocalDate dateIssued;

	public Integer getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(Integer ticketNo) {
		this.ticketNo = ticketNo;
	}


	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Traveler getTraveler() {
		return traveler;
	}

	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Integer getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(Integer confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	public float getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public LocalDate getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(LocalDate dateIssued) {
		this.dateIssued = dateIssued;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmationCode == null) ? 0 : confirmationCode.hashCode());
		result = prime * result + ((dateIssued == null) ? 0 : dateIssued.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((ticketNo == null) ? 0 : ticketNo.hashCode());
		result = prime * result + Float.floatToIntBits(ticketPrice);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (confirmationCode == null) {
			if (other.confirmationCode != null)
				return false;
		} else if (!confirmationCode.equals(other.confirmationCode))
			return false;
		if (dateIssued == null) {
			if (other.dateIssued != null)
				return false;
		} else if (!dateIssued.equals(other.dateIssued))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (ticketNo == null) {
			if (other.ticketNo != null)
				return false;
		} else if (!ticketNo.equals(other.ticketNo))
			return false;
		if (Float.floatToIntBits(ticketPrice) != Float.floatToIntBits(other.ticketPrice))
			return false;
		return true;
	}

	
	
}