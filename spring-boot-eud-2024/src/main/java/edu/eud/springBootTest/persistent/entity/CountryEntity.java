package edu.eud.springBootTest.persistent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "COUNTRIES")
@Data
public class CountryEntity {

	@Id
	@Column(name = "COUNTRY_ID")
	private String id;
	@Column(name = "COUNTRY_NAME")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = RegionEntity.class, optional = false)
	@JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
	private RegionEntity region;
	
}
