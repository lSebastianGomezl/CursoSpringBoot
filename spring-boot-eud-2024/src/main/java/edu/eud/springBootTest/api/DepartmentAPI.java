package edu.eud.springBootTest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eud.springBootTest.business.DepartmentService;
import edu.eud.springBootTest.business.RegionService;
import edu.eud.springBootTest.dto.DepartmentDTO;
import edu.eud.springBootTest.dto.RegionDTO;
import edu.eud.springBootTest.util.exception.DatoNoExisteException;
import edu.eud.springBootTest.util.exception.DatoYaExisteException;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/department")
public class DepartmentAPI {

	private final DepartmentService service;
	
	@Autowired
	public DepartmentAPI(DepartmentService service) {
		this.service = service;
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<DepartmentDTO> getById(
			@PathVariable(name = "id") Long id
			){
		DepartmentDTO dto = this.service.getById(id);
		
		if(dto != null) {
			return ResponseEntity.ok(dto);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/execute")
	public void execute() {
		this.service.execute();
	}
}
