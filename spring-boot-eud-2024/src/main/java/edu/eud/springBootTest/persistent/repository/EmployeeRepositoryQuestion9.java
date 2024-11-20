package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion9 extends CrudRepository<EmployeeEntity, Long> {
    
    @Query(value = 
    		"SELECT e.first_name, E.last_name, e.hire_date, j.job_title, d.department_name, e.email "
    		+ "FROM employees e "
    		+ "INNER JOIN jobs j ON(j.job_id = e.job_id) "
    		+ "LEFT JOIN departments d ON(d.department_id = e.department_id) "
    		+ "WHERE e.employee_id IN ("
    		+ "    SELECT employee_id "
    		+ "	   FROM job_history "
    		+ "	   GROUP BY employee_id "
    		+ "    HAVING COUNT(DISTINCT job_id) > 1 "
    		+ ")"
    		+ "ORDER BY e.hire_date ASC",
    				nativeQuery = true)
    List<Object[]> findByEmployeesMoreOneJob();
}
