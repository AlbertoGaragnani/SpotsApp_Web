<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>

<html>
   <head>
      <title>AggiungiSpot</title>
      <link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link>
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
				   <label>Descrizione <textarea name="descrizione" rows="8" cols="8">Inserire una breve descrizione dello spot</textarea></label><br>
                   <label>Carica foto <input type="file" name="file" value="image" multiple/></label><br>
                   <input type="submit" value="Conferma" ><br>
                 
         </form>
     </div>
     
     <% 
	
	if (session.getAttribute("Errore")!=null && session.getAttribute("Errore").equals("ErroreForm"))
    {
     	%>
        <div> Il form di aggiunta dello spot non è stato compilato correttamente ! </div>
     	<% 
     	session.removeAttribute("Errore");
    }
	
	if(session.getAttribute("Errore")!=null && session.getAttribute("Errore").equals("ErroreSpot"))
  	{
  		%>
		<div> Lo spot che hai cercato di inserire è già presente nel dataBase!</div>
		<%
		session.removeAttribute("RegistrazioneOK");
  	}
	
     %>
   </body>
</html>
