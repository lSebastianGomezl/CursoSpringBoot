package edu.eud.springBootTest.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapper;

import edu.eud.springBootTest.business.EmployeeServiceQuestion10;
import edu.eud.springBootTest.business.EmployeeServiceQuestion12;
import edu.eud.springBootTest.business.EmployeeServiceQuestion2;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.JobDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion10;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion12;
import edu.eud.springBootTest.persistent.repository.EmployeeRepositoryQuestion2;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Service
@Primary
@RequiredArgsConstructor
public class EmployeeServiceImpQuestion12 implements EmployeeServiceQuestion12 {
	
	@NonNull
	private final DozerBeanMapper dbm;
	@NonNull
	private final EmployeeRepositoryQuestion12 repository;

	@Override
	public List<JobDTO> findJobsBySalaryRange(Double salary) {

		return this.repository.findJobsBySalaryRange(salary).stream()
				.map(job -> this.dbm.map(job, JobDTO.class)).toList();
	}
	




}
