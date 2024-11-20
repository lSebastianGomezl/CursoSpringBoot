package edu.eud.springBootTest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDTO {

	private String id;	
	private String name;
	
	private RegionDTO region;
	
}
