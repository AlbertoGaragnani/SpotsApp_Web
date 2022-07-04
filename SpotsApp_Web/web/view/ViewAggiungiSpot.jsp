<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>

<html>
   <head>
      <title>AggiungiSpot</title>
      <link type="text/css" href="styles/stile.css" rel="stylesheet"></link>
   </head>
   <body>
           <h1>AggiungiSpot</h1>
           <div>
               <p>Inserisci i dati dello Spot</p>
               <form action="/SpotsApp/aggiungiSpot" method="post" enctype="multipart/form-data">
                   <label>Nome <input type="text" name="nomeSpot"/></label><br>
                   <label>Indirizzo <input type="text" name="indirizzoSpot"/></label><br>
                   <label>Attività
	                   <select name="activities" multiple="multiple">
	                   <%
	                   Attivita[] activities = Attivita.values();
	                   for(Attivita a : activities)
	                   {
	                   %>
	                   		<option value="<%=a.toString()%>"> <%=a.toString()%> </option> 
	                   <%
	                   }
	                   %>
	                   </select>
                   </label><br>

                   <label>Carica foto <input type="file" name="file" value="image"/></label><br>
                   <input type="submit" value="Conferma" ><br>
                 
         </form>
     </div>
   </body>
</html>
