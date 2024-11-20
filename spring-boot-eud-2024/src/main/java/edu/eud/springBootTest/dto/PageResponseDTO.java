package edu.eud.springBootTest.dto;

import java.util.List;

import lombok.Data;

@Data
public class PageResponseDTO<T> {
	
	int totalPages;
	int currentPage;
	long totalRows;
	int currentRows;
	List<T> data;
 
}
