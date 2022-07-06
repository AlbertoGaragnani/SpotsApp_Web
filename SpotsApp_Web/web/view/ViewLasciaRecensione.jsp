<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>

<html>
   <head>
      <title>Lascia recensione</title>
        <link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link>
   </head>
   <body>
        <h1>Lascia una recensione</h1>
        <div>
               <form action="/SpotsApp/lasciaRecensione" method="post">
                   
                 <label>Titolo <input type="text" id="titoloRecensione" name="titoloRecensione"/></label><br>
                 <p>(*)Valuta la tua esperienza in una scala da 1 a 5:</p> 
                 <label>1<input type="radio" id="uno" name="voto" value="1"/></label>
                 <label>2<input type="radio" id="due" name="voto" value="2"/></label>
                 <label>3<input type="radio" id="tre" name="voto" value="3"/></label>
                 <label>4<input type="radio" id="quattro" name="voto" value="4"/></label>
                 <label>5<input type="radio" id="cinque" name="voto" value="5"/></label><br>
                 
                 <br>  
                 
                   <legend>Periodo di permanenza:</legend> 
                   Mattina<input type="checkbox" id="mattina" name="mattina" value="mattina"/> Pomeriggio<input type="checkbox" id="pomeriggio" name="pomeriggio" value="pomeriggio"/> Sera<input type="checkbox" id="sera" name="sera" value="sera"/> <br>
                   <br>
                   Lascia un commmento: <input type="text" id="commentoRecensione" name="commentoRecensione" onkeypress="this.style.width = ((this.value.length + 3) * 8) + 'px';"/> 
         	  	   <input type="submit" value="Invia" ><br>
         	  </form>
         </div>

        <div>
            <p>I campi contrassegnati da (*) sono obbligatori</p>
        </div>
        
        <% 
	
		if (session.getAttribute("Errore")!=null && session.getAttribute("Errore").equals("Errore"))
    	{
     		%>
       		<div> Errore di compilazione del form ! </div>
     		<% 
     		session.removeAttribute("Errore");
    	}
     	%>
   </body>
</html>
