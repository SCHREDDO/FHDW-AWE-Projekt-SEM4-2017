 <%@ page import="java.util.Date, java.text.DateFormat" %>
<html>
  <body>
    <%
	  String date = DateFormat.getDateInstance().format(new Date());
	  String time = DateFormat.getTimeInstance().format(new Date());
    %>
    
    Es ist <%= time %> am <%= date %>

  </body>
</html>