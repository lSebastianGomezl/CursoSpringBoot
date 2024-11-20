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

import edu.eud.springBootTest.business.RegionService;
import edu.eud.springBootTest.dto.RegionDTO;
import edu.eud.springBootTest.util.exception.DatoNoExisteException;
import edu.eud.springBootTest.util.exception.DatoYaExisteException;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/region")
public class RegionAPI {

	private final RegionService service;
	
	@Autowired
	public RegionAPI(RegionService service) {
		this.service = service;
	}
	
	
	@PostMapping("/execute")
	public void execute() {
		this.service.execute();
	}
	
	@GetMapping()
	public List<RegionDTO> getAll(){
		return this.service.getAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<RegionDTO> getById(
			@PathVariable(name = "id") Long id
			){
		RegionDTO dto = this.service.getById(id);
		
		if(dto != null) {
			return ResponseEntity.ok(dto);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping()
	public ResponseEntity<Void> create(
			@RequestBody @Valid RegionDTO dto) {
		try {
			Assert.notNull(dto.getId(), "ID es nulo");
			
			this.service.create(dto);
			
			return ResponseEntity.ok().build();
		}catch (DatoYaExisteException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}		
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<Void> update(
			@PathVariable(name = "id") Long id,
			@RequestBody @Valid RegionDTO dto) {
		try {			
			dto.setId(id);
			this.service.update(dto);
			
			return ResponseEntity.ok().build();
		}catch (DatoNoExisteException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}		
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Void> update(
			@PathVariable(name = "id") Long id) {
		try {						
			this.service.delete(id);
			
			return ResponseEntity.ok().build();
		}catch (DatoNoExisteException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}		
	}
}
