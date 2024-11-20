package edu.eud.springBootTest.business.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapper;

import edu.eud.springBootTest.business.EmployeeService;
import edu.eud.springBootTest.dto.EmployeeDTO;
import edu.eud.springBootTest.dto.PageParamRequestDTO;
import edu.eud.springBootTest.dto.PageResponseDTO;
import edu.eud.springBootTest.persistent.entity.EmployeeEntity;
import edu.eud.springBootTest.persistent.repository.EmployeeRepository;
import edu.eud.springBootTest.persistent.repository.EmployeeRepository2;
import edu.eud.springBootTest.persistent.repository.EmployeeRepository3;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository repository;
	
	private final EmployeeRepository2 repository2;
	
	private final EmployeeRepository3 repository3;
	
	private final DozerBeanMapper dbm;

	@Override
	public void execute() {
		//Pageable pageable = PageRequest.of(0, 20);
		Pageable pageable = PageRequest.of(0, 20, Sort.by(Order.asc("lastName")));
		
		Page<EmployeeEntity> page = this.repository2.findAll(pageable);
		
		System.out.println("Total elementos " + page.getTotalElements());
		System.out.println("Size " + page.getSize());
		System.out.println("Número total de paginas " + page.getTotalPages());
		
		page.get().forEach(e -> {
			System.out.println(e.getFirstName() + " " + e.getLastName());
		});
		
		
		
		//Iterable<EmployeeEntity> list = this.repository.findAll(Sort.by(Order.asc("firstName")));
		//Iterable<EmployeeEntity> list = this.repository.findAll(Sort.by(Order.asc("firstName"), Order.desc("lastName")));
		//Iterable<EmployeeEntity> list = this.repository.findAll(Sort.by("firstName asc", "lastName desc"));
		//Iterable<EmployeeEntity> list = this.repository.findAll(Sort.by(Direction.ASC, "firstName"));
		
		/*for(EmployeeEntity e : list) {
			System.out.println(e.getFirstName() + " " + e.getLastName());
		}*/
	}

	@Override
	public void executeQuery() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//this.repository.getByDepartmentId(20L).stream()
		//this.repository.findByJobId("ST_MAN").stream()
		//this.repository.findBySalaryGreaterThan(8000.0).stream()
		//this.repository.findBySalaryLessThan(8000.0).stream()
		//this.repository.findByJobIdNot("ST_MAN").stream()
		//this.repository.findByFirstNameContaining("ee").stream()
		//this.repository.findByFirstNameNotContaining("ee").stream()
		//this.repository.findByDepartmentIdIn(Arrays.asList(10L, 20L)).stream()
		//this.repository.findByDepartmentIdNotIn(Arrays.asList(10L, 20L)).stream()
		//this.repository.findBySalaryBetween(6000.0, 8000.0).stream()
		//this.repository.findByCommissionPctIsNotNull().stream()
		//this.repository.findByCommissionPctIsNull().stream()
		//this.repository.findByFirstNameStartingWith("E").stream()
		//this.repository.findByFirstNameEndingWith("s").stream()
		//this.repository.findByDepartmentIdAndJobId(10L, "AD_ASST").stream()
		//this.repository.findByDepartmentIdOrJobId(20L, "AD_ASST").stream()
		//this.repository.findByDepartmentIdAndJobIdAndSalaryGreaterThan(10L, "AD_ASST", 10000.0).stream()
		//this.repository.findByFirstNameLike("A_a%").stream()
		//this.repository.findByOrderByFirstNameAscLastNameDesc().stream()
		//this.repository.findByDepartmentIdOrderByFirstNameAsc(50L).stream()
		/*this.repository.findByDepartmentIdAndJobIdNotOrderByFirstNameAscLastNameAscSalaryDesc(50L, "SH_CLERK").stream()
			.forEach(e -> {
				System.out.println(e);
			});*/
		
		//System.out.println("Existe: " + this.repository.existsByDepartmentId(500L));
		//System.out.println("Conteo: " + this.repository.countBySalaryGreaterThan(10000.0));	
		
