<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>
<%@ page import="model.Recensione" %>
<%@ page import="mockDatabase.SpotsDB" %>
<%@ page import="java.io.*" %>
<%@ page import="mockDatabase.MockDB" %>

<html>
   <head>
	<!--	<meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/>   -->
	

      <title></title>
		<link type="text/css" href="styles/stile.css" rel="stylesheet"></link>
		<script type="text/javascript" src="scripts/VisualizzaSpot.js"></script>
		<script type="text/javascript" src="scripts/utils.js"></script>
   </head>
   <body>
   	<%
		String idSpot = request.getParameter("idSpot");
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
	   			%>
	   			<div class="mySlides">
				    <div class="numbertext"><%= i %> / <%= immagini.size() %></div>
				      <img src=<%= immagini.get(i).getPath()  %> style="width:100%">
				</div>
	   			
	   			<%
	   		}
	   		
	   		%>
	   		<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
 			<a class="next" onclick="plusSlides(1)">&#10095;</a>
	   		
    	</div>
     
   
     
     <div>
   		<input type="button" value="Visualizza Profilo"><br>
   		<input type="button" value="Logout"><br>
   		<input type="button" value="Aggiungi Spot"><br>
   </div>
   </body>
</html>
