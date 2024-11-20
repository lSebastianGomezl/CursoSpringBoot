package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;



import edu.eud.springBootTest.business.EmployeeServiceQuestion4;
import edu.eud.springBootTest.business.EmployeeServiceQuestion5;
import edu.eud.springBootTest.dto.EmployeeDTO3;

import edu.eud.springBootTest.persistent.entity.EmployeeEntity;

import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion4;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion5;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion5 implements EmployeeServiceQuestion5 {
	
	
	private final EmployeeRepositoryQuestion5 repository;

	@Override
	public List<EmployeeDTO3>findByDepartmentName(String department) {
		
		return this.repository.findByDepartmentName(department).stream()
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
