package edu.eud.springBootTest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO {
	
	private Long id;
	private String name;
	
	//private Long managerId;
	private EmployeeDTO manager;

}
