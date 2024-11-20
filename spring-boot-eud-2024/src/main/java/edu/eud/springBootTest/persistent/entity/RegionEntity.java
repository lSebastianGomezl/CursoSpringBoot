package edu.eud.springBootTest.persistent.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "regions")
@Data
public class RegionEntity {
	
	@Id
	@Column(name = "region_id")
	//private Long regionId;
	private Long id;
	
	@Column(name = "region_name")
	//private String regionName;
	private String name;
	
	@OneToMany(targetEntity = CountryEntity.class, fetch = FetchType.EAGER, mappedBy = "region")
	private List<CountryEntity> countries;

}
