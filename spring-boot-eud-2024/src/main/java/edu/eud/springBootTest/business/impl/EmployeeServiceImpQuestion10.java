package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import edu.eud.springBootTest.business.EmployeeServiceQuestion10;
import edu.eud.springBootTest.business.EmployeeServiceQuestion2;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion10;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion2;
import lombok.RequiredArgsConstructor;


@Service
@Primary
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion10 implements EmployeeServiceQuestion10 {
	
	
	private final EmployeeRepositoryQuestion10 repository;

	@Override
	public List<EmployeeDTO2> findEmployeesNoChangeJobs() {
		
		return this.repository.findEmployeesNoChangeJobs().stream()
		.map(e -> EmployeeDTO2.builder().id(e.getId()).firstName(e.getFirstName()).lastName(e.getLastName())
				.salary(e.getSalary()).commissionPct(e.getCommissionPct()).build())
		.toList();

	}
	




}
