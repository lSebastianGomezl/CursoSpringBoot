package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion8 extends CrudRepository<EmployeeEntity, Long> {
    
    @Query(value = 
    		"SELECT new EmployeeEntity(e.id, e.firstName, e.lastName, e.email, e.hireDate, e.phoneNumber) "
    		+ "FROM EmployeeEntity e "
    		+ "WHERE e.managerId = :employeeId "
    		+ "AND (e.hireDate <> (SELECT m.hireDate FROM EmployeeEntity m WHERE m.id = e.managerId)) "
    		+ "ORDER BY e.firstName ASC, e.lastName ASC",
    				nativeQuery = false)
    List<EmployeeEntity> findEmployeesOlder(@Param("employeeId") int employeeId);
}
