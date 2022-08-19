package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EscuelaDAO;
import com.luv2code.springboot.cruddemo.entity.Escuela;


@Service
public class EscuelaServiceImpl implements EscuelaService {

	private EscuelaDAO escuelaDAO;
	
	@Autowired
						   // @Qualifier permite elegir la implementación deseada: JDBC o Hibernate
	                       // @Qualifier("escuelaDAOHibernateImpl")
	public EscuelaServiceImpl(@Qualifier("escuelaDAOJdbcImpl")EscuelaDAO theEscuelaDAO) {
		escuelaDAO = theEscuelaDAO;
	}
	
	@Override
	@Transactional
	public List<Escuela> findAll() {
		return escuelaDAO.findAll();
	}

	@Override
	@Transactional
	public Escuela findById(int theId) {
		return escuelaDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Escuela theEmployee) {
		escuelaDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		escuelaDAO.deleteById(theId);
	}

}






