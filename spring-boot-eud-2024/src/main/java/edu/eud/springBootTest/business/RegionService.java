package edu.eud.springBootTest.business;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.RegionDTO;

@Service
public interface RegionService {

	public void execute();
	
	public List<RegionDTO> getAll();
	
	public RegionDTO getById(Long id);
	
	public void create(RegionDTO dto);
	
	public void update(RegionDTO dto);
	
	public void delete(Long id);
	
}
