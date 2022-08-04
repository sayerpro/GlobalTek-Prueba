/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @email sayerpro.op7@gmail.com
 * @version 1.0
 * @author TheSrSmith
 * @date 04 Aug 2022
 */
public class Factura {
    
    /**
     * Modelo de datos que hace refencia en su estructura a una tabla en DB(Database) nombrada 'Facturas'
     */
    int idFactura;
    int numeroFactura;
    String fecha;
    String tipoDePago;
    String documentoCliente;
    String nombreCliente;
    int subTotal;
    int descuento;
    int iva;
    int totalDescuento;
    int totalImpuesto;
    int total;
    
    public Factura () {
        
    }

    public Factura(int idFactura, int numeroFactura, String fecha, String tipoDePago, String documentoCliente, String nombreCliente, int subTotal, int descuento, int iva, int totalDescuento, int totalImpuesto, int total) {
        this.idFactura = idFactura;
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.tipoDePago = tipoDePago;
        this.documentoCliente = documentoCliente;
        this.nombreCliente = nombreCliente;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.iva = iva;
        this.totalDescuento = totalDescuento;
        this.totalImpuesto = totalImpuesto;
        this.total = total;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(int totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public int getTotalImpuesto() {
        return totalImpuesto;
    }

    public void setTotalImpuesto(int totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
