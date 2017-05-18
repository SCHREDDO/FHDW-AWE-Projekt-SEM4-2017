<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>FHDW-Studentenverwaltung Dozent</title>
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
                        <li><a href="http://localhost:8080/Studenten">Studierende</a> </li>
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
<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


    <div class="panel panel-info">
        <div class="panel-heading">
            <!-- GET name -->
			<%= request.getParameter("lecturer")  %>
            <h3 class="panel-title">${lecturer.getFirstname()} ${lecturer.getLarstname}</h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="" class="img-circle img-responsive"> </div>

                <div class=" col-md-9 col-lg-9 ">
                    <table class="table table-user-information">
                        <tbody>
                        <tr>
                            <td>Kürzel:</td>
                            <td>${lecturer.getShort()}</td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td>${lecturer.getE_mail()}</td>
                        </tr>
                        <tr>
                            <td>Addresse:</td>
                            <td>${lecturer.getAddress()}</td>
                        </tr>
                        <tr>
                        <tr>
                            <td>Telephone:</td>
                            <td>${lecturer.getPhone_number()}</td>
                        </tr>
						<tr>
                            <td>Honorardozent:</td>
                            <td>${lecturer.getIs_honouree_lecturer()}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>



</body>
</html>