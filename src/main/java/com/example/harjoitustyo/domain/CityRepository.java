package com.example.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
	
	public List<City> findAllByOrderByNameAsc();
	
}
