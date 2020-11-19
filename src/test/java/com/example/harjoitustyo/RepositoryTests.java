package com.example.harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.harjoitustyo.domain.City;
import com.example.harjoitustyo.domain.CityRepository;
import com.example.harjoitustyo.domain.Park;
import com.example.harjoitustyo.domain.ParkRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTests {
	
	@Autowired
	private CityRepository cityrepo;
	
	@Autowired
	private ParkRepository parkrepo;
	
	@Test
	public void findAllByOrderByNameAsc() {
	List<City> cities = cityrepo.findAllByOrderByNameAsc();
	assertThat(cities.get(0).getName()).isEqualTo("Espoo");
	}
	
	
	@Test
	public void saveCity() {
		City city = new City("Kankaanpää");
		cityrepo.save(city);
		assertThat(city.getCityId()).isNotNull();
	}

	
	@Test
	public void savePark() {
		City city = new City("Kankaanpää");
		cityrepo.save(city);
		Park park = new Park("Puisto", city);
		parkrepo.save(park);
		
		assertThat(park.getParkId()).isNotNull();
		assertThat(park.getCity().getName()).isEqualTo("Kankaanpää");
		assertThat(park.getName()).isEqualTo("Puisto");

	}
	

	
	
}
