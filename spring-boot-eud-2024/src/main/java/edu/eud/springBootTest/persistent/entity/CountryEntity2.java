package edu.eud.springBootTest.persistent.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "COUNTRIES")
@Data
public class CountryEntity2 {

	@Id
	@Column(name = "COUNTRY_ID")
	private String id;
	@Column(name = "COUNTRY_NAME")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = RegionEntity2.class, optional = false)
	@JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
	private RegionEntity2 region;
	
	@OneToMany(targetEntity = LocationEntity2.class, fetch = FetchType.EAGER, mappedBy = "country")
	@JsonIgnore
	private List<LocationEntity2> locations;
}
