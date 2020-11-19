package com.example.harjoitustyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.harjoitustyo.domain.City;
import com.example.harjoitustyo.domain.CityRepository;
import com.example.harjoitustyo.domain.Park;
import com.example.harjoitustyo.domain.ParkRepository;
import com.example.harjoitustyo.domain.User;
import com.example.harjoitustyo.domain.UserRepository;

@SpringBootApplication
public class HarjoitustyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ParkRepository parkrepo, CityRepository cityrepo, UserRepository userrepo) {
		return (args) -> {
			
			City espoo = new City("Espoo");
			cityrepo.save(espoo);
			City sipoo = new City("Sipoo");
			cityrepo.save(sipoo);
			City inari = new City("Inari");
			cityrepo.save(inari);
			City joensuu = new City("Joensuu");
			cityrepo.save(joensuu);
			City ruovesi= new City("Ruovesi");
			cityrepo.save(ruovesi);
			City kauhajoki = new City("Kauhajoki");
			cityrepo.save(kauhajoki);
			City sotkamo = new City("Sotkamo");
			cityrepo.save(sotkamo);
			

			
			
			
			parkrepo.save(new Park("Nuuksio", espoo));
			parkrepo.save(new Park("Koli", joensuu));
			parkrepo.save(new Park("Hiidenportti", sotkamo));
			parkrepo.save(new Park("Lemmenjoki", inari));
			parkrepo.save(new Park("Helvetinjärvi", ruovesi));
			parkrepo.save(new Park("Lauhanvuori", kauhajoki));
			parkrepo.save(new Park("Sipoonkorpi", sipoo));

			//Create user and admin
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userrepo.save(user1);
			userrepo.save(user2);
			
			
			
			
		};
		
		
	}
}
