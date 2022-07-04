<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>
<%@ page import="model.Recensione" %>
<%@ page import="java.io.*" %>
<%@ page import="mockDatabase.MockDB" %>

<html>
   <head>
	<!--	<meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/>   -->
	

      <title></title>
		<link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link>
		<script type="text/javascript" src="/SpotsApp/scripts/visualizzaspot.js"></script>
   </head>
   <body onload="showSlides(1)">
   	<%
		String idSpot = (String) session.getAttribute("idSpot");
   	System.out.println(idSpot);
		String nome="";String indirizzo="";
		int presenzeSegnalate;
		List<Recensione> recensioni = new ArrayList<>();
		List<Attivita> attivita = new ArrayList<>();
		List<File> immagini = new ArrayList<>();
		MockDB db = MockDB.getInstance();
		List<Spot> spots = db.getSpots();
		for(Spot s : spots)
		{
			if(idSpot.equals(s.getId()))
			{
				nome = s.getNome();
				indirizzo = s.getIndirizzo();
				presenzeSegnalate = s.getPresenzeSegnalate();
				recensioni = s.getRecensioni();
				attivita = s.getAttivita();
				immagini = s.getImmagini();
				
			}
		}
	
	%>
   		<h1><%= nome %></h1>
   		<div class="container">
	   		<%
	   		for(int i =0;i<immagini.size();i++ )
	   		{
	   			System.out.println(immagini.get(i).getPath());
	   			System.out.println(immagini.get(i).getPath().replace('\\', '/'));
	   			%>
	   			<div class="mySlides">
				    <div class="numbertext"><%= i+1 %> / <%= immagini.size() %></div>
				      <img src=<%= immagini.get(i).getPath().replace('\\', '/')  %> />
				</div>
	   			
	   			<%
	   		}
	   		
	   		%>
	   		<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
 			<a class="next" onclick="plusSlides(1)">&#10095;</a>
	   		
    	</div>
    	
    	<div>
		 	<form action="/SpotsApp/gestioneUtente" method="get">
		     	<input type="submit" name="logout" value="Logout" >
			    <input type="submit" name="visualizzaprofilo" value="Visualizza Profilo" >
			  	<input type="submit" name="aggiungispot" value="Aggiungi_Spot" >
		 	</form>
	     </div>
    
   
    
   </body>
</html>
