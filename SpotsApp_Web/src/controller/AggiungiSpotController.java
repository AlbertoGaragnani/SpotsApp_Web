package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mockDatabase.MockDB;
import model.Admin;
import model.Attivita;
import model.Moderatore;
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
  //cerca spot indirizzo ed attività, funzione esterna la metto qua per cercare gli spot risultato 
  String nomeSpot = req.getParameter("nomeSpot");
  System.out.println(nomeSpot);
  String indirizzoSpot = req.getParameter("indirizzoSpot");
  System.out.println(indirizzoSpot);
  String[] activities = req.getParameterValues("activities");
  System.out.println(activities);
  List<Attivita> listaAttivita = new ArrayList<>();
  for(String s : activities)
   listaAttivita.add(Attivita.valueOf(s));
//  String immagini = req.getParameter("immagine");
  System.out.println("Attivita inserite:");
  for(Attivita a : listaAttivita)
	  System.out.println(a.toString());
  if(nomeSpot.isBlank() || indirizzoSpot.isBlank() || listaAttivita.isEmpty())
  {
   //Parametri inseriti non validi, solo tabulazioni o spazi
   req.getSession().setAttribute("Errore", "NON HAI COMPILATO IL FORM DI AGGIUNTA SPOT");
  }
  else
  {
   Spot spot = new Spot();
   spot.setNome(nomeSpot);
   spot.setIndirizzo(indirizzoSpot);
   
   //Controllo che lo spot non sia gia presente
   for(Spot sp : this.db.getSpots())
    if(sp.getNome().equals(nomeSpot))
     req.getSession().setAttribute("Errore", "NON HAI COMPILATO IL FORM DI AGGIUNTA SPOT");
   
   //Creazione dell'ID
   String precedentStr = "";
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
   System.out.println("L'id dello spot che si sta cercando di caricare e: "+spot.getId());
   
   //Settaggio IMMAGINI
   List<File> listaFile = new ArrayList<>();
   for(int i=0;i<5;i++)
   {
	   String path = "file"+i;
	   System.out.println("Nome sul jsp che cerco di andare a predendere: "+path);
	   String filePath = req.getParameter(path);
	   System.out.println("PATH del file: "+filePath);
	   if(filePath!=null && !filePath.isBlank() && !filePath.isEmpty())
	   {
		   File f = new File(filePath);
		   if(f!=null)
			   listaFile.add(f);
	   }
   }
   spot.setImmagini(listaFile);
   
   this.db.getSpots().add(spot);
   
   //Redirezione alla home page
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/ViewGestioneUtente.jsp");
    rd.forward(req, resp); 
  }
  
 }
 
 private String findId(String sottoStringa, int precId)
 {
  int num = precId+1;
  return sottoStringa+num;
 }
 
 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
 {
  
 }
 

}