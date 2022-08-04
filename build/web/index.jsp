<%-- 
    Document   : index
    Created on : 03-ago-2022, 7:35:38
    Author     : TheSrSmith
    Email      : sayerpro.op7@gmail.com
    Version    : 1.0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shorcut icon" type="image/x-icon" href="Images/Globaltek_Icon.png";
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <title>Facturación</title>
    </head>
    <body>
        <div class="m-4">
            <img src="Images/Globaltek.png" alt="70" with="170"/>
        </div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark m-4">
        <div class="container-fluid">
            <a class="navbar-brand" href="Controller?navigation=bills&action=read" target="frame">Facturas</a>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="Controller?navigation=newBills&action=list" target="frame">Nueva factura</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="Controller?navigation=products&action=list" target="frame">Ver productos registrados</a>
                </li>
              </ul>
            </div>
        </div>
        </nav>
        <div style="height: 100%;" class="m-4">
            <iframe name="frame" style="height: 700px; width: 100%;"></iframe>
        </div>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
    </body>
</html>
