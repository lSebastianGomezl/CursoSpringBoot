package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion1 extends CrudRepository<EmployeeEntity, Long> {
	
	
	@Query(
			value = "" + "SELECT E.FIRST_NAME, E.LAST_NAME, E.HIRE_DATE, D.DEPARTMENT_NAME, J.JOB_TITLE, E.EMAIL "
			+ "FROM EMPLOYEES E " + "INNER JOIN JOBS J " + "ON (J.JOB_ID = E.JOB_ID) " + "LEFT JOIN departments D "
			+ "ON(D.DEPARTMENT_ID = E.DEPARTMENT_ID) "
			+ "WHERE (LOWER(E.FIRST_NAME) LIKE :firstName% AND LOWER(E.FIRST_NAME) LIKE %:firstName) " 
            + "OR (LOWER(E.LAST_NAME) LIKE :lastName% AND LOWER(E.LAST_NAME) LIKE %:lastName)",
			nativeQuery = true)
	
	List<Object[]> findByFirstNameLetterEqualsLastNameLetter(@Param("firstName") String firstName,@Param("lastName") String lastName);

}
