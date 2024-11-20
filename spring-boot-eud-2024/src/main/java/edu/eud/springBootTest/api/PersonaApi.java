package edu.eud.springBootTest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import edu.eud.springBootTest.business.PersonaService;

@RestController
public class PersonaApi {

	@Autowired
	//@Qualifier("persona2ServiceImpl")
	//@Qualifier("pepito")
	private PersonaService service;
	
	@Autowired
	//@Qualifier("persona2ServiceImpl")
	@Qualifier("pepito")
	private PersonaService service1;
	
	public void execute() {
		System.out.println("Ejecutando metodo execute de PersonaApi");
		this.service.execute();
		this.service1.execute();
	}
	
}
