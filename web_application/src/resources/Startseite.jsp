<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>

</head>
<body>
	<h1>Meine erste JSP</h1>

	<%
		// beliebiger Java-Code ...
		out.println("Hallo");
	%>
	<%=request.getParameter("name")%>

	<form role="form" method="GET" action="http://localhost:8080/Studierenden">
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary btn-block">Studierenden</button>
		</div>
	</form>

	<form role="form" method="GET" action="http://localhost:8080/Dozenten">
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary btn-block">Dozenten</button>
		</div>
	</form>
</body>
</html>
