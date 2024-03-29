package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mockDatabase.*;
import model.Admin;
import model.Moderatore;
import model.Utente;

public class RegistrazioneController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private MockDB db;
	
	public void init(ServletConfig conf) throws ServletException 
	{
		super.init(conf);
		
		db = MockDB.getInstance();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username, password, email, pwdConfirm;
		username = (String) req.getParameter("Username");
		password = (String) req.getParameter("pwd");
		email = (String) req.getParameter("email");
		pwdConfirm = (String) req.getParameter("pwdconfirm");
		
		//Controllo che tutti i campi siano stati inseriti
		if(username.length() == 0 || email.length() == 0 || password.length() == 0 || pwdConfirm.length() == 0)
		{
			//Messaggio di errore, parametri inseriti errati
			req.getSession().setAttribute("Errore", "ErroreParametri");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewRegistrazione.jsp");
			rd.forward(req, resp);
			return;
		}
		
		//Effettuo controllo sulla lunghezza delle credenziali
		if(username.length() > 32 || email.length() > 32 || password.length() > 32 )
		{
			
			//Messaggio di errore: Le credenziali possono essere al massimo di 32 caratteri
			req.getSession().setAttribute("Errore","ErroreLunghezza");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewRegistrazione.jsp");
			rd.forward(req, resp);
			return;
		}
		
		//Effettuo controllo su presenza della "@" nella mail
		if(!email.contains("@"))
		{
			//Messaggio di errore: la mail deve contenere "@"
			req.getSession().setAttribute("Errore","ErroreMail");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewRegistrazione.jsp");
			rd.forward(req, resp);
			return;
		}
		
		if(!password.equals(pwdConfirm))
		{
			//Messaggio di errore: la mail deve contenere "@"
			req.getSession().setAttribute("Errore","ErrorePassword");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewRegistrazione.jsp");
			rd.forward(req, resp);
			return;
		}				
			
		Utente utente = new Utente();
		boolean giaPresente = false;
		utente.setUsername(username);
		utente.setEmail(email);
		for(Utente u : this.db.getUtenti()) {
			if(u.getUsername().equals(username))
				giaPresente = true;
		}
		for(Moderatore m : this.db.getModeratori()) {
			if(m.getUsername().equals(username))
				giaPresente = true;
		}
		for(Admin a : this.db.getAdmin()) {
			if(a.getUsername().equals(username))
				giaPresente = true;
		}
		if(!giaPresente)
        {
            //Aggiungo l'utente e rimando alla pagina principale
            this.db.getUtenti().add(utente);
            this.db.getPassword().put(utente, password);
            req.getSession().setAttribute("RegistrazioneOK", username);
            //Forward alla pagina di login
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewLogin.jsp");
            rd.forward(req, resp);
            return;
        }
		else
		{
			//Messaggio di errore, l'utente è già presente
			req.getSession().setAttribute("Errore", "ErroreGiaPresente");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewRegistrazione.jsp");
			rd.forward(req, resp);
			return;
		}
	}

}
