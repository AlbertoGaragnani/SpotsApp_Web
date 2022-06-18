<%@ page session="true"%>
<html>
   <head>
        <meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/>
      <title>SpotsApp Login</title>
        <link type="text/css" href="styles/default.css" rel="stylesheet"></link>
   </head>
   <body>

     <form action="Login" method="post">
     	<p>User:</p>
        <input type="text" name="userName" size="30"/><br>
        <p>Password:</p>
        <input type="password" name="pwd" size="30"/><br><br>
        <input type="submit" value="Log In"/>
     </form>

     <div>Non sei ancora registrato? <a href="Registrazione.jsp">Clicca Qui!</a></div>


     <% if (session.getAttribute("currentUser")!=null)
     {%>
         <div>
         Benvenuto <%= session.getAttribute("currentUser") %>
         </div>

     <% } %>
	<% if (session.getAttribute("Errore")!=null && session.getAttribute("Errore").equals("Errore"))
     {%>
         <div> Errore di login ! </div>
     <% }%>
   </body>
</html>

