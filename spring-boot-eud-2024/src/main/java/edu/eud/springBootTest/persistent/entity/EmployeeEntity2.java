package edu.eud.springBootTest.persistent.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEES")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity2 {
	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	private String email;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "HIRE_DATE")
	private Date hireDate;
	private Double salary;
	@Column(name = "COMMISSION_PCT")
	private Float commissionPct;
	@Column(name = "MANAGER_ID")
	private Long managerId;
	
	@OneToOne(targetEntity = DepartmentEntity2.class, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
	private DepartmentEntity2 department;
	
	@OneToOne(targetEntity = JobEntity.class, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
	private JobEntity job;

	public EmployeeEntity2(Long id, String firstName, String lastName, String email, String phoneNumber, Date hireDate,
			Double salary, Float commissionPct, Long managerId, JobEntity job) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.job = job;
	}
	
	
}