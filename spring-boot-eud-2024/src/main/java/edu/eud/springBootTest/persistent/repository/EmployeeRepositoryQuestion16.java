package edu.eud.springBootTest.persistent.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


import edu.eud.springBootTest.persistent.entity.EmployeeEntity;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity2;


@Repository
public interface EmployeeRepositoryQuestion16 extends CrudRepository<EmployeeEntity2, Long> {
	
	
	//List<EmployeeEntity2> findAll(Pageable pageable);
	
	

}
