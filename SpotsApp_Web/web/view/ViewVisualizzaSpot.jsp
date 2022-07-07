<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>
<%@ page import="model.Permanenza" %>
<%@ page import="model.Recensione" %>
<%@ page import="java.io.*" %>
<%@ page import="mockDatabase.MockDB" %>
<%@ page import="java.text.DecimalFormat" %>

<html>
   <head>
	<!--	<meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/>   -->
	

      <title></title>
		<link type="text/css" href="${pageContext.request.contextPath}/styles/stile.css" rel="stylesheet"></link>
		<link type="text/css" href="${pageContext.request.contextPath}/styles/chart.css" rel="stylesheet"></link>
		<script type="text/javascript" src="/SpotsApp/scripts/visualizzaspot.js"></script>
			<%
		String idSpot = (String) session.getAttribute("idSpot");
   		System.out.println(idSpot);
		String nome="";String indirizzo="";String descrizione="";
		double punteggioTemp = 0;
		double punteggio = 0;
		
		int presenzeSegnalate = 0;
		double affluenzaMattina = 0;
		double affluenzaPomeriggio = 0;
		double affluenzaSera = 0;
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
						for(Permanenza p : r.getPermanenza())
						{
							if(p == Permanenza.MATTINA)
								affluenzaMattina++;
							else if(p == Permanenza.POMERIGGIO)
								affluenzaPomeriggio++;
							else
								affluenzaSera++;
						}
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
	 			<%
	    		if(session.getAttribute("aggiunto") != null)
	    		{
	    			%>
	    			<div>
	    				<p>Lo spot è stato aggiunto ai preferiti</p>
	    			</div>
	    			<%
	    			session.removeAttribute("aggiunto");
	    		}
	    		%>
		   		
	    	</div>
	    	
	    	
	    	<div class = "InfoSpot">
	    	
	    		<div class= "punteggio" >
	    			
	    			<span><%= punteggio %> &#11088;</span><br>
	    			
	    		</div>
	    		<div class= "descrizione" >
	    		<label> Descrizione:</label><br>
	    			<p class = infospottext><%= descrizione %></p>		    				
	    		</div>
	    		<div class= "descrizione" >
	    		<label> Indirizzo:</label><p class = infospottext><%= indirizzo %></p>		    				
	    		</div>
	    		
	    		<div>
	    			<label> Presenze:</label><p class = "infospotpresenze"><%=presenzeSegnalate%></p>
	    		</div>
	    		
	    		<%
	    		//Logica per calcolo affluenza
	    		double totAffluenza = affluenzaMattina + affluenzaPomeriggio + affluenzaSera;
	    		double percMAT = affluenzaMattina / totAffluenza * 100;
	    		percMAT = (int)(Math.round(percMAT * 100)) / 100.0;
	    		double percPOM = affluenzaPomeriggio / totAffluenza * 100;
	    		percPOM = (int)(Math.round(percPOM * 100)) / 100.0;
	    		double percSER = affluenzaSera / totAffluenza * 100;
	    		percSER = (int)(Math.round(percSER * 100)) / 100.0;
	    		int mattina = (int) percMAT;
	    		int pomeriggio = (int) percPOM;
	    		int sera = (int) percSER;
	    		System.out.println("Mat: " + mattina + " POm: " + pomeriggio + "Sera: " +sera);
	    		%>
	    		
	    		<div>
		    		<dl>
						  <dt>
						   		Affluenza
						  </dt>
						  <dd class="percentage percentage-<%=mattina%>"><span class="text">MATTINA <%=percMAT%>%</span></dd><br>
						  <dd class="percentage percentage-<%=pomeriggio%>"><span class="text">POME <%=percPOM%>%</span></dd><br>
						  <dd class="percentage percentage-<%=sera%>"><span class="text">SERA <%=percSER%>%</span></dd>
					</dl>
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
