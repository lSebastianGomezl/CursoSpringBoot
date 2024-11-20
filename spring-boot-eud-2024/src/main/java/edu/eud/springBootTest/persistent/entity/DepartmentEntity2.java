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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEPARTMENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DepartmentEntityGnerator")
	@SequenceGenerator(sequenceName = "DEPARTMENTS_SEQ", name = "DepartmentEntityGnerator", allocationSize = 1, initialValue = 1)
	@Column(name = "DEPARTMENT_ID")
	private Long id;
	@Column(name = "DEPARTMENT_NAME")
	private String name;
	@Column(name = "MANAGER_ID")
	private Long managerId;
	
	@OneToOne(targetEntity = LocationEntity2.class, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
	private LocationEntity2 location;

}
