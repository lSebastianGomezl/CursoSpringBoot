package edu.eud.springBootTest.business;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
@Scope("prototype")
public class PrototypeBean {

	private Integer value = 0;
	
	@PostConstruct
	private void init() {
		System.out.println("init value: " + value);
	}
	
	public void increment() {
		System.out.println("Value: " + value);
		this.value++;
	}
}
