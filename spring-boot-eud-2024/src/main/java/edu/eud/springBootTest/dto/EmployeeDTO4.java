package edu.eud.springBootTest.dto;

import java.util.Date;

import com.github.dozermapper.core.Mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmployeeDTO4 {

	private Long id;
	private String firstName;
	private String lastName;	
	private String nameManager;
	private String phoneNumber;
	private String departmentName;

	
}

