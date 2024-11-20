package edu.eud.springBootTest.business;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.dto.EmployeeDTO1;

@Service
public interface EmployeeServiceQuestion1 {
	
	public List<EmployeeDTO1>findByFirstNameLetterEqualsLastName(String firstName, String lastName);

}
