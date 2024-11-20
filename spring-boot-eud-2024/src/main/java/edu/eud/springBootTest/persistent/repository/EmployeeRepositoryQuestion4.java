package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion4 extends CrudRepository<EmployeeEntity, Long> {
    
    @Query(value = 
    		"SELECT new EmployeeEntity(e.id, e.firstName, e.lastName, e.email, e.hireDate, e.phoneNumber) "
    		+ "FROM EmployeeEntity e WHERE MONTH(e.hireDate) BETWEEN 1 AND 3 "
    		+ "AND YEAR(e.hireDate) = :year",
    				nativeQuery = false)
    List<EmployeeEntity> consultarEmpleadosIngresaronPorQ(@Param("year") int year);
}
