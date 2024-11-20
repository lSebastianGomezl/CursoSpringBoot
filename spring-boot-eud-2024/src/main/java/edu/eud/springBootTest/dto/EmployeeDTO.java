package edu.eud.springBootTest.dto;

import java.util.Date;

import com.github.dozermapper.core.Mapping;

import lombok.Data;

@Data
public class EmployeeDTO {

	private Long id;
	private String firstName;
	private String lastName;	
	//private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private Double salary;
	private Float commissionPct;
	private Long managerId;
	private Long departmentId;
	@Mapping("email")
	private String correoElectronico;
	
}
