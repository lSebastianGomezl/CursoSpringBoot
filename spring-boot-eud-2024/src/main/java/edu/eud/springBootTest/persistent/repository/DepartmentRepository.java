package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.persistent.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{
	
	List<DepartmentEntity> findByManagerFirstName(String firstName);
	List<DepartmentEntity> findByManagerFirstNameAndManagerLastNameOrderByNameAsc(String firstName, String lastName);
	List<DepartmentEntity> findByManagerSalaryGreaterThanAndNameContainingOrderByManagerFirstNameDesc(Double salary, String word);
	
	/*@Query(value = ""
			+ "SELECT d "
			+ "FROM DepartmentEntity d "
			+ "INNER JOIN EmployeeEntity e "
			+ "ON e.id = d.manager.id "
			+ "WHERE e.departmentId = d.id "
			+ "ORDER BY d.name ASC ",
			nativeQuery = false)*/
	@Query(value = ""
			+ "SELECT d "
			+ "FROM DepartmentEntity d "			
			+ "WHERE d.manager.departmentId = d.id "
			+ "ORDER BY d.name ASC ",
			nativeQuery = false)
	List<DepartmentEntity> consultarJefePertenezcaAlMismoDepto();
	
	@Query(value = ""
			+ "SELECT d.*, e.* "
			+ "FROM DEPARTMENTS d "
			+ "INNER JOIN EMPLOYEES e "
			+ "ON e.EMPLOYEE_ID = d.MANAGER_ID "			
			+ "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID "
			+ "ORDER BY d.DEPARTMENT_NAME ASC ",
			nativeQuery = true)
	List<Object[]> consultarJefePertenezcaAlMismoDepto2();

}
