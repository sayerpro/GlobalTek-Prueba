/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DetallesFactura;
import Model.Factura;
import Model.FacturaDAO;
import Model.FacturaDetallada;
import Model.ProductosDAO;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @email sayerpro.op7@gmail.com
 * @version 1.0
 * @author TheSrSmith
 * @date 04 Aug 2022
 */
public class Controller extends HttpServlet {

    Factura factura = new Factura();
    FacturaDAO facturaDAO = new FacturaDAO();
    DetallesFactura detallesFactura = new DetallesFactura();
    FacturaDetallada facturaDetallada = new FacturaDetallada();
    ProductosDAO produsctosDAO = new ProductosDAO();
    int idFactura;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String navigation = request.getParameter("navigation");
        
        /**
         * Logica principal de la navegación en el app y control de datos
         */
        if (navigation.equals("bills")) {
            switch (action) {
                case "Crear factura":
                    facturaDetallada = poblarModelos(request);
                    facturaDAO.agregarFacturas(facturaDetallada.getFactura(), facturaDetallada.getDetalles());
                    request.getRequestDispatcher("Controller?navigation=bills&action=read").forward(request, response);
                    break;
                case "read":
                    List facturas = facturaDAO.listarFacturas();
                    request.setAttribute("facturas", facturas);
                    request.getRequestDispatcher("bills.jsp").forward(request, response);
                    break;
                 case "update":
                    idFactura = convert(request.getParameter("id"));
                    FacturaDetallada facturaCompleta = facturaDAO.listarFacturas(idFactura);
                    List productos = produsctosDAO.listarProductos();             
                    request.setAttribute("productos", productos);
                    request.setAttribute("factura", facturaCompleta.getFactura());
                    request.setAttribute("detalles", facturaCompleta.getDetalles());
                    request.getRequestDispatcher("Controller?navigation=newBills&action=read").forward(request, response);
                    break;
                case "Actualizar factura":
                    facturaDetallada = poblarModelos(request);
                    facturaDAO.actualizarFacturas(facturaDetallada.getFactura(), facturaDetallada.getDetalles(), idFactura);
                    request.getRequestDispatcher("Controller?navigation=bills&action=read").forward(request, response);
                    break;
                case "delete":
                    idFactura = convert(request.getParameter("id"));
                    facturaDAO.eliminarFacturas(idFactura);
                    request.getRequestDispatcher("Controller?navigation=bills&action=read").forward(request, response);
                    break;
                default:
                    break;
            }
        }
        if (navigation.equals("newBills")) {
            if (action.equals("list")) {
                    
                List productos = produsctosDAO.listarProductos();  
                request.setAttribute("fechaActual", LocalDate.now());
                request.setAttribute("productos", productos);
            }
            request.getRequestDispatcher("newBills.jsp").forward(request, response);
        }
        if (navigation.equals("products")) {
            if (action.equals("list")) {
                List productos = produsctosDAO.listarProductos();  
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("products.jsp").forward(request, response);
            }
        }
    }
    
    /**
     * Metodo que llena los modelos
     * @param HttpServletRequest
     * @return FacturaDetallada
     */
    private FacturaDetallada poblarModelos(HttpServletRequest request) {
        int numeroFactura = convert(request.getParameter("txtnumeroFactura"));
        String fecha = request.getParameter("txtfecha");
        String tipoDePago = request.getParameter("txttipoDePago");
        String documentoCliente = request.getParameter("txtdocumentoCliente");
        String nombreCliente = request.getParameter("txtnombreCliente");
        int subTotal = convert(request.getParameter("txtsubTotal"));
        int descuento = convert(request.getParameter("txtdescuento"));
        int iva = convert(request.getParameter("txtiva"));
        
        /*Calculo de procentajes*/
        int totalDescuento = (subTotal * descuento) / 100;
        int totalImpuesto = (subTotal * iva) / 100;
        int total = (subTotal + totalImpuesto) - totalDescuento;

        int idProducto = convert(request.getParameter("txtproducto"));
        int cantidad = convert(request.getParameter("txtCantidad"));
        int precioUnitario = convert(request.getParameter("txtPrecio"));

        factura.setNumeroFactura(numeroFactura);
        factura.setFecha(fecha);
        factura.setTipoDePago(tipoDePago);
        factura.setDocumentoCliente(documentoCliente);
        factura.setNombreCliente(nombreCliente);
        factura.setSubTotal(subTotal);
        factura.setDescuento(descuento);
        factura.setIva(iva);
        factura.setTotalDescuento(totalDescuento);
        factura.setTotalImpuesto(totalImpuesto);
        factura.setTotal(total);

        detallesFactura.setIdProducto(idProducto);
        detallesFactura.setCantidad(cantidad);
        detallesFactura.setPrecioUnitario(precioUnitario);

        FacturaDetallada facturaCompleta = new FacturaDetallada();
        facturaCompleta.setFactura(factura);
        facturaCompleta.setDetalles(detallesFactura);
        return facturaCompleta;
    }
    
    /**
    * Metodo que convierte una cadena de string en un número entero
    * @param String
    * @return int
    */
    private int convert(String cadena) {
        int val = 0;
        try {
            val = Integer.parseInt(cadena);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid String");
        }
        return val;
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}