//		try {
//			//this.repository.findByHireDateLessThanEqual(sdf.parse("31/12/2007")).stream()
//			//this.repository.findByHireDateGreaterThan(sdf.parse("31/12/2007")).stream()
//			//this.repository.findByHireDateBetween(sdf.parse("01/01/2007"), sdf.parse("31/12/2007")).stream()
//			//this.repository.findByHireDateAfterOrSalaryLessThanAndCommissionPctIsNotNull(sdf.parse("01/01/2007"), 12000.0).stream()
//			this.repository.findByFirstNameStartingWithAndLastNameEndingWithAndHireDateBetween("A", "s", sdf.parse("01/01/2007"), sdf.parse("01/01/2008"))
//				.forEach(e -> {
//					System.out.println(e);
//				});
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//Pageable pageable = PageRequest.of(0, 10);
		//Pageable pageable = PageRequest.of(0, 20, Sort.by(Order.asc("salary")));
		
		/*this.repository2.findByDepartmentId(50L, pageable).stream()
		.forEach(e -> System.out.println(e));*/
		
		//this.repository2.findByFirstNameContaining("e", pageable).stream()
		//this.repository2.findByDepartmentIdAndJobIdAndSalaryGreaterThan(50L, "SH_CLERK", 2000.0, pageable).stream()
		
		//this.repository2.findByJobId("SH_CLERK", Sort.unsorted()).stream()
		//this.repository2.findByJobId("SH_CLERK", Sort.by(Order.asc("firstName"))).stream()
		//this.repository2.findByJobId("SH_CLERK", Sort.by(Order.asc("firstName"), Order.desc("lastName"))).stream()
		
		/*this.repository2.findByDepartmentIdAndJobId(50L, "SH_CLERK", pageable).stream()
		.forEach(System.out::println);*/
		
		//this.repository.deleteByDepartmentId(500L);
		//this.repository.removeByDepartmentIdAndJobId(500L, "SH_CLERK");
		
		//this.repository3.consultarPorDepartamento(50L).stream()
		//this.repository3.consultarPorDepartamentoYCargo(50L, "SH_CLERK").stream()
		//this.repository3.consultarPorSalarioONoTieneComision(5000.0).stream()
		//this.repository3.consultarPorRangoSalarial(2000.0, 5000.0).stream()
		//this.repository3.consultarNombreApellidoDelJefe("steven", "King").stream()
		//this.repository3.consultarPorNumerodeLetrasEnNonmbre(3).stream()
			//.forEach(System.out::println);
		/*this.repository3.consultarPorRangoSalarialSql(2000.0, 5000.0).stream()
			.forEach(e -> {
				System.out.println("ID: " + e[0]);
				System.out.println("Nombre: " + e[1]);
				System.out.println("Apellido: " + e[2]);
				System.out.println("Salario: " + e[3]);
			});*/
		
		/*this.repository3.consultarPorRangoSalarialSql(2000.0, 5000.0).stream()
			.map(e -> {
				EmployeeDTO dto = new EmployeeDTO();
				
				dto.setId(((Integer)e[0]).longValue());
				dto.setFirstName((String)e[1]);
				dto.setLastName((String)e[2]);
				dto.setSalary(((BigDecimal)e[3]).doubleValue());
				dto.setCommissionPct((e[4] != null ? ((BigDecimal)e[4]).floatValue() : null));
				
				return dto;
			}).toList()
			.forEach(System.out::println);*/
		
		/*
		this.repository3.consultarPorRangoSalarialSql2(2000.0, 5000.0).stream()
			.forEach(System.out::println);
		*/
		//System.out.println(this.repository3.contarPorDepartamento(50L));
		//System.out.println(this.repository3.existePorDepartamento(500L));
		
		//System.out.println(this.repository3.contarPorDepartamentoSql(50L));
		
		//this.repository.findTop5ByOrderByFirstNameAsc().stream()
		/*this.repository.findTop10ByDepartmentIdOrderByFirstNameAscLastNameAsc(50L).stream()
			.forEach(e -> {
				System.out.println(e);
			});*/
		
		/*Optional<EmployeeEntity> primerEmpleado = this.repository.findFirstByOrderByHireDateAsc();
		
		if(primerEmpleado.isPresent()) {
			System.out.println("Primer empleado: " + primerEmpleado.get());
		}else {
			System.out.println("No existe el empleado");
		}*/
	}
	
	@Override
	public List<EmployeeDTO> consultarPorDepartamentoCargoSalario(Long departmentId, String jobId, Double salary){
		return this.repository.findByDepartmentIdAndJobIdAndSalaryGreaterThan(departmentId, jobId, salary)
			.stream()
			.map(e -> this.fromEmployeeEntityToEmployeeDTO(e))
			.toList();	
	}
	
	@Override
	//public List<EmployeeDTO> consultarPorDepartamento(Long departmentId, int page, int pageSize){
	public PageResponseDTO<EmployeeDTO> consultarPorDepartamento(Long departmentId, PageParamRequestDTO page){
		PageResponseDTO<EmployeeDTO> response = new PageResponseDTO<EmployeeDTO>();
				
		Page<EmployeeEntity> entities = this.repository2.findByDepartmentId(departmentId, PageRequest.of(page.getSize(), page.getPageSize(), Sort.by(Order.asc("firstName"))));
			
		response.setCurrentPage(page.getSize());
		response.setCurrentRows(entities.getNumberOfElements());
		response.setTotalPages(entities.getTotalPages());
		response.setTotalRows(entities.getTotalElements());
		//Mapeando con un Mapper desarrollado por mi
		/*response.setData(entities.getContent()		  
				.stream()
				.map(e -> this.fromEmployeeEntityToEmployeeDTO(e))
				.toList());*/
		
		response.setData(entities.getContent()
				.stream()
				.map(e -> this.dbm.map(e, EmployeeDTO.class))
				.toList());
		
		return response;
	}
	
	private EmployeeDTO fromEmployeeEntityToEmployeeDTO(EmployeeEntity e) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setDepartmentId(e.getDepartmentId());
		dto.setSalary(e.getSalary());
		dto.setJobId(e.getJobId());
		dto.setFirstName(e.getFirstName());
		dto.setLastName(e.getLastName());
		
		return dto;
	}
	
	private EmployeeEntity fromEmployeeDTOToEmployeeEntity(EmployeeDTO e) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setFirstName(e.getFirstName());
		entity.setLastName(e.getLastName());
		
		return entity;
	}

}
