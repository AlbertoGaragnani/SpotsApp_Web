package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mockDatabase.*;
import model.*;

public class LoginController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private MockDB db;
	
	
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
		
		db = MockDB.getInstance();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("userName");
		String passwordToCheck = req.getParameter("pwd");
		String password = null;
		Utente utente = new Utente();
		//Ciclo sui DBMock per trovare l'utente associato all'username inserito
		for(Admin user : this.db.getAdmin()) {
			if(user.getUsername().equals(username)) {
				password = this.db.getPassword().get(user);
				req.getSession().setAttribute("tipoUtente", "Admin");
				utente = user;
			}
		}
		
		if(password == null)
		{
			for(Moderatore user : this.db.getModeratori()) {
				if(user.getUsername().equals(username)) {
					password = this.db.getPassword().get(user);
					req.getSession().setAttribute("tipoUtente", "Moderatore");
					utente = user;
				}
			}
		}
		
		if(password == null)
		{
			for(Utente user : this.db.getUtenti()) {
				if(user.getUsername().equals(username)) {
					password = this.db.getPassword().get(user);
					req.getSession().setAttribute("tipoUtente", "Utente");
					utente = user;
				}
			}
		}
		
		if(password != null)
		{
			//Controllo se la password è stata inserita correttamente e nel caso vado a Gestione Utente
			if(passwordToCheck.equals(password)) {
				
				req.getSession().setAttribute("currentUser", utente);
				resp.sendRedirect("/SpotsApp/view/ViewGestioneUtente.jsp");
			}
			//La password è errata
			else {
				req.getSession().setAttribute("Errore", "Errore");
				resp.sendRedirect("/SpotsApp/view/ViewLogin.jsp");
			}
		}
		//Non è stato trovato nessun utente con l'username inserito nel database
		else
		{
			req.getSession().setAttribute("Errore", "Errore");
			resp.sendRedirect("/SpotsApp/view/ViewLogin.jsp");
		}
	}

}
