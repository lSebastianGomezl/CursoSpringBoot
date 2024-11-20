package edu.eud.springBootTest.dto;

import java.util.Date;

import edu.eud.springBootTest.persistent.entity.DepartmentEntity;
import edu.eud.springBootTest.persistent.entity.DepartmentEntity2;
import edu.eud.springBootTest.persistent.entity.JobEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class EmployeeDTO16 {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private Double salary;
	private Float commissionPct;
	private Long managerId;
	private DepartmentEntity2 department;
	private JobEntity job;
}
