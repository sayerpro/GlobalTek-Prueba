/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Configuration.Conection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @email sayerpro.op7@gmail.com
 * @version 1.0
 * @author TheSrSmith
 * @date 04 Aug 2022
 */
public class FacturaDAO {
    
    Conection cn = new Conection();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int response;
     
    /**
     * Metodo que consume una tabla en base de datos para traer información de una tabla en especifica
     * @return List
     */
    public List listarFacturas() {
        String sql = "select * from Facturas";
        List<Factura> facturas = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Factura bill = new Factura();
                bill.setIdFactura(rs.getInt(1));
                bill.setNumeroFactura(rs.getInt(2));
                bill.setFecha(rs.getString(3));
                bill.setTipoDePago(rs.getString(4));
                bill.setDocumentoCliente(rs.getString(5));
                bill.setNombreCliente(rs.getString(6));
                bill.setSubTotal(rs.getInt(7));
                bill.setDescuento(rs.getInt(8));
                bill.setIva(rs.getInt(9));
                bill.setTotalDescuento(rs.getInt(10));
                bill.setTotalImpuesto(rs.getInt(11));
                bill.setTotal(rs.getInt(12));
                
                facturas.add(bill);
            }
        } catch (SQLException e) {
            System.out.println("Model.FacturaDAO.listarFacturas() - Error al listar las facturas: " + e);
        }
        
        return facturas;
    }
    
     /**
     * Consume una tabla en base de datos para traer información de un procedimiento almacenado con un Id como parametro 
     * @param idFactura
     * @return FacturaDetallada
     */
    public FacturaDetallada listarFacturas(int idFactura) {
        Factura bill = new Factura();
        DetallesFactura details = new DetallesFactura();
        
        try {
            con = cn.Conexion();
            CallableStatement procedure = con.prepareCall("{call ConsultarFacturaCompleta(?)}");
            procedure.setInt(1, idFactura);
            rs = procedure.executeQuery();
            
            while (rs.next()) {
                bill.setIdFactura(rs.getInt(1));
                bill.setNumeroFactura(rs.getInt(2));
                bill.setFecha(rs.getString(3));
                bill.setTipoDePago(rs.getString(4));
                bill.setDocumentoCliente(rs.getString(5));
                bill.setNombreCliente(rs.getString(6));
                bill.setSubTotal(rs.getInt(7));
                bill.setDescuento(rs.getInt(8));
                bill.setIva(rs.getInt(9));
                bill.setTotalDescuento(rs.getInt(10));
                bill.setTotalImpuesto(rs.getInt(11));
                bill.setTotal(rs.getInt(12));
                details.setIdDetalle(rs.getInt(13));
                details.setIdFactura(rs.getInt(14));
                details.setIdProducto(rs.getInt(15));
                details.setCantidad(rs.getInt(16));
                details.setPrecioUnitario(rs.getInt(17));
            } 
        } catch (SQLException e) {
            System.out.println("Model.FacturaDAO.listarFacturas() - Error al listar facturas detalladas factura: " + e);
        }
        
        FacturaDetallada facturaDetallada = new FacturaDetallada();
        facturaDetallada.setFactura(bill);
        facturaDetallada.setDetalles(details);
        
        return facturaDetallada;
    }
    
    /**
     * Este metodo inserta datos en una base de datos por medio de un procedimiento almacenado con dos modelos de datos como parametros
     * @param bill
     * @param details
     * @return int
     */
    public int agregarFacturas(Factura bill, DetallesFactura details) {        
        try {
            con = cn.Conexion();
            CallableStatement procedure = con.prepareCall("{call InsertarFactura(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            procedure.setInt(1, bill.getNumeroFactura());
            procedure.setString(2, bill.getFecha());
            procedure.setString(3, bill.getTipoDePago());
            procedure.setString(4, bill.getDocumentoCliente());
            procedure.setString(5, bill.getNombreCliente());
            procedure.setInt(6, bill.getSubTotal());
            procedure.setInt(7, bill.getDescuento());
            procedure.setInt(8, bill.getIva());
            procedure.setInt(9, bill.getTotalDescuento());
            procedure.setInt(10, bill.getTotalImpuesto());
            procedure.setInt(11, bill.getTotal());
            procedure.setInt(12, details.getIdProducto());
            procedure.setInt(13, details.getCantidad());
            procedure.setInt(14, details.getPrecioUnitario());
            
            response = procedure.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Model.FacturaDAO.agregarFacturas() - Error al insertar factura: " + e);
        }
        
        return response;
    }
    
    /**
     * Actualiza informacion en una base de datos por medio de un procedimiento almacenado con tres parametros
     * @param bill
     * @param details
     * @param idFactura
     * @return int
     */
    public int actualizarFacturas(Factura bill, DetallesFactura details,int idFactura) {
        try {
            con = cn.Conexion();
            CallableStatement procedure = con.prepareCall("{call ActualizarFacturaCompleta(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            procedure.setInt(1, idFactura);
            procedure.setInt(2, bill.getNumeroFactura());
            procedure.setString(3, bill.getFecha());
            procedure.setString(4, bill.getTipoDePago());
            procedure.setString(5, bill.getDocumentoCliente());
            procedure.setString(6, bill.getNombreCliente());
            procedure.setInt(7, bill.getSubTotal());
            procedure.setInt(8, bill.getDescuento());
            procedure.setInt(9, bill.getIva());
            procedure.setInt(10, bill.getTotalDescuento());
            procedure.setInt(11, bill.getTotalImpuesto());
            procedure.setInt(12, bill.getTotal());
            procedure.setInt(13, details.getIdProducto());
            procedure.setInt(14, details.getCantidad());
            procedure.setInt(15, details.getPrecioUnitario());
            
            response = procedure.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Model.FacturaDAO.agregarFacturas() - Error al actualizar factura: " + e);
        }
        
        return response;
    }
    
    /**
     * Elimina registros de una base de datos por medio de un procedimiento almacenado que recibe un Id como parametro
     * @param idFactura
     */
    public void eliminarFacturas(int idFactura) {        
        try {
            con = cn.Conexion();
            CallableStatement procedure = con.prepareCall("{call EliminarFacturas(?)}");
            procedure.setInt(1, idFactura);
            procedure.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Model.FacturaDAO.eliminarFacturas() - Error en la eliminacion de factura: " + e);
        }
    }
}
