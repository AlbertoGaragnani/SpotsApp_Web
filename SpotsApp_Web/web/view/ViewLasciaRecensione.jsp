<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>
<%@ page import="mockDatabase.MockDB" %>

<html>
   <head>
      <title>Lascia recensione</title>
        <!--  <link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link> -->
        <link type="text/css" href="${pageContext.request.contextPath}/styles/lasciarecensione.css" rel="stylesheet"></link>
        <script type="text/javascript" src="scripts/visualizzaspot.js"></script>
   </head>
   
   <% 
   		String idSpot = (String)session.getAttribute("idSpot"); 
   		String nome="";
   		MockDB db = MockDB.getInstance();
		List<Spot> spots = db.getSpots();
		for(Spot s : spots)
		{
			if(idSpot.equals(s.getId()))
			{
				nome = s.getNome();
				
			}
			
		}
   
   %>
   <body>
      	<div>
			<img src="/SpotsApp/images/LogoSmall.png" align="left"/>
			<img src="/SpotsApp/images/Icon.png" align="right"/>
		</div>
        
        <div class="formdiv">
        	<h1>Lascia una recensione</h1><br><br>
				<form class="form" action="/SpotsApp/lasciaRecensione" method="POST">
				  <div class="form__title"><%= nome %></div>
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
     	<a href="ViewVisualizzaSpot.jsp" id="backlink" style="position:fixed;bottom:0;right:5px">Back</a>
   </body>
</html>
