<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>FHDW-Studentenverwaltung</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <h3>FHDW - Studentenverwaltung</h3>

    <!-- data-toggle lets you display modal without any JavaScript -->
    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#popUpWindow">Anmelden</button>

    <div class="modal fade" id="popUpWindow">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- header -->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h3 class="modal-title">Log In</h3>
                </div>

                <!-- body (form) -->
                <div class="modal-body">
                    <form role="form" method="GET" action="http://localhost:8080/Startseite">
                        <div class="form-group">
                            <input type="email" name="name"  class="form-control" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <input name="pass" type="password" class="form-control" placeholder="Password">
                        </div>
                        
                                        <div class="modal-footer">
                    <button type="submit" class="btn btn-primary btn-block">Anmelden</button>
                </div>
                    </form>
                </div>

                <!-- button -->


            </div>
        </div>
    </div>

</div>

</body>
</html>