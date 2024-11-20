package edu.eud.springBootTest.persistent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "LOCATIONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationEntity2 {
	
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

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CountryEntity2.class, optional = false)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
	private CountryEntity2 country;

}
