package edu.eud.springBootTest.business;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.EmployeeDTO3;


@Service
public interface EmployeeServiceQuestion4 {
	
	public List<EmployeeDTO3>consultarEmpleadosIngresaronPorQ(int year);

}
