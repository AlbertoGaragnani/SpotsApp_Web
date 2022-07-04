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

import org.hsqldb.Session;

import com.google.gson.Gson;

import mockDatabase.MockDB;
import model.Admin;
import model.Attivita;
import model.Moderatore;
import model.Spot;
import model.Utente;

public class GestioneUtenteController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	private MockDB db;
	//private Gson g;
	
	
	public void init(ServletConfig conf) throws ServletException 
	{
		super.init(conf);
		
		db = MockDB.getInstance();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("sono in do post");
		//cerca spot indirizzo ed attività, funzione esterna la metto qua per cercare gli spot risultato 
		String attivita = req.getParameter("attivita");
		String indirizzo = req.getParameter("indirizzo");
		if(req.getParameter("cercaspot") != null)
		{
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
				resp.sendRedirect("view/ViewGestioneUtente.jsp");
				//RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewGestioneUtente.jsp");
				//rd.forward(req, resp);

			}
		}
		
		
		
		
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("sono in do get");
	
		if(req.getParameter("logout") != null)
		{
			
			System.out.println("LOGGOUTOUT");
			req.getSession().invalidate();
			resp.sendRedirect("view/ViewLogin.jsp");
		}
		else if(req.getParameter("visualizzaprofilo") != null)
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewVisualizzaProfilo.jsp");
			rd.forward(req, resp);
		}
		else if(req.getParameter("aggiungispot") != null)
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewAggiungiSpot.jsp");
			rd.forward(req, resp);
		}
		else if(req.getParameter("visualizzaspot") != null)
		{
			System.out.println("provo a visualizzare");
			
			String idSpot = req.getParameter("idSpot");
			
			req.getSession().setAttribute("idSpot", idSpot);
			resp.sendRedirect("view/ViewVisualizzaSpot.jsp");
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewVisualizzaSpot.jsp");
			//rd.forward(req, resp);
		}
		
		
		
		
	}
	
	private List<Spot> ricercaSpot(String indirizzo, String attivita)
	{
		List<Spot> res = new ArrayList<Spot>();
		//Almeno uno dei due parametri va bene quindi ricerco
		if(indirizzo.isBlank())
		{
			//Vuol dire che ha inserito solo l'attivita
			for(Spot spot : this.db.getSpots())
				if(spot.getAttivita().contains(Attivita.valueOf(attivita)))
					res.add(spot);
		}
		else if(attivita.isBlank())
		{
			//Ha messo solo l'indirizzo
			for(Spot spot : this.db.getSpots())
				if(spot.getIndirizzo().equals(indirizzo))
					res.add(spot);
		}
		else
		{
			//Ha inserito tutti e due
			for(Spot spot : this.db.getSpots())
				if(spot.getAttivita().contains(Attivita.valueOf(attivita)) && spot.getIndirizzo().equals(indirizzo))
					res.add(spot);
		}
		return res;
	}
	

}
