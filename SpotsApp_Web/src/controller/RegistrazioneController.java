package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mockDatabase.UsersDB;
import model.Utente;

public class RegistrazioneController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private Gson gson;
	
	private UsersDB databaseUtenti;
	
	public void init(ServletConfig conf) throws ServletException 
	{
		super.init(conf);
		gson = new Gson();
		databaseUtenti = new UsersDB();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username, password, email;
		username = (String) req.getParameter("userName");
		password = (String) this.getServletContext().getAttribute("pwd");
		email = (String) this.getServletContext().getAttribute("email");
		this.getServletContext().setAttribute("verifica",false);
		if(username!=null && password!=null && email!=null)
		{
			Utente utente = new Utente();
			utente.setUsername(username);
			utente.setEmail(email);
			if(!this.databaseUtenti.getUtenti().contains(utente))
			{
				//Aggiungo l'utente e rimando alla pagina principale
				this.getServletContext().setAttribute("verifica",true);
				this.databaseUtenti.getUtenti().add(utente);
				this.databaseUtenti.getPassword().put(utente, password);
				//Forward alla pagina principale
			}
			else
			{
				//Messaggio di errore, l'utente è già presente
				this.getServletContext().setAttribute("verifica",false);
//				req.getRequestDispatcher("");
			}
		}
		else
		{
			//Messaggio di errore, parametri inseriti errati
			this.getServletContext().setAttribute("verifica",false);
		}
	}

}
