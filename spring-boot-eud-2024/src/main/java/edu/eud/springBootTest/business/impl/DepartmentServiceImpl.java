package edu.eud.springBootTest.business.impl;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapper;

import edu.eud.springBootTest.business.DepartmentService;
import edu.eud.springBootTest.dto.DepartmentDTO;
import edu.eud.springBootTest.persistent.entity.DepartmentEntity;
import edu.eud.springBootTest.persistent.repository.DepartmentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	@NonNull
	private final DepartmentRepository repository;
	
	@NonNull
	private final DozerBeanMapper mapper;

	@Override
	public DepartmentDTO getById(Long id) {
		Optional<DepartmentEntity> ent = this.repository.findById(id);
		
		if(ent.isPresent()) {
			return this.mapper.map(ent.get(), DepartmentDTO.class);
		}else {
			return null;
		}
	}
	
	@Override
	public void execute() {
		//this.repository.findByManagerFirstName("Adam").stream()
		//this.repository.findByManagerFirstNameAndManagerLastNameOrderByNameAsc("Adam", "Fripp").stream()
		//this.repository.findByManagerSalaryGreaterThanAndNameContainingOrderByManagerFirstNameDesc(2000.0, "s").stream()
		//this.repository.consultarJefePertenezcaAlMismoDepto().stream()
		this.repository.consultarJefePertenezcaAlMismoDepto2().stream()
			.forEach(System.out::println);
	}
	
}
