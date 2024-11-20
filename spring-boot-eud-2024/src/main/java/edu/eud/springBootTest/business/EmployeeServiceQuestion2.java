package edu.eud.springBootTest.business;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.EmployeeDTO2;

@Service
public interface EmployeeServiceQuestion2 {
	
	public List<EmployeeDTO2>consultarPorRangoSalarialOrdenadoPorNombreApellidoAsc(Double salary1, Double salary2);

}
