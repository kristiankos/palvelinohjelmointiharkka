package com.example.harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Park {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long parkId;
	
	@NotEmpty
	private String name;

	@ManyToOne
	@JsonIgnoreProperties("parks")
	@JoinColumn(name = "city")
	private City city;
	
	public Park() {
		super();
	}

	
	
	public Park(String name) {
		super();
		this.name = name;
	}



	public Park(String name, City city) {
		super();
		this.name = name;
		this.city = city;
	}



	public Long getParkId() {
		return parkId;
	}

	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public City getCity() {
		return city;
	}



	public void setCity(City city) {
		this.city = city;
	}



	@Override
	public String toString() {
		return "Park [parkId=" + parkId + ", name=" + name + ", city=" + city + "]";
	}

	
}
