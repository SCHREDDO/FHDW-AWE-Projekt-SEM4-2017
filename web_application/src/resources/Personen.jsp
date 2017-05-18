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

                <!-- drop down menu -->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mein Profil <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Profil</a></li>
                        <li><a href="#">Einstellungen</a></li>
                    </ul>
                </li>
            </ul>

            <!--right align -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Ausloggen</a></li>
            </ul>

        </div>

    </div>
</nav>
<form action="createPerson.jsp" method="get">
    <fieldset>
        <%= request.getParameter("permissions")  %>
        <legend></legend>
        <label for="fistname">First Name</label>
        <input type="text" name="firstname"/> <br/>
        <label for="lastname">Last Name</label>
        <input type="text" name="lastname"/> <br/>
		<label for="shortname">Kurzel</label>
        <input type="text" name="shortname"/> <br/>
		 <label for="password">Password</label>
        <input type="text" name="password"/> <br/>
        <label for="e_mail">Email</label>
        <input type="text" name="e_mail"/> <br/>
		<label for="address">Addresse</label>
        <input type="text" name="address"/> <br/>
		<label for="phone_number">Telephon</label>
        <input type="text" name="phone_number"/> <br/>
        <select name="pid">
		c:forEach items="${permissions}" var="permissions">
			<option value="${permissions.getRiid()}" >${permissions.getName()}</</option>
		</c:forEach>
        </select>
        <input type="submit" value="submit">
    </fieldset>
</form>
<div class="form-group pull-right">
    <input type="text" class="search form-control" placeholder="What you looking for?">
</div>
<span class="counter pull-right"></span>
<table class="table table-hover table-bordered results">
    <thead>
    <tr>
        <th>#</th>
        <th class="col-md-3 col-xs-3">Name / Nachname</th>
		<th class="col-md-3 col-xs-3">Kurzel</th>
        <th class="col-md-3 col-xs-3">Adresse</th>
        <th class="col-md-3 col-xs-3">Email</th>
    </tr>
    <tr class="warning no-result">
        <td colspan="4"><i class="fa fa-warning"></i> No result</td>
    </tr>
    </thead>
    <tbody>
    
    <%= request.getParameter("persons")  %>
    <c:forEach items="${persons}" var="persons">
    	<tr>
    		<th scope="row">${persons.getStid()}</th>      
	        <td>${persons.getFirstname()} ${persons.getLarstname()}</td>
	        <td>${persons.getShortname()}</td>
	        <td>${persons.getAdress()}</td>
			<td>${persons.getE_mail()}</td>
			<td><a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a></td>
			<!--<td>Buttons Edit / Delete</td>-->
    	</tr>
	</c:forEach>
    
    </tbody>
</table>

</div>


</body>
</html>