package edu.eud.springBootTest.business.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import edu.eud.springBootTest.business.LocationService;
import edu.eud.springBootTest.dto.LocationDTO;
import edu.eud.springBootTest.persistent.entity.CountryEntity;
import edu.eud.springBootTest.persistent.entity.LocationEntity;
import edu.eud.springBootTest.persistent.repository.CountryRepository;
import edu.eud.springBootTest.persistent.repository.LocationRepository;
import edu.eud.springBootTest.util.exception.DatoNoExisteException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

	@NonNull
	private LocationRepository repository;
	
	@NonNull
	private CountryRepository countryRepository;
	
		
	/*@Override
	public Long create(LocationDTO dto) {				
		LocationEntity entity = new LocationEntity();
		entity.setCity(dto.getCity());
		entity.setCountryId(dto.getCountryId());
		entity.setPostalCode(dto.getPostalCode());
		entity.setStateProvince(dto.getStateProvince());
		entity.setStreetAddress(dto.getStreetAddress());
		
		entity = this.repository.save(entity);
		
		return entity.getId();
	}*/
	
	@Override
	public Long create(LocationDTO dto) {				
		Iterable<CountryEntity> countries = this.countryRepository.findAll();
		
		String countryId = null;
		
		for(CountryEntity c : countries) {
			if(c.getName().equals(dto.getCountryName())) {
				countryId = c.getId();
				break;
			}
		}
		
		if(countryId != null) {
			LocationEntity entity = new LocationEntity();
			entity.setCity(dto.getCity());
			entity.setCountryId(countryId);
			entity.setPostalCode(dto.getPostalCode());
			entity.setStateProvince(dto.getStateProvince());
			entity.setStreetAddress(dto.getStreetAddress());
			
			entity = this.repository.save(entity);
			
			return entity.getId();
		}else {
			throw new DatoNoExisteException("Country con nombre " + dto.getCountryName() + " NO existe");
		}	
	}
	
	

}
