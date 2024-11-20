package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.eud.springBootTest.persistent.entity.EmployeeEntity;

public interface EmployeeRepository2 extends PagingAndSortingRepository<EmployeeEntity, Long>{
	
	Page<EmployeeEntity> findByDepartmentId(Long departmentId, Pageable pageable);
	
	List<EmployeeEntity> findByFirstNameContaining(String word, Pageable pageable);
	
	List<EmployeeEntity> findByDepartmentIdAndJobIdAndSalaryGreaterThan(Long departmentId, String jobId, Double salary, Pageable pageable);
	
	List<EmployeeEntity> findByJobId(String jobId, Sort sort);
	
	List<EmployeeEntity> findByDepartmentIdAndJobId(Long departmentId, String jobId, Pageable pageable);
	
	
}
