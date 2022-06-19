<%@ page session="true"%>
<html>
   <head>
      <title>SpotsApp Login</title>
        <link type="text/css" href="styles/default.css" rel="stylesheet"></link>
   </head>
   <body>

     <form action="/SpotsApp/login" method="post">
     	<p>User:</p>
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
        <p>Password:</p>
        <input type="password" name="pwd" size="30"/><br><br>
        <input type="submit" value="Log In"/>
     </form>

     <div>Non sei ancora registrato? <a href="view/ViewRegistrazione.jsp">Clicca Qui!</a></div>

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

