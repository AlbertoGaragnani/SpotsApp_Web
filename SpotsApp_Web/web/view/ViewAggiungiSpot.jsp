<%@ page session="true"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Attivita" %>
<%@ page import="model.Spot" %>

<html>
   <head>
      <title>AggiungiSpot</title>
      <link type="text/css" href="${pageContext.request.contextPath}/styles/aggiungispot.css" rel="stylesheet"></link>
   </head>
   <body>
           <div>
			<img src="/SpotsApp/images/LogoSmall.png" align="left"/>
			<img src="/SpotsApp/images/Icon.png" align="right"/>
		</div>
           <div>
           
	           <div class="formdiv">
	        	<h1>Aggiungi Spot</h1><br><br>
					<form class="form" action="/SpotsApp/aggiungiSpot" method="post" enctype="multipart/form-data">
					  <div class="form__title">Inserisci i campi del nuovo spot</div>
					  
					  <div class="form__item">
					    <label for="nomeSpot" class="form__label">Nome</label>
					    <input type="text" class="form__input" name="nomeSpot" id="nomeSpot" placeholder="Inserisci nome Spot">
					  </div>
					  
					  <div class="form__item">
					    <label for="indirizzoSpot" class="form__label">Indirizzo</label>
					    <input type="text" class="form__input" name="indirizzoSpot" id="indirizzoSpot" placeholder="Via...">
					  </div>
					  
					  <div class="form__item">
					    <label for="activities" class="form__label">Attivit�</label>
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
					    <span class="form__error">A sample error message</span>
					  </div>
					  
					  <div class="form__item">
					    <label for="descrizione" class="form__label">Descrizione</label>
					    <textarea maxlength="500" class="form__input" name="descrizione" id="descrizione" placeholder="Inserisci una descrizione dello Spot (Max. 500 chars)"></textarea>
					  </div>
					  
					  <div class="form__item">
					    <label for="file" class="form__label">Inserisci foto</label>
					    <input type="file" class = "form_input" name="file" value="image" multiple />
					  </div>
					  
					  <div class="form__item">
					    <button class="form__btn" type="submit" name="conferma">Conferma</button>
					  </div>
					</form>	         	  
	         </div>
	           
	           
           
           
         <!--       <p>Inserisci i dati dello Spot</p>
               <form action="/SpotsApp/aggiungiSpot" method="post" enctype="multipart/form-data">
                   <label>Nome <input type="text" name="nomeSpot"/></label><br>
                   <label>Indirizzo <input type="text" name="indirizzoSpot"/></label><br>
                   <label>Attivit�
	                   <select name="activities" multiple="multiple">
	                   <%
	              //     Attivita[] activities = Attivita.values();
	               //    for(Attivita a : activities)
	                   {
	                   %>
	                //   		
	                   <%
	                   }
	                   %>
	                   </select>
                   </label><br>
				   <label>Descrizione <textarea name="descrizione" rows="8" cols="8">Inserire una breve descrizione dello spot</textarea></label><br>
                   <label>Carica foto <input type="file" name="file" value="image" multiple/></label><br>
                   <input type="submit" value="Conferma" ><br>
                 
         </form>  -->
     </div>
     
     <% 
	
	if (session.getAttribute("Errore")!=null && session.getAttribute("Errore").equals("ErroreForm"))
    {
     	%>
        <div> Il form di aggiunta dello spot non � stato compilato correttamente ! </div>
     	<% 
     	session.removeAttribute("Errore");
    }
	
	if(session.getAttribute("Errore")!=null && session.getAttribute("Errore").equals("ErroreSpot"))
  	{
  		%>
		<div> Lo spot che hai cercato di inserire � gi� presente nel dataBase!</div>
		<%
		session.removeAttribute("RegistrazioneOK");
  	}
	
     %>
   </body>
</html>
