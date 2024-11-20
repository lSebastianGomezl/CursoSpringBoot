package edu.eud.springBootTest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eud.springBootTest.business.EmployeeServiceQuestion11;
import edu.eud.springBootTest.business.EmployeeServiceQuestion4;
import edu.eud.springBootTest.business.EmployeeServiceQuestion5;
import edu.eud.springBootTest.business.EmployeeServiceQuestion6;
import edu.eud.springBootTest.business.EmployeeServiceQuestion7;
import edu.eud.springBootTest.business.EmployeeServiceQuestion9;
import edu.eud.springBootTest.dto.EmployeeDTO1;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.EmployeeDTO3;



@RestController
@RequestMapping("/api/employee")
public class EmployeeAPIQuestion11 {
	
	@Autowired
	private EmployeeServiceQuestion11 service;
	
	
	@GetMapping("/filterhistoryEmployeeJobs")
	public ResponseEntity<?> findByHistoryEmployeeJobs(@RequestParam(required = false, defaultValue = "101") int employeeId) {
		List<EmployeeDTO1> result = service.findByHistoryEmployeeJobs(employeeId);
		System.out.println(result.size());

		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
	}

}
