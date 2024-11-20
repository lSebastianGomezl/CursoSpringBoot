package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion10 extends CrudRepository<EmployeeEntity, Long> {
	
	
	@Query(value = 
			"SELECT new EmployeeEntity(e.id, e.firstName, e.lastName, e.salary, e.commissionPct) "
			+ "FROM EmployeeEntity e "
			+ "WHERE ( "
			+ "SELECT COUNT(DISTINCT j.jobId) "
			+ "FROM JobHistoryEntity j "
			+ "WHERE j.employeeId = e.id "
			+ ") <= 1 "
			+ "ORDER BY e.firstName asc, e.lastName asc",
		   nativeQuery = false)
	List<EmployeeEntity> findEmployeesNoChangeJobs();
	

}
