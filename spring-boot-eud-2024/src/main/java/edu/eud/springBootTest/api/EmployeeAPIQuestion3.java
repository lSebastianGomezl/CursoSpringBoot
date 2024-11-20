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
import edu.eud.springBootTest.business.EmployeeServiceQuestion3;
import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.dto.EmployeeDTO4;
import edu.eud.springBootTest.dto.PageParamRequestDTO;
import edu.eud.springBootTest.dto.PageResponseDTO;

@RestController
@RequestMapping("/api/employee")
public class EmployeeAPIQuestion3 {
	
	@Autowired
	private EmployeeServiceQuestion3 service;
	
	
	@GetMapping("/filter/managername")
	public List<EmployeeDTO4> findByManagerFirstNameOrLastName(
			@RequestParam(name = "firstName", required = false, defaultValue = "") String firstName,
			@RequestParam(name = "lastName", required = false, defaultValue = "") String lastName
			){
		return this.service.findByManagerFirstNameOrLastName(firstName, lastName);
	}

}
