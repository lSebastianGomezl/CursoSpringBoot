package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import edu.eud.springBootTest.business.EmployeeServiceQuestion3;
import edu.eud.springBootTest.dto.EmployeeDTO4;

import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion3;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion3 implements EmployeeServiceQuestion3 {
	
	
	private final EmployeeRepositoryQuestion3 repository;

	@Override
	public List<EmployeeDTO4> findByManagerFirstNameOrLastName(String firstName, String lastName) {

		List<Object[]>result = this.repository.findByManagerFirstNameOrLastName(firstName, lastName);
		System.out.println(result.size());
		List<EmployeeDTO4> listEmployee = new ArrayList<EmployeeDTO4>();
		
		result.stream().forEach(e -> {
			EmployeeDTO4 dto = EmployeeDTO4.builder()
					
					.id((((Number) e[0]).longValue()))
					
					.firstName((String)e[1])
					.lastName((String)e[2])
					.nameManager((String)e[3])
					.departmentName((String)e[4])
					.phoneNumber((String)e[5])
					
					.build();
					
			
			listEmployee.add(dto);
			
			});
		
			
		return listEmployee;
		
	}
	




}
