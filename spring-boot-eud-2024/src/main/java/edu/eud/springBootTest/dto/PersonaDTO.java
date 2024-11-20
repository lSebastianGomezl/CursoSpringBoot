package edu.eud.springBootTest.dto;

import java.util.Date;

public class PersonaDTO {

	private String nombre;
	private Integer edad;
	private Date fechaNacimiento;
	
	public PersonaDTO() {
		this.nombre = null;
		this.edad = 0;
		this.fechaNacimiento = null;
	}

	public PersonaDTO(String nombre, Integer edad, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
