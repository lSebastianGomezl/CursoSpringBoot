package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;



import edu.eud.springBootTest.business.EmployeeServiceQuestion4;
import edu.eud.springBootTest.business.EmployeeServiceQuestion5;
import edu.eud.springBootTest.business.EmployeeServiceQuestion6;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.EmployeeDTO3;

import edu.eud.springBootTest.persistent.entity.EmployeeEntity;

import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion4;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion5;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion6;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion6 implements EmployeeServiceQuestion6 {
	
	
	private final EmployeeRepositoryQuestion6 repository;

	@Override
	public List<EmployeeDTO2> findByJobPorcent(String jobName, Double porcent) {
		
		return this.repository.findByJobPorcent(jobName,porcent).stream()
				.map(e -> EmployeeDTO2.builder().id(e.getId()).firstName(e.getFirstName()).lastName(e.getLastName())
						.salary(e.getSalary()).commissionPct(e.getCommissionPct()).build())
				.toList();
		
	}
	




}
