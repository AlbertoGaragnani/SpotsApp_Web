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
	private AdminDB databaseAdmin;
	private ModeratoriDB databaseModeratori;
	private UsersDB databaseUtenti;
	
	
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
		if(this.getServletContext().getAttribute("UsersDB") == null) {
			databaseUtenti = new UsersDB();
			this.getServletContext().setAttribute("UsersDB", databaseUtenti);
		}
		else
			databaseUtenti = (UsersDB) this.getServletContext().getAttribute("UsersDB");
		if(this.getServletContext().getAttribute("ModeratoriDB") == null) {
			databaseModeratori = new ModeratoriDB();
			this.getServletContext().setAttribute("ModeratoriDB", databaseModeratori);
		}
		else
			databaseModeratori = (ModeratoriDB) this.getServletContext().getAttribute("ModeratoriDB");
		if(this.getServletContext().getAttribute("AdminDB") == null) {
			databaseAdmin = new AdminDB();
			this.getServletContext().setAttribute("AdminDB", databaseAdmin);
		}
		else
			databaseAdmin = (AdminDB) this.getServletContext().getAttribute("AdminDB");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("userName");
		String passwordToCheck = req.getParameter("pwd");
		String password = null;
		Utente utente = new Utente();
		//Ciclo sui DBMock per trovare l'utente associato all'username inserito
		for(Admin user : this.databaseAdmin.getAdmin()) {
			if(user.getUsername().equals(username)) {
				password = this.databaseAdmin.getPassword().get(user);
				req.getSession().setAttribute("tipoUtente", "Admin");
				utente = user;
			}
		}
		
		if(password == null)
		{
			for(Moderatore user : this.databaseModeratori.getModeratori()) {
				if(user.getUsername().equals(username)) {
					password = this.databaseModeratori.getPassword().get(user);
					req.getSession().setAttribute("tipoUtente", "Moderatore");
					utente = user;
				}
			}
		}
		
		if(password == null)
		{
			for(Utente user : this.databaseUtenti.getUtenti()) {
				if(user.getUsername().equals(username)) {
					password = this.databaseUtenti.getPassword().get(user);
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
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewGestioneUtente.jsp");	
				rd.forward(req, resp);
			}
			//La password è errata
			else {
				req.getSession().setAttribute("Errore", "Errore");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewLogin.jsp");	
				rd.forward(req, resp);
			}
		}
		//Non è stato trovato nessun utente con l'username inserito nel database
		else
		{
			req.getSession().setAttribute("Errore", "Errore");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewLogin.jsp");	
			rd.forward(req, resp);
		}
	}

}
