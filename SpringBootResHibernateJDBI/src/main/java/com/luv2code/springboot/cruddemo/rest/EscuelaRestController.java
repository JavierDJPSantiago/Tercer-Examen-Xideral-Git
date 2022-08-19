package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Escuela;

import com.luv2code.springboot.cruddemo.service.EscuelaService;

@RestController
@RequestMapping("/api")
public class EscuelaRestController {

	private EscuelaService escuelaService;
	
	@Autowired
	public EscuelaRestController(EscuelaService theescuelaService) {
		escuelaService = theescuelaService;
	}
	
	// expone "/escuela" y regresa una lista de escuelas
	@GetMapping("/escuelas")
	public List<Escuela> findAll() {
		return escuelaService.findAll();
	}

	// añadir mapeo para GET /escuela/{escuelaId}
	
	@GetMapping("/escuelas/{escuelaId}")
	public Escuela getEscuela(@PathVariable int escuelaId) {
		
		Escuela theEscuela = escuelaService.findById(escuelaId);
		
		if (theEscuela == null) {
			throw new RuntimeException("Id de la Escuela no encontrado - " + escuelaId);
		}
		
		return theEscuela;
	}
	
	// añadir mapeo para POST /escuelas - añadir nueva escuela
	
	@PostMapping("/escuelas")
	public Escuela addEscuela(@RequestBody Escuela theEscuela) {
		
		//también en caso de que pasen una identificación en JSON ... establezca la identificación en 0
		// esto es para forzar un guardado del nuevo elemento... en lugar de actualizar
		
		theEscuela.setId(0);
		
		escuelaService.save(theEscuela);
		
		return theEscuela;
	}
	
	// agregar mapeo para PUT /escuelas - actualizar escuelas existentes
	
	@PutMapping("/escuelas")
	public Escuela updateEscuela(@RequestBody Escuela theEscuela) {
		
		escuelaService.save(theEscuela);
		
		return theEscuela;
	}
	
	//agregar mapeo para ELIMINAR /escuelas/{escuelaId} - eliminar escuela
	
	@DeleteMapping("/escuelas/{escuelaId}")
	public String deleteEscuela(@PathVariable int escuelaId) {
		
		Escuela tempEscuela = escuelaService.findById(escuelaId);
		
		// Lanzar excepción si es nulo
		
		if (tempEscuela == null) {
			throw new RuntimeException("Id de la escuela no encontrada - " + escuelaId);
		}
		
		escuelaService.deleteById(escuelaId);
		
		return "Id de la escuela eliminada - " + escuelaId;
	}
	
}










