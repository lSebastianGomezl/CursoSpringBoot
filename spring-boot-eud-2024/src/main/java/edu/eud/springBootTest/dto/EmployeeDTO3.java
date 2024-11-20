package edu.eud.springBootTest.dto;

import java.util.Date;

import com.github.dozermapper.core.Mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class EmployeeDTO3 {

	private Long id;
	private String firstName;
	private String lastName;	
	private String email;
	private Date hierDate;
	private String phoneNumber;
	
	
	public EmployeeDTO3(Long id, String firstName, String lastName, String email, Date hierDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hierDate = hierDate;
	}

	public EmployeeDTO3(Long id, String firstName, String lastName, String email, Date hierDate, String phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hierDate = hierDate;
		this.phoneNumber = phoneNumber;
	}
	
	
	
}


