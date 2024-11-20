package edu.eud.springBootTest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.eud.springBootTest.business.impl.Persona1ServiceImpl;
import edu.eud.springBootTest.dto.PersonaDTO;

@SpringBootApplication
public class SpringBootEud2024Application {

	/*@Autowired
	private PersonaApi api;
	
	@Autowired
	private ExampleInjection exampleInjection;*/
	
	/*@Autowired
	private ApplicationContext ctx;*/
	
	@Autowired
	private Persona1ServiceImpl service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEud2024Application.class, args);
	}
	
	@Bean
	public CommandLineRunner startup() {
		return args -> {	
			System.out.println("Ejecutando luego de carga de Spring Boot");
			
			//ESTE SI ES UN BEAN DE SPRING
			//this.api.execute();
			
			//NO ES UN BEAN DE SPRING
			//PersonaApi myApi = new PersonaApi();
			
			//myApi.execute();
			
			//exampleInjection.execute();
			
			/*SingletonBean bean1 = this.ctx.getBean(SingletonBean.class);
			bean1.increment();
			bean1.increment();
			
			SingletonBean bean2 = this.ctx.getBean(SingletonBean.class);
			bean2.increment();
			bean2.increment();*/
			
			/*PrototypeBean bean1 = this.ctx.getBean(PrototypeBean.class);
			bean1.increment();
			bean1.increment();*/
			
			/*PrototypeBean bean2 = this.ctx.getBean(PrototypeBean.class);
			bean2.increment();
			bean2.increment();*/
			
			PersonaDTO dto = new PersonaDTO("Camilo", 20, new Date());
			
			String json = this.service.getJson(dto);
			
			System.err.println(json);
			
		};	
	}
}
