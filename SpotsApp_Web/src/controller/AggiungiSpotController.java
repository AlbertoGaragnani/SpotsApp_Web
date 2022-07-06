package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import mockDatabase.MockDB;
import model.Attivita;
import model.Recensione;
import model.Spot;
import model.Utente;

public class AggiungiSpotController extends HttpServlet{
 
	 private static final long serialVersionUID = 1L;
	 
	 private MockDB db;
	 
	 
	 public void init(ServletConfig conf) throws ServletException 
	 {
	     super.init(conf);
	  
	     db = MockDB.getInstance();
	 }
	 
	 public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	 {
		 //cerca spot indirizzo ed attivit√†, funzione esterna la metto qua per cercare gli spot risultato 
		 String nomeSpot = req.getParameter("nomeSpot");
		 String indirizzoSpot = req.getParameter("indirizzoSpot");
		 String[] activities = req.getParameterValues("activities");
		 String descrizione = req.getParameter("descrizione");
		 List<Attivita> listaAttivita = new ArrayList<>();
		 if(activities != null) {
			 for(String s : activities)
				 listaAttivita.add(Attivita.valueOf(s));
		 }
		 List<String> fileNames = new ArrayList<>();
		 
		 //Upload immagini
		 String fName;
		 List<Part> fileParts = req.getParts().stream().filter(part -> "file".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
		 for(Part filePart : fileParts) {
			 fName = filePart.getSubmittedFileName();
			 this.getServletContext();
			 String imagesDir = System.getProperty("catalina.base") + "\\webapps\\SpotsApp\\images\\";
			 fileNames.add(fName);
			 filePart.write(imagesDir + fName);
		 }
		 
		 if(nomeSpot.isBlank() || indirizzoSpot.isBlank() || listaAttivita.isEmpty() || fileParts.isEmpty())
		 {
			 //Parametri inseriti non validi, solo tabulazioni o spazi
			 req.getSession().setAttribute("Errore", "ErroreForm");
			 resp.sendRedirect("view/ViewAggiungiSpot.jsp");
		 }
		 else
		 {
			 Spot spot = new Spot();
			 Map<String,Double> mappa = new HashMap<>();
			 List<Recensione> lista = new ArrayList<>();
			 
			 //Settaggio nome ed indirizzo
		     spot.setNome(nomeSpot);
		     spot.setIndirizzo(indirizzoSpot);
		     
		     //Settaggio attivit‡
		     spot.setAttivita(listaAttivita);
		     
		     //Settaggio descrizione
		     spot.setDescrizione(descrizione);
		     
		     //Settaggio usernameUtente
		     Utente utente = (Utente) req.getSession().getAttribute("currentUser");
		     spot.setUsernameUtente(utente.getUsername());
		   
		     //Settaggio ID
		     String newId = newId();
		     spot.setId(newId);
		   
		     //Settaggio IMMAGINI
		     for(String fileName : fileNames) {
		    	 spot.setImmagini(new File("/SpotsApp/images/" + fileName));		   
		     }
		     
		     //Settaggio valori di default
		     spot.setPresenzeSegnalate(0);
			 spot.setAffluenza(mappa);
			 spot.setRecensioni(lista);
			 
			//Controllo che lo spot non sia gia presente
			 boolean giaPresente = false;
		     for(Spot sp : this.db.getSpots()) {
			     if(sp.equals(spot))
			    	 giaPresente = true;
		     }
		     
		     if(giaPresente)
		     {
		    	req.getSession().setAttribute("Errore", "ErroreSpot");
		    	resp.sendRedirect("view/ViewAggiungiSpot.jsp"); 
		     }
		     else
		     {
		    	 //Aggiunta spot al database
		    	 this.db.getSpots().add(spot);
				   
			     //Redirezione alla home page
				 req.getSession().setAttribute("idSpot", newId);
				 resp.sendRedirect("view/ViewVisualizzaSpot.jsp"); 
		     }
		  }
	 }
	 
	 private String newId() {
		 String res = "";
		 boolean stop = false;
		 String last = this.db.getSpots().get(this.db.getSpots().size() - 1).getId();
		 String malformedNumber = last.substring(2);
		 int beginIndex = 0;
		 for(int i = 0; i < malformedNumber.length() && !stop; i++) {
			 if(malformedNumber.charAt(i) == '0')
				 beginIndex++;
			 else
				 stop = true;
				 
		 }
		 String number = malformedNumber.substring(beginIndex);
		 int numId = Integer.parseInt(number);
		 int newNumId = numId + 1;
		 res += "SP";
		 for(int i = 0; i < 4 - String.valueOf(newNumId).length(); i++)
			 res += "0";
		 res += newNumId;
		 return res;
	 }
	 
	 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
	 }
 

}