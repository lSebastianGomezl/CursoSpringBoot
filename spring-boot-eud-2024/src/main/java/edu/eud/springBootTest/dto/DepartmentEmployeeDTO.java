package edu.eud.springBootTest.dto;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DepartmentEmployeeDTO {
	private Integer departmentId;
	private String departmentName;
	private String bossName;
	private BigDecimal qtyEmployees;
}
