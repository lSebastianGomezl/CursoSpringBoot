package edu.eud.springBootTest.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import edu.eud.springBootTest.business.PersonaService;
import edu.eud.springBootTest.dto.PersonaDTO;
import edu.eud.springBootTest.persistent.ConexionBaseDatos;

@Service
@Primary
public class Persona1ServiceImpl implements PersonaService {
	
	@Autowired
	private ConexionBaseDatos cdb;
	
	@Autowired
	@Qualifier("myGson")
	private Gson gson;
	
	public void execute() {
		System.out.println("Ejecutando metodo execute de Persona1ServiceImpl");
		this.cdb.execute();
	}
	
	public String getJson(PersonaDTO persona) {
		return this.gson.toJson(persona);
	}

}
