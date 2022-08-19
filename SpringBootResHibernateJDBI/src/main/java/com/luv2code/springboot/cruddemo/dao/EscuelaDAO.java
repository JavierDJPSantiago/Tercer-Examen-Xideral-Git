package com.luv2code.springboot.cruddemo.dao;

import java.util.List;


import com.luv2code.springboot.cruddemo.entity.Escuela;

//interface de clase de persistencia
public interface EscuelaDAO {   

	List<Escuela> findAll();
	
	Escuela findById(int theId);
	
	void save(Escuela escuela);
	
	void deleteById(int theId);
	
}
