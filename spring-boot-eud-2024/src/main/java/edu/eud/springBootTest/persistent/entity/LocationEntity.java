package edu.eud.springBootTest.persistent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "LOCATIONS")
@Data
public class LocationEntity {
	
	@Id
	@Column(name = "LOCATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LocationEntityGenerator")
	@SequenceGenerator(sequenceName = "LOCATIONS_SEQ", name = "LocationEntityGenerator", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@Column(name = "STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column()
	private String city;
	
	@Column(name = "STATE_PROVINCE")
	private String stateProvince;
	
	@Column(name = "COUNTRY_ID")
	private String countryId;

}
