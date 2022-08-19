package com.luv2code.springboot.cruddemo.service;

import java.util.List;


import com.luv2code.springboot.cruddemo.entity.Escuela;

public interface EscuelaService {

	public List<Escuela> findAll();
	
	public Escuela findById(int theId);
	
	public void save(Escuela escuela);
	
	public void deleteById(int theId);
	
}
