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
	private AdminDB adminDB;
	private ModeratoriDB moderatoriDB;
	private UsersDB usersDB;
	
	
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
		this.adminDB = new AdminDB();
		this.moderatoriDB = new ModeratoriDB();
		this.usersDB = new UsersDB();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("userName");
		String passwordToCheck = req.getParameter("pwd");
		String password = null;
		Utente utente = new Utente();
		for(Admin user : this.adminDB.getAdmin()) {
			if(user.getUsername().equals(username)) {
				password = this.adminDB.getPassword().get(user);
				req.getSession().setAttribute("tipoUtente", "Admin");
				utente = user;
			}
		}
		
		if(password == null)
		{
			for(Moderatore user : this.moderatoriDB.getModeratori()) {
				if(user.getUsername().equals(username)) {
					password = this.moderatoriDB.getPassword().get(user);
					req.getSession().setAttribute("tipoUtente", "Moderatore");
					utente = user;
				}
			}
		}
		
		if(password == null)
		{
			for(Utente user : this.usersDB.getUtenti()) {
				if(user.getUsername().equals(username)) {
					password = this.usersDB.getPassword().get(user);
					req.getSession().setAttribute("tipoUtente", "Utente");
					utente = user;
				}
			}
		}
		
		if(password != null)
		{
			if(passwordToCheck.equals(password)) {
				req.getSession().setAttribute("currentUser", utente);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("view/ViewLogin.jsp");	
				rd.forward(req, resp);
			}
			else {
				req.getSession().setAttribute("Errore", "Errore");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("view/ViewLogin.jsp");	
				rd.forward(req, resp);
			}
		}
		else
		{
			req.getSession().setAttribute("Errore", "Errore");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("view/ViewLogin.jsp");	
			rd.forward(req, resp);
		}
	}

}
