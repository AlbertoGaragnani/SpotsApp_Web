package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mockDatabase.UsersDB;
import model.Utente;

public class RegistrazioneController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private UsersDB databaseUtenti;
	
	public void init(ServletConfig conf) throws ServletException 
	{
		super.init(conf);
		databaseUtenti = new UsersDB();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String username, password, email;
		username = (String) req.getParameter("userName");
		password = (String) this.getServletContext().getAttribute("pwd");
		email = (String) this.getServletContext().getAttribute("email");
		this.getServletContext().setAttribute("verifica",false);
		
		//Effettuo controllo sulla lunghezza delle credenziali
		if(username.length() > 32 || email.length() > 32 || password.length() > 32 )
		{
			
			//Messaggio di errore: Le credenziali possono essere al massimo di 32 caratteri
			req.getSession().setAttribute("Errore","ErroreLunghezza");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("view/ViewLogin.jsp");
			rd.forward(req, resp);
			return;
		}
		
		//Effettuo controllo su presenza della "@" nella mail
		if(email.contains("@"))
		{
			//Messaggio di errore: la mail deve contenere "@"
			req.getSession().setAttribute("Errore","ErroreMail");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("view/ViewLogin.jsp");
			rd.forward(req, resp);
			return;
		}
			
			
			
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
				//Forward alla pagina di login
				RequestDispatcher rd = getServletContext().getRequestDispatcher("view/ViewLogin.jsp");
				rd.forward(req, resp);
				return;
			}
			else
			{
				//Messaggio di errore, l'utente è già presente
				this.getServletContext().setAttribute("verifica",false);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("view/ViewRegistrazione.jsp");
				rd.forward(req, resp);
				return;
			}
		}
		else
		{
			//Messaggio di errore, parametri inseriti errati
			this.getServletContext().setAttribute("verifica",false);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("view/ViewRegistrazione.jsp");
			rd.forward(req, resp);
			return;
		}
	}

}
