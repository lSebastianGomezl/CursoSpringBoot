package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion11 extends CrudRepository<EmployeeEntity, Long> {
    
    @Query(value = 
    		"SELECT E.FIRST_NAME, E.LAST_NAME, E.HIRE_DATE, D.DEPARTMENT_NAME, J.JOB_TITLE, E.EMAIL "
    		+ "FROM EMPLOYEES E "
    		+ "INNER JOIN JOBS J ON (J.JOB_ID = E.JOB_ID) "
    		+ "LEFT JOIN departments D ON(D.DEPARTMENT_ID = E.DEPARTMENT_ID) "
    		+ "WHERE E.JOB_ID IN((SELECT JH.JOB_ID FROM JOB_HISTORY JH WHERE EMPLOYEE_ID = :employeeId)) "
    		+ "ORDER BY E.HIRE_DATE ASC",
    				nativeQuery = true)
    List<Object[]> findByHistoryEmployeeJobs(@Param("employeeId") int employeeId);
}
