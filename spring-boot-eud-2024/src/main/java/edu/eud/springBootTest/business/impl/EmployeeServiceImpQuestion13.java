package edu.eud.springBootTest.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapper;

import edu.eud.springBootTest.business.EmployeeServiceQuestion10;
import edu.eud.springBootTest.business.EmployeeServiceQuestion12;
import edu.eud.springBootTest.business.EmployeeServiceQuestion13;
import edu.eud.springBootTest.business.EmployeeServiceQuestion2;
import edu.eud.springBootTest.dto.DepartmentEmployeeDTO;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.JobDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion10;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion12;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion13;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Service
@Primary
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion13 implements EmployeeServiceQuestion13 {
	
	@NonNull
	private final DozerBeanMapper dbm;
	@NonNull
	private final EmployeeRepositoryQuestion13 repository;

	@Override
	public List<DepartmentEmployeeDTO> findDepartmentsQtyEmployees(int qty) {
		List<Object[]> result = this.repository.findDepartmentsQtyEmployees(qty);
		
		return result.stream()
				.map(d -> DepartmentEmployeeDTO.builder()
						.departmentId((Integer) d[0])
						.departmentName((String) d[1])
						.bossName((String) d[2])
						.qtyEmployees((BigDecimal) d[3]).build()).toList();

	}
	




}
