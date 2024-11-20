package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion3 extends CrudRepository<EmployeeEntity, Long> {
	
	
	@Query(value = "SELECT e.EMPLOYEE_ID, e.FIRST_NAME as empleadoFirstName, e.LAST_NAME as empleadoLastName, e.PHONE_NUMBER, " +
            "m.FIRST_NAME as managerFirstName, d.DEPARTMENT_NAME as departmentName " +
            "FROM employees e " +
            "JOIN employees m ON e.manager_id = m.employee_id " +
            "LEFT JOIN departments d ON e.department_id = d.department_id " +
            "WHERE (m.FIRST_NAME = :firstName OR m.LAST_NAME = :lastName) " +
            "ORDER BY e.FIRST_NAME, e.LAST_NAME",
    nativeQuery = true)
	List<Object[]> findByManagerFirstNameOrLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
