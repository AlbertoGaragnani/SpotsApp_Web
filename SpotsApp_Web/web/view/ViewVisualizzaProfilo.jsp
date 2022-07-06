<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Attivita" %>
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
		 	<form action="/SpotsApp/visualizzaProfilo" method="get">
		     	<input type="submit" name="cambiaPW" value="Cambia password" >
			    <input type="submit" name="preferiti" value="I miei preferiti" >
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
