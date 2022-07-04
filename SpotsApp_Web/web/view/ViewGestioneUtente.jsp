<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>

<html>
   <head>
	<!--	<meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/>   -->
      <title>GestioneUtente</title>
		<link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link>
		<script type="text/javascript" src="scripts/GestioneUtente.js"></script>
		<script type="text/javascript" src="scripts/utils.js"></script>
   </head>
   <body>
   
   	<% if(session.getAttribute("currentUser")!=null)
   	{
	%>
		
		<h1>Home Utente</h1>
   		<div>
	   		<h2>Cerca Spot</h2>
	   		<p>Inserisci i criteri di ricerca dello Spot</p>
	   		<form action="/SpotsApp/gestioneUtente" method="post">
	   			<label>Indirizzo <input type="text" name="indirizzo" size="30"/></label><br>
	      		<label>Attivita 
	      		<select name="attivita">
	      		<option value="" >Attivita</option>
	      			<%
	      			for(Attivita a : Attivita.values())
	      			{
	      				%>
	      				<option value=<%= a.name() %>><%= a.name() %></option>
	      				<%
	      			}
	      			%>
	      		</select>
	      		</label><br>
	      		<input type="submit" name="cercaspot" value="CercaSpot"/>
	      		
	     	</form>
    	</div>
     
	     <%
	     if(session.getAttribute("listaSpot") != null)
	     {
	    	 %>
	    	 <div>
		    	 <form action="/SpotsApp/gestioneUtente" method="post">
		    	 	<ol>
		    	 	<%
		    	 	List<Spot> listaSpot = (List<Spot>) session.getAttribute("listaSpot");
		    	 	for(Spot s : listaSpot)
		    	 	{
		    	 		
		    	 		String img = s.getImmagini().get(0).getPath().replace('\\', '/');
		    	 		%>
		    	 		<li>
		    	 			<p><%= s.getNome() %></p>
		    	 			<p><%= s.getIndirizzo() %></p>
		    	 			<img class="spotListImg" src=<%= img %> align="left" />
		    	 			<input type="submit" name=<%= s.getId() %> value="visualizzaspot" >
		    	 		</li>
		    	 		<%
		    	 	}
		    	 	%>
		    	 	</ol>
		    	 </form>
	    	 </div>
	    	 <%
	     }
	     %>
	     
	     <div>
		 	<form action="/SpotsApp/gestioneUtente" method="get">
		     	<input type="submit" name="logout" value="Logout" >
			    <input type="submit" name="visualizzaprofilo" value="Visualizza Profilo" >
			  	<input type="submit" name="aggiungispot" value="Aggiungi_Spot" >
		 	</form>
	     </div>
	     
    
	
	
	<%
   	} 
   	else{
   		%><h1>SESSIONE NON VALIDA</h1> <%
   	}
	%>
   	
   </body>
</html>

