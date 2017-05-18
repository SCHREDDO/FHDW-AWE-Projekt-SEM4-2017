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
<form action="EditStudenten" method="get">
    <fieldset>
		<%= request.getParameter("permission")  %>
		<%= request.getParameter("person")  %>
        <legend></legend>
        <label for="fistname">First Name</label>
        <input type="text" name="firstname" value="{person.getFirstname()}"/> <br/>
        <label for="lastname">Last Name</label>
        <input type="text" name="lastname" value="{person.getLastname()}"/> <br/>
		<label for="lastname">Kurzel</label>
        <input type="text" name="shortname" value="{person.getShortname()}"/> <br/>
		 <label for="email">Password</label>
        <input type="text" name="password" value="{person.getPassword()}"/> <br/>
        <label for="email">Email</label>
        <input type="text" name="e_mail" value="{person.getE_mail()}"/> <br/>
		<label for="email">Addresse</label>
        <input type="text" name="address" value="{person.getAddress()}"/> <br/>
		<label for="email">Telephon</label>
        <input type="text" name="phone_number " value="{person.getPhone_number()}"/> <br/>
        <select name="pid">
		c:forEach items="${permission}" var="permission">
			<c:choose>
				<c:when test="${permission.getRiid() == person.getRight().getRiid()}">
					<option value="${permission.getRiid()}" selected="selected">${permission.getName()}</</option>
				</c:when>    
				<c:otherwise>
					<option value="${permission.getRiid()}">${permission.getName()}</</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
        </select>
        <input type="submit" value="submit">
    </fieldset>
</form>



</body>
</html>