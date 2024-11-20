package edu.eud.springBootTest.business;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class SingletonBean {
	
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
