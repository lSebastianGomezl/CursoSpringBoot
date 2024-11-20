package edu.eud.springBootTest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eud.springBootTest.business.EmployeeService;
import edu.eud.springBootTest.business.EmployeeServiceQuestion1;
import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.dto.EmployeeDTO1;
import edu.eud.springBootTest.dto.PageParamRequestDTO;
import edu.eud.springBootTest.dto.PageResponseDTO;

@RestController
@RequestMapping("/api/employee")
public class EmployeeAPIQuestion1 {
	
	@Autowired
	private EmployeeServiceQuestion1 service;
	
	
	@GetMapping()
	public List<EmployeeDTO1> findByFirstNameLetterEqualsLastName(
			@RequestParam(name = "firstName", required = false, defaultValue = "d") String firstName,
			@RequestParam(name = "lastName", required = false, defaultValue = "d") String lastName
			){
		return this.service.findByFirstNameLetterEqualsLastName(firstName, lastName);
	}

}
