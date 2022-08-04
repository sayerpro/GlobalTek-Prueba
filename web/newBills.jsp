<%-- 
    Document   : newBills
    Created on : 03-ago-2022, 8:35:53
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
        <title>Nueva factura</title>
    </head>
    <body>
        <div>
            <div class="card">
                <div class="card-body">
                    <h1>Crear nueva factura</h1>
                    <form class="row mt-3 g-3 needs validation" action="Controller?navigation=bills" method="POST">
                         <div class="form-group col-3">
                            <label class="form-label">Número de factura</label>
                            <input required type="text" placeholder="Ej: 0123" value="${factura.getNumeroFactura()}" name="txtnumeroFactura" class="form-control">
                        </div>
                        <div class="form-group col-3">
                            <label class="form-label">Fecha</label>
                            <input required placeholder="dd/mm/aaaa" type="date" min="${fechaActual}" value="${factura.getFecha()}" name="txtfecha" class="form-control">
                        </div>
                        <div class="form-group col-3">
                            <label class="form-label">Tipo de pago</label>
                            <input required type="text" placeholder="Ej: Contado" value="${factura.getTipoDePago()}" name="txttipoDePago" class="form-control">
                        </div>
                        <div class="form-group col-3">
                            <label class="form-label">Número de documento del cliente</label>
                            <input required type="text" placeholder="Ej: 0123456789" value="${factura.getDocumentoCliente()}" name="txtdocumentoCliente" class="form-control">
                        </div>
                        <div class="form-group col-3">
                            <label class="form-label">Nombre del cliente</label>
                            <input required type="text" placeholder="Ej: Global Tek" value="${factura.getNombreCliente()}" name="txtnombreCliente" class="form-control">
                        </div>
                        <div class="form-group col-3">
                            <label class="form-label" >Subtotal</label>
                            <input required type="number" placeholder="Ej: 85000" min="1" value="${factura.getSubTotal()}" name="txtsubTotal" class="form-control">
                        </div>
                        <div class="form-group col-3">
                            <label class="form-label">Descuento</label>
                            <input required type="number" placeholder="Ej: 10%" min="0" value="${factura.getDescuento()}" name="txtdescuento" class="form-control">
                        </div>
                        <div class="form-group col-3">
                            <label class="form-label">IVA</label>
                            <input required type="number" placeholder="Ej: 19%" min="0" value="${factura.getIva()}" name="txtiva" class="form-control">
                        </div>
                        <h1>Detalles</h1>
                        <div class="form-group col-3">
                            <label class="form-label">Seleccionar producto</label>
                            <select required class="form-select" aria-label="Default select example" name="txtproducto">
                                <option disabled value="" selected>Seleccione una opción</option>
                                <c:forEach var="producto" items="${productos}">
                                    <option value="${producto.getIdProducto()}">${producto.getProducto()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-3">
                            <label class="form-label">Cantidad</label>
                            <input required type="number" placeholder="Ej: 12" min="1" value="${detalles.getCantidad()}" name="txtCantidad" class="form-control">
                        </div>
                        <div class="form-group col-3">
                            <label class="form-label">Precio unitario</label>
                            <input required type="number" placeholder="Ej: 43000" min="1" value="${detalles.getPrecioUnitario()}" name="txtPrecio" class="form-control">
                            <div class="invalid-feedback">
                                El precio unitario no puede ser negativo
                            </div>
                        </div>
                        <div class="form-group col-3">
                            <div class="container px-4 text-center">
                                <div class="row gx">
                                    <div class="col">
                                        <input type="submit" name="action" value="Crear factura" class="btn btn-primary">
                                    </div>
                                    <div class="col">
                                        <input type="submit" name="action" value="Actualizar factura" class="btn btn-success">
                                    </div>
                                </div>
                          </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
    </body>
</html>