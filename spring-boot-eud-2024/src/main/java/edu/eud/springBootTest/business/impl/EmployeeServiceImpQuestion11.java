package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import edu.eud.springBootTest.business.EmployeeServiceQuestion11;
import edu.eud.springBootTest.business.EmployeeServiceQuestion4;
import edu.eud.springBootTest.business.EmployeeServiceQuestion5;
import edu.eud.springBootTest.business.EmployeeServiceQuestion6;
import edu.eud.springBootTest.business.EmployeeServiceQuestion7;
import edu.eud.springBootTest.business.EmployeeServiceQuestion9;
import edu.eud.springBootTest.dto.EmployeeDTO1;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.EmployeeDTO3;


import edu.eud.springBootTest.persistent.entity.EmployeeEntity;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion11;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion4;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion5;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion6;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion7;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion9;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion11 implements EmployeeServiceQuestion11 {

	@NonNull
	private final EmployeeRepositoryQuestion11 repository;

	@Override
	public List<EmployeeDTO1> findByHistoryEmployeeJobs(int employeeId) {
		List<Object[]> result = this.repository.findByHistoryEmployeeJobs(employeeId);

		return result.stream()
				.map(e -> EmployeeDTO1.builder()
						.firstName((String) e[0])
						.lastName((String) e[1])
						.hireDate((Date) e[2])
						.departmentName((String) e[3])
						.jobTitle((String) e[4])
						.correoElectronico((String) e[5])
						.build())
				.toList();
	}


	




}
