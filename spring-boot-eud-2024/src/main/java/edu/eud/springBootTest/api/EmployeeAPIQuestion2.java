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
import edu.eud.springBootTest.business.EmployeeServiceQuestion2;
import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.PageParamRequestDTO;
import edu.eud.springBootTest.dto.PageResponseDTO;

@RestController
@RequestMapping("/api/employee")
public class EmployeeAPIQuestion2 {
	
	@Autowired
	private EmployeeServiceQuestion2 service;
	
	
	@GetMapping("/salaryfilter")
	public List<EmployeeDTO2> findByFirstNameLetterEqualsLastName(
			@RequestParam(name = "salary1", required = false, defaultValue = "1000") Double salary1,
			@RequestParam(name = "salary2", required = false, defaultValue = "4000") Double salary2
			){
		return this.service.consultarPorRangoSalarialOrdenadoPorNombreApellidoAsc(salary1, salary2);
	}

}
