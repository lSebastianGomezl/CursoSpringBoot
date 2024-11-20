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
import edu.eud.springBootTest.util.SQLConstants;


public interface EmployeeRepositoryQuestion12 extends CrudRepository<EmployeeEntity, Long> {
	
	
	@Query(name = SQLConstants.NAME_JOB_ENTITY_RESULTSET_MAPPING, nativeQuery = true)
	public List<JobEntity> findJobsBySalaryRange(@Param("salary") Double salary);
	

}
