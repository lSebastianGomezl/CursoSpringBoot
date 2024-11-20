package edu.eud.springBootTest.business.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapper;

import edu.eud.springBootTest.business.CountryService;
import edu.eud.springBootTest.dto.CountryDTO;
import edu.eud.springBootTest.persistent.repository.CountryRepository;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

	@Nonnull
	private CountryRepository repository;
	
	@Nonnull
	private DozerBeanMapper mapper;
	
	@Override
	public CountryDTO getById(String id) {
		return this.repository.findById(id)
				.map(c -> this.mapper.map(c, CountryDTO.class))
				.orElse(null);
	}
}
