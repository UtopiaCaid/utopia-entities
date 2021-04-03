/**
 * 
 */
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


/**
 * @author dwoo
 *
 */
@Entity
@Table(name = "tbl_flights")
public class Flight implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3634923359976670872L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_no")
	private Integer flightNo;

	@Column(name = "flight_gate", length = 45)
	@NonNull
	private String flightGate;
	
	@ManyToOne
	@JoinColumn(name = "airport_id_dep")
	private Airport airportDeparture;
	
	@ManyToOne
	@JoinColumn(name = "airport_id_arr")
	private Airport airportArrival;
	
	@ManyToOne
	@JoinColumn(name = "aircraft_id")
	private Aircraft aircraft;
	
	@OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Ticket> tickets;
	

	@Column(name = "base_price")
	@NonNull
	private float basePrice;
	
	@Column(name = "departure")
	@NonNull
	private LocalDate departure;
	
	@Column(name = "arrival")
	@NonNull
	private LocalDate arrival;
	
	@Column(name = "status", length = 45)
	@NonNull
	private String status;
	
	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public Integer getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(Integer flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightGate() {
		return flightGate;
	}

	public void setFlightGate(String flightGate) {
		this.flightGate = flightGate;
	}

	public Airport getairportDeparture() {
		return airportDeparture;
	}

	public void setairportDeparture(Airport airportDeparture) {
		this.airportDeparture = airportDeparture;
	}

	public Airport getairportArrival() {
		return airportArrival;
	}

	public void setairportArrival(Airport airportArrival) {
		this.airportArrival = airportArrival;
	}



	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public LocalDate getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDate departure) {
		this.departure = departure;
	}

	public LocalDate getArrival() {
		return arrival;
	}

	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aircraft == null) ? 0 : aircraft.hashCode());
		result = prime * result + ((airportArrival == null) ? 0 : airportArrival.hashCode());
		result = prime * result + ((airportDeparture == null) ? 0 : airportDeparture.hashCode());
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result + Float.floatToIntBits(basePrice);
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((flightGate == null) ? 0 : flightGate.hashCode());
		result = prime * result + ((flightNo == null) ? 0 : flightNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Flight other = (Flight) obj;
		if (aircraft == null) {
			if (other.aircraft != null)
				return false;
		} else if (!aircraft.equals(other.aircraft))
			return false;
		if (airportArrival == null) {
			if (other.airportArrival != null)
				return false;
		} else if (!airportArrival.equals(other.airportArrival))
			return false;
		if (airportDeparture == null) {
			if (other.airportDeparture != null)
				return false;
		} else if (!airportDeparture.equals(other.airportDeparture))
			return false;
		if (arrival == null) {
			if (other.arrival != null)
				return false;
		} else if (!arrival.equals(other.arrival))
			return false;
		if (Float.floatToIntBits(basePrice) != Float.floatToIntBits(other.basePrice))
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (flightGate == null) {
			if (other.flightGate != null)
				return false;
		} else if (!flightGate.equals(other.flightGate))
			return false;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}