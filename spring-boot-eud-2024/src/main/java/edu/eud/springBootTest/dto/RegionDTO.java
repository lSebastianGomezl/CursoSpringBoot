package edu.eud.springBootTest.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionDTO {

	//@NotNull(message = "ID es nulo")
	private Long id;
	
	@NotBlank(message = "name es nulo o vacio")
	@Size(max = 25, message = "name permite máximo 25 caracteres")
	private String name;
	
	private List<CountryDTO> countries;
	
}
