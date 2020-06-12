package riepilogowebapp.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import riepilogowebapp.models.Persona;

public class Service {
	EntityManager em;

	public Service(EntityManagerFactory emf) {

		this.em = emf.createEntityManager();
	}

	public void close() {
		this.em.close();
	}

	

	public List<Persona> stampaListaPersone() {

		List<Persona> lista = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
		return lista;

	}


	public Persona salvaPersona(Persona persona) {

		
		em.getTransaction().begin();
		em.persist(persona);
		em.getTransaction().commit();
		return persona;

	}
}
