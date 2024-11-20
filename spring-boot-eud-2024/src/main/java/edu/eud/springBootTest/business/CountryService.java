package edu.eud.springBootTest.business;

import org.springframework.stereotype.Service;

import edu.eud.springBootTest.dto.CountryDTO;

@Service
public interface CountryService {
	
	public CountryDTO getById(String id);

}
