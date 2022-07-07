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

public class VisualizzaProfiloController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private MockDB db;
	
	public void init(ServletConfig conf) throws ServletException 
	{
		super.init(conf);	
		
		db = MockDB.getInstance();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		if(req.getParameter("rimuovipreferiti") != null)
		{
			String idSpot = req.getParameter("rimuovipreferiti");
			Utente utente = (Utente) req.getSession().getAttribute("currentUser");
			String username = utente.getUsername();
			Spot toDel = new Spot();;
			for(Spot s : this.db.getSpots()) {
				if(s.getId().equals(idSpot)) {
					toDel = s;
					break;
				}
			}
			this.db.getPreferiti().get(username).remove(toDel);
			resp.sendRedirect("view/ViewVisualizzaProfilo.jsp");
		}
		else if(req.getParameter("visualizzaspot") != null)
		{			
			String idSpot = req.getParameter("visualizzaspot");
			req.getSession().setAttribute("idSpot", idSpot);
			resp.sendRedirect("view/ViewVisualizzaSpot.jsp");
		}	
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	
		if(req.getParameter("cambiaPW") != null)
		{
			//Logica per cambaire pw
		}
		else if(req.getParameter("inserzioni") != null)
		{
			//LOgica per rimuovere inserzioni
		}
		else if(req.getParameter("logout") != null)
		{
			req.getSession().invalidate();
			resp.sendRedirect("view/ViewLogin.jsp");
		}
	}	

}