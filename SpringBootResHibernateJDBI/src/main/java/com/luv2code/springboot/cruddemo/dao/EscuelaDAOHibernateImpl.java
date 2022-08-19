package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Escuela;

@Repository
public class EscuelaDAOHibernateImpl implements EscuelaDAO {

	// definir el campo para el administrador de entidades	
	private EntityManager entityManager;
		
	// configurar la inyección de constructor
	@Autowired  //inyección de el objeto entity manager por spring boot
	public EscuelaDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Escuela> findAll() {

		// obtener la sesión de hibernate actual
		Session currentSession = entityManager.unwrap(Session.class);
		
		// crear una consulta
		Query<Escuela> theQuery =
				currentSession.createQuery("from Escuela", Escuela.class); //Escuela es el entiti, no se refiere al nombre de la tabla
		
		// ejecutar consulta y obtener lista de resultados
		List<Escuela> escuela = theQuery.getResultList();
		
		// Regresar el resultado		
		return escuela;
	}


	@Override
	public Escuela findById(int theId) {

		// obtener la sesión de hibernate actual
		Session currentSession = entityManager.unwrap(Session.class);
		
		// obtener la escuela
		Escuela escuela =
				currentSession.get(Escuela.class, theId);
		
		// regresar la escuela
		return escuela;
	}


	@Override
	public void save(Escuela escuela) {

		// obtener la sesión de hibernate actual
		Session currentSession = entityManager.unwrap(Session.class);
		
		// guardar la escuela
		currentSession.saveOrUpdate(escuela);
	}


	@Override
	public void deleteById(int theId) {
		
		// obtener la sesión de hibernate actual
		Session currentSession = entityManager.unwrap(Session.class);
				
		// eliminar un objeto con la llave primaria
		Query theQuery = 
				currentSession.createQuery(
						"delete from Escuela where id=:escuelaId");
		theQuery.setParameter("escuelaId", theId);
		
		theQuery.executeUpdate();
	}




}







