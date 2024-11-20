package edu.eud.springBootTest.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import edu.eud.springBootTest.business.PersonaService;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
class SpringBootEud2024ApplicationTests {
	
	@Value("${test-number}")
	Integer number1;
	
	@Value("${eud.example-number.1}")
	Integer number2;

	@Autowired
	PersonaService service;
	
	@Test
	void contextLoads() {
		System.out.println("Numero: " + number1);
		
		this.service.execute();
		
		assert true;
	}

}
