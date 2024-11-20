package edu.eud.springBootTest.business.impl;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapper;

import edu.eud.springBootTest.business.RegionService;
import edu.eud.springBootTest.dto.RegionDTO;
import edu.eud.springBootTest.persistent.entity.RegionEntity;
import edu.eud.springBootTest.persistent.repository.Region2Repository;
import edu.eud.springBootTest.persistent.repository.RegionRepository;
import edu.eud.springBootTest.util.exception.DatoNoExisteException;
import edu.eud.springBootTest.util.exception.DatoYaExisteException;
import jakarta.annotation.Nonnull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

	@NonNull
	private final RegionRepository repository;
	
	@NonNull
	private final Region2Repository repository2;
	
	@Nonnull
	private final DozerBeanMapper mapper;
	
	@Override
	public void execute() {
		/*this.repository.findAll().forEach(region -> {
			System.out.println("Region " + region.getId() + " - " + region.getName());
		});*/
		
		//System.out.println("Tabla REGION tiene " + this.repository.count() + " registros");
		
		/*Optional<RegionEntity> region = this.repository.findById(50L);
		
		if(region.isPresent()) {
			System.out.println("ID: " + region.get().getId());
			System.out.println("Name: " + region.get().getName());
		}else {
			System.out.println("No existe la región");
		}*/
		
		/*boolean existe = this.repository.existsById(2L);
		System.out.println("Region existe: " + existe);*/
		
		//RegionEntity e = this.create();
		
		//this.repository.save(e);		
		//e = this.repository.save(e);
		//this.repository2.saveAndFlush(e);
		
		//this.repository.delete(e);
		//this.repository.deleteById(7L);
		//this.repository.borrarPorId(7L);
		//this.repository.borrarPorIdSql(7L);
		
		/*RegionEntity r = new RegionEntity();
		r.setId(7L);
		r.setName("Oceania5");
		
		this.repository.save(r);*/
		//this.repository.actualizarPorId(7L, "Oceania10");
		this.repository.actualizarPorIdSql(7L, "Oceania20");
	}
	
	public RegionEntity create() {
		RegionEntity entity = new RegionEntity();
		entity.setId(10L);
		//entity.setName("123456789012345678901234567890");
		entity.setName("Oceania");
		return entity;	
	}

	/*@Override
	public List<RegionDTO> getAll() {
		List<RegionDTO> regionsResponse = new ArrayList<RegionDTO>();
		
		Iterable<RegionEntity> regions = this.repository.findAll();
		
		for(RegionEntity r : regions) {
			RegionDTO dto = new RegionDTO();
			dto.setId(r.getId());
			dto.setName(r.getName());
			
			regionsResponse.add(dto);
		}
		
		return regionsResponse;
	}*/
	
	/*@Override
	public List<RegionDTO> getAll() {
		List<RegionDTO> regionsResponse = new ArrayList<RegionDTO>();
		
		this.repository.findAll().forEach(r -> {
			RegionDTO dto = new RegionDTO();
			dto.setId(r.getId());
			dto.setName(r.getName());
			
			regionsResponse.add(dto);
		});
		
		return regionsResponse;
	}*/
	
	@Override
	public List<RegionDTO> getAll() {		
		return StreamSupport.stream(this.repository.findAll().spliterator(), false)
			.map(r -> this.mapper.map(r, RegionDTO.class))
			.toList();		
	}

	/*@Override
	public RegionDTO getById(Long id) {
		Optional<RegionEntity> region = this.repository.findById(id);
		
		if(region.isPresent()) {
			return new RegionDTO(region.get().getId(), region.get().getName());
		}else {
			return null;
		}
	}*/
	
	@Override
	public RegionDTO getById(Long id) {
		return this.repository.findById(id)
				//.map(r -> new RegionDTO(r.getId(), r.getName()))
				.map(r -> this.mapper.map(r, RegionDTO.class))
				.orElse(null);				
	}

	@Override
	public void create(RegionDTO dto) {
		if(!this.repository.existsById(dto.getId())) {
			RegionEntity entity = new RegionEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			
			this.repository.save(entity);
		}else {
			throw new DatoYaExisteException("El ID " + dto.getId() + " ya existe en DB");			
		}
	}

	@Override
	public void update(RegionDTO dto) {
		if(this.repository.existsById(dto.getId())) {
			RegionEntity entity = new RegionEntity();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			
			this.repository.save(entity);
		}else {
			throw new DatoNoExisteException("El ID " + dto.getId() + " NO existe en DB");
		}
	}

	@Override
	public void delete(Long id) {
		if(this.repository.existsById(id)) {						
			this.repository.deleteById(id);
		}else {
			throw new DatoNoExisteException("El ID " + id + " NO existe en DB");
		}
	}
}
