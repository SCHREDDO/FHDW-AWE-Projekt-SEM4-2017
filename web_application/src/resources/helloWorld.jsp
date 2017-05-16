<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title> Hello World JSP </title>
  </head>
  <body>
    <h1> Meine erste JSP </h1>
    
    <img src="static/fhdw.jpg" />
    <%
      // beliebiger Java-Code ...
      out.println( "Hallo" );
    %>
    <%= request.getParameter("name")  %>
    <form role="form" method="GET" action="http://localhost:8080/Startseite">
                     <div class="form-group">
                         <input name="name" value="test@mail.de" type="email" class="form-control" placeholder="Email">
                     </div>
                     <div class="form-group">
                         <input name="pass" value="test" type="password" class="form-control" placeholder="Password">
                     </div>
                     
                     <button type="submit" class="btn btn-primary btn-block" >Anmelden</button>
                 </form>
  </body>
</html>