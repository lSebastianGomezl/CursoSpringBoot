package edu.eud.springBootTest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class ExampleInjection {
	
	@Value("${eud.example-text}")
	private String exampleText;

	//Inyección por atributo
	//@Autowired
	//private PersonaService service;
	
	/*public ExampleInjection() {
		System.out.println("Creando ExampleInjection desde el constructor con texto " + this.exampleText);
	}*/
	
	//private final PersonaService service;
	
	//Inyección por constructor
	//@Autowired
	/*public ExampleInjection(PersonaService service) {
		this.service = service;
	}*/
	
	private PersonaService service;
	
	@PostConstruct
	public void init() {		
		System.out.println("Creando ExampleInjection desde el init() con texto " + this.exampleText);
	}
	
	public void execute() {
		System.out.println("Ejecutando desde ExampleInjection");
		this.service.execute();
		
		//this.service = new Persona2ServiceImpl();
		//this.service.execute();
	}
	
	//Inyección por setter
	@Autowired
	public void setService(PersonaService service) {
		this.service = service;
	}
}
