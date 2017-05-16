
<%@taglib uri="http://java.sun.com/jsp/jstl/core"prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="de">
<head>
<title>FHDW-Studentenverwaltung Studierende</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="static/main.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="static/main.js"></script>
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
				<li><a
					href="http://localhost:63342/HTML/new.html?_ijt=ti0ajrs32fvekqd8540kphhucv">Startseite</a></li>
				<li class="active" class="dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown">Verwaltung<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Studierende</a></li>
						<li><a
							href="http://localhost:63342/HTML/dozenten.html?_ijt=oj8cckts413mtjs2od612mvq0c">Dozenten</a>
						</li>
					</ul></li>
				<li><a
					href="http://localhost:63342/HTML/Kontakt.html?_ijt=ti0ajrs32fvekqd8540kphhucv">Kontakt</a></li>

				<!-- drop down menu -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Mein Profil <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Profil</a></li>
						<li><a href="#">Einstellungen</a></li>
					</ul></li>
			</ul>

			<!--right align -->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Ausloggen</a></li>
			</ul>

		</div>

	</div>
	</nav>

	<div class="form-group pull-right">
		<input type="text" class="search form-control"
			placeholder="What you looking for?">
	</div>
	<span class="counter pull-right"></span>
	<table class="table table-hover table-bordered results">
		<thead>
			<tr>
				<th>#</th>
				<th class="col-md-5 col-xs-5">Name / Nachname</th>
				<th class="col-md-4 col-xs-4">Kurs</th>
				<th class="col-md-3 col-xs-3">Matrikelnr</th>
			</tr>
			<tr class="warning no-result">
				<td colspan="4"><i class="fa fa-warning"></i> No result</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${student}" > 
			<tr>
				<td>
			 		<c:out value="${student.zahl}"/>
			  	</td>
			  	<td > 
			 		<c:out value="${student.name}"/>
			  	</td>
			</tr>
			</c:forEach>  
			</tbody>
	</table>

	</div>


</body>
</html>