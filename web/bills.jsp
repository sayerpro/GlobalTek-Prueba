<%-- 
    Document   : inicio
    Created on : 03-ago-2022, 7:37:05
    Author     : TheSrSmith
    Email      : sayerpro.op7@gmail.com
    Version    : 1.0
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <title>Facturas</title>
    </head>
    <body>
        <div class="m-4">
            <h3>Aqui podras ver todas las facturas registradas</h3>
            <table class="table table-hover">
                <thead>
                    <tr class="table-dark">
                        <th>Fecha</th>
                        <th>Número de factura</th>
                        <th>Nombre del cliente</th>
                        <th>Total</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="factura" items="${facturas}">
                        <tr>
                            <td class="table-secondary">${factura.getFecha()}</td>
                            <td class="table-secondary">${factura.getNumeroFactura()}</td>
                            <td class="table-secondary">${factura.getNombreCliente()}</td>
                            <td class="table-secondary">${factura.getTotal()}</td>
                            <td class="table-secondary">
                                <a class="btn btn-warning" href="Controller?navigation=bills&action=update&id=${factura.getIdFactura()}">Editar</a>
                                <a class="btn btn-danger" href="Controller?navigation=bills&action=delete&id=${factura.getIdFactura()}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table
        </div>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
    </body>
</html>