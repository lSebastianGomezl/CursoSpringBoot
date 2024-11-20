package edu.eud.springBootTest.business;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.EmployeeDTO2;
import edu.eud.springBootTest.dto.EmployeeDTO4;

@Service
public interface EmployeeServiceQuestion3 {
	
	public List<EmployeeDTO4> findByManagerFirstNameOrLastName(String firstName,String lastName);

}
