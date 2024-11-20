package edu.eud.springBootTest.business;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.dto.PageParamRequestDTO;
import edu.eud.springBootTest.dto.PageResponseDTO;

@Service
public interface EmployeeService {
	
	public void execute();
	
	public void executeQuery();
	
	/**
	 * 
	 * @param departmentId
	 * @param jobId
	 * @param salary
	 * @return
	 */
	public List<EmployeeDTO> consultarPorDepartamentoCargoSalario(Long departmentId, String jobId, Double salary);
	
	//public List<EmployeeDTO> consultarPorDepartamento(Long departmentId, int page, int pageSize);
	public PageResponseDTO<EmployeeDTO> consultarPorDepartamento(Long departmentId, PageParamRequestDTO page);

}
