package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion2 extends CrudRepository<EmployeeEntity, Long> {
	
	
	@Query(value = 
			"SELECT new EmployeeEntity(e.id, e.firstName, e.lastName, e.salary, e.commissionPct) "
		  + "FROM EmployeeEntity e "
		  + "WHERE e.salary BETWEEN :salary1 AND :salary2 "
		  + "ORDER BY e.firstName ASC, e.lastName ASC",
		   nativeQuery = false)
	List<EmployeeEntity> consultarPorRangoSalarialOrdenadoPorNombreApellidoAsc(@Param("salary1") Double salaryStart, @Param("salary2") Double salaryEnd);
	

}
