<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>FHDW-Studentenverwaltung Personen</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">

        <!-- Logo -->
        <div class="navbar-header">
            <a href="#" class="navbar-brand">FHDW-Studentenverwaltung</a>
        </div>

        <!-- Menu Items -->
        <div>
            <ul class="nav navbar-nav">
                <li><a href="http://localhost:8080/Startseite">Startseite</a></li>
                <li class="active" class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Verwaltung<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="http://localhost:8080/Studenten">Studierenden</a> </li>
                        <li><a href="http://localhost:8080/Dozenten">Dozenten</a> </li>
						<li><a href="http://localhost:8080/Personen">Personen</a></li>
						<li><a href="http://localhost:8080/Verwaltung">Verwaltung</a></li>
						<li><a href="http://localhost:8080/Kurse">Kurse</a> </li>
						<li><a href="http://localhost:8080/Module">Module</a></li>
                    </ul>
                </li>
                <li><a href="http://localhost:8080/Kontakt">Kontakt</a></li>
            </ul>

            <!--right align -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Ausloggen</a></li>
            </ul>

        </div>

    </div>
</nav>
<form action="EditDozent" method="get">
    <fieldset>
		<%= request.getParameter("lecturer")  %>
		<%= request.getParameter("persons")  %>
        <legend></legend>
		<input type="hidden" name="leid" value="${lecturer.getPeid()}">
        <select name="peid">
		<c:forEach items="${persons}" var="persons">
			<c:choose>
				<c:when test="${persons.getPeid() == lecturer.getPeid()}">
					<option value="${persons.getPeid()}" selected="selected">${persons.getFirstname()} ${persons.getLarstname()}</option>
				</c:when>    
				<c:otherwise>
					<option value="${persons.getPeid()}">${persons.getFirstname()} ${persons.getLarstname()}</</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
        </select>
        <select name="is_honouree_lecturer">
            <option value="1">Ja</option>
			<option value="0">Nein</option>
        </select>
        <input type="submit" value="submit">
    </fieldset>
</form>



</body>
</html>