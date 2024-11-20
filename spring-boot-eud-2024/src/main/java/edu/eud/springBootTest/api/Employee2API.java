package edu.eud.springBootTest.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eud.springBootTest.dto.Employee2DTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/employee2")
@Slf4j
public class Employee2API {
	
	//GET - /api/employee
	//200 --> OK
	//500 --> Error
	@GetMapping(
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Employee2DTO> getAll() {
		List<Employee2DTO> employees = new ArrayList<Employee2DTO>();
		
		Employee2DTO dto1 = new Employee2DTO();
		dto1.setId(1L);
		dto1.setFirstName("Cesar");
		dto1.setLastName("Garcia");
		dto1.setAge(20);
		dto1.setBirthDate(new Date());
		
		employees.add(dto1);
		
		Employee2DTO dto2 = new Employee2DTO();
		dto2.setId(2L);
		dto2.setFirstName("Lorena");
		dto2.setLastName("Perez");
		dto2.setAge(30);
		dto2.setBirthDate(new Date());
		
		employees.add(dto2);
		
		//throw new RuntimeException("Error generado");
		
		return employees;
	}
	
	//GET - /api/employee/id/25
	//200  --> OK (Existe o que no existe)
	//500  --> Error
	//400  --> Bad request
	/*@GetMapping(
			value = {"/id/{id}"})
	public EmployeeDTO getById(
			@PathVariable(value = "id") Long id) {
		if(id < 50) {
			EmployeeDTO dto1 = new EmployeeDTO();
			dto1.setId(id);
			dto1.setFirstName("Cesar");
			dto1.setLastName("Garcia");
			dto1.setAge(20);
			dto1.setBirthDate(new Date());
			
			return dto1;
		}else {
			return null;
		}
	}*/
	
	//200 --> OK con contenido
	//204 --> No content
	//500, 400
	@GetMapping(
			value = {"/id/{id}", "/{id}"})
	public ResponseEntity<Employee2DTO> getById(
			@PathVariable(value = "id") Long id) {
		if(id < 50) {
			Employee2DTO dto1 = new Employee2DTO();
			dto1.setId(id);
			dto1.setFirstName("Cesar");
			dto1.setLastName("Garcia");
			dto1.setAge(20);
			dto1.setBirthDate(new Date());
			
			return ResponseEntity.ok(dto1);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping(
			value = {"/fn/{fn}/ln/{ln}", "/names/{fn}/{ln}"})
	public ResponseEntity<List<Employee2DTO>> getByNames(
			@PathVariable(value = "fn") String firstName,
			@PathVariable(value = "ln") String lastName) {
		List<Employee2DTO> employees = new ArrayList<Employee2DTO>();
		
		Employee2DTO dto1 = new Employee2DTO();
		dto1.setId(1L);
		dto1.setFirstName(firstName);
		dto1.setLastName(lastName);
		dto1.setAge(20);
		dto1.setBirthDate(new Date());
		
		employees.add(dto1);
		
		Employee2DTO dto2 = new Employee2DTO();
		dto2.setId(2L);
		dto2.setFirstName(firstName);
		dto2.setLastName(lastName);
		dto2.setAge(30);
		dto2.setBirthDate(new Date());
		
		employees.add(dto2);
		
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping(
			value = {"/id"})
	public ResponseEntity<Employee2DTO> getById2(
			@RequestParam(value = "id", required = true) Long id) {
		return this.getById(id);
	}
	
	@GetMapping(
			value = {"/names"})
	public ResponseEntity<List<Employee2DTO>> getByNames2(
			@RequestParam(value = "fn", required = true) String firstName,
			@RequestParam(value = "ln", required = true) String lastName) {
		return this.getByNames(firstName, lastName);
	}
	
	@GetMapping(
			value = {"/names2"})
	public ResponseEntity<List<Employee2DTO>> getByNames3(
			@RequestParam(value = "fn", required = false) String firstName,
			@RequestParam(value = "ln", required = false) String lastName) {
		
		if(firstName == null && lastName == null) {
			return ResponseEntity.badRequest().build();		
		}
				
		List<Employee2DTO> employees = new ArrayList<Employee2DTO>();
		
		if(firstName != null && lastName == null) {
			Employee2DTO dto2 = new Employee2DTO();
			dto2.setId(2L);
			dto2.setFirstName(firstName);
			dto2.setLastName("Paez");
			dto2.setAge(30);
			dto2.setBirthDate(new Date());
			
			employees.add(dto2);
		}else if(firstName == null && lastName != null) {
			Employee2DTO dto2 = new Employee2DTO();
			dto2.setId(2L);
			dto2.setFirstName("Victor");
			dto2.setLastName(lastName);
			dto2.setAge(30);
			dto2.setBirthDate(new Date());
			
			employees.add(dto2);
		}else if(firstName != null && lastName != null){
			Employee2DTO dto2 = new Employee2DTO();
			dto2.setId(2L);
			dto2.setFirstName(firstName);
			dto2.setLastName(lastName);
			dto2.setAge(30);
			dto2.setBirthDate(new Date());
			
			employees.add(dto2);
		}else {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping(
			value = "/code/{code}")
	public List<Employee2DTO> getByFilter(
			@PathVariable(name = "code") Long code,
			@RequestParam(name = "fn", required = false, defaultValue = "Carlos") String firstName,
			@RequestParam(name = "ln", required = true) String lastName
			){
		return new ArrayList<Employee2DTO>();
	}
	
	@PostMapping(
			value = "/filter"
			)
	public ResponseEntity<List<Employee2DTO>> getByFilter2(
			@RequestBody Employee2DTO dto
			){
		return ResponseEntity.ok(Arrays.asList(dto));
	}
	
	/*@PostMapping()
	public ResponseEntity<Long> create(
			@RequestBody EmployeeDTO dto
			){
		return ResponseEntity.ok(new Random().nextLong());
	}*/
	
	@PostMapping()
	public ResponseEntity<Employee2DTO> create(
			@RequestBody @Valid Employee2DTO dto
			){
		
		dto.setId(new Random().nextLong());
		
		return ResponseEntity
				.status(HttpStatus.CREATED) //Definiendo HTTP Status Code 201
				.body(dto); //Fijando es la respuesta
	}
	
	/*@PutMapping(
			value = "/id/{id}"
			)
	public ResponseEntity<Void> modify(
			@PathVariable(name = "id") Long id,
			@RequestBody EmployeeDTO dto
			) {
		//Busca el empleado
		//Actualiza
		if(id < 100) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.noContent().build();
		}
	}*/
	
	@PutMapping()
	public ResponseEntity<Void> modify(
			@RequestBody Employee2DTO dto
			) {
		try {
			this.validateModify(dto);
			
			if(dto.getId() < 100) {
				return ResponseEntity.ok().build();
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	private void validateModify(Employee2DTO dto) {
		Assert.notNull(dto.getId(), "IS es nulo");		
		
		if(dto.getFirstName() == null && dto.getLastName() == null) {
			throw new IllegalArgumentException("FN y LN son nulos");
		}
	}

	/**
	 * 
	 * @param dto
	 * @return boolean, TRUE si es valido, FALSE si es invalido
	 */
	/*private boolean validateModify(EmployeeDTO dto) {
		Assert.notNull(dto.getId(), "IS es nulo");		
		
		if(dto.getFirstName() == null && dto.getLastName() == null) {
			return false;
		}
		
		return true;
	}*/
	/*@DeleteMapping(
			value = "/id/{id}"
			)
	public ResponseEntity<Void> delete(
			@PathVariable(name = "id") Long id
			){
		if(id < 100) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.noContent().build();
		}		
	}*/
	
	@DeleteMapping(
			value = "/id/{id}"
			)
	public ResponseEntity<Employee2DTO> delete(
			@PathVariable(name = "id") Long id
			){
		if(id < 100) {
			Employee2DTO dto2 = new Employee2DTO();
			dto2.setId(id);
			dto2.setFirstName("Dummy");
			dto2.setLastName("Dummy");
			dto2.setAge(30);
			dto2.setBirthDate(new Date());
			
			return ResponseEntity.ok(dto2);
		}else {
			return ResponseEntity.noContent().build();
		}		
	}
	
	@RequestMapping(
			value = "/merge", 
			method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<Void> merge(
			@RequestBody Employee2DTO dto
			){
		//Modify
		if(dto.getId() != null) {
			return ResponseEntity.ok().build();
		//Create
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	}
	
	@PatchMapping("/id/{id}")
	public void partialUpdate(
			@RequestBody Employee2DTO dto
			) {
		//El proceso de actualización
		return;
		//return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).build();
	}
	
	@PostMapping(value = "/execute")
	public void execute(
			@RequestHeader(name = HttpHeaders.HOST, required = true) String host,
			@RequestHeader(name = "username", required = true) String username			
			) {
		
		System.out.println("Usuario que ejecuta el proceso: " + username + " desde " + host );
	}
	
	@PostMapping(value = "/execute2")
	public ResponseEntity<Void> execute2(
			@RequestHeader(name = "username", required = false, defaultValue = "test") String username			
			) {
		
		System.out.println("Usuario que ejecuta el proceso: " + username);
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.put("filename", Arrays.asList("myFile.txt"));
		headers.put(HttpHeaders.CONTENT_LENGTH, Arrays.asList("250"));
		
		ResponseEntity<Void> response = new ResponseEntity<>(headers, HttpStatus.OK);
		
		return response;
	}
	

	public ResponseEntity<Void> myMethod(){
		try {
			//Procesamiento y respondo (200, 201, 409)
			
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			// Registro en log y respondo (4XX, 500)
			log.error("Error en myMethod", e);
			
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
