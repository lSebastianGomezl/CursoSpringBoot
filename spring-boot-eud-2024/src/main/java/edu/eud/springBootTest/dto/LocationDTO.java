package edu.eud.springBootTest.dto;

import lombok.Data;

@Data
public class LocationDTO {
	
	private Long id;
	private String streetAddress;
	private String postalCode;	
	private String city;
	private String stateProvince;
	//private String countryId;
	private String countryName;

}
