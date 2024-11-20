package edu.eud.springBootTest.business;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.DepartmentEmployeeDTO;
import edu.eud.springBootTest.dto.EmployeeDTO1;
import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.EmployeeDTO3;
import edu.eud.springBootTest.dto.JobDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;


@Service
public interface EmployeeServiceQuestion13 {
	
	public List<DepartmentEmployeeDTO> findDepartmentsQtyEmployees(int qty);

}
