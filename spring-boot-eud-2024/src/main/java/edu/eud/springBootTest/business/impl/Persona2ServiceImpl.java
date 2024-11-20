package edu.eud.springBootTest.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eud.springBootTest.business.PersonaService;
import edu.eud.springBootTest.persistent.ConexionBaseDatos;

//@Service
@Service("pepito")
public class Persona2ServiceImpl implements PersonaService {
	
	@Autowired
	private ConexionBaseDatos cdb;
	
	public void execute() {
		System.out.println("Ejecutando metodo execute de Persona2ServiceImpl");
		this.cdb.execute();
	}

}
