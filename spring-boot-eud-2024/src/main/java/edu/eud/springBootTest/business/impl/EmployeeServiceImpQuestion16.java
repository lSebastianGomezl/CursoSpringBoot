package edu.eud.springBootTest.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapper;

import edu.eud.springBootTest.business.EmployeeServiceQuestion10;
import edu.eud.springBootTest.business.EmployeeServiceQuestion12;
import edu.eud.springBootTest.business.EmployeeServiceQuestion13;
import edu.eud.springBootTest.business.EmployeeServiceQuestion16;
import edu.eud.springBootTest.business.EmployeeServiceQuestion2;
import edu.eud.springBootTest.dto.DepartmentEmployeeDTO;
import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.dto.EmployeeDTO16;
import edu.eud.springBootTest.dto.EmployeeDTO17;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.JobDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity2;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion10;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion12;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion13;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion16;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion16 implements EmployeeServiceQuestion16 {
	
	@NonNull
	private final DozerBeanMapper dbm;
	@NonNull
	private final EmployeeRepositoryQuestion16 repository;
	
	
	@Override
	public EmployeeDTO16 findById(Long id) {
		Optional<EmployeeEntity2> optionalEntity = this.repository.findById(id);

		if (optionalEntity.isPresent()) {
			EmployeeEntity2 entity = optionalEntity.get();
			return dbm.map(entity, EmployeeDTO16.class);
		}
		return null;
	}





}
