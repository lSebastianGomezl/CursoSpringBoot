package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion7 extends CrudRepository<EmployeeEntity, Long> {
    
    @Query(value = 
    		"SELECT e.first_name, E.last_name, e.hire_date, d.department_name, j.job_title, e.email "
    		+ "FROM employees e "
    		+ "INNER JOIN jobs j ON (j.job_id = e.job_id) "
    		+ "INNER JOIN departments d ON(d.manager_id = e.employee_id) "
    		+ "ORDER BY d.department_name ASC",
    				nativeQuery = true)
    List<Object[]> findByEmployeeIsManager();
}
