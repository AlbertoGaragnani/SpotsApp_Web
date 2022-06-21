<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>

<html>
   <head>
	<!--	<meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/>   -->
      <title>GestioneUtente</title>
		<link type="text/css" href="styles/stile.css" rel="stylesheet"></link>
		<script type="text/javascript" src="scripts/request.js"></script>
		<script type="text/javascript" src="scripts/utils.js"></script>
   </head>
   <body>
   		<h1>Home Utente</h1>
   		<div>
	   		<h2>Cerca Spot</h2>
	   		<p>Inserisci i criteri di ricerca dello Spot</p>
	   		<form action="gestioneUtente" method="post">
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
	      		<input type="submit" value="CercaSpot"/>
	     </form>
     </div>
     
     <%
     if(session.getAttribute("listaSpot") != null)
     {
    	 %>
    	 <div>
    	 	<ol>
    	 	<%
    	 	List<Spot> listaSpot = (List<Spot>) session.getAttribute("listaSpot");
    	 	for(Spot s : listaSpot)
    	 	{
    	 		%>
    	 		<li>
    	 			<p><%= s.getNome() %></p>
    	 			<p><%= s.getIndirizzo() %></p>
    	 			<input type="button" value="Visualizza" onClick="">
    	 		</li>
    	 		<%
    	 	}
    	 	%>
    	 	</ol>
    	 </div>
    	 <%
     }
     %>
     
     <div>
   		<input type="button" value="Visualizza Profilo"><br>
   		<input type="button" value="Logout"><br>
   		<input type="button" value="Aggiungi Spot"><br>
   </div>
   </body>
</html>

