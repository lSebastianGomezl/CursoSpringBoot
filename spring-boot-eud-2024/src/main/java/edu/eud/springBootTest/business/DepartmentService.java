package edu.eud.springBootTest.business;

import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.DepartmentDTO;

@Service
public interface DepartmentService {

	public DepartmentDTO getById(Long id);
	
	public void execute();
	
}
