package riepilogowebapp.controller;

import java.io.IOException;



import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import riepilogowebapp.models.Persona;
import riepilogowebapp.service.Service;


@WebServlet(name = "aggiungiPersona", urlPatterns = "/aggiungiPersona")

public class AggiungiPersona extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		Persona persona = new Persona();
		persona.setNome(req.getParameter("nome"));
		persona.setCognome(req.getParameter("cognome"));
		persona.setNumero(Long.parseLong("numero"));
		Service s = new Service(emf);

				s.salvaPersona(persona);
				req.setAttribute("mess", "Persona aggiunta con successo!");
		
		
		
		req.setAttribute("listaPersone", s.stampaListaPersone());
		s.close();
		req.getRequestDispatcher("home.jsp").forward(req, resp);

	}
}
