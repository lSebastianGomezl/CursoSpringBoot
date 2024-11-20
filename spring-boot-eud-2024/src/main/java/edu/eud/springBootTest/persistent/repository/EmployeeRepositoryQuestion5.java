package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion5 extends CrudRepository<EmployeeEntity, Long> {
    
    @Query(value = 
    		"SELECT new EmployeeEntity(e.id, e.firstName, e.lastName, e.email, e.hireDate, e.phoneNumber) "
    		+ "FROM EmployeeEntity e "
    		+ "WHERE e.departmentId IN(SELECT d.id FROM DepartmentEntity d WHERE UPPER(d.name) = UPPER(:department)) "
    		+ "ORDER BY e.firstName ASC, e.lastName ASC",
    				nativeQuery = false)
    List<EmployeeEntity> findByDepartmentName(@Param("department") String department);
}
