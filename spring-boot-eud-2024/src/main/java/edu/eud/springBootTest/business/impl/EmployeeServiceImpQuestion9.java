package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;



import edu.eud.springBootTest.business.EmployeeServiceQuestion4;
import edu.eud.springBootTest.business.EmployeeServiceQuestion5;
import edu.eud.springBootTest.business.EmployeeServiceQuestion6;
import edu.eud.springBootTest.business.EmployeeServiceQuestion7;
import edu.eud.springBootTest.business.EmployeeServiceQuestion9;
import edu.eud.springBootTest.dto.EmployeeDTO1;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.EmployeeDTO3;

import edu.eud.springBootTest.persistent.entity.EmployeeEntity;

import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion4;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion5;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion6;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion7;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion9;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion9 implements EmployeeServiceQuestion9 {
	
	
	private final EmployeeRepositoryQuestion9 repository;

	@Override
	public List<EmployeeDTO1> findByEmployeesMoreOneJob() {
		
		List<Object[]> result = this.repository.findByEmployeesMoreOneJob();
		return result.stream().map(e -> EmployeeDTO1.builder()
				.firstName((String) e[0])
				.lastName((String) e[1])
				.hireDate((Date) e[2])
				.jobTitle((String) e[3])
				.departmentName((String) e[4])
				.correoElectronico((String) e[5])
				.build())
				.toList();
				
	}

	




}
