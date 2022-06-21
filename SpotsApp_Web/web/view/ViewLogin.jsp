<%@ page session="true"%>
<html>
   <head>
      <title>SpotsApp Login</title>
        <link type="text/css" href="/SpotsApp/styles/stile.css" rel="stylesheet"></link>
   </head>
   <body>
		<div>
			<div>
				<img src="/SpotsApp/images/LogoSmall.png" align="left"/>
				<img src="/SpotsApp/images/Icon.png" align="right"/>
			</div>
			
			<br/>
			
			<div align="center">
			<h1>AUTENTICAZIONE</h1>
			<br/>
		     <form action="/SpotsApp/login" method="post">
		     	<label>Username: </label>
		     	<%
		     	if(session.getAttribute("RegistrazioneOK") != null)
		     	{
		     		%>
		            <input type="text" name="userName" value=<%= (String)session.getAttribute("RegistrazioneOK") %> size="30"/><br>
		         	<% 
		     	}
		     	else
		     	{
		     		%>
		            <input type="text" name="userName" size="30"/><br>
		         	<% 
		     	}
		     	%>
		     	
		     	<br>
		        <label>Password: </label>
		        <input type="password" name="pwd" size="30"/>
		        
		        <br><br><br>
		        <input id="plsgo" type="submit" value="Log In"/>
		     </form>
		     </div>
		
		     <div id="link" align="center">Non sei ancora registrato? <a href="/SpotsApp/view/ViewRegistrazione.jsp">Clicca Qui!</a></div>
		</div>
	<% 
	
	if (session.getAttribute("Errore")!=null && session.getAttribute("Errore").equals("Errore"))
    {
     	%>
        <div> Errore di login ! </div>
     	<% 
     	session.removeAttribute("Errore");
    }
	
	if(session.getAttribute("RegistrazioneOK") != null)
  	{
  		%>
		<div>Registrazione avvenuta con successo!</div>
		<%
		session.removeAttribute("RegistrazioneOK");
  	}
	
     %>
   </body>
</html>

