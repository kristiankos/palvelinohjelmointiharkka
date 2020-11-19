package com.example.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cityId;
	
	@NotEmpty
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
	@JsonIgnoreProperties("city")
	private List<Park> parks;

	
	
	public City() {
		super();
	}

	
	public City(String name) {
		super();
		this.name = name;
	}

	

	public City(Long cityId) {
		super();
		this.cityId = cityId;
	}


	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Park> getParks() {
		return parks;
	}

	public void setParks(List<Park> parks) {
		this.parks = parks;
	}


	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", name=" + name + "]";
	}



	
	

}
