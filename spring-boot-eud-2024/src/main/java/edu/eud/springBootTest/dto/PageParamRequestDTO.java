package edu.eud.springBootTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageParamRequestDTO {

	int size;
	int pageSize;
	
}
