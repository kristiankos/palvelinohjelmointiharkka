package com.example.harjoitustyo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.harjoitustyo.domain.City;
import com.example.harjoitustyo.domain.CityRepository;

@RestController
public class CityController {

	@Autowired
	private CityRepository cityrepo;

	// RESTful service to get all cities
	@GetMapping(value = "/cities")
	public @ResponseBody List<City> cityListRest() {
		return (List<City>) cityrepo.findAll();
	}


	// RESTful service to save new city
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/cities")
	public @ResponseBody City saveCityRest(@RequestBody City city) {
		return cityrepo.save(city);
	}


}
