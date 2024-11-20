package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;



import edu.eud.springBootTest.business.EmployeeServiceQuestion4;

import edu.eud.springBootTest.dto.EmployeeDTO3;

import edu.eud.springBootTest.persistent.entity.EmployeeEntity;

import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion4;
import lombok.RequiredArgsConstructor;


@Service
@Primary
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion4 implements EmployeeServiceQuestion4 {
	
	
	private final EmployeeRepositoryQuestion4 repository;

	@Override
	public List<EmployeeDTO3>consultarEmpleadosIngresaronPorQ(int year) {
		
		return this.repository.consultarEmpleadosIngresaronPorQ(year).stream()
				.map(e -> EmployeeDTO3.builder()
						.id(e.getId())
						.firstName(e.getFirstName())
						.lastName(e.getLastName())
						.email(e.getEmail())
						.hierDate(e.getHireDate())
						.build())
				.toList();
		
	}
	




}
