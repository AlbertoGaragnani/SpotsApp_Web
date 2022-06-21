<%@ page session="true"%>
<html>
   <head>
      <title>SpotsApp Registration</title>
		<link type="text/css" href="/SpotsApp/styles/stile.css" rel="stylesheet"></link>
   </head>
   <body>
   
   			<div>
				<img src="/SpotsApp/images/LogoSmall.png" align="left"/>
				<img src="/SpotsApp/images/Icon.png" align="right"/>
			</div>
			<br>
	<div align="center">
			<h1>REGISTRAZIONE</h1>
			<br/>
     <form action="/SpotsApp/registrazione" method="post">
      		<label>Email: </label>
      		<input type="text" name="email" size="30"/><br><br>
      		<label>Username: </label>
      		<input type="text" name="Username" size="30"/><br><br>
      		<label>Password: </label>
      		<input type="password" name="pwd" size="30"/><br><br>
      		<label>Conferma pw: </label>
      		<input type="password" name="pwdconfirm" size="30"/><br><br>
      		<input type="submit" value="Register"/>
      </form>
      
      </div>
      	
      	<%
      	
      	if(session.getAttribute("Errore") != null)
      	{
      		if(session.getAttribute("Errore").equals("ErroreMail"))
      		{
      			%>
      			<div>Errore registrazione: la mail deve contenere "@"</div>
      			<% 	
      		}
      		if(session.getAttribute("Errore").equals("ErroreLunghezza"))
      		{
      			%>
      			<div>Errore registrazione: Le credenziali devono essere di massimo 32 caratteri </div>
      			<%
      		}
      		if(session.getAttribute("Errore").equals("ErroreGiaPresente"))
      		{
      			%>
      			<div>Errore registrazione: L'username scelto è gia presente nel database </div>
      			<%
      		}
      		if(session.getAttribute("Errore").equals("ErroreParametri"))
      		{
      			%>
      			<div>Errore registrazione: I parametri del form non sono stati inseriti correttamente </div>
      			<%
      		}
      		if(session.getAttribute("Errore").equals("ErrorePassword"))
      		{
      			%>
      			<div>Errore registrazione: Le due password devono essere uguali </div>
      			<%
      		}
      		
      		session.removeAttribute("Errore");
      	}      	
      	
      	%>
      	
      		
		<div id="link" align="center">Hai già un account? <a href="/SpotsApp/view/ViewLogin.jsp">Clicca Qui!</a></div>


   </body>
</html>

