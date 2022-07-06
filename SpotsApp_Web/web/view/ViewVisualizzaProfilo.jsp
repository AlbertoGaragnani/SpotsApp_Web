<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Spot" %>
<%@ page import="model.Utente" %>
<%@ page import="java.io.*" %>
<%@ page import="mockDatabase.MockDB" %>

<html>
   <head>
	    <title>VisualizzaProfilo</title>
		<link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link>
   </head>
   <body>
   		<%
	   	Utente user = (Utente) session.getAttribute("currentUser");
	   	%>
   		<h1>Profilo</h1>
   		<div>
	   		<h2>Informazioni personali</h2>
	   		<ul>
	   			<li> <p>Username: <%= user.getUsername() %></p> </li>
	   			<li> <p>Email: <%= user.getEmail() %></p> </li>
	   		</ul>	
    	</div>
    	
    	<div>
    		<h2>I miei preferiti</h2>
    		<form action="/SpotsApp/gestioneUtente" method="get">
	    		<%
	    		List<Spot> preferiti = new ArrayList<>();
	    		MockDB db = MockDB.getInstance();
	    		preferiti = db.getPreferiti().get(user.getUsername());
	    		%>
	    		<ol>
	    			<%
	    			for(Spot s : preferiti)
	    			{
	    				String img = s.getImmagini().get(0).getPath().replace('\\', '/');
		    	 		%>
		    	 		<li>
		    	 			<p><%= s.getNome() %></p>
		    	 			<p><%= s.getIndirizzo() %></p>
		    	 			<img class="spotListImg" src=<%= img %> align="left" />
		    	 			<input hidden="true" name="idSpot" value=<%= s.getId() %> />
		    	 			<input type="submit"  name="visualizzaspot" value="Visualizza Spot" />
		    	 		</li>
		    	 		<%
	    			}
	    			%>
	    		</ol>
    		</form>
    	</div>
    	
    	<div>
		 	<form action="/SpotsApp/visualizzaProfilo" method="get">
		     	<input type="submit" name="cambiaPW" value="Cambia password" >
			  	<input type="submit" name="inserzioni" value="Rimuovi inserzioni" >
		 	</form>
	    </div>
    
   		<div>
   			<form action="/SpotsApp/visualizzaProfilo" method="post">
   				<input type="submit" name="logout" value="Logout" >
   			</form>
   		</div>
    
   </body>
</html>
