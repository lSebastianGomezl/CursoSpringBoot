package edu.eud.springBootTest.dto;

import java.util.Date;

import edu.eud.springBootTest.persistent.entity.DepartmentEntity;
import edu.eud.springBootTest.persistent.entity.JobEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class EmployeeDTO17 {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private Double salary;
	private Float commissionPct;
	private Long managerId;
	private Long departmentId;
	private JobEntity job;
}
