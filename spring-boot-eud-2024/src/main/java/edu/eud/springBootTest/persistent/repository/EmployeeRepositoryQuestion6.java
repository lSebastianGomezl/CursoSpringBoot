package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


public interface EmployeeRepositoryQuestion6 extends CrudRepository<EmployeeEntity, Long> {
    
    @Query(value = 
    		"SELECT new EmployeeEntity(e.id, e.firstName, e.lastName, e.salary, e.commissionPct) "
    		+ "FROM EmployeeEntity e "
    		+ "WHERE e.jobId in(SELECT j.jobId FROM JobEntity j WHERE LOWER(j.jobTitle) = LOWER(:jobName)) "
    		+ "AND e.commissionPct > :porcent "
    		+ "ORDER BY e.firstName DESC, e.lastName DESC",
    				nativeQuery = false)
    List<EmployeeEntity> findByJobPorcent(@Param("jobName") String jobName, @Param("porcent") Double porcent);
}
