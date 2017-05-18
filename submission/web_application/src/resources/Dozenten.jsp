<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>FHDW-Studentenverwaltung Dozenten</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="../js/main.js"></script>
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

<c:choose>
	<c:when test="${rpid == 2}">
<form action="http://localhost:8080/Dozenten/Create" method="get">
    <fieldset>
		<%= request.getParameter("persons")  %>
        <legend></legend>
        <select name="peid">
		<c:forEach items="${persons}" var="persons">
			<option value="${persons.getPeid()}">${persons.getFirstname()} ${persons.getLarstname()}</option>
		</c:forEach>
        </select>
        <select name="is_honouree_lecturer">
            <option value="1">Ja</option>
			<option value="0">Nein</option>
        </select>
        <input type="submit" value="submit">
    </fieldset>
</form>
	</c:when>
</c:choose>
<div class="form-group pull-right">
    <input type="text" class="search form-control" placeholder="What you looking for?">
</div>
<span class="counter pull-right"></span>
<table class="table table-hover table-bordered results">
    <thead>
    <tr>
        <th>#</th>
        <th class="col-md-3 col-xs-3">Name / Nachname</th>
        <th class="col-md-3 col-xs-3">Kürzel</th>
        <th class="col-md-3 col-xs-3">Hunoradotzent</th>
		<th class="col-md-3 col-xs-3"></th>
		<th class="col-md-3 col-xs-3"></th>
		<th class="col-md-3 col-xs-3"></th>
		
    </tr>
    <tr class="warning no-result">
        <td colspan="4"><i class="fa fa-warning"></i> No result</td>
    </tr>
    </thead>
    <tbody>
    
    <%= request.getParameter("lecturers")  %>
    
    <c:forEach items="${lecturers}" var="lecturers">
    	<tr>
    		<th scope="row"><a href="http://localhost:8080/Dozenten/Show?leid=${lecturers.getLeid()}">${lecturers.getLeid()}</a></th>
    		<td>${lecturers.getFirstname()} ${students.getLarstname()}</td> 
	        <td>${lecturers.getShortname()}</td>
	        <td>${lecturers.getIs_honouree_lecturer()}</td>
	        <td><a href="http://localhost:8080/Dozenten/Edit?leid=${lecturers.leid}" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a></td>
    		<td><a href="http://localhost:8080/Dozenten/Delete?leid=${lecturers.leid}" data-original-title="Delete this user" data-toggle="tooltip" type="button" class="confirm-delete btn mini red-stripe"><i class="glyphicon glyphicon-edit"></i></a></td>
    	
    	</tr>
	</c:forEach>
	
    </tbody>
</table>

</div>


</body>
</html>