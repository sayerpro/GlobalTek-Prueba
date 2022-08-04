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
public class FacturaDetallada {
    
    DetallesFactura detalles;
    Factura factura;

    public FacturaDetallada() {
    }

    public FacturaDetallada(DetallesFactura detalles, Factura factura) {
        this.detalles = detalles;
        this.factura = factura;
    }

    public DetallesFactura getDetalles() {
        return detalles;
    }

    public void setDetalles(DetallesFactura detalles) {
        this.detalles = detalles;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}