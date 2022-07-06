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

public class VisualizzaSpotController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	private MockDB db;
	
	
	public void init(ServletConfig conf) throws ServletException 
	{
		super.init(conf);
		
		db = MockDB.getInstance();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//cerca spot indirizzo ed attività, funzione esterna la metto qua per cercare gli spot risultato 
		String attivita = req.getParameter("attivita");
		String indirizzo = req.getParameter("indirizzo");
		if(req.getParameter("cercaspot") != null)
		{
			System.out.println(db.getSpots().get(db.getSpots().size() - 1).getNome());
			System.out.println(db.getSpots().get(db.getSpots().size() - 1).getAttivita().get(0));
			if(attivita.isBlank() && indirizzo.isBlank())
			{
				//Parametri inseriti non validi, solo tabulazioni o spazi
				req.getSession().setAttribute("Errore", "I due parametri passati sono vuoti");
				resp.sendRedirect("view/ViewGestioneUtente.jsp");

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
	
		if(req.getParameter("segnalapresenza") != null)
		{
			String idSpot = req.getParameter("idSpot");
			for(Spot s: this.db.getSpots())
			{
				if(idSpot.equals(s.getId()))
				{
					s.setPresenzeSegnalate(s.getPresenzeSegnalate()+1);
				}
			}
			resp.sendRedirect("view/ViewVisualizzaSpot.jsp");
		}
		else if(req.getParameter("backhome") != null)
		{
			req.getSession().removeAttribute("idSpot");
			resp.sendRedirect("view/ViewGestioneUtente.jsp");
		}
		else if(req.getParameter("lasciarecensione") != null)
		{
			//redirezione alla view di aggiungi recensione
		}
		else if(req.getParameter("segnalaspot") != null)
		{			
			resp.sendRedirect("view/ViewVisualizzaSpot.jsp");
		}
		else if(req.getParameter("aggiungipreferiti") != null)
		{			
			
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