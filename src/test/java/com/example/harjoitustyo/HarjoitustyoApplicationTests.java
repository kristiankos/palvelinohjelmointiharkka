package com.example.harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.harjoitustyo.web.ParkController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HarjoitustyoApplicationTests {

	@Autowired
	private ParkController parkcontroller;
	
	
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(parkcontroller).isNotNull();
	}
	

	
	

}
