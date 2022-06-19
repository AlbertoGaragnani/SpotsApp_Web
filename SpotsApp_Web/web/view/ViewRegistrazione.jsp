<%@ page session="true"%>
<html>
   <head>
      <title>SpotsApp Registration</title>
		<link type="text/css" href="styles/default.css" rel="stylesheet"></link>
   </head>
   <body>

     <form action="/SpotsApp/registrazione" method="post">
      		<p>User:</p>
      		<input type="text" name="userName" size="30"/><br>
      		<p>email:</p>
      		<input type="text" name="email" size="30"/><br><br>
      		<p>Password:</p>
      		<input type="password" name="pwd" size="30"/><br><br>
      		<p>Conferma Password:</p>
      		<input type="password" name="pwdconfirm" size="30"/><br><br>
      		<input type="submit" value="Register"/>
      	</form>
      	
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
      	
      		



   </body>
</html>

