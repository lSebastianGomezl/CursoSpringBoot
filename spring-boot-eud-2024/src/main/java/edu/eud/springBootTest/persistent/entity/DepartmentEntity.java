package edu.eud.springBootTest.persistent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEPARTMENTS")
@Data
@NoArgsConstructor
public class DepartmentEntity {
	
	@Id
	@Column(name = "DEPARTMENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DepartmentEntityGenerator")
	@SequenceGenerator(name = "DepartmentEntityGenerator", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@Column(name = "DEPARTMENT_NAME")
	private String name;
	
	/*@Column(name = "MANAGER_ID")
	private Long managerId;*/
	
	@OneToOne(targetEntity = EmployeeEntity.class, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
	private EmployeeEntity manager;
	
	//Suponiendo que hay una relación muchos a muchos entre EMPLOYEES y DEPARTMENTS
	//Suponiendo que a nivel de MR esa relacion se parte en la tabla EMP_DEPT
	//EMP_DEPT --> EMPLOYEE_ID, DEPTO_ID	
	//@ManyToMany(fetch = FetchType.EAGER, targetEntity = EmployeeEntity.class, mappedBy = "deptos")
	//private List<EmployeeEntity> employees;

}
