package edu.eud.springBootTest.business;

import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.LocationDTO;

@Service
public interface LocationService {
	
	public Long create(LocationDTO dto);

}
