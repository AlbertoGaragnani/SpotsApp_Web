<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>

<html>
   <head>
      <title>Lascia recensione</title>
        <!--  <link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link> -->
        <link type="text/css" href="${pageContext.request.contextPath}/styles/lasciarecensione.css" rel="stylesheet"></link>
        <script type="text/javascript" src="scripts/visualizzaspot.js"></script>
   </head>
   
   <% String idSpot = (String)session.getAttribute("idSpot"); %>
   <body>
      	<div>
			<img src="/SpotsApp/images/LogoSmall.png" align="left"/>
			<img src="/SpotsApp/images/Icon.png" align="right"/>
		</div>
        
        <div class="formdiv">
        	<h1>Lascia una recensione</h1><br><br>
       <!--        <form action="/SpotsApp/lasciaRecensione" method="post">
                   
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
         	  
		-->  
				<form class="form" action="/SpotsApp/lasciaRecensione" method="POST">
				  <div class="form__title"><%= idSpot %></div>
				  <p class="form__desc">
				  Esprimi il tuo parere sullo spot!</p>
				  <div class="form__item">
				    <label for="titoloRecensione" class="form__label">Titolo</label>
				    <input type="text" class="form__input" name="titoloRecensione" id="titoloRecensione" placeholder="Dai un titolo alla recensione">
				  </div>
				  <div class="form__item">
				    <label for="voto" class="form__label">Punteggio (*)</label>
				    <input type="number" class="form__input form__input--small" name="voto" id="voto" min="1" max="5" placeholder="Punteggio 1-5">
				  </div>
				  <div class="form__item">
				    <label for="permanenza" class="form__label">Fascia di permanenza</label>
				   <!--   <input type="date" class="form__input form__input--small" name="expirydate" id="expirydate" placeholder="Enter an expiration date"> -->
						<select name="permanenza" multiple>
							<option value="MATTINA">MATTINA</option>
							<option value="POMERIGGIO">POMERIGGIO</option>
							<option value="SERA">SERA</option>
						</select>
				    <span class="form__error">A sample error message</span>
				  </div>
				  <div class="form__item">
				    <label for="commentoRecensione" class="form__label">Descrizione</label>
				    <textarea maxlength="500" class="form__input" name="commentoRecensione" id="commentoRecensione" placeholder="Inserisci una descrizione della tua esperienza(Max. 500 chars)"></textarea>
				    <span class="form__error">A sample error message</span>
				  </div>
				  <div class="form__item">
				    <button class="form__btn" type="submit">Fatto</button>
				  </div>
				</form>	         	  
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
