<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>
<%@ page import="model.Recensione" %>
<%@ page import="java.io.*" %>
<%@ page import="mockDatabase.MockDB" %>
<%@ page import="java.text.DecimalFormat" %>

<html>
   <head>
	<!--	<meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/>   -->
	

      <title></title>
		<link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link>
		<script type="text/javascript" src="/SpotsApp/scripts/visualizzaspot.js"></script>
			<%
		String idSpot = (String) session.getAttribute("idSpot");
   		System.out.println(idSpot);
		String nome="";String indirizzo="";String descrizione="";
		double punteggioTemp = 0;
		double punteggio = 0;
		
		int presenzeSegnalate = 0;
		List<Recensione> recensioni = new ArrayList<>();
		List<Attivita> attivita = new ArrayList<>();
		List<File> immagini = new ArrayList<>();
		MockDB db = MockDB.getInstance();
		List<Spot> spots = db.getSpots();
		for(Spot s : spots)
		{
			if(idSpot.equals(s.getId()))
			{
				nome = s.getNome();
				indirizzo = s.getIndirizzo();
				presenzeSegnalate = s.getPresenzeSegnalate();
				attivita = s.getAttivita();
				immagini = s.getImmagini();
				descrizione=s.getDescrizione();
				
				if(s.getRecensioni().size()>0)
				{
					recensioni = s.getRecensioni();
					for (Recensione r: recensioni)
					{
						punteggioTemp += r.getValutazione();
					}
					punteggioTemp = punteggioTemp / recensioni.size();
					punteggio = (int)(Math.round(punteggioTemp * 10)) / 10.0;
				}
			}
			
		}
	
	%>
   </head>
   <body onload="showSlides(1)">
   		<div>
				<img src="/SpotsApp/images/LogoSmall.png" align="left"/>
				<img src="/SpotsApp/images/Icon.png" align="right"/>
		</div>
   
   
   		
   		<div class="floatContainervisualizza" >
   		<h1><%= nome %></h1>
	   		<div class="container" >
		   		<%
		   		for(int i =0;i<immagini.size();i++ )
		   		{
		   			System.out.println(immagini.get(i).getPath());
		   			System.out.println(immagini.get(i).getPath().replace('\\', '/'));
		   			%>
		   			<div class="mySlides">
					    <div class="numbertext"><%= i+1 %> / <%= immagini.size() %></div>
					      <img class="slideImg" src=<%= immagini.get(i).getPath().replace('\\', '/')  %> />
					</div>
		   			
		   			<%
		   		}
		   		
		   		%>
		   		<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
	 			<a class="next" onclick="plusSlides(1)">&#10095;</a>
		   		
	    	</div>
	    	
	    	
	    	<div class = "InfoSpot">
	    	
	    		<div class= "punteggio" >
	    			
	    			<span><%= punteggio %> &#11088;</span>
	    			
	    		</div>
	    		<div class= "descrizione" >
	    		<label> Descrizione:</label>
	    			<p class = infospottext><%= descrizione %></p>	
	    				
	    		</div>
	    		
	    		<div>
	    			<label> Presenze segnalate: </label>
	    			<p class = "infospottext"><%= presenzeSegnalate %></p>
	    		</div>
	    			<label> Affluenza </label>
	    		<div>
	    			
	    		</div>
	    		
	    		<div class ="bottoni">
	    			<form action="/SpotsApp/visualizzaSpot" method="get">
				     	<input type="submit" name="segnalapresenza" value="Segnala presenza" >
					    <input type="submit" name="lasciarecensione" value="Lascia Recensione" >
					  	<input type="submit" name="segnalaspot" value="Segnala Spot" >
					  	<input type="submit" name="aggiungipreferiti" value="&#128150;" >
					  	<input type="submit" name="backhome" id="home" value="Home" >
				 	</form>
	    		
	    		</div>
	    	
	    	
	    	</div>
    	</div>
    	
    	<div class="recensioni">
    			<form action="/SpotsApp/visualizzaSpot" method="get">
		    	 	<ol>
			    	 	<%
			    	 	for(Recensione r : recensioni)
			    	 	{
			    	 		
			    	 		
			    	 		%>
			    	 		<li>
			    	 			<div style="padding:20px">
				    	 			<% for(int i=0;i<r.getValutazione();i++)
				    	 				{
				    	 					%> 
				    	 						<span>&#11088;</span>
				    	 					<%
				    	 				}
				    	 				%><br>
				    	 			<h3><%= r.getTitolo() %></h3>
				    	 			<div id="descrizionne"><%= r.getDescrizione() %></div>
				    	 			<input hidden="true" name="idRecensione" value=<%= r.getId() %> />
				    	 			<input type="submit"  name="segnalarecensione" value="Segnala" />
				    	 		</div>
			    	 		</li>
			    	 		<%
			    	 	}
			    	 	%>
		    	 	</ol>
	   			</form>
    	
    	</div>
   </body>
</html>
