package edu.eud.springBootTest.dto;

import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee2DTO {

	public Long id;
	
	@NotBlank(message = "lastName is null or empty")
	public String firstName;
	
	//@NotEmpty //(NotNull y "")
	//@NotBlank //(NotNull, "", "   ")
	@NotBlank(message = "lastName is null or empty")
	public String lastName;
	
	@Past(message = "birthDate is in the future")
	//@PastOrPresent
	//@Future
	//@FutureOrPresent
	public Date birthDate;
	
	@NotNull(message = "age is null")
	@Min(value = 18, message = "La edad debe ser mayor a X")
	@Max(value = 100, message = "La edad debe ser menor a X")
	public Integer age;
	
	@NotNull
	@Size(min = 3, max = 50, message = "El cargo debe estar entre 3 y 50 caracteres")
	public String job;
	
	@Positive
	@PositiveOrZero
	@Negative
	@NegativeOrZero
	public Integer number;
	
	//carlos.chaparro@gmail
	@Email
	@Email(regexp = "[a-zA-Z0-9._-]@(1-50[a-Z].[1-3])")
	public String email;
	
	@AssertTrue
	@AssertFalse
	public boolean isValid;
	
	@NotBlank
	@Pattern(regexp = "ISBN[0-50]{a-A}-[1-5]{0-9}")
	public String patron;
	
	@Valid
	private PersonaDTO persona;
	
	@NotEmpty
	//@Size(min = 3)
	//@Valid -> NO VALIDA
	private List<@Valid PersonaDTO> personas;
	
}
