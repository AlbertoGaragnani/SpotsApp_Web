package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mockDatabase.MockDB;
import model.Permanenza;
import model.Recensione;
import model.Spot;

public class LasciaRecensioneController extends HttpServlet{
 
	 private static final long serialVersionUID = 1L;
	 
	 private MockDB db;
	 
	 
	 public void init(ServletConfig conf) throws ServletException 
	 {
	     super.init(conf);
	  
	     db = MockDB.getInstance();
	 }
	 
	 public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	 {
		 List<Permanenza> permanenza = new ArrayList<>();

		 String idSpot = (String) req.getSession().getAttribute("idSpot");
		 
		 //Recupero permanenza
		 String [] selected = req.getParameterValues("permanenza");
		 if(selected != null)
		 {
			 for(int i=0;i<selected.length;i++)
			 {
				 System.out.println("selected: " + selected[i]);
				 if(selected[i].equals("MATTINA"))
				 {
					 permanenza.add(Permanenza.MATTINA);
				 }
				 else if(selected[i].equals("POMERIGGIO"))
				 {
					 permanenza.add(Permanenza.POMERIGGIO);
				 }
				 else if(selected[i].equals("SERA"))
				 {
					 permanenza.add(Permanenza.SERA);
				 }
			 }
		 }
		 
	/*	 String mattina = req.getParameter("mattina");
		 if(mattina != null)
			 permanenza.add(Permanenza.MATTINA);
		 String pomeriggio = req.getParameter("pomeriggio");
		 if(pomeriggio != null)
			 permanenza.add(Permanenza.POMERIGGIO);
		 String sera = req.getParameter("sera");
		 if(sera != null)
			 permanenza.add(Permanenza.SERA);    */
		 
		 

		 //Recupero titolo
		 String titoloRecensione = req.getParameter("titoloRecensione");

		 //Recupero voto
		 String voto = req.getParameter("voto");

		 //Recupero commento
		 String commentoRecensione = req.getParameter("commentoRecensione");

		 //Unica condizione di errore sul voto mancante
		 if(voto==null)
		 {
			 req.getSession().setAttribute("Errore", "Errore");
			 resp.sendRedirect("view/ViewLasciaRecensione.jsp");
		 }
		 else
		 {
			 Recensione recensione = new Recensione();
			 
			 //Setto il voto
			 recensione.setValutazione(Integer.parseInt(voto));
			 
			 //Setto il titolo
			 if(!titoloRecensione.equals(""))
				 recensione.setTitolo(titoloRecensione);
			 
			 //Setto il commento
			 if(!commentoRecensione.equals(""))
				 recensione.setDescrizione(commentoRecensione);
			 
			 //Setto la permanenza
			 recensione.setPermanenza(permanenza);
			 
			 //Recupero lo spot ed aggiungo la recensione
			 for(Spot s : this.db.getSpots()) 
			 {
				 if(s.getId().equals(idSpot)) {
					 s.setRecensioni(recensione);
				 }
			 }

			 //Redirezione
			 resp.sendRedirect("view/ViewVisualizzaSpot.jsp");
		 }
	 }
	 
	 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	 {
	  
	 }
}