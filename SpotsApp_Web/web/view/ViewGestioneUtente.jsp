<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>

<html>
   <head>
	<!--	<meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/>   -->
      <title>GestioneUtente</title>
		<link type="text/css" href="${pageContext.request.contextPath}/styles/homeutente.css" rel="stylesheet"></link>
		<script type="text/javascript" src="scripts/GestioneUtente.js"></script>
		<script type="text/javascript" src="scripts/utils.js"></script>
   </head>
   <body>
   
   	<% if(session.getAttribute("currentUser")!=null)
   	{
	%>
		<div>
				<img src="/SpotsApp/images/LogoSmall.png" align="left"/>
				<img src="/SpotsApp/images/Icon.png" align="right"/>
		</div>
		<h1>HOME UTENTE</h1><br><br>
		<div class="floatContainer">
	   		<div class="home" align="center">
		   		<div class="formdiv" >
			      <form class="form" action="/SpotsApp/gestioneUtente" method="post">
				  <div class="form__title">Cerca Spot</div>
				  <p class="form__desc">
				  Inserisci i criteri di ricerca dello spot</p>
				  <div class="form__item">
				  		<label for="indirizzo" class="form_label">Indirizzo</label>
			   			<input type="text" class="form_input" name="indirizzo" id="indirizzo" size="40" placeholder="Via..."/>
				  </div>
				  <div class="form__item">
				   		<label class="form_label" for="attivita" >Attivita </label>
						<select name="attivita">
			      		<option value="" >Attivita</option>
			      			<%
			      			for(Attivita a : Attivita.values())
			      			{
			      				%>
			      				<option value=<%= a.name() %>><%= a.name() %></option>
			      				<%
			      			}
			      			%>
			      		</select>
				  </div>
				  <div class="form__item">
				    <button class="form__btn" type="submit" name="cercaspot">Cerca Spot</button>
				  </div>
				</form>	
				</div>        
		<div style="padding:40px">
		 	<form action="/SpotsApp/gestioneUtente" method="get">
			    <input type="submit" name="visualizzaprofilo" value="Visualizza Profilo" >
			  	<input type="submit" name="aggiungispot" value="Aggiungi Spot" >
		 	</form>
	     </div>		
		     	
	    	</div>
	     
		     <%
		     if(session.getAttribute("listaSpot") != null)
		     {
		    	 %>
		    	 <div class="spotResults">
			    	 <form action="/SpotsApp/gestioneUtente" method="get">
			    	 	<ol id="listaspot">
			    	 	<%
			    	 	List<Spot> listaSpot = (List<Spot>) session.getAttribute("listaSpot");
			    	 	for(Spot s : listaSpot)
			    	 	{
			    	 		System.out.println(s.getId());
			    	 		String img = s.getImmagini().get(0).getPath().replace('\\', '/');
			    	 		%>
			    	 		<li >
			    	 			<div class="listspotItem" >
				    	 			<h3><%= s.getNome() %></h3>
				    	 			<br>
				    	 			<img class="spotListImg" src=<%= img %> /><p><%= s.getIndirizzo() %></p>
				    	 			<button type="submit"  value=<%= s.getId() %> name="visualizzaspot" >Visualizza Spot</button>
			    	 			</div>
			    	 		</li>
			    	 		<br>
			    	 		<%
			    	 	}
			    	 	%>
			    	 	</ol>
			    	 </form>
		    	 </div>

		    	 <%
		     }
		     %>
	     </div>
	     
	     
    
	
	
	<%
   	} 
   	else{
   		%><h1>SESSIONE NON VALIDA</h1> <%
   	}
	%>
   	
   </body>
</html>

