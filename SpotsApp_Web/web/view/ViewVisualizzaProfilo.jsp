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
	   	<div>
				<img src="/SpotsApp/images/LogoSmall.png" align="left"/>
				<img src="/SpotsApp/images/Icon.png" align="right"/>
		</div>
   		
		<br>
   		<div class="floatContainer">
   		<h1>PROFILO</h1>
	   		<div class="infopersonali">
		   		<h2>Informazioni personali</h2>
		   		<ul>
		   			<li> <p>Username: <%= user.getUsername() %></p> </li>
		   			<li> <p>Email: <%= user.getEmail() %></p> </li>
		   		</ul>	
		   		<br>
		   		<form action="/SpotsApp/visualizzaProfilo" method="get">
			     	<input type="submit" name="cambiaPW" value="Cambia password" >
				  	<input type="submit" name="inserzioni" value="Rimuovi inserzioni" >
				  	<input type="submit" name="logout" value="Logout" >
			 	</form>
	    	</div>
	    	
	    	<div class="preferiti">
	    		<h2>I miei preferiti</h2>
	    		<form action="/SpotsApp/visualizzaProfilo" method="post">
		    		<%
		    		List<Spot> preferiti = new ArrayList<>();
		    		MockDB db = MockDB.getInstance();
		    		preferiti = db.getPreferiti().get(user.getUsername());
		    		%>
		    		<ol id="listaspot">
		    			<%
		    			for(Spot s : preferiti)
		    			{
		    				String img = s.getImmagini().get(0).getPath().replace('\\', '/');
			    	 		%>
			    	 		<li >
			    	 			<div class="listspotItem" >
				    	 			<h3><%= s.getNome() %></h3>
				    	 			<img class="spotListImg" src=<%= img %> /><p><%= s.getIndirizzo() %></p>
				    	 			<button type="submit"  value=<%= s.getId() %> name="visualizzaspot" >Visualizza Spot</button>
				    	 			<button type="submit"  value=<%= s.getId() %> name="rimuovipreferiti" >Rimuovi</button>
			    	 			</div>
			    	 		</li>
			    	 		<br>
			    	 		<%
		    			}
		    			%>
		    		</ol>
	    		</form>
	    	</div>
    	
    	</div>
    	<a href="ViewGestioneUtente.jsp" id="homelink" style="position:fixed;bottom:0;right:5px">Home</a>
    
    
   </body>
</html>
