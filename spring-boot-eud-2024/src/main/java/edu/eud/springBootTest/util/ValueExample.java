package edu.eud.springBootTest.util;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ValueExample {
			
	@Value("${eud.example-text}")
	private String texto;
	
	@Value("${eud.example-number.1}")
	private Integer number1;
	
	@Value("${eud.example-number.2}")
	private Float number2;
	
	@Value("${eud.example-boolean}")
	private Boolean boleano;
	
	@Value("${eud.example-no-existe:Texto de Prueba}")
	private String noExiste;
	
	@Value("#{systemEnvironment['USER']}")
	private String username;
	
	@Value("#{systemProperties['java.io.tmpdir']}")
	private String tmpDir;
	
	@Value("#{${eud.example-string-list}}")
	private List<String> listOfTexts;
	
	@Value("#{${eud.example-number-list}}")
	private List<Integer> listOfNumbers;
	
	@Value("${eud.example.random.int}")
	private Integer randomInt;
	
	@Value("${random.int(10)}")
	private Integer randomInt2;
	
	@Value("${random.int[10,100]}")
	private Integer randomInt3;
	
	//private Map<Integer, String> myMap;
	
	@PostConstruct
	public void init() {
		System.out.println("init");
	}
}
