package edu.eud.springBootTest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import edu.eud.springBootTest.business.EmployeeServiceQuestion4;
import edu.eud.springBootTest.business.EmployeeServiceQuestion5;
import edu.eud.springBootTest.business.EmployeeServiceQuestion6;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.EmployeeDTO3;



@RestController
@RequestMapping("/api/employee")
public class EmployeeAPIQuestion6 {
	
	@Autowired
	private EmployeeServiceQuestion6 service;
	
	
	@GetMapping("/filterJobPorcent")
	public ResponseEntity<?> findByDepartmentName(
			@RequestParam(required = false, defaultValue = "Sales Representative") String jobName,
			@RequestParam(required = false, defaultValue = "0.25") Double porcent) {
		List<EmployeeDTO2> result = service.findByJobPorcent(jobName, porcent);
		System.out.println(result.size());

		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
	}

}
