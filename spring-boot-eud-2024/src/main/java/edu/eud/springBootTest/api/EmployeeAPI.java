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
import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.dto.PageParamRequestDTO;
import edu.eud.springBootTest.dto.PageResponseDTO;

@RestController
@RequestMapping("/api/employee")
public class EmployeeAPI {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public void execute() {
		this.service.execute();
	}
	
	@PostMapping("/query")
	public void executeQuery() {
		this.service.executeQuery();
	}
	
	@GetMapping("/filtro1")
	public List<EmployeeDTO> consultarPorDepartamentoCargoSalario(
			@RequestParam(name = "departamento", required = true) Long departamento,
			@RequestParam(name = "cargo", required = true) String cargo,
			@RequestParam(name = "salarioMinimo", required = true) Double salary
			){
		return this.service.consultarPorDepartamentoCargoSalario(departamento, cargo, salary);
	}
	
	@GetMapping("/filtro2/departamento/{departamento}")
	public PageResponseDTO<EmployeeDTO> consultarPorDepartamento(
			@PathVariable(name = "departamento") Long departamento,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize
			){
		PageParamRequestDTO pageParam = new PageParamRequestDTO(page, pageSize);
		
		return this.service.consultarPorDepartamento(departamento, pageParam);
	}

}
