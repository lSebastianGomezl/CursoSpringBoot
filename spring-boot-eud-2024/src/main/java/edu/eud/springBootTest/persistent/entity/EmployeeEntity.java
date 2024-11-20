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
public class EmployeeEntity {
	@Id
	@Column(name = "EMPLOYEE_ID")
	private Long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column()
	
	private String email;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "HIRE_DATE")
	private Date hireDate;
	@Column(name = "JOB_ID")
	private String jobId;
	@Column()
	private Double salary;
	@Column(name = "COMMISSION_PCT")
	private Float commissionPct;
	@Column(name = "MANAGER_ID")
	private Long managerId;
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	
	
	
	
	public EmployeeEntity(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	
	public EmployeeEntity(Long id, String firstName, String lastName, Double salary, Float commissionPct) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.commissionPct = commissionPct;
	}

	public EmployeeEntity(Long id, String firstName, String lastName, Date hireDate, Double salary, Long managerId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.salary = salary;
		this.managerId = managerId;
	}



	public EmployeeEntity(Long id, String firstName, String lastName, String email,Date hireDate, String phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
	}


	


	
	
}