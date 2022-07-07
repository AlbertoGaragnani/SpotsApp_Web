package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mockDatabase.MockDB;
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
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String idSpot = (String) req.getSession().getAttribute("idSpot");
	
		if(req.getParameter("segnalapresenza") != null)
		{
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
			resp.sendRedirect("view/ViewLasciaRecensione.jsp");
		}
		else if(req.getParameter("segnalaspot") != null)
		{			
			resp.sendRedirect("view/ViewVisualizzaSpot.jsp");
		}
		else if(req.getParameter("aggiungipreferiti") != null)
		{
			Utente user = (Utente) req.getSession().getAttribute("currentUser");
			Spot preferito = new Spot();
			for(Spot s : this.db.getSpots()) {
				if(s.getId().equals(idSpot)) {
					preferito = s;
					break;
				}				
			}
			boolean isPresent = false;
			for(Spot s : this.db.getPreferiti().get(user.getUsername())) {
				if(s.getId().equals(preferito.getId())) {
					isPresent = true;
					break;
				}
			}
			if(!isPresent)
				this.db.getPreferiti().get(user.getUsername()).add(preferito);
			req.getSession().setAttribute("aggiunto", "");
			resp.sendRedirect("view/ViewVisualizzaSpot.jsp");
		}
	}
}