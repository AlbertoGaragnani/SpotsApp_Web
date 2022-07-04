<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>

<html>
   <head>
    <!--    <meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/>   -->
      <title>AggiungiSpot</title>
        <link type="text/css" href="styles/stile.css" rel="stylesheet"></link>
        <script type="text/javascript" src="scripts/VisualizzaSpot.js"></script>
        <script type="text/javascript" src="scripts/AggiungiSpot.js"></script>
        <script type="text/javascript" src="scripts/utils.js"></script>
   </head>
   <body>
           <h1>AggiungiSpot</h1>
           <div>
               <p>Inserisci i dati dello Spot</p>
               <form action="aggiungiSpot" method="post">
                   <label>Nome <input type="text" name="nomeSpot"/></label><br>
                   <label>Indirizzo <input type="text" name="indirizzoSpot"/></label><br>
                   <select name="activities" multiple=“multiple”>
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
                   
                   <%
                   for(int i=0;i<5;i++)
                   {
                   %>
                   <input type="text" value="file<%=i%>"> Carica foto n.<%=i%>
                   <%
                   }
                   %>
                   
                   
                   
         </form>

        <div>
           <input type="submit" value="AggiungiSpotController" ><br>
           </div>

     </div>
   </body>
</html>
