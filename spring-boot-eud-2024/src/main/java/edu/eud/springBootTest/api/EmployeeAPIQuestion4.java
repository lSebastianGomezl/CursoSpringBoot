package edu.eud.springBootTest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import edu.eud.springBootTest.business.EmployeeServiceQuestion4;
import edu.eud.springBootTest.dto.EmployeeDTO3;



@RestController
@RequestMapping("/api/employee")
public class EmployeeAPIQuestion4 {
	
	@Autowired
	private EmployeeServiceQuestion4 service;
	
	
	@GetMapping("/filteryear")
	public List<EmployeeDTO3> consultarEmpleadosIngresaronPorQ(
			@RequestParam(name = "year", required = true, defaultValue = "2006") int year
			){
		return this.service.consultarEmpleadosIngresaronPorQ(year);
	}

}
