package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import edu.eud.springBootTest.business.EmployeeServiceQuestion2;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion2;
import lombok.RequiredArgsConstructor;


@Service
@Primary
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion2 implements EmployeeServiceQuestion2 {
	
	
	private final EmployeeRepositoryQuestion2 repository;

	@Override
	public List<EmployeeDTO2> consultarPorRangoSalarialOrdenadoPorNombreApellidoAsc(Double salary1, Double salary2) {

		List<EmployeeEntity>result = this.repository.consultarPorRangoSalarialOrdenadoPorNombreApellidoAsc(salary1, salary2);
		System.out.println(result.size());
		
		List<EmployeeDTO2> listEmployee = new ArrayList<EmployeeDTO2>();
		
		result.stream().forEach(
				e -> {
			EmployeeDTO2 dto = new EmployeeDTO2();
				dto.setId(e.getId());
				dto.setFirstName(e.getFirstName());
				dto.setLastName(e.getLastName());
				dto.setSalary(e.getSalary());
				dto.setCommissionPct(e.getCommissionPct());
				
				listEmployee.add(dto);
						
				});
		
			
		return listEmployee;
		
	}
	




}
