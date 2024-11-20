package edu.eud.springBootTest.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import edu.eud.springBootTest.business.EmployeeServiceQuestion16;

import edu.eud.springBootTest.dto.EmployeeDTO16;


@RestController
@RequestMapping("/api/employee")
public class EmployeeAPIQuestion16 {
	
	@Autowired
	private EmployeeServiceQuestion16 service;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		EmployeeDTO16 dto = service.findById(id);
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
}
