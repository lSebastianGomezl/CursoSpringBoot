package edu.eud.springBootTest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eud.springBootTest.business.EmployeeService;
import edu.eud.springBootTest.business.EmployeeServiceQuestion1;
import edu.eud.springBootTest.business.EmployeeServiceQuestion10;
import edu.eud.springBootTest.business.EmployeeServiceQuestion2;
import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.PageParamRequestDTO;
import edu.eud.springBootTest.dto.PageResponseDTO;

@RestController
@RequestMapping("/api/employee")
public class EmployeeAPIQuestion10 {
	
	@Autowired
	private EmployeeServiceQuestion10 service;
	
	
	@GetMapping("/filterMoreJob")
	public ResponseEntity<?> findByEmployeesMoreOneJob() {
		List<EmployeeDTO2> result = service.findEmployeesNoChangeJobs();

		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();

	}
}
