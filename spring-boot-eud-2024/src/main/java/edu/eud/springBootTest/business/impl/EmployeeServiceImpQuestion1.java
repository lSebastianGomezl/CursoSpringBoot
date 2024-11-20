package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import edu.eud.springBootTest.business.EmployeeServiceQuestion1;
import edu.eud.springBootTest.dto.EmployeeDTO1;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion1;
import lombok.RequiredArgsConstructor;


@Service
@Primary
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion1 implements EmployeeServiceQuestion1 {
	
	
	private final EmployeeRepositoryQuestion1 repository;

	@Override
	public List<EmployeeDTO1> findByFirstNameLetterEqualsLastName(String firstName, String lastName) {

		List<Object[]>result = this.repository.findByFirstNameLetterEqualsLastNameLetter(firstName, lastName);
		System.out.println(result.size());
		List<EmployeeDTO1> listEmployee = new ArrayList<EmployeeDTO1>();
		
		result.stream().forEach(e -> {
			EmployeeDTO1 dto = EmployeeDTO1.builder()
					.firstName((String)e[0])
					.lastName((String)e[1])
					.hireDate((Date)e[2])
					.departmentName((String)e[3])
					.jobTitle((String)e[4])
					.correoElectronico((String)e[5])
					.build();
			
			listEmployee.add(dto);
			
			});
		
			
		return listEmployee;
		
	}
	




}
