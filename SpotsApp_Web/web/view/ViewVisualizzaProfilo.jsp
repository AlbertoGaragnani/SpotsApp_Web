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
	    <title>VisualizzaProfilo</title>
		<link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link>
   </head>
   <body>
   		<h1>Profilo</h1>
   		<div>
	   		<%
	   		
	   		%>	
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
