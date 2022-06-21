package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mockDatabase.AdminDB;
import mockDatabase.ModeratoriDB;
import mockDatabase.SpotsDB;
import mockDatabase.UsersDB;
import model.Admin;
import model.Attivita;
import model.Moderatore;
import model.Spot;
import model.Utente;

public class GestioneUtenteController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private AdminDB databaseAdmin;
	private ModeratoriDB databaseModeratori;
	private UsersDB databaseUtenti;
	private SpotsDB databaseSpots;
	
	
	public void init(ServletConfig conf) throws ServletException 
	{
		super.init(conf);
		
		this.databaseUtenti = (UsersDB) this.getServletContext().getAttribute("UsersDB");
		this.databaseModeratori = (ModeratoriDB) this.getServletContext().getAttribute("ModeratoriDB");
		this.databaseAdmin = (AdminDB) this.getServletContext().getAttribute("AdminDB");
		if(this.getServletContext().getAttribute("SpotsDB") == null) 
		{
			this.databaseSpots = new SpotsDB();
			this.getServletContext().setAttribute("SpotsDB", databaseSpots);
		}
		else
			this.databaseSpots = (SpotsDB) this.getServletContext().getAttribute("SpotsDB");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//cerca spot indirizzo ed attività, funzione esterna la metto qua per cercare gli spot risultato 
		String attivita = req.getParameter("attivita");
		String indirizzo = req.getParameter("indirizzo");
		if(attivita.isBlank() && indirizzo.isBlank())
		{
			//Parametri inseriti non validi, solo tabulazioni o spazi
			req.getSession().setAttribute("Errore", "I due parametri passati sono vuoti");
		}
		else
		{
			//Chiama la funzione di ricerca
			//Salvare un parametro che chiam
			List<Spot> listaSpot = new ArrayList<>();
			listaSpot = ricercaSpot(indirizzo,attivita);
			req.getSession().setAttribute("listaSpot",listaSpot);

		}
		
	}
	
	private List<Spot> ricercaSpot(String indirizzo, String attivita)
	{
		List<Spot> res = new ArrayList<Spot>();
		//Almeno uno dei due parametri va bene quindi ricerco
		if(indirizzo.isBlank())
		{
			//Vuol dire che ha inserito solo l'attivita
			for(Spot spot : this.databaseSpots.getSpots())
				if(spot.getAttivita().contains(Attivita.valueOf(attivita)))
					res.add(spot);
		}
		else if(attivita.isBlank())
		{
			//Ha messo solo l'indirizzo
			for(Spot spot : this.databaseSpots.getSpots())
				if(spot.getIndirizzo().equals(indirizzo))
					res.add(spot);
		}
		else
		{
			//Ha inserito tutti e due
			for(Spot spot : this.databaseSpots.getSpots())
				if(spot.getAttivita().contains(Attivita.valueOf(attivita)) && spot.getIndirizzo().equals(indirizzo))
					res.add(spot);
		}
		return res;
	}
	

}
