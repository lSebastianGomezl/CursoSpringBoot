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
import edu.eud.springBootTest.business.EmployeeServiceQuestion8;
import edu.eud.springBootTest.dto.EmployeeDTO1;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.EmployeeDTO3;

import edu.eud.springBootTest.persistent.entity.EmployeeEntity;

import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion4;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion5;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion6;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion7;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion8;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion8 implements EmployeeServiceQuestion8 {
	
	
	private final EmployeeRepositoryQuestion8 repository;

	@Override
	public List<EmployeeDTO3> findEmployeesOlder(int employeeId) {
		
		return this.repository.findEmployeesOlder(employeeId).stream()
				.map(e -> EmployeeDTO3.builder()
						.id(e.getId())
						.firstName(e.getFirstName())
						.lastName(e.getLastName())
						.email(e.getEmail())
						.hierDate(e.getHireDate())
						.phoneNumber(e.getPhoneNumber())
						.build())
				.toList();
				
				
	}

	




}
