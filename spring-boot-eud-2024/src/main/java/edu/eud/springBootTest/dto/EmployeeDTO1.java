package edu.eud.springBootTest.dto;

import java.util.Date;

import com.github.dozermapper.core.Mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Builder
public class EmployeeDTO1 {
	

	private String firstName;
	private String lastName;	
	private Date hireDate;
	private String jobTitle;
	private String departmentName;
	private String correoElectronico;
	

	
	
	
	

}
