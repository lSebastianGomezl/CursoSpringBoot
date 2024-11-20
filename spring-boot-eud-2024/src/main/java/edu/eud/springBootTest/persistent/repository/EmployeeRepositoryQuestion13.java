package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;
import edu.eud.springBootTest.persistent.entity.JobEntity;


public interface EmployeeRepositoryQuestion13 extends CrudRepository<EmployeeEntity, Long> {
	
	
	@Query(value = 
					"SELECT d.department_id,"
					+ "d.department_name,"
					+ "m.first_name || ' ' || m.last_name AS manager_name,"
					+ "       COUNT(e.employee_id) AS employee_count "
					+ "			FROM departments d "
					+ "			JOIN employees m ON d.manager_id = m.employee_id "
					+ "			LEFT JOIN employees e ON d.department_id = e.department_id "
					+ "			GROUP BY d.department_id, d.department_name, m.first_name, m.last_name "
					+ "			HAVING COUNT(e.employee_id) > :qty "
					+ "			ORDER BY employee_count ASC ",
		   nativeQuery = true)
	List<Object[]> findDepartmentsQtyEmployees(@Param("qty") int qty);
	

}
