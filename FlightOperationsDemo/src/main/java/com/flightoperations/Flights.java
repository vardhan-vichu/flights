package com.flightoperations;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flights {

	@Id
	@GeneratedValue
	long id;

	String name;
	String source;
	String destination;
	long price;
	@Basic
	java.util.Date departure;
	@Basic
	java.util.Date arrival;

	public Flights() {
		super();
	}

	public Flights(String name, String source, String destination, long price, Date departure, Date arrival) {
		super();
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.departure = departure;
		this.arrival = arrival;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public java.util.Date getDeparture() {
		return departure;
	}

	public void setDeparture(java.util.Date departure) {
		this.departure = departure;
	}

	public java.util.Date getArrival() {
		return arrival;
	}

	public void setArrival(java.util.Date arrival) {
		this.arrival = arrival;
	}

	@Override
	public String toString() {
		return "Flights [id=" + id + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ ", price=" + price + ", departure=" + departure + ", arrival=" + arrival + "]";
	}

}
