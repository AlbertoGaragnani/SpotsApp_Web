package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import mockDatabase.MockDB;
import model.Attivita;
import model.Recensione;
import model.Spot;
import model.Utente;

@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
	maxFileSize = 1024 * 1024 * 10,      // 10 MB
	maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
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
		 List<Attivita> listaAttivita = new ArrayList<>();
		 for(String s : activities)
			 listaAttivita.add(Attivita.valueOf(s));
		 Part filePart = req.getPart("file");
		 String fileName = filePart.getSubmittedFileName();
		 for(Part part : req.getParts()) {
			 part.write("C:\\Users\\Utente\\git\\SpotsApp_Web\\SpotsApp_Web\\web\\images\\" + fileName);
		 }
		 if(nomeSpot.isBlank() || indirizzoSpot.isBlank() || listaAttivita.isEmpty())
		 {
			 //Parametri inseriti non validi, solo tabulazioni o spazi
			 req.getSession().setAttribute("Errore", "ErroreForm");
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
		     
		     //Settaggio usernameUtente
		     Utente utente = (Utente) req.getSession().getAttribute("currentUser");
		     spot.setUsernameUtente(utente.getUsername());
		   
		     //Controllo che lo spot non sia gia presente
		     for(Spot sp : this.db.getSpots())
		     if(sp.getNome().equals(nomeSpot))
		    	 req.getSession().setAttribute("Errore", "ErroreSpot");
		   
		     //Creazione dell'ID
		     /*String precedentStr = "";
		     for(Spot s : this.db.getSpots())
		    	 precedentStr = s.getId();
		     System.out.println("Id ultimo spot: "+precedentStr);
		     precedentStr = precedentStr.substring(precedentStr.length()-2,precedentStr.length());
		     int precedent = 0;
		     try
		     {
		    	 precedent = Integer.parseInt(precedentStr);
		    	 System.out.println("Numero parsato"+precedent);
		     }
		     catch(NumberFormatException e)
		     {
		    	 e.printStackTrace();
		     }
		     spot.setId(findId(precedentStr,precedent));
		     System.out.println("L'id dello spot che si sta cercando di caricare e: "+spot.getId());*/
		     spot.setId("SP0005");
		   
		     //Settaggio IMMAGINI
		     spot.setImmagini(new File("/SpotsApp/images/" + fileName));		   
		     this.db.getSpots().add(spot);
		     
		     //Settaggio valori di default
		     spot.setPresenzeSegnalate(0);
			 spot.setAffluenza(mappa);
			 spot.setRecensioni(lista);
		   
		     //Redirezione alla home page
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewGestioneUtente.jsp");
		     rd.forward(req, resp); 
		  }
	 }
	 
	 private String findId(String sottoStringa, int precId) {
	     int num = precId+1;
	     return sottoStringa+num;
	 }
	 
	 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
	 }
 

}